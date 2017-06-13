package MyCollection;

public class Object {
    private  String firstName;
    private  String lastName;
    public Object(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public String getName(){
        return firstName + " " + lastName;
    }
}
