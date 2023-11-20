package com.learning.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.learning.service.QuestionService;
import com.learning.util.QuizAppUtility;

public class Launch {
	public static void main(String args[]) {
		@SuppressWarnings("resource")
		ApplicationContext context=
				new ClassPathXmlApplicationContext("ApplicationContext.xml");
		QuestionService service= context.getBean("questionService",QuestionService.class);
		
		
		QuizAppUtility.displayWelcome();
		QuizAppUtility.displayRules();
		try {
			Thread.sleep(4000);	
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		service.playQuiz();
	}

}
