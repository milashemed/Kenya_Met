<div id="passwordModal" class="modal fade" role="dialog">
  <div class="modal-dialog">  
<div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Password Change</h4>
        
        </div>
      <div class="modal-body">
          <form class="form-horizontal" role="form">
              
              <div class="form-group" style="margin: 2%;">
<!--                  <label class="control-label col-sm-1" for="txtnew">New Password </label>-->
                  <input type="password" id="txtnew" class="form-control" placeholder="New Password" />
              </div>
              <div class="form-group" style="margin: 2%;">
<!--                  <label class="control-label col-sm-1" for="txtconf">Confirm Password </label>-->
                  <input type="password" id="txtconf" class="form-control" placeholder="Confirm Password" />
              </div>
               
          </form>
      </div>
    <div class="notify" id="notifychange"><span>Notify</span></div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary btn-block btn-lg"  id="btnhints">Password Hints</button>
        <button type="button" class="btn btn-primary btn-block btn-lg"  id="btnchange">Change Password</button>
      </div>
    </div>
  </div>
</div>
<script>
var btnhints = document.getElementById('btnhints')
btnhints.addEventListener('click',function(){
    var hints = "<p><strong>Passwords are Required to Have the Following Characteristics</strong> </p> <br /> <p> 1) Must Be 8 Characters Long</p> <br /><p> 2) Must Consist of at Least One Upper Case Letter </p> <br /><p> 3) Must Consist of at Least One Lower Case Letter </p> <br /><p> 4) Must Consist of at Least One Digit</p>"
    bootbox.alert(hints)
},true)
var btnchange = document.getElementById('btnchange')
btnchange.addEventListener('click',function(){
    
   var txtnew = document.getElementById('txtnew').value
   var txtconf = document.getElementById('txtconf').value
   if (!isPassword(txtnew)){
       bootbox.alert("Password is Weak,Please Click on Password Hints to check Password Constraints")
       
   }
   else if (txtnew !== txtconf){
       
     bootbox.alert("Passwords do not Match")

   }
   else {
       
       
       user.changePassword(txtnew)
   }
},true)
</script>