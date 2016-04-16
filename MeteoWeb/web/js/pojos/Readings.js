/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function Reading(){
    this.details = {
        "temperature":0,
        "rainfall":0,
        "humidity":0,
        "evaporation":0,
        "pressure":0,
        "windSpeed":0,
        "WindDirection":""
        
   }
   this.setTemperature = function(temp){
       this.details.temperature = temp
   }
   this.setRainfall = function (rainfall){
       this.details.rainfall = rainfall
   }
   this.setHumidity = function(humidity){
       this.details.humidity = humidity
   }
   this.setEvaporation = function(evaporation){
       this.details.evaporation = evaporation
   }
   this.setPressure = function(pressure){
       this.details.pressure = pressure
   }
   this.setWindSpeed = function(speed){
       this.details.windSpeed = speed
   }
   this.setWindDirection = function(direction){
       this.details.WindDirection = direction
   }
    this.save = function() {
        var xmlhttp = new XMLHttpRequest()
        var url = "../../SaveReading?temp="+this.details.temperature+"&rain="+this.details.rainfall+"&humidity="+this.details.humidity+"&evaporation="+this.details.evaporation+"&pressure="+this.details.pressure+"&speed="+this.details.windSpeed+"&direction="+this.details.WindDirection
       alert(url)
        xmlhttp.open("GET",url,true)
        xmlhttp.onreadystatechange = function(){
            if (xmlhttp.readyState==4 && xmlhttp.status==200){
                var response = xmlhttp.responseText
               
                var obj = JSON.parse(response)
                if (obj.Status==="OK"){
                    bootbox.alert("Weather Reading has Been submitted",function(){
                         $('#readingModal').modal('toggle')
                         
                    })
                    
                }
                else {
                    bootbox.alert("An Error Has Ocurred,Please Try Again",function(){
                        $('#readingModal').modal('toggle')
                    })
                }
                }
            }
            xmlhttp.send(null)
        }
        
    
    this.retrieve = function (){
        
        
    }
}
