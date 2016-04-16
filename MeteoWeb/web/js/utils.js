/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function isIOS(){
    if (navigator.userAgent.match(/iPhone/i)){
        return true;
        
    }
    else {
        
        return false;
    }
    
}
function isMaterial(){
    if (navigator.userAgent.match(/Android/i)){
        return true;
        
    }
    else {
        
        return false;
    }
    
}
function isFennec(){
     if (navigator.userAgent.match(/Mozilla/i) && navigator.userAgent.match(/Mobile/i)){
        return true;
        
    }
    else {
        
        return false;
    }
    
}
function openWin(url,width,height){
    var options = "menubar=yes,width" + width + ",height="+height+",scrollbars=yes,toolbar=yes"
    window.open(url,"win",options)
}
