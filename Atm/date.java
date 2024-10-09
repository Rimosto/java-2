
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;

public class date {
    public static void main(String[] args) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        LocalDate currentDate = LocalDate.now();
        LocalTime time = LocalTime.now();
        System.out.println("Current Date : " + currentDate);
        System.out.println("Current Date and Time: " + currentDateTime);
        System.out.println("Current Time: " + time);

        LocalDate date = LocalDate.of(2024, 9, 5);
        System.out.println("Date: " + date);
        date = date.plusMonths(1);
        System.out.println("After Adding One Month: " + date);
        date = date.plusYears(5);
        System.out.println("After Adding Five Years: " + date);
        LocalDate date2 = LocalDate.of(2024, Month.SEPTEMBER, 05);
        LocalTime time2 = LocalTime.of(16, 15);
        LocalDateTime date2Time2 = LocalDateTime.of(date2, time2);
        System.out.println("ACTUAL DATE AND TIME" + date2Time2);
        date2Time2 = date2Time2.minusDays(4);
        System.out.println("MINUS DAYS" + date2Time2);
        date2Time2 = date2Time2.minusHours(101);
        System.out.println("MINUS HOURS " + date2Time2);
        date2Time2 = date2Time2.minusSeconds(300);
        System.out.println("MINUS SEC " + date2Time2);

        LocalDate start = LocalDate.of(2015, Month.JANUARY, 1);
        LocalDate end = LocalDate.of(2015, Month.MARCH, 30);
        Period period = Period.ofMonths(1); // create a period
        performAnimalEnrichment(start, end, period);
    }

    private static void performAnimalEnrichment(LocalDate start, LocalDate end,
            Period period) { // uses the generic period
        LocalDate upTo = start;
        while (upTo.isBefore(end)) {
            System.out.println("give new toy: " + upTo);
            upTo = upTo.plus(period); // adds the period
        }

    }
}
