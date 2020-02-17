package ArraysListsAndStructedDAta.Week3;

import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le =WebLogParser.parseEntry("110.76.104.12 - - [30/Sep/2015:07:47:11 -0400] \"GET //favicon.ico HTTP/1.1\" 200 3426");
        System.out.println(le);
    }
    public void testwithHashMap()
    {
        LogAnalyzer la=new LogAnalyzer();
        la.readFile("src/weblog3-short_log");
        HashMap<String,Integer> counts=la.countVisitsPerIp();
        System.out.println("Most no of vists by ip :"+la.mostNumberVisitsByIP(counts));
        ArrayList<String> mostvistedip=la.iPsMostVisits(counts);
        System.out.println("Ips that are most visited");
        for(String i:mostvistedip)
            System.out.print(i+"\t");
        System.out.println();
        HashMap<String,ArrayList<String>> ipsonday=la.iPsForDays();
        System.out.println("Day on which most ips visited: "+la.dayWithMostIPVisits(ipsonday));
        ArrayList<String> ipswithmostvistsonaday=la.iPsWithMostVisitsOnDay(ipsonday,"Sep 30");
        System.out.println("ipswithmostvistsonaday on sep 30");
        for(String i:ipswithmostvistsonaday)
            System.out.print(i+"\t");
    }
    public void testLogAnalyzer() {
        LogAnalyzer le = new LogAnalyzer();
        le.readFile("src/short-test_log");
        le.printAll();
    }
    public static void main(String args[]) {
        Tester obj= new Tester();
        //obj.testLogEntry();
       // obj.testLogAnalyzer();
        obj.testwithHashMap();
    }
}