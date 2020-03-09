/*
Gruber Healthcare has different types of forms for their customer, one of which is a know your customer form ( KYC ) which has to be filled annually. Each form has a date which signifies the date the form was filled called the form date.
Due to government regulations the KYC form can only be filled within + or - 30 days of the signup anniversary of a customer. When filling it up, you have to provide the form date. If you are past the +-30 day anniversary then you can back-date it so that it falls in the +-30-day window. When filling it up you cannot use a future date for the form date.
For Example, assuming today is 4 Apr 2017 and I had signed up on 1st Mar 2014, my window for KYC submission this year would be 30 Jan 2017 to 31 Mar 2017. Since it is already 4th Apr - I would have to back-date the KYC to a date in this range.
Note: The KYC form can be filled only for the closest anniversary in the past or within 30 days range in future.
Anniversary refers to same day and month every year. If your birthday is 01-02-1992 -then your first anniversary will be 01-02-1993, the 2nd will be 01-02-1994 and so on. 01-02-1992 is not an anniversary.
Given the signup date and the current date, provide the allowable date range for the form date.
Input - First line is an integer n as the number of inputs to be passed. Next, n lines are n input for the program in the format dd-mm-yyyy dd-mm-yyyy Each line has two dates separated by space where the first date in signup date and the second date is the current date.
Output - Range of dates for KYC form in format dd-mm-yyyy dd-mm-yyyy
Test Input:
5
16-07-1998 27-06-2017
04-02-2016 04-04-2017
04-05-2017 04-04-2017
04-04-2015 04-04-2016
04-04-2015 15-03-2016
Test output:
16-06-2017 27-06-2017
05-01-2017 06-03-2017
No range
05-03-2016 04-04-2016
05-03-2016 15-03-2016
 */
package Assignment4;

import java.util.*;
import java.text.*;
import java.io.*;
import java.util.logging.Logger;

class GruberHealthCareKYC {
    static Logger logger = Logger.getLogger(GruberHealthCareKYC.class.getName());
    Calendar calendar = Calendar.getInstance();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
   /*
   This method calculates range of dates which are valid to do kyc verification and returns valid range as String
   if the anniversary date is 30 days behind or ahead of signup date
    */
    public String rangeOfDatesForKYC(Date anniversary, Date today) {
        calendar.setTime(today);
        int presentYear = calendar.get(Calendar.YEAR);
        calendar.setTime(anniversary);
        calendar.set(Calendar.YEAR, presentYear);
        Date presentAniversary = calendar.getTime();

        calendar.add(Calendar.DATE, 30);        //maximum possible date for KYC
        Date maxDate = calendar.getTime();

        calendar.add(Calendar.DATE, -60);       //Date at this point is 30 days ahead, so bringing it 60 days back would mean 30 days before the actual aniversary
        Date minDate = calendar.getTime();          //minimum possible date for KYC

        if (today.compareTo(minDate) <= 0) {        //Check if a range is obtainable from today
            logger.info("not in range");
            return "No Range";
        } else {
            logger.info(simpleDateFormat.format(minDate) + " " + (today.compareTo(maxDate) > 0 ? simpleDateFormat.format(maxDate) : simpleDateFormat.format(today)));
            return simpleDateFormat.format(minDate) + " " + (today.compareTo(maxDate) > 0 ? simpleDateFormat.format(maxDate) : simpleDateFormat.format(today));
        }
    }

    public static void main(String args[]) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            int test = Integer.parseInt(bufferedReader.readLine().trim());
            GruberHealthCareKYC gruberHealthCareKYC = new GruberHealthCareKYC();
            while (test-- > 0) {
                String date[] = bufferedReader.readLine().split(" ");
                Date aniversary = simpleDateFormat.parse(date[0]);
                Date today = simpleDateFormat.parse(date[1]);
                gruberHealthCareKYC.rangeOfDatesForKYC(aniversary, today);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("error occured at input given or reading input");
        }
    }
}
