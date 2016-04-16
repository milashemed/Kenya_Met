/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function User(username,password){
    this.details = {
        "Username":username,
        "Password":password
        
    }
    this.authenticate = function (){
        
        var xmlhttp = new XMLHttpRequest();
        var url = "../Authenticate?Username="+this.details.Username+"&Password="+this.details.Password
       
        xmlhttp.open("GET",url,true)
        xmlhttp.onreadystatechange = function(){
            if (xmlhttp.status === 200 && xmlhttp.readyState === 4){
                var response = xmlhttp.responseText
                var obj = JSON.parse(response)
                if (obj.results == "Empty"){
                    bootbox.alert("<p class=text-danger lead><strong>User Does not Exist, Please Contact Administrator For Registration</strong></p>")
                }
                else if (obj.results == "Fail"){
                    bootbox.alert("<p class=text-danger lead><strong>Inavlid Username and/or Password</strong></p>")

                }
                else if (obj.status === "0"){
                    bootbox.alert("<p class=text-danger lead><strong>User Has been Disabled, Please Contact Administrator For Verification and Reactivation</strong></p>")

                    
                }
                else if (obj.type === "Administrator"){
                    bootbox.alert("Administrator Console is not Accessible From Web Interface")
                }
                else if (obj.results === "Success"){
                    
                    if (obj.passChange === "1"){
                    //$('#notifylogin').fadeOut('slow')
                    
                        $('#loginModal').modal('toggle')
                    bootbox.alert("You Are Required To Change Your Password Before You Can Use the System",function(){
                      
                        $('#passwordModal').modal('show')  
                      
                    })
                }
                else {
                    
                        var url = ""
                       
                        if (obj.type.toString().localeCompare("Management") === 0 ){
                            
                            $.get("createSession.jsp?username="+obj.username,function(datas,status){
                               if (status.localeCompare("success") === 0){
                                    bootbox.alert("User Has Been Authenticated, You Will Now Be Redirected to Your Homepage",function(){
                                        window.location = "Management/landing.jsp" 
                                        sessionStorage.type="Management"
                                    })
                                }
                            })
                        }
                        else if (obj.type.toString().localeCompare("Data Entry") === 0){
                           
                            $.get("createSession.jsp?username="+obj.username,function(datas,status){
                                if (status.localeCompare("success") === 0){
                                    bootbox.alert("User Has Been Authenticated, You Will Now Be Redirected to Your Homepage",function(){
                                        window.location = "Volunteer/landing.jsp" 
                                        sessionStorage.type="Data Entry"
                                    })
                                }
                               
                            })
                        }
                        
                }
                }
                 
            }
            
        }
        xmlhttp.send(null);
    }
    this.changePassword = function(newPassword){
        var xmlhttp = new XMLHttpRequest()
        
        var url = "../changePassword?newPassword="+newPassword+"&username="+this.details.Username
        xmlhttp.open("GET",url,true)
        xmlhttp.onreadystatechange = function(){
            if (xmlhttp.readyState==4 && xmlhttp.status==200){
                var response = xmlhttp.responseText;
                alert(response)
                var obj = JSON.parse(response)
                if (obj.Status == "OK"){
                    bootbox.alert("Password Changed,You Will Now Be Redirected To Your Homepage",function(){
                        
                        var url = ""
                        if (obj.type === "Management"){
                             $.get("createSession.jsp?username="+data.username,function(datas,status){
                               window.location = "Management/landing.jsp" 
                            })
                        }
                        else if (obj.type === "Data Entry"){
                            
                             $.get("createSession.jsp?username="+data.username,function(datas,status){
                                
                               window.location = "Volunteer/landing.jsp"  
                            })
                        }
                        window.location = url
                    })
                }
                else {
                   
                    bootbox.alert("An Error Occured, Please Try Again",function(){
                        $('#passwordModal').modal('show')  
                    })
                }
            }
        }
        xmlhttp.send(null)
    }
    
}

