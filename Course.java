

import java.io.Serializable;


public class Course implements Serializable{
    private String courseName;
    private String courseCode;
    private int maxCapacity;
    private int currentEnrollment;
    private Enums.EnumSem semester; 
    
    //Constructor 
    public Course(String courseName,String courseCode,Enums.EnumSem semester,int maxCapacity) {
        this.courseName=courseName;
        this.courseCode=courseCode;
        this.maxCapacity=maxCapacity;
        this.currentEnrollment=0;
        this.semester=semester;
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
    public Enums.EnumSem getSemester() {return semester;}
}
