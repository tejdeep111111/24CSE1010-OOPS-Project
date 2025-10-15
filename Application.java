import java.util.ArrayList;
import java.util.List;

public class Application {
    /*
    //this method accepts a person object(which doesn't exist directly) 
    but identifies which class does the object belong to(among the child classes of person)(Polymorphism)
    public static void indentifyRoleDisplayInfo(Person person) {
        person.displayBasicInfo();
        person.displayRole();
    }*/
    
    //these are the main lists(that are passed as arguments for saveData fn)
    public static List<Course> courseList=new ArrayList<>();
    public static List<Person> personList=new ArrayList<>();
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        //an attempt to load previous data from an existing file(if exists)
        Object[] prevData =Manager.loadData();
        if(prevData!=null) {
            courseList =(List<Course>) prevData[0];
            personList =(List<Person>) prevData[1];
        }
        Manager m=new Manager(courseList,personList);
        int choice=-1;
        while(choice!=0) {
            System.out.println();
            System.out.println("-University Management System Menu-");
            System.out.println("1.Add New Student");
            System.out.println("2.Enroll Student in Course");
            System.out.println("3.View Staus");
            System.out.println("0.Exit");
            System.out.println();
            choice=m.getMenuChoice();
            switch (choice) {
                case 1:
                    m.addNewStudent();
                    break;
                case 2:
                    m.enrollStudentInCourse();
                    break;
                case 3:
                    m.viewStatus();
                    break;
                case 0:
                    Manager.saveData(courseList, personList);
                    System.out.println("Exiting System.");
                    break;
                default:
                    System.out.println("INVALID ACTION.");
            }
        }
    }
}
