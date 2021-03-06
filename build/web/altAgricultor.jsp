<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="Classes.Agricultor"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="dao" class="DAOclasses.AgricultorDAO"/>
<%@ page import= "DAOclasses.PessoaDAO" %>

<%
String id = "0";
request.setAttribute("idAgricultor", id);
Agricultor a = dao.getAgricultor(id);
String nomeAgricultor = a.getPf().getNome();
request.setAttribute("nomeAgricultor", nomeAgricultor);
String CPFAgricultor = a.getPf().getCPF();
request.setAttribute("CPFAgricultor", CPFAgricultor);
String RGAgricultor = a.getPf().getRG();
request.setAttribute("RGAgricultor", RGAgricultor);
Date dataBanco = a.getPf().getDataNascimento();
DateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
String dataAgricultor = formatoData.format(dataBanco);
request.setAttribute("dataAgricultor", dataAgricultor);
String generoAgricultor = a.getPf().getSexo();
request.setAttribute("generoAgricultor", generoAgricultor);
String cadProAgricultor = a.getCadPro();
request.setAttribute("cadProAgricultor", cadProAgricultor);
String telefoneAgricultor = a.getPf().getPessoa().getTelefone();
request.setAttribute("telefoneAgricultor", telefoneAgricultor);
String emailAgricultor = a.getPf().getPessoa().getEmail();
request.setAttribute("emailAgricultor", emailAgricultor);
String logradouroAgricultor = a.getPf().getPessoa().getLogradouro();
request.setAttribute("logradouroAgricultor", logradouroAgricultor);
int numeroLogradouroAgricultor = a.getPf().getPessoa().getNumero();
request.setAttribute("numeroLogradouroAgricultor", numeroLogradouroAgricultor);
String complementoLogradouroAgricultor = a.getPf().getPessoa().getComplemento();
request.setAttribute("complementoLogradouroAgricultor", complementoLogradouroAgricultor);
String bairroAgricultor = a.getPf().getPessoa().getBairro();
request.setAttribute("bairroAgricultor", bairroAgricultor);
String CEPAgricultor = a.getPf().getPessoa().getCEP();
request.setAttribute("CEPAgricultor", CEPAgricultor);
String cidadeAgricultor = a.getPf().getPessoa().getCidade();
request.setAttribute("cidadeAgricultor", cidadeAgricultor);
String estadoAgricultor = a.getPf().getPessoa().getEstado();
request.setAttribute("estadoAgricultor", estadoAgricultor);
%>

<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<link rel="icon" type="image/png" href="assets/img/favicon2.ico">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title>Perfil</title>

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
                        <p>dashboard</p>
                    </a>
                </li>
                <li><a href="#" class="toggle-custom" data-toggle="collapse" data-target="#submenu1">
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
                    <a class="navbar-brand" href="#">Usuário</a>
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
                                <h4 class="title">Alterar dados</h4>
                            </div>
                            <div class="content">
                                <form role="form" action="EditaAgricultor" method="POST">
                                    <div class="row">
                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label>CAD-PRO</label>
                                                <input readonly type="text" id="cadpro" name="cadpro" class="form-control" placeholder="1012345678" value="${cadProAgricultor}"/>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label>Nome</label>
                                                <input readonly type="txt" id="nome" name="nome" class="form-control" value="${nomeAgricultor}"/>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <label>Email</label>
                                                <input type="txt" id="email" name="email" class="form-control" placeholder="usuario@provedor.com" value="${emailAgricultor}"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label>CPF</label>
                                                <input readonly type="text" id="cpf" name="cpf" class="form-control mask-CPF" placeholder="439.564.661-09" value="${CPFAgricultor}"/>
                                            </div>
                                        </div>
                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label>RG</label>
                                                <input readonly type="text" id="rg" name="rg" class="form-control mask-RG" placeholder="52.689.231-0" value="${RGAgricultor}"/>
                                            </div>
                                        </div>
                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label>Data de Nascimento</label>
                                                <input readonly type="text" id="nascimento" name="nascimento" class="form-control"  placeholder="29/05/1978" value="${dataAgricultor}"/>
                                            </div>
                                        </div>
                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label>Telefone</label>
                                                <input type="text" id="telefone" name="telefone" class="form-control mask-phone" placeholder="(43)3235-2969" value="${telefoneAgricultor}"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label>Sexo</label>
                                                <input readonly class="form-control" name="sexo" id="sexo" value="${generoAgricultor}"/>
                                            </div>
                                        </div>
                                        <div class="col-md-8">
                                            <div class="form-group">
                                                <label>Endereço</label>
                                                <input type="text" id="logradouro" name="logradouro" class="form-control" placeholder="Rua das Rosas" value="${logradouroAgricultor}"/>
                                            </div>
                                        </div>
                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label>Número</label>
                                                <input type="text" id="numero" name="numero" class="form-control" placeholder="416" value="${numeroLogradouroAgricultor}"/>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label>Complemento</label>
                                                <input type="text" id="complemento" name="complemento" class="form-control" placeholder="Apto 52 Bloco C" value="${complementoLogradouroAgricultor}"/>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label>Bairro</label>
                                                <input type="text" id="bairro" name="bairro" class="form-control" placeholder="Centro" value="${bairroAgricultor}"/>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label>Cidade</label>
                                                <input type="txt" id="cidade" name="cidade" class="form-control" placeholder="Cornélio Procópio" value="${cidadeAgricultor}"/>
                                            </div>
                                        </div>
                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label>Estado</label>
                                                <input id="estado" name="estado" class="form-control" value="${estadoAgricultor}"/>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <label>CEP</label>
                                                <input type="txt" id="cep" name="cep" class="form-control mask-CEP" placeholder="86.300-000" value="${CEPAgricultor}"/>
                                            </div>
                                        </div>
                                    </div>
                                

                                    <button type="submit" class="btn btn-success btn-info btn-fill pull-right col-md-2" style="margin-bottom: 40px;">Alterar</button>
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
    
    <script src="assets/js/jquery.validate.min.js"></script>
        
        <!-- inline scripts related to this page -->
		<script type="text/javascript">
			jQuery(function($) {
				
				if(!ace.vars['touch']) {
					$('.chosen-select').chosen({allow_single_deselect:true}); 
					//resize the chosen on window resize
			
					$(window)
					.off('resize.chosen')
					.on('resize.chosen', function() {
						$('.chosen-select').each(function() {
							 var $this = $(this);
							 $this.next().css({'width': $this.parent().width()});
						})
					}).trigger('resize.chosen');
					//resize chosen on sidebar collapse/expand
					$(document).on('settings.ace.chosen', function(e, event_name, event_val) {
						if(event_name != 'sidebar_collapsed') return;
						$('.chosen-select').each(function() {
							 var $this = $(this);
							 $this.next().css({'width': $this.parent().width()});
						})
					});
			
					/*
					$('#chosen-multiple-style .btn').on('click', function(e){
						var target = $(this).find('input[type=radio]');
						var which = parseInt(target.val());
						if(which == 2) $('#form-field-select-4').addClass('tag-input-style');
						 else $('#form-field-select-4').removeClass('tag-input-style');
					});*/
				}
			
			
				$('[data-rel=tooltip]').tooltip({container:'body'});
				$('[data-rel=popover]').popover({container:'body'});
			
				$(".mask-phone").mask("(99) 9999-9999?9");
				$(".mask-CPF").mask("999.999.999-99");
				$(".mask-RG").mask("99.999.999-*");
				$(".mask-CEP").mask("99999-999");
				$(".mask-DATA").mask("99/99/9999");
				$(".mask-email").mask("[A-Za-z0-9+_.-]{1,}+@[A-Za-z0-9-]{1,}+(\\.[A-Za-z0-9-]{2,6}+){1,2}");
                
								
				$('#validation-form').validate({
					errorElement: 'div',
					errorClass: 'help-block',
					focusInvalid: false,
					ignore: "",
					rules: {
						email: {
							required: true,
							email:true
						},
					},
			
					messages: {
						email: {
							required: "Por favor, insira um email valido.",
							email: "Por favor, insira um email valido."
						},
					},
			
			
					highlight: function (e) {
						$(e).closest('.form-group').removeClass('has-info').addClass('has-error');
					},
			
					success: function (e) {
						$(e).closest('.form-group').removeClass('has-error');//.addClass('has-info');
						$(e).remove();
					},
			
					errorPlacement: function (error, element) {
						if(element.is('input[type=checkbox]') || element.is('input[type=radio]')) {
							var controls = element.closest('div[class*="col-"]');
							if(controls.find(':checkbox,:radio').length > 1) controls.append(error);
							else error.insertAfter(element.nextAll('.lbl:eq(0)').eq(0));
						}
						else if(element.is('.select2')) {
							error.insertAfter(element.siblings('[class*="select2-container"]:eq(0)'));
						}
						else if(element.is('.chosen-select')) {
							error.insertAfter(element.siblings('[class*="chosen-container"]:eq(0)'));
						}
						else error.insertAfter(element.parent());
					},
			
					submitHandler: function (form) {
					},
					invalidHandler: function (form) {
					}
				});
			
			});
		</script>

</html>