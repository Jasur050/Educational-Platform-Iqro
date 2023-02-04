import java.util.List;

public interface IUserRepository {
    boolean createUser(User user);
    User getUser(int id);
    User logIn(String email, String password);
    List<User> getAllUsers();
    List<Course> getAllCourses();
}