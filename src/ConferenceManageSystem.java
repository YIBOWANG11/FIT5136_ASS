import code.entity.*;
import code.repo.UserRepository;
import code.userInterface.UserInterface;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

//Controller
public class ConferenceManageSystem {
    private static final UserRepository userRepository = UserRepository.getInstance();
    private static final UserInterface ui = UserInterface.getInstance();
    private static final String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
    private static final List<String> AVAILABLE_ROLES = Arrays.asList("author", "chair", "reviewer");

    public static void main(String[] args) {

        ConferenceManageSystem conferenceManageSystem = new ConferenceManageSystem();
        boolean flag = true;
        while (flag) {
            User user = null;
            while (null == user) {
                try {
                    Scanner input = new Scanner(System.in);
                    ui.displayMainPage();
                    int userOption = input.nextInt();
                    if (userOption == 0) {
                        //logout
                        flag = false;
                        break;
                    }
                    if (userOption == 1) {
                        //login
                        ui.displayLoginPage();
                        System.out.println("Please input your email:");
                        String email = input.next();

                        System.out.println("Please input your password:");
                        String password = input.next();

                        user = conferenceManageSystem.login(password, email);
                    }
                    if (userOption == 2) {
                        //register
                        ui.displayRegisterPage();
                        System.out.println("Please input your email:");
                        String email = input.nextLine();
                        System.out.println("Please input your password:");
                        String password = input.nextLine();
                        System.out.println("Please confirm password:");
                        String confirmedPassword = input.nextLine();
                        System.out.println("Please provide your role:");
                        String role = input.nextLine();
                        user = conferenceManageSystem.register(email,password,confirmedPassword,role);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            while (null != user) {
                user.displayPage();
                Scanner scanner = new Scanner(System.in);
                int option = scanner.nextInt();
                if (option == 0) {
                    System.out.println("logout");
                    user = null;
                } else {
                    user.runFeatureBy(option);
                }
            }
        }
    }


    private User login(String password, String email) {
        List<User> allUsers = userRepository.findAll();
        Optional<User> targetUserOpt = allUsers
                .stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst();
        if (!targetUserOpt.isPresent()) {

            System.out.println("email not exist");
            return null;
        }
        User targetUser = targetUserOpt.get();
        if (!targetUser.getPassword().equals(password)) {
            System.out.println("Wrong password");
            return null;
        }
        return generateUser(targetUser);
    }

    private User register(String email, String password, String confirmedPassword, String role) {
        Pattern pattern = Pattern.compile(REGEX_EMAIL);
        List<User> allUsers = userRepository.findAll();
        if (!pattern.matcher(email).matches()) {
            System.out.println("Wrong Email format");
            return null;
        }
        List<String> emails = allUsers.stream().map(User::getEmail).collect(Collectors.toList());
        if (emails.contains(email)) {
            System.out.println("email already register");
            return null;
        }
        if (!password.equals(confirmedPassword)) {
            System.out.println("password is different");
            return null;
        }
        if (!AVAILABLE_ROLES.contains(role)) {
            System.out.println("invalid role");
            return null;
        }
        User newUser = new User(userRepository.generateMaxId(),email,password,role);
        userRepository.addOne(newUser);
        return newUser;
    }

    private User generateUser(User user) {
        if (user.getRole().equals("admin")) {
            return new Admin(user.getId(), user.getEmail(), user.getPassword(), user.getRole());
        }
        if (user.getRole().equals("chair")) {
            return new Chair(user.getId(), user.getEmail(), user.getPassword(), user.getRole());
        }
//        if (user.getRole().equals("reviewer")) {
//            return new Reviewer(user.getId(), user.getEmail(), user.getPassword(), user.getRole());
//        }
        if (user.getRole().equals("author")) {
            return new Author(user.getId(), user.getEmail(), user.getPassword(), user.getRole());
        }
        return user;
    }

}
