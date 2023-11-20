package com.learning.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class QuizAppUtility {
	public static void displayWelcome() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        System.out.println(dateFormat.format(cal.getTime()));

        System.out.println("###############################################################");
        System.out.println("                       Welcome to QuizApp                      ");
        System.out.println("###############################################################");

    }
	 public static void displayRules() {
	        System.out.println("##########################################################################");
	        System.out.println("Please read the Quiz rules:  ");
	        System.out.println("**There are total 5 questions and Time limit for each question is 10 seconds.");
	        System.out.println("**You have the option to skip the question if you do not want to answer.");
	        System.out.println("**1 point will be deducted from your score for each wrong answer.");
	        System.out.println("##########################################################################");
	    }
	 public static boolean checkforInteger(String skipScan){
	        boolean result=false;
	        if(skipScan.equalsIgnoreCase("1")||
	                skipScan.equalsIgnoreCase("2")||
	                skipScan.equalsIgnoreCase("3")||
	                skipScan.equalsIgnoreCase("4")){
	            result=true;
	        }
	        return result;
	    }
	 public static void displayTopic() {
	        System.out.println(" Please select the topic for your quiz from the below options:");
	        System.out.println("1.Core java programming");
	        System.out.println("2.General Knowledge");
	    }
}
