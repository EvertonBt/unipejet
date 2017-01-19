// Fazendo copia do conteúdo do select "roles" para o campo hidden "role"

$(function($){
	 
    $('#roles').change(function(){
    var role = $('#roles').val();
 
    
    $('#role').attr({
   	   'value': role
   	  
   	});
     
      });
      
      
    });


// Validação de campos via jquery

$(document).ready(function(){
	$('#formulario').validate({
	 rules: {
		 
	senha_testa: {
	   required: true,
	   equalTo: "#password"
	 
	 },
	
	 documento: {
		required: true,
	
		 
	 },
	 
	 name: {
			required: true,
		
			 
		 },
		 
		 password: {
				required: true,
			
				 
			 },
		 login: {
				required: true,
			    
				 
			 }	 
	 
	 },
	
	messages:
	{
		 senha_testa: {
	         required: "Campo obrigat\xF3rio",
	         equalTo: "As senhas devem ser iguais"

	},
	  
	 documento: {
         required: "Campo obrigat\xF3rio",
       

},
	 

	 
	 name: {
			required: "Campo obrigat\xF3rio"
		
			 
		 },
		 
		 password: {
				required: "Campo obrigat\xF3rio"
			
				 
			 },
		 login: {
				required: "Campo obrigat\xF3rio"
			
				 
			 }
	
	
	 
	}

	});

	});
 

// Calcula a idade a partir da data e faz a validação em seguida


$(function($){
	 
   
    $('#releaseDate').blur(function(){
 
 
      var data = $('#releaseDate').val();
 
        dataAtual = new Date(data);
        var ano = dataAtual.getYear();
        var idade = 116 - ano;
       
    	$('#idade').attr({
       	   'value': idade
       	  
       	});
    	
    });
});


// Renderiza botão rg->cpf

$("#cpf").click(function() {
    document.getElementById("documento").placeholder = "Digite o seu CPF"
    
    
    
  });
   $("#rg").click(function() {
    document.getElementById("documento").placeholder = "Digite o seu RG"
  });


