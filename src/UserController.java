import java.util.List;

public class UserController {
    private final IUserRepository repo;

    public UserController(IUserRepository repo) {
        this.repo = repo;
    }

    public User logIn(String email, String password){
        User loggedUser = repo.logIn(email, password);

        if(loggedUser != null){
            return loggedUser;
        }
        return null;
    }

    public String createUser(String name, String surname, String email, String password) {
        User user = new User(name, surname, email,password);

        boolean created = repo.createUser(user);

        return (created ? "User was created!" : "User creation was failed!" );
    }

    public String getUser(int id) {
        User user = repo.getUser(id);

        return (user == null ? "User was not found!" : user.toString());
    }

    public String getAllUsers() {
        List<User> users = repo.getAllUsers();
        return users.toString();
    }
    public List<Course> getAllCourses() {
        List<Course> courses = repo.getAllCourses();
        if(courses!= null){
            return courses;
        }else {
            System.out.println("Its null");
        }
        return null;
    }

}