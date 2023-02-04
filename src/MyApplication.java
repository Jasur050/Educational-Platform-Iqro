import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyApplication {
    private final UserController controller;
    private final Scanner scanner;
    private static User loggedUser = null;
    private static final ArrayList<Integer> myCourses = new ArrayList<>();
    private static ArrayList<Course> courses = new ArrayList<>();

    public MyApplication(UserController controller) {
        this.controller = controller;
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println();
            System.out.println("Welcome to My Application");
            System.out.println("Select option:");
            System.out.println("1. Log in");
            System.out.println("2. Sign Up");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.print("Enter option (1-2) to exit 0: ");
                int option = scanner.nextInt();
                if (option == 1) {
                    logIn();
                } else if (option == 2) {
                    createUserMenu();
                } else if (option == 0) {
                    System.out.println("============================ Goodbye! Have a nice day ;) ============================");
                    break;
                } else {
                    System.out.println("You should chose right option! Try again ");
                }
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void logIn() {
        System.out.println("Please enter email: ");
        String email = scanner.next();
        System.out.println("Please enter password: ");
        String password = scanner.next();

        User response = controller.logIn(email.trim(),password.trim());
        loggedUser = response;
        if(loggedUser != null){
            while (true){
                System.out.println("*****************************************************");
                System.out.println();
                System.out.println("Welcome to Developers platform ");
                System.out.println("Select option to continue:");
                System.out.println("1. Add courses ");
                System.out.println("2. My courses ");
                System.out.println("0. Exit");
                System.out.println();
                try {
                    System.out.print("Enter option (1-2) to exit 0: ");
                    int option = scanner.nextInt();
                    if (option == 1) {
                        addCourses();
                    } else if (option == 2) {
                        getMyCourses();
                    } else if (option == 0) {
                        System.out.println("============================ Goodbye! Have a nice day ;) ============================");
                        break;
                    }else {
                        System.out.println("You should chose right option! Try again ");
                    }
                }
                catch (Exception e) {
                    System.out.println(e.getMessage());

                }System.out.println("*****************************************************");
            }
        }
        else {
            System.out.println("Wrong password or email...");
            System.out.println("If you dont have account, please register!");
        }
    }


        public void addCourses(){
            getAllCourses();

            while (true){
                System.out.print("Please choose one of the courses (0 for exit): ");
                Integer choice = scanner.nextInt();
                if(choice!=0 && (choice > 0 && choice >= myCourses.size())){
                    if(!(myCourses.contains(choice))){
                        myCourses.add(choice);
                    }else {
                        System.out.println("You already have it!");
                    }

                } else if (choice == 0) {
                    break;
                }else {
                    System.out.println("Please enter right id");
                }
            }
        }

        public void getMyCourses(){
            if (myCourses != null) {
//                System.out.println("\n===========================  -All Courses-  ===========================");
//                System.out.printf("|%-10s | %-30s | %-15s |%n", "№", "Dish Name", "Price");
//                for (Integer mc : myCourses) {
//                    System.out.printf("|%-10d | %-30s | %15s |%n", course.getId(), course.getName(), course.getTeacher());
//                }
//                System.out.println("********************************************************************");
                System.out.println(courses.toString());
            }
        }
        public void getAllCourses() {
                List<Course> allCourses = controller.getAllCourses();
                courses = (ArrayList<Course>) allCourses;
                if (courses != null) {
                    System.out.println("\n===========================  -All Courses-  ===========================");
                    System.out.printf("|%-10s | %-30s | %-15s |%n", "№", "Dish Name", "Price");
                    for (Course course : courses) {
                        System.out.printf("|%-10d | %-30s | %15s |%n", course.getId(), course.getName(), course.getTeacher());
                    }
                    System.out.println("********************************************************************");

                }
        }


    public void getAllUsersMenu() {
        String response = controller.getAllUsers();
        System.out.println(response);
    }

    public void getUserByIdMenu() {
        System.out.println("Please enter id");

        int id = scanner.nextInt();
        String response = controller.getUser(id);
        System.out.println(response);
    }

    public void createUserMenu() {
        System.out.println("Please enter name");
        String name = scanner.next();
        System.out.println("Please enter surname");
        String surname = scanner.next();
        System.out.println("Please enter email");
        String email = scanner.next();
        System.out.println("Please password email");
        String password = scanner.next();

        String response = controller.createUser(name, surname,email,password);
        System.out.println(response);
    }
}