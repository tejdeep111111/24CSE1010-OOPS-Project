//This class is the main application(contains main method),usually interacts with user
public class Application {
    /*this method accepts a person object(which doesn't exist directly) 
    but identifies which class does the object belong to(among the child classes of person)(Polymorphism)*/
    public static void indentifyRoleDisplayInfo(Person person) {
        person.displayBasicInfo();
        person.displayRole();
    }
    public static void main(String[] args) {
        Course oops=new Course("Object Oriented Programming","CS203");
        Course oopsLab=new Course("Object Oriented Programming Lab", "CS206");
        Student tej=new Student("Bhimireddy Tej Deep Reddy","24CSE1010",2024,"BTechCSE");
        Professor mini=new Professor("Dr.Mini S", "cse1", "CSE");

        mini.teachCourse(oops);
        mini.teachCourse(oopsLab);
        
        mini.enrollStudent(oops,tej);
        mini.enrollStudent(oopsLab,tej);

        indentifyRoleDisplayInfo(tej);
        indentifyRoleDisplayInfo(mini);
    }
}
