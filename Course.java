//This class is used to create course instances(Ex-CS203)
public class Course {
    private String courseName;
    private String courseCode;
    
    //Constructor 
    public Course(String courseName,String courseCode) {
        this.courseName=courseName;
        this.courseCode=courseCode;
    }
    public String getCourseName() {return courseName;}
    public String getCourseCode() {return courseCode;}
    public String getCourseInfo() {
        return courseCode+"-"+courseName;
    }
}
