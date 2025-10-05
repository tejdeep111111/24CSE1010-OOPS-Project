import java.util.ArrayList;
import java.util.List;

//This class is inherited from the abstract base class Person
public class Student extends Person {
    private int joiningYear;
    private String major;
    private List<Course> registeredCourses;
    //Constructor
    public Student(String name,String id,int joiningYear,String major) {
        super(name,id,EnumRole.STUDENT);
        this.joiningYear=joiningYear;
        this.major=major;
        this.registeredCourses=new ArrayList<>();
    }
    //member function to register a course to a student(Can throw CourseFullException)
    public void registerCourse(Course course) throws CourseFullException{
        if(course.getCurrentEnrollment()>=course.getMaxCapacity()) {
            //throwing user defined custom exception
            throw new CourseFullException("Course "+course.getCourseCode()+" is full. Can't register "+getName()+".");
        }
        if(registeredCourses.contains(course)) {
            System.out.println("Warning: "+getName()+" is already registered for "+course.getCourseCode()+".");
            return;
        }
        registeredCourses.add(course);
        course.incrementEnrollment();
        System.out.println(getName()+" registered for: "+course.getCourseCode());
    }
    //member function to assign a grade to a student
    public void assignGrade(Course course,EnumGrade grade) {
        if(registeredCourses.contains(course)) {
            System.out.println("Assigned grade "+grade.toString()+" to "+this.getName()+" in "+course.getCourseCode());
        } 
        else {
            System.out.println(this.getName()+" is not registered for "+course.getCourseCode());
        }
    }
    //implementation of the abstract method of abstact base class Person
    @Override
    public void displayRole() {
        System.out.println("Joined in the academic year: "+joiningYear);
        System.out.println("Major in: "+major);
        System.out.println("Registered Courses("+registeredCourses.size()+"):");
        //is a java for each loop(iterates linearly upto the end of the list)
        for(Course course : registeredCourses) {
            System.out.println(" - "+course.getCourseInfo());
        }
    }
    public void withdrawCourse(Course course) {
        if(registeredCourses.remove(course)) {
            course.decrementEnrollment();
            System.out.println(getName()+" successfully withdrew from:"+course.getCourseCode());
        }
        else {
            System.out.println("Error: "+getName()+" is not registered for"+course.getCourseCode()+".");
        }
    }
}
