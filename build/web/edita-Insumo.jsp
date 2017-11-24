<%@page import="Classes.Insumo"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="dao" class="DAOclasses.InsumoDAO"/>
<%@ page import= "DAOclasses.InsumoDAO" %>

<%
String id = request.getParameter("id");
request.setAttribute("idInsumo", id);
Insumo i = dao.getInsumo(id);
String tipoInsumo = i.getTipo();
request.setAttribute("tipoInsumo", tipoInsumo);
String categoriaInsumo = i.getCategoria();
request.setAttribute("categoriaInsumo", categoriaInsumo);
String especificacoesInsumo = i.getEspecificacoes();
request.setAttribute("especificacoesInsumo", especificacoesInsumo);
int quantidadeInsumo = i.getQuantidade();
request.setAttribute("quantidadeInsumo", quantidadeInsumo);
String marcaInsumo = i.getMarca();
request.setAttribute("marcaInsumo", marcaInsumo);
String dataInsumo = i.getDataValidade();
request.setAttribute("dataInsumo", dataInsumo);
float precoInsumo = i.getPreco();
request.setAttribute("precoInsumo", precoInsumo);
%>

<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<link rel="icon" type="image/png" href="assets/img/favicon2.ico">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title>Cadastro Insumo</title>

	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />


    <!-- Bootstrap core CSS     -->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet" />

    <!-- Animation library for notifications   -->
    <link href="assets/css/animate.min.css" rel="stylesheet"/>

    <!--  Light Bootstrap Table core CSS    -->
    <link href="assets/css/light-bootstrap-dashboard.css" rel="stylesheet"/>


    <!--  CSS for Demo Purpose, don't include it in your project     -->
    <link href="assets/css/demo.css" rel="stylesheet" />


    <!--     Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300' rel='stylesheet' type='text/css'>
    <link href="assets/css/pe-icon-7-stroke.css" rel="stylesheet" />
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
                        <li><a href="listarInsumos.jsp">Insumo</a>
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


        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="header">
                                <h4 class="title">Insumo</h4>
                            </div>
                            <div class="content">
                                <form role="form" action="EditaInsumo" method="POST">
                                    <div class="row">
                                        <div class="col-md-1">
                                            <div class="form-group">
                                                <label>ID</label>
                                                <input type="text" id="idInsumo" name="idInsumo" class="form-control" value="${idInsumo}"/>
                                            </div>
                                        </div>
                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label>Tipo</label>
                                                <input type="text" id="tipo" name="tipo" class="form-control" value="${tipoInsumo}"/>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <label>Categoria</label>
                                                <input type="text" id="categoria" name="categoria" class="form-control" value="${categoriaInsumo}"/>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <label>Especificações</label>
                                                <input type="text" id="especificacoes" name="especificacoes" class="form-control" value="${especificacoesInsumo}"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label>Marca</label>
                                                <input type="text" id="marca" name="marca" class="form-control" value="${marcaInsumo}"/>
                                            </div>
                                        </div>
                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label>Data de Validade</label>
                                                <input type="text" id="dataValidade" name="dataValidade" class="form-control" value="${dataInsumo}"/>
                                            </div>
                                        </div>
                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label>Quantidade</label>
                                                <input type="text" id="quantidade" name="quantidade" class="form-control" value="${quantidadeInsumo}"/>
                                            </div>
                                        </div>
                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label>Preço</label>
                                                <input type="text" id="preco" name="preco" class="form-control" value="${precoInsumo}"/>
                                            </div>
                                        </div>
                                    </div>
                                    <button type="reset" class="btn btn-success btn-info btn-fill pull-right col-md-2">Limpar</button>
                                    <button type="submit" class="btn btn-success btn-info btn-fill pull-right col-md-2" style="margin-bottom: 40px;">Enviar</button>
                                    <div class="clearfix"></div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>


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