import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Wedding {
    private LocalDate weddingDate;
    private String location;
    private String groomName;
    private String brideName;
    List<Person> guests = new ArrayList<>();
    public Wedding(Couple c, LocalDate d, String l){
        weddingDate = d;
        location = l;
        groomName = c.getGroom().getFirst()+" "+c.getGroom().getLast();
        brideName = c.getBride().getFirst()+" "+c.getBride().getLast();
    }
    public String getBrideName(){
        return brideName;
    }
    public String getGroomName(){
        return groomName;
    }
    public String getLocation(){
        return location;
    }
    public LocalDate getWeddingDate() {
        return weddingDate;
    }
    // add guests and get the guest's name from the time they were invited
    public void addGuests(Person a){
        guests.add(a);
    }
    public String getGuest(int a){
        return guests.get(a-1).getFirst()+" "+guests.get(a-1).getLast();
    }
}
