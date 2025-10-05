//This class is the main application(contains main method),usually interacts with user
public class Application {
    /*this method accepts a person object(which doesn't exist directly) 
    but identifies which class does the object belong to(among the child classes of person)(Polymorphism)*/
    public static void indentifyRoleDisplayInfo(Person person) {
        person.displayBasicInfo();
        person.displayRole();
    }
    public static void main(String[] args) {
        Course oops=new Course("Object Oriented Programming","CS203",1);
        Course oopsLab=new Course("Object Oriented Programming Lab", "CS206",62);
        Course dsa=new Course("Data Structures and Algorithms","CS200", 60);
        Student tej=new Student("Bhimireddy Tej Deep Reddy","24CSE1010",2024,"BTechCSE");
        Student soma=new Student("Soma Teja","24CSE1047",2024,"BTechCSE");
        Professor mini=new Professor("Dr.Mini S", "CSE");
        Professor vnk=new Professor("Dr.K Venkat Naresh", "CSE");

        mini.teachCourse(oops);
        mini.teachCourse(oopsLab);
        vnk.teachCourse(dsa);
        //error:(try block ends whenever an exception occoured) so remaining block of code in try will not be executed
        //solution-used separate try catch blocks for each enrollment
        try {
            mini.enrollStudent(oops,tej);
        } catch(CourseFullException e) {
            System.out.println("Caught Error: "+e.getMessage());
        }
        try {
            mini.enrollStudent(oops,soma);
        } catch(CourseFullException e) {
            System.out.println("Caught Error: "+e.getMessage());
        }
        try {
            mini.enrollStudent(oopsLab,soma);
        } catch (CourseFullException e) {
            System.out.println("Caught Error: "+e.getMessage());
        }
        try {
            vnk.enrollStudent(dsa,tej);
        } catch(CourseFullException e) {
            System.out.println("Caught Error: "+e.getMessage());
        }

        tej.withdrawCourse(oopsLab);

        indentifyRoleDisplayInfo(vnk);
        indentifyRoleDisplayInfo(tej);
        indentifyRoleDisplayInfo(mini);
        indentifyRoleDisplayInfo(soma);
        
        mini.submitGrade(oops, tej, EnumGrade.F);
    }
}
