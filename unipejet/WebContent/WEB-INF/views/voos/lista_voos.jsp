<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>UnipeJet</title>

   <sec:authorize access="isAuthenticated()">
  <sec:authentication property="principal" var="user"/>
   </sec:authorize>  
   
    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
       <link rel="stylesheet" href="<c:url value='/resources/css/bootstrap.min.css'/>">
    <!-- Custom CSS -->
    <link href="css/sb-admin.css" rel="stylesheet">
      <link rel="stylesheet" href="<c:url value='/resources/css/sb-admin.css'/>">
    <!-- Custom Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="<c:url value='/resources/font-awesome/css/font-awesome.min.css'/>">


    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">UnipeJet</a>
            </div>
            <!-- Top Menu Items -->
            <ul class="nav navbar-right top-nav">
              
                <li class="dropdown">
                    <a  class="dropdown-toggle" data-toggle="dropdown" href="${spring:mvcUrl('CC#carrinho').arg(0,user.login).build()}"><i class="fa fa-shopping-cart" aria-hidden="true"> &nbsp; Carrinho  (${shoppingCart.quantity})</i> <b class="caret"></b></a>
       
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> ${user.name} <b class="caret"></b></a>
              
                </li>
            </ul>
            <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
                    <li>
                        <a href="${spring:mvcUrl('UC#homePage').build()}"><i class="fa fa-fw fa-dashboard"></i> Voltar para Home</a>
                    </li>
                    
                    <li>
                        <a  href="${spring:mvcUrl('UC#list').build()}"><i class="fa fa-fw fa-user"></i> Administrar Usuários</a>
                    </li>
                   
                   
                   <li class="active">
                        <a href="${spring:mvcUrl('VC#list_voo').build()}"><i class="fa fa-fw fa-plane"></i>  Administrar Voos</a>
                    </li>
                
                     <li class="">
                        <a href="${spring:mvcUrl('UC#logoutPage').build()}"><i class="fa fa-fw fa-user"></i>  Logout</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </nav>

        <div id="page-wrapper">

            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            Voos
                        </h1>
                        <ol class="breadcrumb">
                            <li>
                                <i class="fa fa-dashboard"></i>  <a href="index.html">Geral</a>
                            </li>
                            <li class="active">
                                <i class="fa fa-table"></i> Voos
                            </li>
                        <li>
                        <span style="color:blue; text-align: center"> ${sucesso} ${msg} </span>
                        </li>
                        </ol>
                    
                    
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
                    <div class="col-lg-12">
                        <h2>Lista de Voos</h2>
                        <div class="table-responsive">
                            <table class="table table-bordered table-hover table-striped">
                                <thead>
                                    <tr>
                                        <th>Código</th>
                                        <th>Origem</th>
                                        <th>Destino</th>
                                        <th>Horário da partida</th>
                                        <th>Duração</th>
                                        <th>Distância</th>
                                        <th>Preço Unitário</th>
                                        <th> Capacidade </th>
                                        <th>Assentos Restantes</th>
                                        
                                        <th> Ação</th>
                                    </tr>
                                </thead>
                                <tbody>
                                   
                                   <c:forEach items="${voos}" var="voo">
                                    <tr>
                                        <td>${voo.identificador}</td>
                                        <td>${voo.origem}</td>
                                        <td>${voo.destino}</td>
                                        <td>${voo.hora_partida}</td>
                                        <td>${voo.duracao} horas</td>
                                        <td>${voo.distancia} km</td>
                                        <td> R$ ${voo.preco}</td>
                                        <td>${voo.capacidade}</td>
                                        <td>${voo.assentos} </td>
                                        <td><a href="${spring:mvcUrl('VC#edita_voo').arg(0,voo.identificador).build()}"><button type="button" class="center btn btn-xs btn-primary">Editar</button></a>
                                        <a href="${spring:mvcUrl('VC#remove_voo').arg(0,voo.identificador).build()}"><button type="button" class="btn btn-xs btn-danger">Excluir</button> </a> </td>
                                    </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <!-- /.row -->
                 <div class="row adicionar">
                    <div class="col-lg-12">
                        <a  href="${spring:mvcUrl('VC#cadastroVoos').build()}"><button type="button" class="btn btn-lg btn-success novo"><i class="fa fa-plus-circle"></i>Novo voo</button></a>
                    </div>
                </div>
            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

</body>

</html>
    