/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function isPassword(subject){
    if (subject.match(/^(?=\S*?[A-Z])(?=\S*?[a-z])(?=\S*?[0-9])\S{6,}$/)) {
	return true
} else {
	// Match attempt failed
        return false;
}

}
 function isNumeric(evt){
     var charCode = (evt.which) ? evt.which : evt.keyCode
     if (charCode > 31 && (charCode != 46 && charCode<48 || charCode > 57))
         return false;
     return true;
 }