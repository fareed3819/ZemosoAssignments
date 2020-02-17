package assignment11;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

class CharacterCount
{
    public static void main(String args[]){
        String fileName=args[0];
        int i=0;
        HashMap<String,Integer> map=new HashMap<String,Integer>();

        try{
            BufferedReader br= new BufferedReader(new FileReader(fileName));

            //inserting the characters in a map
            while((i=br.read())!=-1){
                char temp=(char)i;
                String c="";
                if(temp=='\n') c="\\n";
                else if(temp=='\t') c="\\t";
                else if(temp==' ' )  c="space";
                else c=Character.toString(temp);
                if(map.containsKey(c)) map.replace(c,map.get(c)+1);
                else map.put(c,1);

            }

            //creating and putting the map into ouput.txt
            BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
            for (Map.Entry element : map.entrySet()){
                String key = (String)element.getKey();
                int value=(int)element.getValue();
                bw.write("the charater  "+key+"  occured  "+value+" times");
                bw.newLine();

            }
            bw.close();
        }
        catch(Exception e){
            System.out.println("File doesnot Exist");
        }
    }
}