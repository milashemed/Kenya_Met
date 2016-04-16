<%-- 
    Document   : landing
    Created on : Mar 31, 2016, 5:17:17 PM
    Author     : SALIM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
 
        <link rel="stylesheet" type="text/css" href="../../Assets/lib/bootstrap/css/bootstrap.min.css" />
                <link rel="stylesheet" type="text/css" href="../../Assets/Style/sidebar.css" />

        <script src="../../Assets/lib/jquery/jquery.js"></script>
        <script src="../../Assets/lib/bootstrap/js/bootstrap.min.js"></script>
        <script src="../../Assets/lib/bootbox.min.js"></script>
        <script src="../../js/initial.min.js"></script>
        <script src="../../js/Validators.js"></script>
        <link rel="stylesheet" href="style/main.css" />
        <title>Kenya Meteorological Department Data Entry Page</title>
         <script src="../../js/pojos/Readings.js"></script>
        <script src="scripts/app.js"></script>
        
       
    </head>
    <body>
         <div id="wrapper">
            <%@include file="../includes/DE_sidebar.jsp" %>
            <div id="page-content-wrapper">
            <div class="container-fluid">
                      

                <div class="row">
                    <div class="col-lg-12">
                        <h1>Dashboard</h1>
                        <h5>Average Weather Conditions As Of <span id="dte"></span></h5>
                        <ul class="nav nav-tabs">
                            <li class="active"><a data-target="#summary" data-toggle="tab">Summary View</a></li>
                            <li><a data-target="#graphical" data-toggle="tab">Graphical View</a></li>
                            <li><a data-target="#log" data-toggle="tab">Log View</a></li>

                        </ul>
                        <div class="tab-content">
                            <div class="tab-pane active" id="summary">
                                <div class="container">
                                    <div class="row">
                                        <div class="col-sm-3 col-md-2 col-lg-4"><img src="Images/temperature.png" /></div>
                                        <div class="col-sm-9 col-md-10 col-lg-8 reading">0&degC</div>

                                    </div>
                                    <div class="row">
                                        <div class="col-sm-3 col-md-2 col-lg-4"><img src="Images/night_rain.png" /></div>
                                        <div class="col-sm-9 col-md-10 col-lg-8 reading">0mm</div>

                                    </div>
                                    <div class="row">
                                        <div class="col-sm-3 col-md-2 col-lg-4"><img src="Images/pressure.png" /></div>
                                        <div class="col-sm-9 col-md-10 col-lg-8 reading">0mb</div>

                                    </div>
                                    <div class="row">
                                        <div class="col-sm-3 col-md-2 col-lg-4"><img src="Images/evaporation.png" /></div>
                                        <div class="col-sm-9 col-md-10 col-lg-8 reading">0%</div>

                                    </div>
                                    <div class="row">
                                        <div class="col-sm-3 col-md-2 col-lg-4"><img src="Images/wind_turbine.png" /></div>
                                        <div class="col-sm-9 col-md-10 col-lg-8 reading">0%</div>

                                    </div>
                                    <div class="row">
                                        <div class="col-sm-3 col-md-2 col-lg-4"><img src="Images/rsz_1humidity-icon.png" /></div>
                                        <div class="col-sm-9 col-md-10 col-lg-8 reading">0%</div>

                                    </div>
                                </div>
                            </div>
        <div class="tab-pane" id="graphical">Graphical</div>
<div class="tab-pane" id="log">Log View</div>
    </div>
                    </div>
                </div>
            </div>
        </div>
        </div>
            <%@include file="../modals/readings.jsp" %>
    </body>
</html>
