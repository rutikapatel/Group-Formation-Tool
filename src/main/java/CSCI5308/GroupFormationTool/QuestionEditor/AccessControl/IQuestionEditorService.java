package CSCI5308.GroupFormationTool.QuestionEditor.AccessControl;

import java.util.HashMap;

public interface IQuestionEditorService {


    String SaveQuestionServiceForTextAndNumeric(String questionText, String questionTitle, String selectedQuestionType, String userId) throws Exception;

    String saveQuestionForMultipleChoiceService(String questionText, String questionTitle, String selectedQuestionType, String options, String ranks, String userId) throws Exception;

    HashMap<Integer, String> arrangeOptionsBasedOnRank(String optionText, String rankText);
}
