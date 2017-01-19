$(document).ready(function(){
	$('#formulario').validate({
	 rules: {

	   origem: {
	         required: true
	         

	},
	   destino: {

	      required: true
	     

	},

	    duracao: {

	   required: true
	},

	    distancia: {
	    
	    required: true,
	    
	},

	   preco: {
	    required: true
	    

	},
	capacidade: {
       required: true

	},

	 hora_partida: {
	   required: true,
	  
	 
	 }
	},
	
	messages:
	{
		 origem: {
	         required: "Campo obrigatório"
	         

	},
	   destino: {

	      required: "Campo obrigatório"
	     

	},

	    duracao: {

	   required: "Campo obrigatório"
	},

	    distancia: {
	    
	    required: "Campo obrigatório"
	    
	},

	   preco: {
	    required: "Campo obrigatório"
	    

	},
	capacidade: {
       required: "Campo obrigatório"

	},

	 hora_partida: {
	   required: "Campo obrigatório"
	  
	 
	 }

	}

	});

	});
