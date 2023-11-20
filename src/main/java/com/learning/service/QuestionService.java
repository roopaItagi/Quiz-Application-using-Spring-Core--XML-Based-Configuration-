package com.learning.service;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import com.learning.bean.Question;
import com.learning.util.QuizAppUtility;

public class QuestionService {
	
	List<Question> questions;
	private String[] answers= {"4","4","4","1","4"};
	
	
	Scanner scanner;
	int score;

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public String[] getAnswers() {
		return answers;
	}

	public void setAnswers(String[] answers) {
		this.answers = answers;
	}

	public Scanner getScanner() {
		return scanner;
	}

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}


	public QuestionService(List<Question> questions) {
		super();
		this.questions = questions;
	}

	public void playQuiz() {
		
		try {
			Thread.sleep(4000);	
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		startQuiz();
		
	}
	private void startQuiz() {
		boolean playAgain;	        
	        	do {
	        		int i=0;
	        		this.score=0;
	        		//Iterate through each question
	                for (Question q : questions) {
	                    try {
	                        System.out.println("Question: " + (i+1));
	                        System.out.println(q.toString());
	                        System.out.println("Enter the right option: or type s to skip this question");
	                       
	                        String userInput = readDataFromConsole();
	                        validateInput(userInput,i);
	                        
	                    }catch (Exception e) {
	                        e.printStackTrace();
	                    }	                        
	                    i++;
	                }
	                System.out.println("Your final score is : " + this.score + "/" + questions.size());
	                System.out.println("------------------------------------------------------");
	                System.out.println("Do you want to play again?Y/N : ");
		            String ready = scanner.next();
		            if (ready != null && ready.equalsIgnoreCase("Y")) {
		                playAgain = true;
		            } else {
		                playAgain = false;
		                break;
		                }
	                
  	        	}while (playAgain);
	        System.out.println("-----------------------------------------");
	        System.out.println("Thanks For Using Quiz Application\nSee you again");
	        System.out.println("-----------------------------------------");
	             
	    }
	
	 public static String readDataFromConsole() throws InterruptedException{
	        ExecutorService ex = Executors.newSingleThreadExecutor();//Returns: the newly created single-threaded Executor
	        String input1 = null;
	        try {
	            Future<String> result = ex.submit(
	                    new ConsoleInputReadTask());
	            try {
	                input1 = result.get(10, TimeUnit.SECONDS);

	            } catch (ExecutionException e) {
	                e.getCause().printStackTrace();
	            } catch (TimeoutException e) {
	                result.cancel(true);
	                System.out.println("\nTimeout!");
	                System.out.println("------------------------------------------------------");
	            }
	        }
	        finally {
	            ex.shutdownNow();
	        }
	        return input1;
	    } 
	 private void validateInput(String userInput,int i) {
		 if ("s".equalsIgnoreCase(userInput)) {	                            
             System.out.println("skipping question");	                           
             System.out.println("------------------------------------------------------");
         } 
         else if(null!=userInput && !userInput.isEmpty()) {
             if (QuizAppUtility.checkforInteger(userInput)) {                         
                 if (userInput.equals(answers[i])) {
                     System.out.println("Correct Answer");
                     this.score++;
                 } else {
                     System.out.println("Wrong answer!!!!");
                     System.out.println("The correct option is : " + answers[i]);
                     this.score--;
                 }
                 System.out.println("Your current score is : " + this.score + "/" + questions.size());
                 System.out.println("------------------------------------------------------");
             }else{
                 System.out.println("Invalid Input!!!!");
                 System.out.println("------------------------------------------------------");
             }
         }
	 }
}
