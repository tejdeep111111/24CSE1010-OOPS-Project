

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class Manager {
    
    private static final String DATA_FILE="university_data.ser";
    //method that does Serialization(Saving Data)
    public static void saveData(List<Course> courses,List<Person> people) {
        //this is an object array that holds both the lists
        Object[] dataToSave = {courses,people};
        //the resourses that are opened in () implements AutoClosable,so they are automatically closed when the try block exits(either normally or due to an exception)
        //this overcomes the need of explicitly writing finally block for resourse cleanup
        //FileOutputStream-creates a connection between the program and the specific file on the disk
        //ObjectOutputStream-It has the method writeObject() that handles the work of serialization
        try(FileOutputStream fileOut=new FileOutputStream(DATA_FILE);
            ObjectOutputStream objectOut=new ObjectOutputStream(fileOut)) {
                //we must have to pass every object that we have to save to the writeObject() method
                objectOut.writeObject(dataToSave);
                System.out.println("Application data successfully saved to "+DATA_FILE);
        } catch(IOException e) {
            e.printStackTrace();
            System.out.println("ERROR saving data: "+e.getMessage());
        }
    }
    //method that does De-Serialization
    public static Object[] loadData() {
        try(FileInputStream fileIn=new FileInputStream(DATA_FILE);
            ObjectInputStream objectIn=new ObjectInputStream(fileIn)) {
                Object[] loadedData=(Object[]) objectIn.readObject();
                System.out.println("Application read the data successfully from: "+DATA_FILE);
                return loadedData;
          //catch block that handles the normal scenario(first time feeding data) when the file doesn't exist yet
          //returns null-the calling code must check for this null return value and know to initialize all data structures
        } catch(FileNotFoundException e) {
            System.out.println("Data File not found,so Starting with empty data.");
            return null;
          //catch block handles all issues during the loading process
          //returns null-to ensure the program can still start(with fresh data) rather than crashing
        } catch(IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("ERROR loading data: "+e.getMessage());
            return null;
        }
    }
    public static Person findPersonById(List<Person> people,String ID) {
        for(Person p : people) {
            if(p.getId().equals(ID)) {
                return p;
            }
        }
        return null;
    }
    public static Course findCourseByCode(List<Course> courses,String code) {
        for(Course c : courses) {
            if(c.getCourseCode().equals(code)) {
                return c;
            }
        }
        return null;
    }


    //final is used(so once initialized,the pointer people will always point to that particular arrayList no matter what)
    private final List<Person> people;
    private final List<Course> courses;
    private final Scanner scnr;
        public Manager(List<Course> courses,List<Person> people) {
            this.people=people;
            this.courses=courses;
            this.scnr=new Scanner(System.in);
            //initializing default data only if we have no prev Data(lists are empty)
            if(courses.isEmpty() && people.isEmpty()) {
                initializeData();
                System.out.println("Initializing default university data.");
            }
            else {
                System.out.println("Using loaded university data.");
            }
        }
    private void addNewCourse() {
        System.out.println("\n---Add New Course---");
        String courseName=readString("Enter Course Name: ");
        String courseCode=readString("Enter Course Code: ");
        int semNumber=readInt("Enter Semester Number(1-8): ");
        Enums.EnumSem semester=Enums.EnumSem.getByNumber(semNumber);
        if(semester==null || semNumber==0 || semNumber>8) {
            System.out.println("Error: Invalid Semester number. Course could not be created.");
            return;
        }
        int maxCapacity=readInt("Enter Maximum Capacity: ");

        Course newCourse=new Course(courseName, courseCode, semester, maxCapacity);
        courses.add(newCourse);
        System.out.println("Course created successfully:");
        System.out.println(newCourse.getCourseInfo());
    }
    private void addNewProfessor() {
        System.out.println("\n---Add New Professor---");
        String name=readString("Enter Professor Name: ");
        String department=readString("Enter Department: "); 

        Professor newProfessor=new Professor(name, department);
        people.add(newProfessor);
        System.out.println("\nProfessor Created successfully.");
        newProfessor.displayBasicInfo();
        //i want here to ask user that if he wants to assign this professor to courses
        //we can also do this later on
        String control="Y";
        do {
            String courseCode=readString("Enter Course code to assign that course to this professor(or Enter NULL to skip)");
            if(courseCode.equals("NULL") || courseCode.equals("null")) {
                System.out.println("Skipping course assignment.");
                break;
            }
            else {
                assignProfessorToCourse(newProfessor.getId(), courseCode);
            }
            control=readString("Another course assignment to this professor? (Y/N): ").toUpperCase();
        } while(control.equals("Y"));
    }
    private void assignProfessorToCourse(String professorId,String courseCode) {
        Course courseToBeTaught=getCourseByCode(courseCode);
        if(courseToBeTaught==null) {
            System.out.println("ERROR: Course not found with corresponding courseCode.");
            return;
        }
        else {
            Person personFound=gerPersonById(professorId);
            if(personFound instanceof Professor) {
                Professor professorFound=(Professor) personFound;
                professorFound.teachCourse(courseToBeTaught);
            }
            else {
                System.out.println("ERROR: Professor not found with corresponding id.");
            }
        }
    }
    private void initializeData() {
        /*Course oops=new Course("Object Oriented Programming","CS203",EnumSem.SEMESTER_3,1);
        Course oopsLab=new Course("Object Oriented Programming Lab", "CS206",EnumSem.SEMESTER_3,62);
        Course dsa=new Course("Data Structures and Algorithms","CS200",EnumSem.SEMESTER_3, 60);
        Professor mini=new Professor("Dr.Mini S", "CSE");
        Professor vnk=new Professor("Dr.K Venkat Naresh", "CSE");
        courses.add(oops);
        courses.add(oopsLab); 
        courses.add(dsa);
        people.add(mini);
        people.add(vnk);
        mini.teachCourse(oops);
        mini.teachCourse(oopsLab);
        vnk.teachCourse(dsa);*/

        //first we take all courses as inputs asking user to do
        System.out.println("Starting the program with getting all courses first");
        int control=1;
        do {
            addNewCourse();
            control=readInt("\nAdd another course? (1/0): ");
        } while(control==1);
        System.out.println("Completed with Entering Courses.Start Entering Professor Details.");
        control=1;
        do {
            addNewProfessor();
            control=readInt("\nAdd another professor? (1/0): ");
        } while(control==1);
        System.out.println("Done with entering professor details.");
    }
    public Person gerPersonById(String id) {
        for(Person p:people) {
            //compares without considering case sensitivity of alphabets
            if(p.getId().equalsIgnoreCase(id)) {
                return p;
            }
        }
        return null;
    }
    public Course getCourseByCode(String code) {
        for(Course c:courses) {
            if(c.getCourseCode().equalsIgnoreCase(code)) {
                return c;
            }
        }
        return null;
    }


    //helper method to read 
    private String readString(String prompt) {
        String input;
        do {
            System.out.println(prompt);
            input=scnr.nextLine();
            if(input.trim().isEmpty()) {
                System.out.println("Input cannot be Empty. Please try again.");
            }
        } while(input.trim().isEmpty());
        return input;
    }
    private int readInt(String prompt) {
        String input=readString(prompt);
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return 0;
        }
    }



    public void addNewStudent() {
        String name=readString("Enter Student Name: ");
        String major=readString("Enter Student Major: ");
        String id=readString("Enter Student ID: ");
        String yearInput=readString("Enter joiningYear: ");
        int joiningYear=0;
        try {
            joiningYear=Integer.parseInt(yearInput);
        } catch(NumberFormatException e) {
            System.out.println("Invalid year entered.Using the current year.");
            Calendar calender=Calendar.getInstance();
            joiningYear=calender.get(Calendar.YEAR);
        }
        Student newStudent=new Student(name, id, joiningYear, major);
        people.add(newStudent);
        System.out.println("Student created successfully. ID: "+newStudent.getId());
    }
    public void enrollStudentInCourse() {
        System.out.println("Enter Student ID: ");
        String id=scnr.nextLine();
        System.out.println("Enter Course Code: ");
        String courseCode=scnr.nextLine();

        Person person=gerPersonById(id);
        Course course=getCourseByCode(courseCode);
        Professor enrollingProfessor=null;
        for(Person p:people) {
            if(p.getRole()==Enums.EnumRole.PROFESSOR) {
                enrollingProfessor=(Professor) p;
                break;
            }
        }
        //Checks if the Person object referenced by the person variable is actually an instance of the Student class.
        if(!(person instanceof Student)) {
            System.out.println("Error: ID "+id+" doesn't belong to a student.");
            return;
        }
        //null is default value to course(remains null if there are no courses with mentioned courseCode in the list courses)
        if(course==null) {
            System.out.println("Error: CourseCode "+courseCode+" not found.");
            return;
        }
        if(enrollingProfessor==null) {
            System.out.println("Error: Can't enroll.No Professor found in the system.");
        }
        try {
            enrollingProfessor.enrollStudent(course,(Student) person);
        }
        catch (CourseFullException e) {
            System.out.println("Caught Error: "+e.getMessage());
        }
    }
    //replacement for indentifyRoleDisplayInfo
    public void viewStatus() {
        System.out.println("Enter person ID(Student/Professor): ");
        String id=scnr.nextLine();
        Person p=gerPersonById(id);
        if(p!=null) {
            p.displayBasicInfo();
            p.displayRole();
        }
        else {
            System.out.println("Error : Person with ID "+id+" not found.");
        }
    }   
    public List<Course> getCoursesBySemester(Enums.EnumSem semester) {
        List<Course> result=new ArrayList<>();
        for(Course c : this.courses) {
            if(c.getSemester()==semester) {
                result.add(c);
            }
        }
        return result;
    }
    public int getMenuChoice() {
        System.out.println();
        System.out.print("Enter your choice: ");
        String input=scnr.nextLine();
        try {
            return Integer.parseInt(input);
        } catch(NumberFormatException e) {
            System.out.println("Ivalid input.Please enter a number.");
            return -1;
        }
    }
}
