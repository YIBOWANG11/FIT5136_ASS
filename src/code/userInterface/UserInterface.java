package code.userInterface;

public class UserInterface {
    private static final String LINE = "******************************************************************************";
    private static final String BLANK = "*                                                                             *";
    private static UserInterface userInterface;
    private UserInterface(){
    }
    public static UserInterface getInstance(){
        if (null == userInterface){
            userInterface = new UserInterface();
        }
        return userInterface;
    }

    public void displayMainPage() {
        System.out.println(LINE);
        System.out.println(BLANK);
        System.out.println("*                              welcome to CMS                                *");
        System.out.println("*                              input 0 to logout                             *");
        System.out.println("*                              input 1 to login                              *");
        System.out.println("*                              input 2 to register                           *");
        System.out.println(BLANK);
        System.out.println(LINE);

    }

    public void displayRegisterPage() {
        System.out.println(LINE);
        System.out.println(BLANK);
        System.out.println("*                                      welcome to CMS                                *");
        System.out.println("*                                      please give email:                             *");
        System.out.println("*                                      please give password:                           *");
        System.out.println("*                                      please give role:                              *");
        System.out.println(BLANK);
        System.out.println(LINE);
    }

    public void displayLoginPage() {
        System.out.println(LINE);
        System.out.println(BLANK);
        System.out.println("*                                      welcome to CMS                                *");
        System.out.println("*                                      please give email:                            *");
        System.out.println("*                                      please give password:                         *");
        System.out.println(BLANK);
        System.out.println(LINE);
    }

    public void admin() {
        System.out.println(LINE);
        System.out.println(BLANK);
        System.out.println("*                              Admin page                                    *");
        System.out.println("*                              input 0 to logout                             *");
        System.out.println("*                              input 1 to retrieve user                      *");
        System.out.println("*                              input 2 to retrieve paper                     *");
        System.out.println("*                              input 3 to retrieve conference                *");
        System.out.println(BLANK);
        System.out.println(LINE);
    }

    public void chair() {
        System.out.println(LINE);
        System.out.println(BLANK);
        System.out.println("*                              Chair page                                    *");
        System.out.println("*                              input 0 to logout                             *");
        System.out.println("*                              input 1 to creat a conference                 *");
        System.out.println("*                              input 2 to modify a conference                *");
        System.out.println("*                              input 3 to assign papers to reviewer          *");
        System.out.println(BLANK);
        System.out.println(LINE);
    }

    public void reviewer() {
    }

    public void author() {
    }

    public void displayPageBy(String role) {
        if ("admin".equals(role)) {
            admin();
        }
        if ("chair".equals(role)) {
            chair();
        }
        if ("reviewer".equals(role)) {
            reviewer();
        }
        if ("author".equals(role)) {
            author();
        }
    }
}
