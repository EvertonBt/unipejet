<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html;
charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


<sec:authorize access="isAuthenticated()">
		<sec:authentication property="principal" var="user"/>
		<div>
Olá ${user.name}
</div>
	</sec:authorize>


<span style="color:blue; text-align: center"> ${sucesso} </span>

<sec:authorize access="hasRole('ROLE_ADMIN')">
<li><a href="/cadastro">Cadastrar novo Usuario</a></li>
</sec:authorize>

<table>
<tr>
<th>Nome</th>
<th>Login</th>
<th> Idade </th>
<th> Tipo_Documento </th>
<th> Numero do Documento </th>
<th> Cartão de Milhas </th>
<th>  Ação   </th>
</tr>

<c:forEach items="${users}" var="user">
<tr>
<td> ${user.name}  </td>

<td> ${user.login} </td>

<td> ${user.idade} anos </td>

<td align="center"> ${user.tipo_documento} </td>

<td> ${user.documento} </td>

<td> ${user.cartao_milha} </td>
<td> <a href="${spring:mvcUrl('UC#edita').arg(0,user.login).build()}"> Editar </a> </td>

</tr>


</c:forEach>
</table>

</body>
</html>