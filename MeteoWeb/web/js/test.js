/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function Test(){
    this.fullname = {
        Fname: "Salim",
        Mname: "Said"
        
    };
    this.getFullName = function(){
        
        return this.fullname.Fname + " " + this.fullname.Mname
    }
    
}
