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
        Student tej=new Student("Bhimireddy Tej Deep Reddy","24CSE1010",2024,"BTechCSE");
        Student soma=new Student("Soma Teja","24CSE1047",2024,"BTechCSE");
        Professor mini=new Professor("Dr.Mini S", "CSE");
        Professor vnk=new Professor("Dr.K Venkat Naresh", "CSE");

        mini.teachCourse(oops);
        //mini.teachCourse(oopsLab);
        vnk.teachCourse(oopsLab);
        try {
            mini.enrollStudent(oops,tej);
            vnk.enrollStudent(oopsLab,soma);
            mini.enrollStudent(oops, soma);


            //error:(try block ends whenever an exception occoured) so remaining block of code in try will not be executed

            
            vnk.enrollStudent(oopsLab,tej);
        }
        //getMessage is a default fn of exception class
        catch(CourseFullException e) {
            System.out.println("Caught Error: "+e.getMessage());
        }

        //tej.withdrawCourse(oopsLab);

        indentifyRoleDisplayInfo(vnk);
        indentifyRoleDisplayInfo(tej);
        indentifyRoleDisplayInfo(mini);
        indentifyRoleDisplayInfo(soma);
        
    }
}
