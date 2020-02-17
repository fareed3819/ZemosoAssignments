/*
Write a java function that will ping any host ( given as input ) and computes the median of the time taken to ping.

Use the system ping utility, do not use any deprecated methods.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Assignment3 {
    static void ping(String host,int no_of_times)
    {
        String command="ping -c "+no_of_times+" "+host;
        String command_output="";
        int counter=0;
        int index=0;
        String time="";
        ArrayList<Float> arrayList=new ArrayList<Float>();
        try {
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
            command_output = stdInput.readLine();
            command_output = stdInput.readLine();
            while (counter < no_of_times) {
                index = command_output.indexOf("time");
                time = command_output.substring(index + 5, index + 9);
                arrayList.add(Float.parseFloat(time));
                command_output = stdInput.readLine();
                counter++;

            }
            Collections.sort(arrayList);
            if (arrayList.size() % 2 != 0)
                System.out.println("Median of time taken to ping " + arrayList.get(arrayList.size() / 2));
            else
                System.out.println("Median of time taken to ping " + (arrayList.get(arrayList.size() / 2) + arrayList.get((arrayList.size() / 2) - 1)) / 2);
        }
        catch (Exception e){e.printStackTrace();}

    }
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter host to ping");
        String host=bufferedReader.readLine();
        System.out.println("Enter number of times to ping");
        int no_of_times=Integer.parseInt(bufferedReader.readLine().trim());
        ping(host,no_of_times);

    }
}