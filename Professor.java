import java.util.ArrayList;
import java.util.List;

//This class is inherited from the abstract class Person
public class Professor extends Person{
    private String department;
    private List<Course> coursesTaught;
    //Constructor
    public Professor(String name,String id,String department) {
        super(name,id);
        this.department=department;
        this.coursesTaught=new ArrayList<>();
    }
    //member function to assign a course to a professor
    public void teachCourse(Course course) {
        coursesTaught.add(course);
        System.out.println(getName()+"is assigned to teach: "+course.getCourseCode());
    }
    //member function to enroll a student to a course taught by the professor
    public void enrollStudent(Course course,Student student) {
        student.registerCourse(course);
        System.out.println(student.getName()+" is enrolled for the  course "+course.getCourseCode());
    }

    @Override
    public void displayRole() {
        System.out.println("Is a Professor");
        System.out.println("Department: "+department);
        System.out.println("Courses Taught("+coursesTaught.size()+"):");
        //is a java for each loop(iterates linearly upto the end of the list)
        for (Course course : coursesTaught) {
            System.out.println("-"+course.getCourseInfo());
        }
    }
}
