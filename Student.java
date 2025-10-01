import java.util.ArrayList;
import java.util.List;

//This class is inherited from the abstract base class Person
public class Student extends Person {
    private int joiningYear;
    private String major;
    private List<Course> registeredCourses;
    //Constructor
    public Student(String name,String id,int joiningYear,String major) {
        super(name,id);
        this.joiningYear=joiningYear;
        this.major=major;
        this.registeredCourses=new ArrayList<>();
    }
    //member function to register a course to a student
    public void registerCourse(Course course) {
        registeredCourses.add(course);
        System.out.println(getName()+" registered for: "+course.getCourseCode());
    }
    //member function to assign a grade to a student
    public void assignGrade(Course course,String grade) {
        if(registeredCourses.contains(course)) {
            System.out.println("Assigned grade "+grade+" to "+this.getName()+" in "+course.getCourseCode());
        } 
        else {
            System.out.println(this.getName()+" is not registered for "+course.getCourseCode());
        }
    }
    //implementation of the abstract method of abstact base class Person
    @Override
    public void displayRole() {
        System.out.println("Is a Student joined in the academic year: "+joiningYear);
        System.out.println("Major in: "+major);
        System.out.println("Registered Courses("+registeredCourses.size()+"):");
        //is a java for each loop(iterates linearly upto the end of the list)
        for(Course course : registeredCourses) {
            System.out.println(" - "+course.getCourseInfo());
        }
    }
}
