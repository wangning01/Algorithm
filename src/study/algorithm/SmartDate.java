package study.algorithm;

//import com.sun.deploy.util.StringUtils;
import edu.princeton.cs.algs4.StdIn;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SmartDate
{
    final static String DATE_FORMAT = "dd-MM-yyyy";

    private final int month;
    private final int day;
    private final int year;
    private Date date;

    public SmartDate(int m, int d, int y) throws Exception {
        month = m;
        day = d;
        year = y;

        String strDate = String.format("%02d",d)+"-"+String.format("%02d",m)+"-"+String.format("%04d",y);

        if(!isDateValid(strDate)) {
            throw new Exception("Invalid Date: " + "yyyy:" + y + " mm:" + m + " dd:" + d);
        }


    }


    public int month()
    { return month; }
    public int day()
    { return day; }
    public int year()
    { return day; }
    public String toString()
    { return month() + "/" + day()
            + "/" + year();
    }

    public  boolean isDateValid(String date)
    {

        try {
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
            df.setLenient(false);
            this.date = df.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public static void main(String[] args) throws Exception {

        int year =0;
        int month=0;
        int day=0;

        do {
            System.out.println("Please enter year in yyyy format:");
            String s_year = StdIn.readString();
            try {
                year = Integer.valueOf(s_year);
            }catch(NumberFormatException e){
                System.err.println("Invalid number.");
                continue;
            }
            if(year > 9999)
                System.err.printf("%s is not in correct format.", s_year);
            else
                break;
        }while(true);

        do {
            System.out.println("Please enter month in mm format:");
            String s_month = StdIn.readString();
            try {
                month = Integer.valueOf(s_month);
            }catch (NumberFormatException e){
                System.err.println("Invalid number.");
                continue;
            }
            if(month > 12 || month <1)
                System.err.printf("%s is not in correct format.", s_month);
            else
                break;
        }while(true);


        do {
            System.out.println("Please enter day in dd format:");
            String s_day = StdIn.readString();
            try {
                day = Integer.valueOf(s_day);
            }catch(NumberFormatException e){
                System.err.println("Invalid number.");
                continue;
            }
            if(day<1 || day>31)
                System.err.printf("%s is not in correct format.", s_day);
            else
                break;
        }while(true);

        SmartDate sd = new SmartDate(month, day, year);

        System.out.println(sd.dayOfWeek());

    }

    private String dayOfWeek() {

        if(this.date != null) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(this.date);

            switch (cal.get(Calendar.DAY_OF_WEEK)) {
                case 1:
                    return "Sunday";
                case 2:
                    return "Monday";
                case 3:
                    return "Tuesday";
                case 4:
                    return "Wednesday";
                case 5:
                    return "Thursday";
                case 6:
                    return "Friday";
                case 7:
                    return "Saturday";
                default:
                    return "Undefined";
            }
        }
        else
            return "Undefined";

    }
}