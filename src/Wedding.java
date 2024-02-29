import java.time.LocalDate;
public class Wedding {
    private LocalDate weddingDate = new LocalDate(2022, 8, 12);

    public LocalDate getWeddingDate() {
        return weddingDate;
    }
    public void setWeddingDate(LocalDate a){
        weddingDate = a;
    }
}
