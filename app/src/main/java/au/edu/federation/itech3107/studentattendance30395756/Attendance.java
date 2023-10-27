package au.edu.federation.itech3107.studentattendance30395756;

public class Attendance {
    private Integer id;
    private String number;
    private String name;
    private Integer couId;
    private Integer stuId;

    private Integer type;

    public Attendance(Integer id, Integer stuId, String number, String name, Integer couId, Integer type) {
        this.id = id;
        this.stuId = stuId;
        this.number = number;
        this.name = name;
        this.couId = couId;
        this.type = type;
    }

    public Attendance() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public Integer getCouId() {
        return couId;
    }

    public void setCouId(Integer couId) {
        this.couId = couId;
    }
}
