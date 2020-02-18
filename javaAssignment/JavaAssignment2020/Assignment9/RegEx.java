/*
Using the documentation for java.util.regex.Pattern as a resource, write and test a regular expression that checks a sentence to see that it begins with a capital letter and ends with a period.
 */
package Assignment9;

import javax.imageio.ImageTranscoder;
import java.util.*;
import java.util.regex.*;
class RegExCheck{
    public boolean matchRegex(String regex,String input)
    {
        Pattern p = Pattern.compile(regex);
        Matcher m=p.matcher(input);
        if(m.find()) return true;
        return false;
    }
    public static void main(String args[]){
        String inputRegex="^[A-Z].*$[.]";
       // String line=args[0];
        String input="Ads342./";

        if(new RegExCheck().matchRegex(inputRegex,input))
            System.out.println("regex Matched");
        else
            System.out.println("unmatched sentence");

    }
}
