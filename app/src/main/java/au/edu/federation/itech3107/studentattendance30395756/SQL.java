package au.edu.federation.itech3107.studentattendance30395756;

public class SQL {

    String s1 = "CREATE TABLE COURSE\n" +
            "(\n" +
            "    id         integer primary key autoincrement,\n" +
            "    name       varchar(255),\n" +
            "    start_time varchar(255),\n" +
            "    end_time   varchar(255)\n" +
            ")";
    String s2 = "CREATE TABLE ACCOUNT\n" +
            "(\n" +
            "    id         integer primary key autoincrement,\n" +
            "    username   varchar(255),\n" +
            "    password   varchar(255)\n" +
            ")";
    String s3 = "CREATE TABLE STUDENT\n" +
            "(\n" +
            "    id         integer primary key autoincrement,\n" +
            "    course_id   integer,\n" +
            "    number   varchar(255),\n" +
            "    name   varchar(255)\n" +
            ")";
    String s4 = "CREATE TABLE ATTENDANCE\n" +
            "(\n" +
            "    id         integer primary key autoincrement,\n" +
            "    student_id   integer,\n" +
            "    student_number   varchar(255),\n" +
            "    student_name   varchar(255),\n" +
            "    status   integer,\n" +
            "    date   varchar(255),\n" +
            "    course_id   varchar(255)\n" +
            ")";

    public SQL(String s1, String s2, String s3, String s4) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        this.s4 = s4;
    }

    public SQL() {
    }

    public String getS1() {
        return s1;
    }

    public void setS1(String s1) {
        this.s1 = s1;
    }

    public String getS2() {
        return s2;
    }

    public void setS2(String s2) {
        this.s2 = s2;
    }

    public String getS3() {
        return s3;
    }

    public void setS3(String s3) {
        this.s3 = s3;
    }

    public String getS4() {
        return s4;
    }

    public void setS4(String s4) {
        this.s4 = s4;
    }
}
