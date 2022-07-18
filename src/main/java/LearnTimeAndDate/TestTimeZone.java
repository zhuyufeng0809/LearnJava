package LearnTimeAndDate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.TimeZone;

public class TestTimeZone {
    public static void main(String[] args) {
        //获取当前日期
        LocalDate today = LocalDate.now();
        int year = today.getYear();
        int month = today.getMonthValue();
        int day = today.getDayOfMonth();
        System.out.printf("Year:%d Month:%d Day:%d \n", year, month, day);

        //获取当前时间
        System.out.println(LocalDateTime.now());

        //创建日期
        LocalDate date = LocalDate.of(2022, 1, 1);

        //判断闰年
        System.out.println(LocalDate.now().isLeapYear());

        //计算日期之间的天数或月数
        Period period = Period.between(LocalDate.of(2022, 1, 1), LocalDate.of(2022, 6 , 1));
        System.out.println(period.toTotalMonths());
    }
}
