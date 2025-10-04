//This class is used to create course instances(Ex-CS203)
public class Course {
    private String courseName;
    private String courseCode;
    private int maxCapacity;
    private int currentEnrollment;
    
    //Constructor 
    public Course(String courseName,String courseCode,int maxCapacity) {
        this.courseName=courseName;
        this.courseCode=courseCode;
        this.maxCapacity=maxCapacity;
        this.currentEnrollment=0;
    }
    public String getCourseName() {return courseName;}
    public String getCourseCode() {return courseCode;}
    public String getCourseInfo() {
        return courseCode+"-"+courseName+"(No.of students enrolled: "+currentEnrollment+"/"+maxCapacity+")";
    }
    public int getMaxCapacity() {return maxCapacity;}
    public int getCurrentEnrollment() {return currentEnrollment;}
    public void decrementEnrollment() {
        if(currentEnrollment>0) {
            currentEnrollment--;
        }
    }
    public void incrementEnrollment() {currentEnrollment++;}
}
