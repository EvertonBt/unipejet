package br.com.unipejet.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Data{ 

	public String converteData(){


		Date dataHoje = new Date();
		SimpleDateFormat formataData = new SimpleDateFormat("yyyy-MM-dd");
		String data = formataData.format(dataHoje);
        System.out.println(data);
		
        return data;
        
        /*Converte de String para Data
        SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/yyyy");
        Date dataEntrada = null;
        try { 
            dataEntrada = formataData.parse("21/09/2010");
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
*/
        

	}
        public String dataHoje(){
    	

    		Date dataHoje = new Date();
    		SimpleDateFormat formataData = new SimpleDateFormat("dd-MM-yyyy:HH:mm");
    		String data = formataData.format(dataHoje);
    	    return data;
    		
    	    
    		}
    	
    
        public int verificaVoo (String data_voo){
    		
            SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/yyyy");
            Date data_hoje = new Date();
            data_voo = "04/10/2016";
            String hoje = formataData.format(data_hoje);
            
            
            System.out.println("Data de hoje: " + hoje);   		
            Date d_hoje = null;
        	Date d_voo = null;
            try {
        		d_hoje = formataData.parse(hoje);
        	    d_voo = formataData.parse(data_voo);
        	
        	} catch (ParseException e) {
        		// TODO Auto-generated catch block
        		e.printStackTrace();
        	}
        	int dias = (int)((d_voo.getTime() - d_hoje.getTime()) / 86400000L);
            return dias;
        	 
        			
        }
        
        
       
}
