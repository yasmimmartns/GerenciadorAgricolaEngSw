<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="dao" class="DAOclasses.PlantacaoDAO"/>

<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta charset="utf-8" />
        <link rel="icon" type="image/png" href="assets/img/favicon2.ico">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    
        <title>Listar Plantações</title>
    
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

	<body class="no-skin">
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
                    <li><a href="#" class="toggle-custom" data-toggle="collapse" data-target="#submenu1">
                            <i class="pe-7s-plus"></i>
                            <p>Cadastro</p>
                        </a>
                        <ul class="collapse" id="submenu1">
                          <li><a href="cadPlantacao.html">Plantação</a>
                          </li>
                          <li><a href="cadInsumo.html">Insumo</a>
                          </li>
                          <li><a href="cadRegiao.html">Região</a>
                          </li>
                        </ul>
                    </li>
                    <li class="active">
                        <a href="#" class="toggle-custom" data-toggle="collapse" data-target="#submenu2">
                            <i class="pe-7s-note2"></i>
                            <p>Listar</p>
                        </a>
                        <ul class="collapse" id="submenu2">
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
        
		<div class="main-container ace-save-state" id="main-container">
			<script type="text/javascript">
				try{ace.settings.loadState('main-container')}catch(e){}
			</script>
				<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
					<i id="sidebar-toggle-icon" class="ace-icon fa fa-angle-double-left ace-save-state" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
				</div>
			</div>

			<div class="main-content">
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
                                        <li><a href="agricultor.html">Alterar dados</a></li>
                                        <li><a href="#">Sair</a></li>
                                      </ul>
                                </li>   
                            </ul>
                        </div>
                    </div>
                </nav>
			
					<div class="page-content">
						<div class="page-header">
							<div class="header">
                                <h4 class="title">Plantação</h4>
                            </div>
						</div><!-- /.page-header -->
						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
								<div class="row">
                                    <div class="col-xs-12">

                                        <!-- div.table-responsive -->

                                        <!-- div.dataTables_borderWrap -->
                                        <div>
                                            <table id="dynamic-table" class="table table-striped table-bordered table-hover">
                                                <thead>
                                                    <tr>
                                                        <th>Tipo</th>
                                                        <th>Categoria</th>
                                                        <th>Endereço</th>
                                                        <th>Area</th>
                                                        <th></th>
                                                    </tr>
                                                </thead>
                                            <tbody>
                                                <c:forEach var="insumo" items="${dao.lista}">
                                                                           
                                                  <!--init the list-->
                                                
                                                    <tr>
                                                        <td>${plantacao.getTipo()}</td>
                                                        <td>${plantacao.getCategoria()}</td>
                                                        <td>${plantacao.getRegiao.getEndereco()}</td>
                                                        <td>${plantacao.getRegiao.getArea()}</td>
                                                    </tr>       
                                                    <!--End the list-->
                                                   </c:forEach> 
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>

								<!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row -->
					</div><!-- /.page-content -->
				</div>
			</div><!-- /.main-content -->

			<footer class="footer">
                <div class="container-fluid">
                    <p class="copyright pull-right">
                        &copy; <script>document.write(new Date().getFullYear())</script> <a href="http://www.creative-tim.com">Creative Tim</a>, made with love for a better web
                    </p>
                </div>
            </footer>

			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
			</a>
		</div><!-- /.main-container -->

		<!-- basic scripts -->
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