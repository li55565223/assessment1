package au.edu.federation.itech3107.studentattendance30395756;

public class Student {
    private Integer id;
    private String name;
    private String number;
    private Integer iid;

    public Student(Integer id, String name, String number, Integer courseId) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.iid = courseId;
    }

    public Student() {
    }

    public Integer getIid() {
        return iid;
    }

    public void setIid(Integer iid) {
        this.iid = iid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
