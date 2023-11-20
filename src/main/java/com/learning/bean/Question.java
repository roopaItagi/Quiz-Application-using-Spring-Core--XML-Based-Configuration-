package com.learning.bean;

public class Question {
	    private String question;
	    private String opt1;
	    private String opt2;
	    private String opt3;
	    private String opt4;

	    public Question(String question, String opt1, String opt2, String opt3, String opt4) {
	    	this.question = question;
	        this.opt1 = opt1;
	        this.opt2 = opt2;
	        this.opt3 = opt3;
	        this.opt4 = opt4;

	    }
	    @Override
		public String toString() {
			return question + 
					"\n" + opt1 + 
					"\n" + opt2 + 
					"\n" + opt3 + 
					"\n" + opt4 ;
		}
}
