package br.com.unipejet.infra;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class Timer {

	   
		@Scheduled(fixedRate = 5 * 1000)
		public static void main(String[] args) {
			// TODO Auto-generated method stub

			
		        String senha = "123456";
		        BCryptPasswordEncoder senhaBCrypt = new BCryptPasswordEncoder();
		        System.out.println(senhaBCrypt.encode(senha));
		        
		        
		        
		        
		        //$2a$10$nfI4z7eMVkYNfNK4InZXv.MpmN1Yeon8Ir16klHeTBIeA3GwUsD7S
	/*
		        Date dataAserFormatada = new Date();
		        String dataFormatada ="1987/08/12";
		         SimpleDateFormat formataData = new SimpleDateFormat("dd-MM-yyyy");
		                dataFormatada= formataData.format(dataAserFormatada);
		  System.out.println(dataFormatada);
		*/              
		     //   String s;
		        Format formatter;
		        Date date = new Date();

		        // 01/09/02
		      /*  formatter = new SimpleDateFormat("MM/dd/yy");
		        s = formatter.format(date);
		        System.out.println(s);
	*/          
		       String  valor = "2009-01-01";
		        String data = valor.replaceAll("-", "/");
		        String[] s = data.split("/");
		        String novaData = s[2]+"/"+s[1]+"/"+s[0];
		        System.out.println(novaData);
		}
			
		}



	
