public class Person {
    private String first = "First_Name";
    private String last = "Last_Name";
    // Constructor with 2 Strings last and first
    public Person(String a, String b){
        first = a;
        last = b;
    }
    // setters and getters for first and last name
    public void setFirst(String a){
        first = a;
    }
    public String getFirst(){
        return first;
    }
    public void setLast(String a){
        last = a;
    }
    public String getLast(){
        return last;
    }
}
