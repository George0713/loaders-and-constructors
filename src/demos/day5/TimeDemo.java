package demos.day5;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.TimeZone;


public class TimeDemo {
	
	public static void main(String[] args) {
		//String is immutable
				String str1="hello";
				str1=str1.substring(0, 3);
				System.out.println(str1);//hel
				
				//Java 8 introduced this java.time package. All the classes in this package are immutable
				
				System.out.println(LocalDate.now());
				LocalDate today=LocalDate.now();
				
				LocalDate after5Days=today.plusDays(5);
				System.out.println(after5Days);// 2019-07-22
				
				LocalDate after3Months=today.plusMonths(3);
				System.out.println(after3Months); //2019-10-17
				
				LocalDate before3Years=today.minusYears(3);
				System.out.println(before3Years);//2016-07-17
				
				System.out.println(today.getDayOfWeek());//WEDNESDAY
				
				String str= "2017-04-22";
				LocalDate obj=LocalDate.parse(str);// to convert string to date
				System.out.println(obj);
				
				//new LocalDate(2010, 01, 22); new LocalDate(2010, 01, 22);
				LocalDate obj1=LocalDate.of(2010, 01, 22);
				//obj1 to string??
				String str2= obj1.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				System.out.println(str2);
				System.out.println(today.isAfter(obj1));
				
				
				String str3= "21/12/2018";
				LocalDate date=LocalDate.parse(str3, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				System.out.println(date);
				
				System.out.println(LocalDateTime.now());
				
				ZonedDateTime zd = ZonedDateTime.now();
				System.out.println(zd);
				
				LocalDate dt1= LocalDate.of(2019,11, 22);
				LocalDate dt2= LocalDate.of(2016,07, 27);
				
				System.out.println(dt1);
				System.out.println(dt2);
				
				System.out.println(ChronoUnit.DAYS.between(dt2, dt1));

				printExpire(dt2.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),6,3);
				
				printZoneTime("America/New_York");
				
				printAge("1991-11-05");
				
//				Duration d=Duration.between(dt2, dt1);
//				System.out.println(d.toDays());
				
	}
	
	public static void printExpire(String purchaseDate, int warranteePm, int warranteePy) {
		
		LocalDate pDate = LocalDate.parse(purchaseDate);
		System.out.println(pDate.plusMonths(warranteePm).plusYears(warranteePy));
		
	}
	
	public static void printZoneTime(String timeZoneID) {
		
		ZonedDateTime zt = ZonedDateTime.now(ZoneId.of(timeZoneID));
		System.out.println(zt);
		
	}
	
	public static void printAge(String birthday) {
		LocalDate bd = LocalDate.parse(birthday);
		LocalDate now = LocalDate.now();		
		
		System.out.println(Period.between(bd, now).getYears());
	}

}

