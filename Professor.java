import java.util.ArrayList;
import java.util.List;
//This class is inherited from the abstract class Person
public class Professor extends Person{
    private String department;
    private List<String> coursesTaught;
    //Constructor
    public Professor(Sting name,String id,String department) {
        super(name,id);
        this.department=department;
        this.coursesTaught=new ArrayList<>();
    }
    
}
