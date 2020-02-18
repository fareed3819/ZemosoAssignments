/*
Using the documentation for java.util.regex.Pattern as a resource, write and test a regular expression that checks a sentence to see that it begins with a capital letter and ends with a period.
 */
package Assignment9;
import java.util.*;
import java.util.regex.*;

class RegEx{
    public static void main(String args[]){
        String regex="^[A-Z].*[.]";
       // String line=args[0];
        String line="Ads342.";   //testing input
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher=pattern.matcher(line);
        if(matcher.find()) System.out.println("found");
        else System.out.println("not found");
    }
}
