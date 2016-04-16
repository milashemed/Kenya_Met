/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function(){
     $('.profile').initial({height:100,width:100})
               setInterval(function(){
                   $('#dte').html("<code>" + new Date() + "</code>")
               },1000)
     $('[data-toggle="tooltip"]').tooltip(); 
   $('#txthumidity').on('change mousemove',function(){
       $('#valhumidity').html($(this).val() + "%")
   })
    $('#txtevaporation').on('change mousemove',function(){
        $('#valevaporation').html($(this).val() + "%")
    })   
    $('#txttemperature').on('blur',function(){
        if ($('#txttemperature').val().length <= 0){
            $(this).attr("title","Temperature Field is Required")
            
            $(this).attr("placeholder","Field is Required")
            $(this).addClass("dirtyinput")
             
        }
        else {
            $(this).removeAttr("title")
            $(this).removeAttr("placeholder")
            $(this).removeClass("dirtyinput")
        }
    })
    $('#txtrainfall').on('blur',function(){
        if ($('#txtrainfall').val().length <= 0){
            $(this).attr("title","Rainfall Field is Required")
            
            $(this).attr("placeholder","Field is Required")
            $(this).addClass("dirtyinput")
             
        }
        else {
            $(this).removeAttr("title")
            $(this).removeAttr("placeholder")
            $(this).removeClass("dirtyinput")
        }
    })
    $('#txtpressure').on('blur',function(){
        if ($('#txtpressure').val().length <= 0){
            $(this).attr("title","Pressure Field is Required")
            
            $(this).attr("placeholder","Field is Required")
            $(this).addClass("dirtyinput")
             
        }
        else {
            $(this).removeAttr("title")
            $(this).removeAttr("placeholder")
            $(this).removeClass("dirtyinput")
        }
    })
   $('#txtspeed').on('blur',function(){
        if ($('#txtspeed').val().length <= 0){
            $(this).attr("title","Wind Speed Field is Required")
            
            $(this).attr("placeholder","Field is Required")
            $(this).addClass("dirtyinput")
             
        }
        else {
            $(this).removeAttr("title")
            $(this).removeAttr("placeholder")
            $(this).removeClass("dirtyinput")
        }
    })
    $('#btnreadings').on('click',function(){
        var err = ""
        var temp = $('#txttemperature').val()
        var rain = $('#txtrainfall').val()
        var humidity = $('#txthumidity').val()
        var evaporation = $('#txtevaporation').val()
        var pressure = $('#txtpressure').val()
        var direction = $('#txtdirection').val()
        var speed = $('#txtspeed').val()
        if (temp.length<=0){
            err+="\tTemperature Field is Required\n"
        }
        if (rain.length<=0){
            err+="\tRainfall Field is Required\n"
        }
        if (pressure.length<=0){
            err+="\tPressure Field is Required\n"
        }
        if (speed.length<=0){
            err+="\tWind Speed Field is Required\n"
        }
        if (err.length>0){
            var msg = "Errors Exist Please Correct Them First\n\n"
            bootbox.alert(msg+err)
        }
        else {
           reading = new Reading();
            reading.setTemperature(temp)
            reading.setRainfall(rain)
            reading.setHumidity(humidity)
            reading.setEvaporation(evaporation)
            reading.setPressure(pressure)
            reading.setWindDirection(direction)
            reading.setWindSpeed(speed)
            reading.save()
            
        }
    })
})
