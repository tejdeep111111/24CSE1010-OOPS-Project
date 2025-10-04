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
        System.out.println(getName()+" is assigned to teach: "+course.getCourseCode());
    }
    //member function to enroll a student to a course taught by the professor(A professor can also register a student for his course)
    //As this fn calls registerCourse of student class which might throw an error
    public void enrollStudent(Course course,Student student) throws CourseFullException {
        student.registerCourse(course);
        System.out.println(student.getName()+" is enrolled for the  course "+course.getCourseCode());
    }
    //member function to submit the grade of a course to a student(by calling the member function assignGrade of class student)
    public void submitGrade(Course course,Student student,String grade) {
        student.assignGrade(course, grade);
        System.out.println("Professor,"+getName()+" submits grade "+grade+" for "+student.getName()+" in "+course.getCourseCode());
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
