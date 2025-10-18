
//Serialisation is the process of converting an entire java object(including all its internal data) into a stream of bytes
import java.io.Serializable;

//Person will be an abstract class(That can't be instantiated but only inherited)
public abstract class Person implements Serializable{
    private String name;
    private String id;
    private final Enums.EnumRole role;
    //Constructor(abstract classes can have constructors)
    public Person(String name,String id,Enums.EnumRole role) {
        this.name=name;
        this.id=id;
        this.role=role;
    }
    public String getName() {return name;}
    public String getId() {return id;}
    //abstract method(the classes that are derived from this class(Person) must provide implementation for this method)
    public abstract void displayRole();
    //Non-abstract method(abstract class can contain both abstract and non-abstract methods)
    public void displayBasicInfo() {
        System.out.println("NAME: "+name+",ID: "+id+",Role: "+role.toString());
    }
    public Enums.EnumRole getRole() {
        return role;
    }
}
