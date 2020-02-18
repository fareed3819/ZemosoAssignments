/*
1. A vampire number v is a number with an even number of digits n, that can be factored into two numbers x and y each with n/2 digits and not both with trailing zeroes, where v contains precisely all the digits from x and from y, in any order. Write a java program to print first 100 vampire numbers.

 */

package assignment6;

import java.util.*;
class Vampire
{
    public static void main(String[] args) {
        int vampireCount=0;
        boolean isVampire=false;
        for(int i=1260;vampireCount!=100;i++){
            if(Integer.toString(i).length()%2==0){
                isVampire=checkVampire(i);
                if(isVampire)
                    vampireCount++;}
        }
    }

    public static int genNum(int length){
        String a="1";
        while(a.length()!=length)
            a=a+"0";
        return Integer.parseInt(a);
    }

    public static HashMap insertMap(String name){
        HashMap<Character,Integer> map=new HashMap<Character,Integer>();
        for(char a:name.toCharArray()){
            if(map.containsKey(a)) map.put(a,map.get(a)+1);
            else map.put(a,1);
        }
        return map;
    }

    public static boolean equate(HashMap<Character,Integer> map1,HashMap<Character,Integer> map2){
        if(map1.size()!=map2.size()) return false;
        for(Map.Entry m:map1.entrySet()){
            if(map2.get(m.getKey())!=m.getValue()) return false;
        }
        return true;
    }

    public static int  getFinal(int length){
        String a="9";
        while(a.length()!=length)
            a=a+"9";
        return Integer.parseInt(a);
    }

    public static boolean checkVampire(int num){
        HashMap<Character,Integer> map;
        String numString=Integer.toString(num);
        map=insertMap(numString);
        int length=numString.length()/2;
        
        int initialNum=genNum(length);
        int finalNum=getFinal(length);

        //checking with possible integers as factors
        for(int i=initialNum;i<=finalNum;i++){
            int flag=0;
            HashMap<Character,Integer> testMap;
            if(num%i==0 && Integer.toString(num/i).length()==length ){
                int factorA=i;
                int factorB=num/i;
                String total=Integer.toString(factorA)+Integer.toString(factorB);
                testMap=insertMap(total);

                if(equate(testMap,map)){
                    System.out.println(num+"  "+factorA+ " "+factorB);
                    return true;
                }
            }
        }
        return false;
    }
}
