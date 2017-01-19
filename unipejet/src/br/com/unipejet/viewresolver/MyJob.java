package br.com.unipejet.viewresolver;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.unipejet.daos.VoosDAO;
import br.com.unipejet.models.Voos;

@Transactional
public class MyJob implements Job {
    
	@Autowired
	VoosDAO voosDAO;
	@Override
    public void execute(JobExecutionContext context)
            throws JobExecutionException {
    
 	   

		
		 Teste teste = new Teste();
		 List <Voos> voos =  teste.list();
	 	 

		 for(Voos voo : voos)
	 	    {
	           
	 	    	String data_voo = voo.getData();
	 	    	int identificador = voo.getIdentificador();
	 	    	double preco = voo.getPreco();
	 	    	int dias = verificaData(data_voo);
	 	    	int status = voo.getStatus();
	 	    	
	 	    	if(dias <= 7 && status == 0) 
	 	    	{
	 	    		double porcentagem = ((preco * 0.3) + preco); 
	 	    	    voo.setPreco(porcentagem);
	 	    	    voo.setIdentificador(identificador);
	 	    		voo.setStatus(1);
	 	    	    teste.altera(voo);
	 	    	
	 	               		
	 	    	}
	 	   
	 	    	
	 	    }
	
	    
	}
 	
 	
    	    public int verificaData(String data_voo){
    		
            SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/yyyy");
            Date data_hoje = new Date();
            String hoje = formataData.format(data_hoje);
            
            
            System.out.println("Agendamento sendo executado... Atualizando valores dos Voos com menos de uma semana");   		
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
