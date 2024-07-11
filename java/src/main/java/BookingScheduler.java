import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BookingScheduler {
    private int capacityPerHour;
    private List<Schedule> schedules;
    private SmsSender smsSender;
    private MailSender mailSender;

    public BookingScheduler(int capacityPerHour) {
        this.schedules = new ArrayList<Schedule>();
        this.capacityPerHour = capacityPerHour;
        this.smsSender = new SmsSender();
        this.mailSender = new MailSender();
    }

    public void addSchedule(Schedule schedule) {

        // 정각에 예약하지 않을 경우 RuntimeException 발생
        if(schedule.getDateTime().getMinute() != 0 ){
            throw new RuntimeException("Booking should be on the hour.");
        }

        // 시간당 예약인원을 초과할 경우 RuntimeException 발생
        int numberOfPeople = schedule.getNumberOfPeople();
        for ( Schedule bookedSchedule : schedules ) {
            if ( bookedSchedule.getDateTime().isEqual(schedule.getDateTime()) ) {
                numberOfPeople += bookedSchedule.getNumberOfPeople();
            }
        }
        if (numberOfPeople > capacityPerHour){
            throw new RuntimeException("Number of people is over restaurant capacity per hour");
        }

        /*
        // 일요일에는 시스템을 오픈하지 않는다.
        LocalDateTime now = LocalDateTime.now();
        if(now.getDayOfWeek() == DayOfWeek.SUNDAY){
           throw new RuntimeException("Booking system is not available on sunday");
        }
        */

        schedules.add(schedule);

        // 고객에게 SMS 발송
        smsSender.send(schedule);
        // 고객이 E Mail을 가지고 있을 경우 E Mail 발송
        if(schedule.getCustomer().getEmail() != null){
            mailSender.sendMail(schedule);
        }
    }

    public boolean hasSchedule(Schedule schedule) {
        return schedules.contains(schedule);
    }

    public void setSmsSender(SmsSender smsSender) {
        this.smsSender = smsSender;
    }

    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }
}

