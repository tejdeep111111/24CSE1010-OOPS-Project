//Person will be an abstract class(That can't be instantiated but only inherited)
public abstract class Person {
    private String name;
    private String id;
    //Constructor(abstract classes can have constructors)
    public Person(String name,String id) {
        this.name=name;
        this.id=id;
    }
    public getName() {return name;}
    public getId() {return id;}
    //abstract method(the classes that are derived from this class(Person) must provide implementation for this method)
    public abstract void displayRole() {}
    //Non-abstract method(abstract class can contain both abstract and non-abstract methods)
    public void displayBasicInfo() {
        System.out.println("NAME: "+name+",ID: "+id);
    }
}
