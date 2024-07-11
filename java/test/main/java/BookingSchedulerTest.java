import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class BookingSchedulerTest {

    @Test
    public void 예약은_정시에만_가능하다_정시가_아닌경우_예약불가() {
    }

    @Test
    public void 예약은_정시에만_가능하다_정시인_경우_예약가능() {
    }

    @Test
    public void 시간대별_인원제한이_있다_같은_시간대에_Capacity_초과할_경우_예외발생() {
    }

    @Test
    public void 시간대별_인원제한이_있다_같은_시간대가_다르면_Capacity_차있어도_스케쥴_추가_성공() {
    }

    @Test
    public void 예약완료시_SMS는_무조건_발송() {
    }

    @Test
    public void 이메일이_없는_경우에는_이메일_미발송() {
    }

    @Test
    public void 이메일이_있는_경우에는_이메일_발송() {
    }

    @Test
    public void 현재날짜가_일요일인_경우_예약불가_예외처리() {
    }

    @Test
    public void 현재날짜가_일요일이_아닌경우_예약가능() {
    }
}
