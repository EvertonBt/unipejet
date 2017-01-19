package br.com.unipejet.viewresolver;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Principal {

		public static void main(String[] args) {

			ApplicationContext context = 
	               new ClassPathXmlApplicationContext
	              ("applicationContext.xml");
		}
	}
	
