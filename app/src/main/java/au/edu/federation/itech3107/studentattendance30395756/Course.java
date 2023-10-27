package au.edu.federation.itech3107.studentattendance30395756;

public class Course {


    private Integer id;
    private String name;
    private String st;
    private String et;
    public Course() {
    }


    public Course(Integer id, String name, String st, String et) {
        this.id = id;
        this.name = name;
        this.st = st;
        this.et = et;
    }

    public Course(String name, String st, String et) {
        this.name = name;
        this.st = st;
        this.et = et;
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

    public String getSt() {
        return st;
    }

    public void setSt(String st) {
        this.st = st;
    }

    public String getEt() {
        return et;
    }

    public void setEt(String et) {
        this.et = et;
    }

}
