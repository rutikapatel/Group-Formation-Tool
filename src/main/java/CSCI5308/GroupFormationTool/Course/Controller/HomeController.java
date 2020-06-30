package CSCI5308.GroupFormationTool.Course.Controller;

import CSCI5308.GroupFormationTool.Course.AccessControl.IHomeService;
import CSCI5308.GroupFormationTool.Course.Model.UserId;
import CSCI5308.GroupFormationTool.Injector;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class HomeController {

	private IHomeService homeService;
	UserId userId = new UserId();

	@RequestMapping("/home")
	public ModelAndView home() {
		ModelAndView model = new ModelAndView();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if ((authentication instanceof AnonymousAuthenticationToken)) {
			model.setViewName("redirect:/login");
			return model;
		}

		userId.setUserId(authentication.getPrincipal().toString());
		homeService = Injector.instance().getHomeService();
		model.addObject("userId", userId.getUserId());
		model.addObject("courses", homeService.getCourses(userId));
		model.addObject("checkRole", homeService.checkRole(userId));
		model.setViewName("home");
		return model;
	}
}
