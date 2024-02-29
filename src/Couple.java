public class Couple {
    private Person bride = new Person("test","aaa");
    private Person groom = new Person("bleh","uweh");
    public Couple(Person a, Person b){
        bride = a;
        groom = b;
    }
    // getters for the bride and groom
    public Person getBride(){
        return bride;
    }
    public Person getGroom(){
        return groom;
    }
}
