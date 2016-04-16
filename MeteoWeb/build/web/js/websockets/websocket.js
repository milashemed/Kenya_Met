/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var initurl = "ws://localhost:8080/MeteoWeb/endpoint";

var initws = new WebSocket(initurl);
var vws = new WebSocket(initurl);
initws.onerror = function(evt){initError(evt)}
initws.onopen = function(evt){initOpen(evt)}
initws.onmessage = function(evt){initMessage(evt)}
function initError(){
    
}
function initOpen(){
    
}
function initMessage(evt){
    alert ("Received " + evt.data )
}