//This class is used to create course instances(Ex-CS203)
public class Course {
    private String courseName;
    private String courseCode;
    private int maxCapacity; 
    
    //Constructor 
    public Course(String courseName,String courseCode,int maxCapacity) {
        this.courseName=courseName;
        this.courseCode=courseCode;
        this.maxCapacity=maxCapacity;
    }
    public String getCourseName() {return courseName;}
    public String getCourseCode() {return courseCode;}
    

}
