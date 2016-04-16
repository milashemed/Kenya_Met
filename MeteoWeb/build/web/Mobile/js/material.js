/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var app = new Framework7({
    pushState: true,
    swipePanel: "left",
    material: true,
    cache: true,
    modalTitle: "Kenya Meteorological Department",
    onAjaxStart: function(xhr){
        app.showIndicator()
    },
    onAjaxComplete: function(xhr){
        app.hideIndicator()
    }
    
});

