<div id="mailModal" class="modal fade" role="dialog">
  <div class="modal-dialog">  
<div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Send Mail</h4>
      </div>
      <div class="modal-body">
          <form class="form-horizontal" role="form">
              
              <div class="form-group" style="margin: 2%;">
                  <label class="control-label" for="txtemail">Email Address </label>
                  <input type="text" id="txtemail" class="form-control" disabled="true" placeholder="Email Address" />
              </div>
              <div class="form-group" style="margin: 2%;">
                  <label class="control-label" forl-sm-1="txtmessage">Message </label>
                  <textarea id='txtmessage' class="form-control" placeholder="Message" rows="5" cols='20'></textarea> 
              </div>
               
          </form>
      </div>
   
      <div class="modal-footer">
        <button type="button" class="btn btn-primary btn-block btn-lg"  id="btnsend">Send Mail</button>
      </div>
    </div>
  </div>
</div>
  
