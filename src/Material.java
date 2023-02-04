public class Material {
    private int id;
    private String  name;
    private String  type;
    private String url;
    private String course;

    public Material(String type,String course,String url, String name ){
        setType(type);
        setCourse(course);
        setUrl(url);
        setName(name);
    }
    public Material(int id,String type,String course,String url, String name ){
        this(type, course, url, name);
        setId(id);

    }


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
