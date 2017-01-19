<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="pt-br">
 <head>
 <meta charset="UTF-8">
 <title>Unipê Airlines</title>
 <link rel="stylesheet" href="<c:url value='/resources/css/login.css'/>">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script> 
 <script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.1.0.min.js"></script>
 <script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.15.0/jquery.validate.min.js"> </script> 

<style>  label.error{color: red; padding: 2px}</style>
<style>

</style>
  
  </head>
  <body>
    <div class="login-wrap">
    <h2> Novo Usuario </h2>
      <div class="form">

        
        
<form:form servletRelativeAction="/salva_usuario" method="post"  commandName="user" id="formulario">
		<span style="color: blue; margin: 10px;"]> ${sucesso } </span>
    
    	<div>
			<label for="login">Login (email)</label>
			<form:input type="text"  path="login" id="login" name="login" placeholder="Digite o seu email" required="true"/>
			<form:errors path="login" style="color: red;; margin-left: 30px;" />
		</div>
    
    
	<div>
			<label for="nome"> Nome</label>
			<form:input  path="name" id="name" name="name" type="text" placeholder="Digite o seu nome"/>
            <form:errors path="name" style="color: red; margin-left: 30px;"/>
	</div>
		
		
	<div>
			<label for="tipo_documento"> Tipo de Documento: </label><br>
		    <label for="cpf">CPF</label><input name="tipo_documento" type="radio" id="cpf" value="CPF" />
		    <label for="id"> RG</label><input name="tipo_documento" type="radio" id="rg" value="RG" checked/>
		    <form:input path="documento" type="text" id="documento" name="documento" required="true" placeholder="Digite o seu RG"/>
		 	<form:errors path="documento" style="color: red; text-align: center; "/>
	
	</div>
	
		<div>
			<label for="password"> Senha</label>
			<form:input  path="password" id="password" name="password" type="password"/>
			<form:errors path="password" style="color: red; text-align: center; "/>
		</div>

       	<div>
			<label for="password"> Senha Novamente</label>
			<form:input  path="senha_testa" id="senha_testa" name="senha_testa" type="password"/>
			<form:errors path="senha_testa" style="color: red; text-align: center; "/>
		</div>
   
		
    <div>
	<label for="releaseDate">Data de Nascimento</label>
	<form:input path="releaseDate" type="date" name="releaseDate" id="releaseDate" />
	<form:errors path="releaseDate" style="color: red; text-align: center; " />
	</div>
 

<sec:authorize access="hasRole('ROLE_ADMIN')">
  <div align="center">
 <select name="roles[0].name"  style="width: 260px; height: 25px" id="roles">
  <option value="ROLE_CLIENTE" selected> CLIENTE (conta limitada)</option>
  <option value="ROLE_ADMIN"> ADMINISTRADOR</option>
 </select>	
  <input type="hidden" name="role"  id="role" value="ROLE_CLIENTE"/>
  </div>
</sec:authorize>

 
 <sec:authorize access="isAnonymous()">  

  <input  type="hidden" name="role" value="ROLE_CLIENTE"/>
  <input  type="hidden" name="roles[0].name" value="ROLE_CLIENTE"/>

</sec:authorize>
   
    <sec:authorize access="hasRole('ROLE_CLIENTE')">  

  <input  type="hidden" name="role" value="ROLE_CLIENTE"/>
  <input  type="hidden" name="roles[0].name" value="ROLE_CLIENTE"/>

</sec:authorize>
   

   
			<label for="cartao_milha"></label>
			<input type="hidden" name="cartao_milha"/>		
		    <input type="hidden" name="cartao_credito" value="10000"/>
		   
			
				
		<form:input path="idade" name="idade" type="text" id="idade" style="display: none"/>
        <form:errors path="idade" style="color: red"/>
<div>
<input type="submit" value="Enviar">
</div>

</form:form>
        

        
      </div>
    </div>
<script type="text/javascript" src="<c:url value='/resources/js/arquivo.js'/>"> </script> 
 
 
</body>
</html>
