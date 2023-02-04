public class Admin {
    private  int id;
    private String name;
    private String surname;
    private String email;
    private String password;


    public Admin(String name, String surname, String email, String password) {
        setName(name);
        setSurname(surname);
        setEmail(email);
        setPassword(password);
    }


    public Admin(int id, String name, String surname, String email, String password) {
        this(name, surname, email, password);
        setId(id);

    }

    // Getters and setters for name, email, and password


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public void setEmail(String email) {
        this.email = email.trim();
    }

    public String getEmail() {
        return email.trim();
    }

    public void setPassword(String password) {
        this.password = password.trim();
    }

    public String getPassword() {
        return password.trim();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
