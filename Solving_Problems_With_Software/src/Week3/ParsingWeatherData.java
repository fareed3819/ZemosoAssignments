/*Assignment
You will write a program to find the coldest day of the year and other interesting facts about the temperature and humidity in a day. To test your program, you will use the nc_weather data folder that has a folder for each year; you can download a .zip folder with these files by clicking here. In the year folder there is a CSV file for every day of the year; each file has the following information. For example, in the 2014 folder, we show parts of the file weather-2014-01-08.csv, the weather data from January 8, 2014.


You will write a program with several methods and tester methods to test each method you write. You should start with the methods from the lesson to find the hottest temperature in a day (and thus in a file) and the hottest temperature in many files and their tester methods. You can use these to write similar methods to find the coldest temperatures.

Specifically you should write the following methods.

1. Write a method named coldestHourInFile that has one parameter, a CSVParser named parser. This method returns the CSVRecord with the coldest temperature in the file and thus all the information about the coldest temperature, such as the hour of the coldest temperature. You should also write a void method named testColdestHourInFile() to test this method and print out information about that coldest temperature, such as the time of its occurrence.

NOTE: Sometimes there was not a valid reading at a specific hour, so the temperature field says -9999. You should ignore these bogus temperature values when calculating the lowest temperature.

2. Write the method fileWithColdestTemperature that has no parameters. This method should return a string that is the name of the file from selected files that has the coldest temperature. You should also write a void method named testFileWithColdestTemperature() to test this method. Note that after determining the filename, you could call the method coldestHourInFile to determine the coldest temperature on that day. When fileWithColdestTemperature runs and selects the files for January 1–3 in 2014, the method should print out


3. Write a method named lowestHumidityInFile that has one parameter, a CSVParser named parser. This method returns the CSVRecord that has the lowest humidity. If there is a tie, then return the first such record that was found.

Note that sometimes there is not a number in the Humidity column but instead there is the string “N/A”. This only happens very rarely. You should check to make sure the value you get is not “N/A” before converting it to a number.

Also note that the header for the time is either TimeEST or TimeEDT, depending on the time of year. You will instead use the DateUTC field at the right end of the data file to get both the date and time of a temperature reading.

You should also write a void method named testLowestHumidityInFile() to test this method that starts with these lines:


and then prints the lowest humidity AND the time the lowest humidity occurred. For example, for the file weather-2014-01-20.csv, the output should be:


NOTE: If you look at the data for January 20, 2014, you will note that the Humidity was also 24 at 3:51pm, but you are supposed to return the first such record that was found.

4. Write the method lowestHumidityInManyFiles that has no parameters. This method returns a CSVRecord that has the lowest humidity over all the files. If there is a tie, then return the first such record that was found. You should also write a void method named testLowestHumidityInManyFiles() to test this method and to print the lowest humidity AND the time the lowest humidity occurred. Be sure to test this method on two files so you can check if it is working correctly. If you run this program and select the files for January 19, 2014 and January 20, 2014, you should get


5. Write the method averageTemperatureInFile that has one parameter, a CSVParser named parser. This method returns a double that represents the average temperature in the file. You should also write a void method named testAverageTemperatureInFile() to test this method. When this method runs and selects the file for January 20, 2014, the method should print out


6. Write the method averageTemperatureWithHighHumidityInFile that has two parameters, a CSVParser named parser and an integer named value. This method returns a double that represents the average temperature of only those temperatures when the humidity was greater than or equal to value. You should also write a void method named testAverageTemperatureWithHighHumidityInFile() to test this method. When this method runs checking for humidity greater than or equal to 80 and selects the file for January 20, 2014, the method should print out


If you run the method checking for humidity greater than or equal to 80 and select the file March 20, 2014, a wetter day, the method should print out

*/

package Week3;

import edu.duke.*;
        import org.apache.commons.csv.*;
        import java.io.File;
public class ParsingWeatherData  {
    public CSVRecord coldestHourInFile(CSVParser parser)
    {
        CSVRecord record=null;
        double mintemp=0.0;
        for(CSVRecord cuurentrecord:parser)
        {
            if(record==null) {
                record = cuurentrecord;
                mintemp=Double.parseDouble(record.get("TemperatureF"));
            }
            else
            {
                if(mintemp>Double.parseDouble(cuurentrecord.get("TemperatureF")))
                {
                    if( Double.parseDouble(cuurentrecord.get("TemperatureF"))>=0.0 ) {
                        record = cuurentrecord;
                        mintemp = Double.parseDouble(cuurentrecord.get("TemperatureF"));
                    }
                }
            }
        }
        return record;
    }
    public void testColdestHourInFile()
    {
        FileResource fr=new FileResource();
        CSVParser parser=fr.getCSVParser();
        CSVRecord rec=coldestHourInFile(parser);
        System.out.println("Coldest hour is :"+rec.get("TimeEST")+" on "+rec.get("DateUTC")+" and temp is :"+rec.get("TemperatureF"));
    }
    public void testColdestHourInFile(String filename)
    {
        FileResource fr=new FileResource(filename);
        CSVParser parser=fr.getCSVParser();
        CSVRecord rec=coldestHourInFile(parser);
        System.out.println("Coldest hour is :"+rec.get("TimeEST")+" on "+rec.get("DateUTC")+" and temp is :"+rec.get("TemperatureF"));
    }
    public void readCSV(String filename)
    {
        File f= new File(filename);
        FileResource fr=new FileResource(filename);
        CSVParser parser=fr.getCSVParser();
        for(CSVRecord rec:parser)
            System.out.println(rec.get("DateUTC")+"  "+rec.get("TemperatureF"));
    }
    public String fileWithColdestTemperature()
    {
        String coldestfile=null;
        Double mintemp=0.0;
        File mintempfile=null;
        DirectoryResource dr= new DirectoryResource();
        for(File f:dr.selectedFiles())
        {
            FileResource fr=new FileResource(f);
            CSVRecord currentrecord=coldestHourInFile(fr.getCSVParser());
            if(mintemp==0.0) {
                mintempfile=f;
                mintemp=Double.parseDouble(currentrecord.get("TemperatureF"));
            }
            else
            {
                if(mintemp>Double.parseDouble(currentrecord.get("TemperatureF")))
                {
                    if( Double.parseDouble(currentrecord.get("TemperatureF"))>=0.0 ) {
                        mintempfile=f;
                        mintemp = Double.parseDouble(currentrecord.get("TemperatureF"));
                    }
                }
            }
        }
        coldestfile=mintempfile.toString();
        return coldestfile;
    }
    public void testFileWithColdestTemperature()
    {
        String fname=fileWithColdestTemperature();
        System.out.println(" file with Coldest temperature is :"+fname);
        testColdestHourInFile(fname);
        readCSV(fname);
    }
    public CSVRecord lowestHumidityInFile(CSVParser parser)
    {
        int lowesthumidity=0,tmp=0;
        CSVRecord rec=null;
        for(CSVRecord curr : parser)
        {
            String hum=curr.get("Humidity");
            if(hum.equals("N/A"))
                continue;
            tmp=Integer.parseInt(hum);
            if(rec==null) {
                lowesthumidity=tmp;
                rec=curr;
            }
            else
            {
                if(lowesthumidity>tmp)
                {
                    lowesthumidity=tmp;
                    rec=curr;
                }
            }
        }
        return rec;
    }
    public void testTowestHumidityInFile()
    {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord csv = lowestHumidityInFile(parser);
        System.out.println("Lowest humity in file found was :"+csv.get("Humidity")+" at "+csv.get("DateUTC"));
    }
    public CSVRecord lowestHumidityInManyFiles()
    {
        CSVRecord rec=null;
        int lowesthumidity=0,tmp=0;
        String humidity=null;
        DirectoryResource dr= new DirectoryResource();
        for(File f:dr.selectedFiles())
        {
            FileResource fr=new FileResource(f);
            CSVRecord currentrecord=lowestHumidityInFile(fr.getCSVParser());
            humidity=currentrecord.get("Humidity");
            tmp=Integer.parseInt(humidity);
            if(rec==null) {
                rec=currentrecord;
                lowesthumidity=tmp;
            }
            else
            {
                if(lowesthumidity>tmp)
                {
                    lowesthumidity=tmp;
                    rec=currentrecord;
                }
            }
        }
        return rec;
    }
    public void testLowestHumidityInManyFiles()
    {
        CSVRecord rec=lowestHumidityInManyFiles();
        System.out.println("Lowest humidity was at "+rec.get("Humidity")+" "+rec.get("DateUTC"));
    }
    public double aveargeTemperature(CSVParser parser)
    {
        double avgtemp=0.0;
        String tmp;
        int count=0;
        for(CSVRecord rec:parser)
        {
            tmp=rec.get("TemperatureF");
            if(Double.parseDouble(tmp)>=0)
            {
                count++;
                avgtemp+=Double.parseDouble(tmp);
            }
        }
        return avgtemp/count;
    }
    public void testAverageTemperature()
    {
        FileResource fr = new FileResource();
        System.out.println("Average temperature in file is  "+aveargeTemperature(fr.getCSVParser()));
    }
    public double averageTemperatureWithHighHumidityInFile(CSVParser parser,int value)
    {
        double res=0.0;
        int count=0;
        String tmp=null;
        String humidity=null;
        for(CSVRecord rec:parser)
        {
            humidity=rec.get("Humidity");
            if(humidity.equals("N/A"))
                continue;
            else
            {
                tmp=rec.get("TemperatureF");
                if(Integer.parseInt(humidity)>value)
                {
                    if(Double.parseDouble(tmp)>=0)
                    {
                        count++;
                        res+=Double.parseDouble(tmp);
                    }
                }
            }
        }
        return res/count;
    }
    public  void testAverageTemperatureWithHighHumidityInFile()
    {
        FileResource fr= new FileResource();
        System.out.println("Average Temp when high Humidity is "+averageTemperatureWithHighHumidityInFile(fr.getCSVParser(),80));
    }
    public static  void main(String args[])
    {
        ParsingWeatherData  obj = new ParsingWeatherData();
        obj.testColdestHourInFile();
        obj.testFileWithColdestTemperature();
        obj.testTowestHumidityInFile();
        obj.testLowestHumidityInManyFiles();
        obj.testAverageTemperature();
        obj.testAverageTemperatureWithHighHumidityInFile();
    }
}