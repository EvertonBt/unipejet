package br.com.unipejet.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.unipejet.daos.RegistroCompraDAO;
import br.com.unipejet.daos.UserDAO;
import br.com.unipejet.daos.VoosDAO;

import br.com.unipejet.models.Role;
import br.com.unipejet.models.User;
import br.com.unipejet.models.Voos;

import br.com.unipejet.validation.UserValidator;
import br.com.unipejet.viewresolver.Agendamento;



@Controller
@Transactional
public class UsuarioController {

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private VoosDAO voosDAO;


	@Autowired
	private RegistroCompraDAO rcDAO;
	
	//Método que chama o formulario de login
	@RequestMapping("/login")
	public String loginPage(){
		
		 Agendamento.main(null);	
		return "auth/login";
	}
	
	
	
	// Método que chama o formulario de cadastro
	@RequestMapping("/cadastro")
	public ModelAndView cadastroPage(User user){
	ModelAndView modelAndView = new ModelAndView("auth/cadastro");
	return modelAndView;
	}
	

	//Método que chama a página inicial (a home)
	@RequestMapping("/")
	public ModelAndView homePage(User user){
	   
		
		ModelAndView modelAndView = new ModelAndView("auth/home");
		long contador = userDAO.contaRegistros();
		double cartao_credito = user.getCartao_credito();
		long contador_voo = voosDAO.contaRegistros();
		long contador_registros = rcDAO.contaRegistros();
		modelAndView.addObject("contador_voo", contador_voo);
		modelAndView.addObject("contador", contador);
		modelAndView.addObject("contador_registros", contador_registros);
		System.out.println(cartao_credito);
		return modelAndView;
		
	}
	
	
	@RequestMapping("/logout")
	public String logoutPage(){
		return "auth/login?logout";
	}
	
	
	
	
    // Método que efetivamente cadastra os usuários (falta melhorar o validação de campos CPF e RG)
	
	@RequestMapping(value="/cadastrar",method=RequestMethod.POST)
	public ModelAndView save(@Valid User user, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) throws SQLException{
		       
		if(bindingResult.hasErrors()){
			return cadastroPage(user);
			
		}
		
		User verifica_login = userDAO.find(user.getLogin());
		if(verifica_login != null)
			{
			
		

		    
	    redirectAttributes.addFlashAttribute("sucesso", "Usuário já existe, escolha outro login");
              
        return new ModelAndView("redirect:cadastro");
			
			}
	    
		else{
		
          // Criptografando a senha antes de armazenar no banco
		    String senha = user.getPassword();
	        BCryptPasswordEncoder senhaBCrypt = new BCryptPasswordEncoder();
	        senha  = senhaBCrypt.encode(senha);
		    user.setPassword(senha);
	        user.setSenha_testa(senha);
		  // Gerando um número qualquer para o cartao de milhas  
		    
		    Calendar valor = Calendar.getInstance();
		    long cartao_milhas = valor.getTimeInMillis();
		    user.setCartao_milha(cartao_milhas);	    
		   
	
		    userDAO.save(user);
            
		    
              	
		  //  System.out.println(user.getCa)
		    redirectAttributes.addFlashAttribute("sucesso", "Usuário cadastrado com sucesso");
	              
	        return new ModelAndView("redirect:cadastro");
		
		}
	}
	
	
	  // Faz a listagem de todos os usuários cadastrados
	   @RequestMapping(value = "/listar", method=RequestMethod.GET)
	   public ModelAndView list(){
	   ModelAndView modelAndView = new ModelAndView("auth/lista_usuarios");
	   modelAndView.addObject("users", userDAO.lista());
	   return modelAndView;
	   }
	
	  // Chama a página de Edição de um usuário específico
	 
       @RequestMapping("/editar")
	   public ModelAndView edita(String login){
	   
       System.out.println(login);   
       ModelAndView modelAndView =
	   new ModelAndView("auth/edita_usuario");
	   User user = userDAO.find(login);
	   modelAndView.addObject("user", user);
	   return modelAndView;
	   }
	
	   
       
       // Efetua a edição de um usuário específico
       @RequestMapping(value="/efetuar_alteracao",method=RequestMethod.POST)
   	public ModelAndView efetuar_alteracao(@Valid User user, BindingResult bindingResult,
   			RedirectAttributes redirectAttributes){
   		  
    	   
   		if(bindingResult.hasErrors()){
   	         
   			
   			
   			return edita(user.getLogin());
   	
   		 
   		
   		}
   		/*
   		  String senha_testa  = user.getSenha_testa(); 
   		  String password = user.getPassword();
          if (senha_testa.equals(password)){
        	  
  	       
  		    user.setPassword(senha_testa);
            user.setSenha_testa(senha_testa);
        	  
          }
   		 */
         
          
        	  BCryptPasswordEncoder senhaBCrypt = new BCryptPasswordEncoder();
    	      String senha_cripto  = senhaBCrypt.encode(user.getPassword());
    	      user.setPassword(senha_cripto);
              user.setSenha_testa(senha_cripto);
          
   		 
   		       userDAO.altera(user);
          
   		      redirectAttributes.addFlashAttribute("sucesso", "Usuário editado com sucesso");
   	              
   	           return new ModelAndView("redirect:/");
   		
   	
   	}
   	
       
   	
   	// Remove usuario cadastrado
    	@RequestMapping("/remove_usuario")
    	public ModelAndView remove_usuario(String login, RedirectAttributes red) {
    	
    		
        User user = userDAO.find(login);
        userDAO.remove(user);
       
        red.addFlashAttribute("sucesso", "Usuário removido com sucesso");
        return new  ModelAndView("redirect:/listar");
    	}
	   
       
	   
    	// Método que chama o formulario de cadastro
    	@RequestMapping("/novo_usuario")
    	public ModelAndView novo_usuario(User user){
    	ModelAndView modelAndView = new ModelAndView("auth/novo_usuario");
    	return modelAndView;
    	}
    	
    	
    	
    	
    	// Método que efetivamente cadastra os usuários 
    	
    	@RequestMapping(value="/salva_usuario",method=RequestMethod.POST)
    	public ModelAndView salva_usuario(@Valid User user, BindingResult bindingResult,
    			RedirectAttributes redirectAttributes) throws SQLException{
    		       
    		if(bindingResult.hasErrors()){
    			return novo_usuario(user);
    			
    		}
    		
    		User verifica_login = userDAO.find(user.getLogin());
    		if(verifica_login != null)
    			{
    			
    			System.out.println("Deu águia");
    		  
    		    
    	    redirectAttributes.addFlashAttribute("sucesso", "Usuário já existe, escolha outro login");
                  
            return new ModelAndView("redirect:novo_usuario");
    			
    			}
    	    
    		else{
    		
              // Criptografando a senha antes de armazenar no banco
    		    String senha = user.getPassword();
    	        BCryptPasswordEncoder senhaBCrypt = new BCryptPasswordEncoder();
    	        senha  = senhaBCrypt.encode(senha);
    		    user.setPassword(senha);
    	        user.setSenha_testa(senha);
    		  // Gerando um número qualquer para o cartao de milhas  
    		    
    		    Calendar valor = Calendar.getInstance();
    		    long cartao_milhas = valor.getTimeInMillis();
    		    user.setCartao_milha(cartao_milhas);	    
    		   
    	
    		    userDAO.save(user);
                
    		    
                  	
    		  //  System.out.println(user.getCa)
    		    redirectAttributes.addFlashAttribute("sucesso", "Usuário cadastrado com sucesso");
    	              
    	        return new ModelAndView("redirect:listar");
    		
    		}
    	}
    	
    	
    	
 	// Método que efetivamente cadastra os usuários a partir do cadastro
    	
    	@RequestMapping(value="/salva_usuario_cadastro",method=RequestMethod.POST)
    	public ModelAndView salva_usuario_cadastro(@Valid User user, BindingResult bindingResult,
    			RedirectAttributes redirectAttributes) throws SQLException{
    		       
    		if(bindingResult.hasErrors()){
    			return cadastroPage(user);
    			
    		}
    		
    		User verifica_login = userDAO.find(user.getLogin());
    		if(verifica_login != null)
    			{
    			
    			System.out.println("Deu águia");
    		  
    		    
    	    redirectAttributes.addFlashAttribute("sucesso", "Usuário já existe, escolha outro login");
                  
            return new ModelAndView("redirect:/cadastro");
    			
    			}
    	    
    		else{
    		
              // Criptografando a senha antes de armazenar no banco
    		    String senha = user.getPassword();
    	        BCryptPasswordEncoder senhaBCrypt = new BCryptPasswordEncoder();
    	        senha  = senhaBCrypt.encode(senha);
    		    user.setPassword(senha);
    	        user.setSenha_testa(senha);
    		  // Gerando um número qualquer para o cartao de milhas  
    		    
    		    Calendar valor = Calendar.getInstance();
    		    long cartao_milhas = valor.getTimeInMillis();
    		    user.setCartao_milha(cartao_milhas);	    
    		   
    	
    		    userDAO.save(user);
                
    		    
                  	
    		  //  System.out.println(user.getCa)
    		    redirectAttributes.addFlashAttribute("sucesso", "Usuário cadastrado com sucesso");
    	              
    	        return new ModelAndView("redirect:/login");
    		
    		}
    	}
    	
    	
    	
	   
	
/*
	  Usando validações mais básicas
	  
	  @InitBinder // indica que esse método será chamado para validação, o método abaixo aponta para a classe que fará a validaçã, no caos o UserValidator
	  protected void initBinder(WebDataBinder binder) {
	  binder.setValidator(new UserValidator());
	  }
	  
*/
	
	
	/* Tentando modificar a data com ajax (não deu certo)
	
		@RequestMapping("converteData")
		public void finaliza(String data, HttpServletResponse response) throws IOException {
			response.getWriter().write("Valeu");
			response.setStatus(200);
			
		}
		
*/
		
		
		

	
}
