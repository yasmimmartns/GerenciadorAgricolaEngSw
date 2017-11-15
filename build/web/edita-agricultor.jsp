<%--
Document   : editar-Agricultor
Created on : 03/11/2016, 15:20:14
Author     : davi
--%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="Classes.Agricultor"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="dao" class="DAOclasses.AgricultorDAO"/>
<%@ page import= "DAOclasses.PessoaDAO" %>

<%
String id = request.getParameter("id");
request.setAttribute("idAgricultor", id);
Agricultor c = dao.getAgricultor(id);
String nomeAgricultor = c.getPf().getNome();
request.setAttribute("nomeAgricultor", nomeAgricultor);
String sobrenomeAgricultor = c.getPf().getSobrenome();
request.setAttribute("sobrenomeAgricultor", sobrenomeAgricultor);
String CPFAgricultor = c.getPf().getCPF();
request.setAttribute("CPFAgricultor", CPFAgricultor);
String RGAgricultor = c.getPf().getRG();
request.setAttribute("RGAgricultor", RGAgricultor);
Date dataBanco = c.getPf().getDataNascimento();
DateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
String generoAgricultor = c.getPf().getSexo();
request.setAttribute("generoAgricultor", generoAgricultor);
String telefoneAgricultor = c.getPf().getPessoa().getTelefone();
request.setAttribute("telefoneAgricultor", telefoneAgricultor);
String emailAgricultor = c.getPf().getPessoa().getEmail();
request.setAttribute("emailAgricultor", emailAgricultor);
String logradouroAgricultor = c.getPf().getPessoa().getLogradouro();
request.setAttribute("logradouroAgricultor", logradouroAgricultor);
int numeroLogradouroAgricultor = c.getPf().getPessoa().getNumero();
request.setAttribute("numeroLogradouroAgricultor", numeroLogradouroAgricultor);
String complementoLogradouroAgricultor = c.getPf().getPessoa().getComplemento();
request.setAttribute("complementoLogradouroAgricultor", complementoLogradouroAgricultor);
String bairroAgricultor = c.getPf().getPessoa().getBairro();
request.setAttribute("bairroAgricultor", bairroAgricultor);
String CEPAgricultor = c.getPf().getPessoa().getCEP();
request.setAttribute("CEPAgricultor", CEPAgricultor);
String cidadeAgricultor = c.getPf().getPessoa().getCidade();
request.setAttribute("cidadeAgricultor", cidadeAgricultor);
String estadoAgricultor = c.getPf().getPessoa().getEstado();
request.setAttribute("estadoAgricultor", estadoAgricultor);
String paisAgricultor = c.getPf().getPessoa().getPais();
request.setAttribute("paisAgricultor", paisAgricultor);
%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta charset="utf-8" />
    <title>EDITAR Agricultor KOINONIA</title>

    <meta name="description" content=" " />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

    <!-- bootstrap & fontawesome -->
    <link rel="stylesheet" href="assets/css/bootstrap.min.css" />
    <link rel="stylesheet" href="assets/font-awesome/4.5.0/css/font-awesome.min.css" />

    <!-- page specific plugin styles -->
    <link rel="stylesheet" href="assets/css/jquery-ui.custom.min.css" />
    <link rel="stylesheet" href="assets/css/chosen.min.css" />
    <link rel="stylesheet" href="assets/css/bootstrap-datepicker3.min.css" />
    <link rel="stylesheet" href="assets/css/bootstrap-timepicker.min.css" />
    <link rel="stylesheet" href="assets/css/daterangepicker.min.css" />
    <link rel="stylesheet" href="assets/css/bootstrap-datetimepicker.min.css" />
    <link rel="stylesheet" href="assets/css/bootstrap-colorpicker.min.css" />

    <!-- text fonts -->
    <link rel="stylesheet" href="assets/css/fonts.googleapis.com.css" />

    <!-- ace styles -->
    <link rel="stylesheet" href="assets/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style" />

    <!--[if lte IE 9]>
        <link rel="stylesheet" href="assets/css/ace-part2.min.css" class="ace-main-stylesheet" />
    <![endif]-->
    <link rel="stylesheet" href="assets/css/ace-skins.min.css" />
    <link rel="stylesheet" href="assets/css/ace-rtl.min.css" />

    <!--[if lte IE 9]>
      <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
    <![endif]-->

    <!-- inline styles related to this page -->

    <!-- ace settings handler -->
    <script src="assets/js/ace-extra.min.js"></script>

    <!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->

    <!--[if lte IE 8]>
    <script src="assets/js/html5shiv.min.js"></script>
    <script src="assets/js/respond.min.js"></script>
    <![endif]-->
</head>

<body class="no-skin">
    <div id="navbar" class="navbar navbar-default          ace-save-state">
        <div class="navbar-container ace-save-state" id="navbar-container">
            <button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler" data-target="#sidebar">
                <span class="sr-only">Toggle sidebar</span>

                <span class="icon-bar"></span>

                <span class="icon-bar"></span>

                <span class="icon-bar"></span>
            </button>

            <div class="navbar-header pull-left">
                <a href="dashboard.html" class="navbar-brand">
                    <small>
                        <i class="fa fa-book"></i>
                        Koinonia Livraria Cristã
                    </small>
                </a>
            </div>

            <div class="navbar-buttons navbar-header pull-right" role="navigation">
                <ul class="nav ace-nav">

                    <li class="light-blue dropdown-modal">
                        <a data-toggle="dropdown" href="#" class="dropdown-toggle">
                            <img class="nav-user-photo" src="assets/images/avatars/user.jpg" alt="Jason's Photo" />
                            <span class="user-info">
                                <small>Bem vindo,</small>
                                Admin
                            </span>

                            <i class="ace-icon fa fa-caret-down"></i>
                        </a>

                        <ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
<!--								<li>
                                <a href="#">
                                    <i class="ace-icon fa fa-cog"></i>
                                    ConfiguraÃ§Ãµes
                                </a>
                            </li>

                            <li>
                                <a href="profile.html">
                                    <i class="ace-icon fa fa-user"></i>
                                    Perfil
                                </a>
                            </li>

                            <li class="divider"></li>-->

                            <li>
                                <a href="#">
                                    <i class="ace-icon fa fa-power-off"></i>
                                    Sair
                                </a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div><!-- /.navbar-container -->
    </div>

    <div class="main-container ace-save-state" id="main-container">
        <script type="text/javascript">
            try{ace.settings.loadState('main-container')}catch(e){}
        </script>

        <div id="sidebar" class="sidebar                  responsive                    ace-save-state">
            <script type="text/javascript">
                try{ace.settings.loadState('sidebar')}catch(e){}
            </script>

            <ul class="nav nav-list">
                <li class="active">
                    <a href="dashboard.html">
                        <i class="menu-icon fa fa-desktop"></i>
                        <span class="menu-text"> Dashboard </span>
                    </a>

                    <b class="arrow"></b>
                </li>

                <li class="">
                    <a href="#" class="dropdown-toggle">
                        <i class="menu-icon fa fa-user"></i>
                        <span class="menu-text">Cadastro</span>
                        <b class="arrow fa fa-angle-down"></b>
                    </a>

                    <b class="arrow"></b>

                    <ul class="submenu">

                        <li class="">
                            <a href="cadastro-fornecedor.html">
                                <i class="menu-icon fa fa-caret-right"></i>
                                Fornecedor
                            </a>

                            <b class="arrow"></b>
                        </li>

                        <li class="">
                            <a href="cadastro-cliente.html">
                                <i class="menu-icon fa fa-caret-right"></i>
                                Cliente
                            </a>

                            <b class="arrow"></b>
                        </li>
                    </ul>
                </li>


                <li class="">
                    <a href="#" class="dropdown-toggle">
                        <i class="menu-icon fa fa-list-alt"></i>
                        <span class="menu-text"> Consultar </span>
                        <b class="arrow fa fa-angle-down"></b>

                    </a>

                    <b class="arrow"></b>

                    <ul class="submenu">

                        <li class="">
                            <a href="listar-fornecedor.jsp">
                                <i class="menu-icon fa fa-caret-right"></i>
                                Fornecedor
                            </a>

                            <b class="arrow"></b>
                        </li>

                        <li class="">
                            <a href="listar-cliente.jsp">
                                <i class="menu-icon fa fa-caret-right"></i>
                                Cliente
                            </a>

                            <b class="arrow"></b>
                        </li>
                    </ul>

                </li>
                                    <li class="">
                    <a href="#" class="dropdown-toggle">
                        <i class="menu-icon fa fa-shopping-basket"></i>
                        <span class="menu-text"> Caixa </span>
                        <b class="arrow fa fa-angle-down"></b>

                    </a>

                    <b class="arrow"></b>

                    <ul class="submenu">

                        <li class="">
                            <a href="caixa-pagamentos.jsp">
                                <i class="menu-icon fa fa-caret-right"></i>
                                Pagamento
                            </a>

                            <b class="arrow"></b>
                        </li>

                        <li class="">
                            <a href="caixa-movimentacoes.jsp">
                                <i class="menu-icon fa fa-caret-right"></i>
                                Movimentações
                            </a>

                            <b class="arrow"></b>
                        </li>
                    </ul>

                </li>
                                    <li class="">
                    <a href="#" class="dropdown-toggle">
                        <i class="menu-icon fa fa-pie-chart"></i>
                        <span class="menu-text"> Estoque </span>
                        <b class="arrow fa fa-angle-down"></b>

                    </a>

                    <b class="arrow"></b>

                    <ul class="submenu">

                        <li class="">
                            <a href="estoque-produtos.jsp">
                                <i class="menu-icon fa fa-caret-right"></i>
                                Produtos
                            </a>

                            <b class="arrow"></b>
                                                    </li>
                    </ul>

                                            <b class="arrow"></b>

                    <ul class="submenu">

                        <li class="">
                            <a href="listar-produtos.jsp">
                                <i class="menu-icon fa fa-caret-right"></i>
                                Listar estoque
                            </a>

                            <b class="arrow"></b>
                                                    </li>
                    </ul>

                </li>
            </ul><!-- /.nav-list -->

            <div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
                <i id="sidebar-toggle-icon" class="ace-icon fa fa-angle-double-left ace-save-state" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
            </div>
        </div>

        <div class="main-content">
            <div class="main-content-inner">
                <div class="breadcrumbs ace-save-state" id="breadcrumbs">
                    <ul class="breadcrumb">
                        <li>
                            <i class="ace-icon fa fa-home home-icon"></i>
                            <a href="index.html">Home</a>
                        </li>

                        <li>Cadastro</li>

                        <li class="active">Cliente</li>
                    </ul><!-- /.breadcrumb -->

                </div>

                <div class="page-content">

                    <div class="page-header">
                        <h1>
                            Editar
                            <small>
                                <i class="ace-icon fa fa-chevron-right"></i>
                                Cliente
                            </small>
                        </h1>
                    </div><!-- /.page-header -->

                    <div class="row">
                        <div class="col-xs-12">
                            <!-- PAGE CONTENT BEGINS -->
                                                            <!--Testar id="validation-form" em forms -->
                            <form class="form-horizontal" role="form" action="EditaAgricultor" method="POST">

                                <div class="space-4"></div>

                                                                    <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right" for="form-field-1"><span style="color:red;">*</span> ID </label>

                                    <div class="col-sm-9">
                                        <input type="text" readonly name="idAgricultor" id="form-field-1" placeholder="ID Agricultor" class="col-xs-10 col-sm-5" value="${idAgricultor}"/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right" for="form-field-1"><span style="color:red;">*</span> Nome </label>

                                    <div class="col-sm-9">
                                        <input required type="text" name="nome" id="form-field-1" placeholder="Ex: João Pedro" class="col-xs-10 col-sm-5" value="${nomeAgricultor}"/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right" for="form-field-1"><span style="color:red;">*</span> Sobrenome </label>

                                    <div class="col-sm-9">
                                        <input required type="text" name="sobrenome" id="form-field-1" placeholder="Ex: Silva" class="col-xs-10 col-sm-2" value="${sobrenomeAgricultor}"/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right" for="form-field-mask-2"><span style="color:red;">*</span> CPF </label>

                                    <div class="col-sm-9">
                                        <input readonly required type="text" name="CPF" id="form-field-mask-2" placeholder="Ex: 425.632.845-65" class="col-xs-5 col-sm-3 mask-CPF" value="${CPFAgricultor}"/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right" for="form-field-mask-2"><span style="color:red;">*</span> RG </label>

                                    <div class="col-sm-9">
                                        <input readonly required type="text" name="RG" id="form-field-mask-2" placeholder="Ex: 25.658.578-3" class="col-xs-5 col-sm-3 mask-RG" value="${RGAgricultor}"/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div>
                                        <label class="col-sm-3 control-label no-padding-right" for="form-field-mask-2"><span style="color:red;">*</span> Data de nascimento</label>
                                        <div class="col-sm-9">
                                            <input required class="col-xs-5 col-sm-2 mask-DATA" type="text" name="dataNascimento" id="form-field-mask-2" placeholder="10-12-2016" value="${dataAgricultor}"/>
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right"><span style="color:red;">*</span> Gênero</label>

                                    <div class="col-sm-9">
                                                                                <c:choose>
                                                                                    <c:when test="${generoAgricultor == 'M'}">
                                                                                        <label class="inline">
                                                                                                <input checked name="sexo" type="radio" value="M" class="ace" />
                                                                                                <span class="lbl middle"> Masculino</span>
                                                                                        </label>
                                                                                        <label class="inline">
                                            <input name="sexo" type="radio" value="F" class="ace" />
                                            <span class="lbl middle"> Feminino</span>
                                                                                        </label>
                                                                                    </c:when>
                                                                                    <c:otherwise>
                                                                                        <label class="inline">
                                                                                            <input name="sexo" type="radio" value="M" class="ace" />
                                                                                            <span class="lbl middle"> Masculino</span>
                                                                                        </label>
                                                                                        <label class="inline">
                                            <input checked name="sexo" type="radio" value="F" class="ace" />
                                            <span class="lbl middle"> Feminino</span>
                                                                                        </label>
                                                                                    </c:otherwise>
                                                                                </c:choose>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Fidelidade </label>

                                    <div class="col-sm-9">
                                                                                    <input type="text" class="col-xs-10 col-sm-3" name="codFidelidade" id="codFidelidade" placeholder="Codigo de fidelidade" value="${codFidelidadeAgricultor}"/>
                                        <label class="middle col-xs-12 col-sm-7">
                                                                                        <input class="ace" type="checkbox" id="fidelidade" name="fidelidade" onclick="enableDisable(this.checked, 'codFidelidadeAgricultor')"/>
                                                                                        <span class="lbl"> Não possui</span>
                                        </label>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right" for="form-field-1"><span style="color:red;">*</span> Telefone </label>

                                    <div class="col-sm-9">
                                        <input type="tel" name="telefone" id="form-field-1" placeholder="Ex: (43) 9632-1236" class="col-xs-10 col-sm-3 mask-phone" value="${telefoneAgricultor}"/>
                                    </div>
                                </div>


                                <div class="form-group">
                                    <label class="control-label col-xs-12 col-sm-3 no-padding-right" for="email"><span style="color:red;">*</span> Email </label>

                                    <div class="col-sm-9">
                                        <div class="clearfix">
                                            <input required type="email" name="email" id="email" placeholder="Ex: livraria@gmail.com" class="col-xs-12 col-sm-4" value="${emailAgricultor}"/>
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right" for="form-field-1"><span style="color:red;">*</span> Logradouro </label>

                                    <div class="col-sm-4">
                                        <input required type="text" name="logradouro" id="form-field-1" placeholder="Ex: Rua Coronel Alendor" class="col-xs-10 col-sm-11" value="${logradouroAgricultor}"/>
                                    </div>

                                    <label class="col-sm-1 control-label no-padding-right " for="form-field-1"><span style="color:red;">*</span> N&uacute;mero </label>

                                    <div class="col-sm-2">
                                        <input required type="tel" name="numero" id="form-field-1" placeholder="Ex: 145" class="col-xs-10 col-sm-8" value="${numeroLogradouroAgricultor}"/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Complemento </label>

                                    <div class="col-sm-9">
                                        <input type="text" name="complemento" id="form-field-1" placeholder="Ex: Bloco A" class="col-xs-10 col-sm-4" value="${complementoLogradouroAgricultor}"/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right" for="form-field-1"><span style="color:red;">*</span> Bairro </label>

                                    <div class="col-sm-9">
                                        <input required type="text" name="bairro" id="form-field-1" placeholder="Ex: Centro" class="col-xs-10 col-sm-4" value="${bairroAgricultor}"/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right" for="form-field-mask-2"><span style="color:red;">*</span> CEP </label>

                                    <div class="col-sm-9">
                                        <input required type="text" name="cep" id="form-field-mask-2" placeholder="Ex: 86300-000" class="col-xs-10 col-sm-3 mask-CEP" value="${CEPAgricultor}"/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right" for="form-field-1"><span style="color:red;">*</span> Cidade </label>

                                    <div class="col-sm-3">
                                        <input required type="text" name="cidade" id="form-field-1" placeholder="Ex: Cornélio Procópio" class="col-xs-10 col-sm-12" value="${cidadeAgricultor}"/>
                                    </div>

                                    <label class="col-sm-1 control-label no-padding-right" for="form-field-1"><span style="color:red;">*</span> Estado </label>

                                    <div class="col-sm-3">
                                        <input required type="text" name="estado" id="form-field-1" placeholder="Ex: Paraná" class="col-xs-10 col-sm-8" value="${estadoAgricultor}"/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right" for="form-field-1"><span style="color:red;">*</span> Pa&iacute;s </label>

                                    <div class="col-sm-4">
                                        <input required type="text" name="pais" id="form-field-1" placeholder="Ex: Brasil" class="col-xs-10 col-sm-5" value="${paisAgricultor}"/>
                                    </div>
                                </div>


                                <div class="clearfix form-actions">
                                    <div class="col-md-offset-3 col-md-9">
                                        <button class="btn btn-success" type="submit">
                                            <i class="ace-icon fa fa-check bigger-110"></i>
                                            Enviar
                                        </button>

                                        &nbsp; &nbsp; &nbsp;
<!--											<button class="btn" type="reset">
                                            <i class="ace-icon fa fa-undo bigger-110"></i>
                                            Limpar
                                        </button>-->
                                    </div>
                                </div>
                            </form>

                        </div><!-- /.col -->
                    </div><!-- /.row -->
                </div><!-- /.page-content -->
            </div>
        </div><!-- /.main-content -->

        <div class="footer">
            <div class="footer-inner">
                <div class="footer-content">
                    <span class="bigger-120">
                    </span>
                </div>
            </div>
        </div>

        <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
            <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
        </a>
    </div><!-- /.main-container -->

    <!-- basic scripts -->

    <!--[if !IE]> -->
    <script src="assets/js/jquery-2.1.4.min.js"></script>

    <!-- <![endif]-->

    <!--[if IE]>
<script src="assets/js/jquery-1.11.3.min.js"></script>
<![endif]-->
    <script type="text/javascript">
        if('ontouchstart' in document.documentElement) document.write("<script src='assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
    </script>
    <script src="assets/js/bootstrap.min.js"></script>

    <!-- page specific plugin scripts -->

    <!--[if lte IE 8]>
      <script src="assets/js/excanvas.min.js"></script>
    <![endif]-->
    <script src="assets/js/jquery-ui.custom.min.js"></script>
    <script src="assets/js/jquery.ui.touch-punch.min.js"></script>
    <script src="assets/js/chosen.jquery.min.js"></script>
    <script src="assets/js/jquery.maskedinput.min.js"></script>

    <!-- page specific plugin scripts -->
    <script src="assets/js/jquery.validate.min.js"></script>

    <!-- ace scripts -->
    <script src="assets/js/ace-elements.min.js"></script>
    <script src="assets/js/ace.min.js"></script>

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

            $("#fidelidade").click(function () {
                $('#codfidelidade').attr("disabled", $(this).is(":checked"));
            });

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
</body>
</html>
