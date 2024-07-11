import java.time.LocalDateTime;

public class Schedule {
    private LocalDateTime dateTime;
    private int numberOfPeople;
    private Customer customer;

    public Schedule(LocalDateTime dateTime, int numberOfPeople, Customer customer) {
        this.dateTime = dateTime;
        this.numberOfPeople = numberOfPeople;
        this.customer = customer;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public Customer getCustomer() {
        return customer;
    }
}
