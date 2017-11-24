<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="Classes.Regiao"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="dao" class="DAOclasses.RegiaoDAO"/>
<%@ page import= "DAOclasses.RegiaoDAO" %>

<%
String id = request.getParameter("id");
request.setAttribute("idRegiao", id);
Regiao r = dao.getRegiao(id);
String enderecoRegiao = r.getEndereco();
request.setAttribute("enderecoRegiao", enderecoRegiao);
float areaRegiao = r.getArea();
request.setAttribute("areaRegiao", areaRegiao);
%>

<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<link rel="icon" type="image/png" href="assets/img/favicon2.ico">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title>Cadastro Plantação</title>

	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />


    <!-- Bootstrap core CSS     -->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet" />

    <!-- Animation library for notifications   -->
    <link href="assets/css/animate.min.css" rel="stylesheet"/>

    <!--  Light Bootstrap Table core CSS    -->
    <link href="light-bootstrap-dashboard.css" rel="stylesheet"/>


    <!--  CSS for Demo Purpose, don't include it in your project     -->
    <link href="assets/css/demo.css" rel="stylesheet" />


    <!--     Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300' rel='stylesheet' type='text/css'>
    <link href="assets/css/pe-icon-7-stroke.css" rel="stylesheet" />
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body>

<div class="wrapper">
    <div class="sidebar" data-color="green" data-image="assets/img/sidebar-6.jpg">

    <!--   you can change the color of the sidebar using: data-color="blue | azure | green | orange | red | purple" -->

    <div class="sidebar-wrapper">
            <div class="logo">
                <h1>
                    <img src="assets/img/favicon2.ico" width="30%"> Agro</img>
                </h1>
            </div>

            <ul class="nav">
                <li>
                    <a href="dashboard.html">
                        <i class="pe-7s-graph"></i>
                        <p>Dashboard</p>
                    </a>
                </li>
                <li class="active"><a href="#" class="toggle-custom" data-toggle="collapse" data-target="#submenu1">
                        <i class="pe-7s-plus"></i>
                        <p>Cadastro</p>
                    </a>
                    <ul class="collapse" id="submenu1">
                      <li><a href="cadPlantacao.jsp">Plantação</a>
                      </li>
                      <li><a href="cadInsumo.html">Insumo</a>
                      </li>
                      <li><a href="cadRegiao.html">Região</a>
                      </li>
                    </ul>
                </li>
                <li>
                    <a href="#" class="toggle-custom" data-toggle="collapse" data-target="#submenu2">
                        <i class="pe-7s-note2"></i>
                        <p>Listar</p>
                    </a>
                    <ul class="collapse" id="submenu2">
                        <li><a href="listarRegiao.jsp">Região</a>
                        </li>
                        <li><a href="listarPlantacao.jsp">Plantação</a>
                        </li>
                        <li><a href="listarInsumo.jsp">Insumo</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="maps.html">
                        <i class="pe-7s-map-marker"></i>
                        <p>Mapa</p>
                    </a>
                </li>
            </ul>
    	</div>
    </div>
    	
    <div class="main-panel">
		<nav class="navbar navbar-default navbar-fixed">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">Cadastro</a>
                </div>
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                              <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    <p>
										Bem vindo, Admin
										<b class="caret"></b>
									</p>

                              </a>
                              <ul class="dropdown-menu">
                                <li><a href="altAgricultor.jsp">Alterar dados</a></li>
                                <li><a href="#">Sair</a></li>
                              </ul>
                        </li>   
                    </ul>
                </div>
            </div>
        </nav>

        <!--Inserido o card para o cadastro de região-->
        <form role="form" action="CadastroPlantacao" method="POST" style="margin-top: 40px;">
                                  
        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="header">
                                <h4 class="title">Plantação</h4>
                            </div>
                            
                            <div class="content">
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label>Tipo da Plantação</label>
                                                <input type="text" id="tipo" name="tipo" class="form-control">
                                            </div>
                                        </div>
                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label>Quantidade</label>
                                                <input type="number" id="quantidade" name="quantidade" class="form-control">
                                            </div>
                                        </div>
                                         <div class="col-md-2">
                                            <div class="form-group">
                                                <label>Região</label>
                                                <input readonly="true" id="regiao" name="regiao" class="form-control" value="${idRegiao}"/>
                                            </div>
                                        </div>
                                        <div class="col-md-1">
                                            <div class="form-group">
                                                <a href="listarRegiaoPlantacao.jsp?id=${regiao.idRegiao}">
                                                    <br>
                                                    <i style="font-size: 45px" class="material-icons">add_to_photos</i>
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                <div class="clearfix"></div>
                            </div>
                        </div> 
                    </div> 

                        <div class="content" style="min-height: 200px!important; padding-bottom: 0;">
                                <div class="container-fluid">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="card">
                                                <div class="header">
                                                    <h4 class="title">Região</h4>
                                                </div>
                                                <div class="content">
                                                        <div class="row">
                                                            <div class="col-md-8">
                                                                <div class="form-group">
                                                                    <label readonly="true">Endereço</label>
                                                                    <input disabled type="text" id="endereco" name="endereco" class="form-control" value="${enderecoRegiao}"/>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-4">
                                                                <div class="form-group">
                                                                    <label readonly="true">Área (m²)</label>
                                                                    <input disabled type="text" id="area" name="area" class="form-control" value="${areaRegiao}"/>
                                                                </div>
                                                            </div>
                                                        </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                <button type="reset" class="btn btn-success btn-info btn-fill pull-right col-md-2">Limpar</button>
                                <button type="submit" class="btn btn-success btn-info btn-fill pull-right col-md-2">Enviar</button>
                            </div>
                        </div> 
                    </div>
                </div>
            </div>
        </div>

        

        </form>

        <footer class="footer">
            <div class="container-fluid">
                <p class="copyright pull-right">
                    Agro - Gerenciador Agrícola &copy; <script>document.write(new Date().getFullYear())</script>
                </p>
            </div>
        </footer>

    </div>
</div>


</body>

    <!--   Core JS Files   -->
    <script src="assets/js/jquery-1.10.2.js" type="text/javascript"></script>
	<script src="assets/js/bootstrap.min.js" type="text/javascript"></script>

	<!--  Checkbox, Radio & Switch Plugins -->
	<script src="assets/js/bootstrap-checkbox-radio-switch.js"></script>

	<!--  Charts Plugin -->
	<script src="assets/js/chartist.min.js"></script>

    <!--  Notifications Plugin    -->
    <script src="assets/js/bootstrap-notify.js"></script>

    <!--  Google Maps Plugin    -->
    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?sensor=false"></script>

    <!-- Light Bootstrap Table Core javascript and methods for Demo purpose -->
	<script src="assets/js/light-bootstrap-dashboard.js"></script>

	<!-- Light Bootstrap Table DEMO methods, don't include it in your project! -->
	<script src="assets/js/demo.js"></script>

</html>