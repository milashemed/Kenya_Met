<%@page import="com.meteo.models.User,com.meteo.controllers.UserController" %>
<%@page import="com.meteo.controllers.UserStationController" %>
<%@page import="com.meteo.models.Station" %>
<% 
    User use = (User)session.getAttribute("user");
    
    UserStationController usco = new UserStationController(); 
    Station statione = usco.getItemByUser(use);
                      
%>
<div id="readingModal" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal">&times;</button>
            <h4 class="modal-title">Add Weather Reading for <%=statione.getLocation() %>  <span></span></h4>
        </div>
        <div class="modal-body">
            <form class="form-horizontal" role="form">
                <div class="form-group" style="margin: 2%;" id="tempcontainer">
                  <label  for="txttemparature">Temperature &degC </label>
                  <input type="text" id="txttemperature" class="form-control" onkeypress="return isNumeric(event)" />
                  
                </div>
                <div class="form-group" style="margin: 2%;">
                  <label  for="txtrainfall">Rainfall mm  </label>
                  <input type="text" id="txtrainfall" class="form-control" onkeypress="return isNumeric(event)" />
                  
                </div>
                <div class="form-group" style="margin: 2%;">
                  <label  for="txthumidity">Humidity </label>
                  <input type="range" id="txthumidity" class="form-control" min="0" max="100" value="0" />
                  <span id="valhumidity" class="values">0%</span>
                </div>
                <div class="form-group" style="margin: 2%;">
                  <label  for="txtevaporation">Evaporation </label>
                  <input type="range" id="txtevaporation" class="form-control" min="0" max="100" value="0" />
                  <span id="valevaporation" class="values">0%</span>
                </div>
                <div class="form-group" style="margin: 2%;">
                  <label  for="txtpressure">Pressure  </label>
                  <input type="text" id="txtpressure" class="form-control" onkeypress="return isNumeric(event)" />
                  
                </div>
                <div class="form-group" style="margin: 2%;">
                  <label  for="txtdirection">Wind Direction </label>
                  <select id="txtdirection" class="form-control">
                      <option value="N">North</option>
                      <option value="E">East</option>
                      <option value="W">West</option>
                      <option value="S">South</option>
                      <option value="NE">North East</option>
                      <option value="NW">North West</option>
                      <option value="SE">South East</option>
                      <option value="SW">South West</option>
                  </select>
              </div>
                <div class="form-group" style="margin: 2%;">
                  <label  for="txtspeed">Wind Speed  </label>
                  <input type="text" id="txtspeed" class="form-control" onkeypress="return isNumeric(event)"  />
                  
                </div>
                <div class="modal-footer">
        <button type="button" class="btn btn-primary btn-block btn-lg"  id="btnreadings">Submit Readings</button>
      </div>
            </form>
        </div>
    </div> 
</div>
</div>
