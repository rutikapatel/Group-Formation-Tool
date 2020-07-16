package CSCI5308.GroupFormationTool.UserManager;

public abstract class UserManagerAbstractFactory {
    private static UserManagerAbstractFactory instance = null;

    public static UserManagerAbstractFactory instance(){
        if (instance == null) {
            instance = new UserManagerAbstractConcrete();
        }
        return instance;
    }

    public abstract IInstructor getInstructor();
    public abstract IUser getUser();
    public abstract IUserRepository getUserRepository();
    public abstract IUserService getUserService();

}
