<%-- 
    Document   : index
    Created on : Mar 4, 2016, 1:34:45 AM
    Author     : SALIM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kenya Meteorological Department - Mobile Login</title>
         <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no, minimal-ui">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <!-- Color theme for statusbar -->
    <meta name="theme-color" content="#2196f3">
    <script src="../../Assets/lib/jquery/jquery.js"></script>
    <link rel="stylesheet" href="../../Assets/lib/framework7/dist/css/framework7.material.min.css" />
    <!-- Path to Framework7 color related styles, Material Theme -->
    <link rel="stylesheet" href="../../Assets/lib/framework7/dist/css/framework7.material.colors.min.css">
    </head>
    <body>
        <div class="views">
      <!-- Your main view, should have "view-main" class -->
      <div class="view view-main">
        <!-- Pages container, because we use fixed navbar and toolbar, it has additional appropriate classes-->
        <div class="pages navbar-fixed toolbar-fixed">
          <!-- Page, "data-page" contains page name -->
          <div data-page="index" class="page">
 
            <!-- Top Navbar. In Material theme it should be inside of the page-->
            <div class="navbar">
              <div class="navbar-inner">
                <div class="center">Volunteer Portal</div>
              </div>
            </div>
 
            <!-- Bottom Toolbar. In Material theme it should be inside of the page-->
<!--            <div class="toolbar">
              <div class="toolbar-inner">
                 Toolbar links 
                <a href="#" class="link">Link 1</a>
                <a href="#" class="link">Link 2</a>
              </div>
            </div>-->
 
            <!-- Scrollable page content -->
            <div class="page-content">
              <p>Page content goes here</p>
              <!-- Link to another page -->
              <a href="about.html">About app</a>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- Path to Framework7 Library JS-->
    <script type="text/javascript" src="../../Assets/lib/framework7/dist/js/framework7.min.js"></script>
    <!-- Path to your app js-->
    <script type="text/javascript" src="../js/material.js"></script>
    </body>
</html>
