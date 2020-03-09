package Assignment1;


/*
Create a java program to search through the home directory and look for files that match a regular expression. The program should be able to take inputs repeatedly and should print out the full absolute path of the matching files found.
Provide appropriate documentation and comments on your code.
 */

import java.io.*;
import java.util.regex.*;
import java.util.logging.Logger;

class MatchingFiles {
    static Pattern pattern;
    static Logger logger = Logger.getLogger(MatchingFiles.class.getName());

    /*
    This method takes path and regular expression as parameters .
    it checks all the files exists in path recurrsively and stores the result of matched files absolutepath into string.
    It concatenates all the matched files absolute paths and returns the result as a string.
     */

    public static void main(String[] args) {
        try {
            while (true) {
                System.out.println("Enter the regex to search (CTRL+C to quit): ");
                String regex = new BufferedReader(new InputStreamReader(System.in)).readLine();
                String result = searchForMatchedFiles(System.getProperty("user.home"), regex);
                logger.info("result is" + result);
            }
        } catch (Exception e) {
            logger.info("Exception occured this may due to reading files having no read permissions or input error");
            e.printStackTrace();
        }
    }
    public static String searchForMatchedFiles(String path, String regex) {
        String res = "";
        File folder = new File(path);
        pattern = Pattern.compile(regex);
        for (File file : folder.listFiles()) {
            if (file.isHidden())
                continue;
            if (file.isFile() && pattern.matcher(file.getName()).matches()) {
                logger.info("regex matched file found and  its absolute path is" + file.getAbsolutePath());
                res = res + file.getAbsolutePath();
            }
            else if (file.isDirectory()) {
                searchForMatchedFiles(file.getAbsolutePath(), regex);
            }
        }
        if (res != "")
            return res;

        return "Not found";
    }

}
