public class Couple {
    private Person bride = new Person("first","last");
    private Person groom = new Person("first","last");
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
