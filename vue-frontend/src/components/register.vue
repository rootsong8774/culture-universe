<template>
  <div>
    <div class="header-right pull-right">
      <ul>
        <li class="reg">
          <a href="#" data-toggle="modal" data-target=".bs-example-modal-lg">
            <h1>Register</h1>
          </a>

          <!-- Register modal -->
          <div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog"
               aria-labelledby="myLargeModalLabel">
            <div class="modal-dialog modal-lg" role="document">
              <div class="modal-content">
                <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal" aria-label="Close">
											 	<span aria-hidden="true">
											 		<i class="fa fa-close"></i>
											 	</span>
                  </button>
                  <h4 class="modal-title" id="myLargeModalLabel">Register</h4>
                  <form class="lg-frm" style="padding:25px">
                    <label>Name :</label>
                    <input type="text" class="form-control" placeholder="Enter Name">
                    <label>Email :</label>
                    <input type="text" class="form-control" placeholder="Enter Email">
                    <label>Passoward :</label>
                    <input type="text" class="form-control" placeholder="Enter Passoward">
                    <button type="button" class="btn btn-default pull-right">Submit</button>
                  </form>
                </div>
              </div>
            </div>
          </div>
        </li><!--/li -->
      </ul><!--/ul -->
    </div><!--/.header-right -->
  </div>
</template>

<script>
export default {
  name: "register",
}
</script>

<style>
.modal-header {
  border-bottom: none;
}

.modal-title {
  font-size: 30px;
  font-weight: 500;
  color: #eb1b33;
}

modal-open {
  overflow: hidden
}

.modal {
  position: fixed;
  font-size: large;
  top: 0;
  right: 0;
  bottom: 0;
  left: 0;
  /*z-index: 1050;*/
  display: none;
  overflow: hidden;
  -webkit-overflow-scrolling: touch;
  outline: 0
}

.modal.fade .modal-dialog {
  -webkit-transition: -webkit-transform .3s ease-out;
  -o-transition: -o-transform .3s ease-out;
  transition: transform .3s ease-out;
  -webkit-transform: translate(0, -25%);
  -ms-transform: translate(0, -25%);
  -o-transform: translate(0, -25%);
  transform: translate(0, -25%)
}

.modal.in .modal-dialog {
  -webkit-transform: translate(0, 0);
  -ms-transform: translate(0, 0);
  -o-transform: translate(0, 0);
  transform: translate(0, 0)
}

.modal-open .modal {
  overflow-x: hidden;
  overflow-y: auto
}

.modal-dialog {
  position: relative;
  width: auto;
  margin: 10px
}

.modal-content {
  position: relative;
  background-color: #fff;
  -webkit-background-clip: padding-box;
  background-clip: padding-box;
  border: 1px solid #999;
  border: 1px solid rgba(0, 0, 0, .2);
  border-radius: 6px;
  outline: 0;
  -webkit-box-shadow: 0 3px 9px rgba(0, 0, 0, .5);
  box-shadow: 0 3px 9px rgba(0, 0, 0, .5)
}

.modal-header {
  padding: 15px;
  border-bottom: 1px solid #e5e5e5
}

.modal-header .close {
  margin-top: -2px
}

.modal-title {
  margin: 0;
  line-height: 1.42857143
}

.modal-footer .btn + .btn {
  margin-bottom: 0;
  margin-left: 5px
}

.modal-footer .btn-group .btn + .btn {
  margin-left: -1px
}

.modal-footer .btn-block + .btn-block {
  margin-left: 0
}

@media (min-width: 1090px) {
  .modal-dialog {
    width: 600px;
    margin: 30px auto
  }

  .modal-content {
    -webkit-box-shadow: 0 5px 15px rgba(0, 0, 0, .5);
    box-shadow: 0 5px 15px rgba(0, 0, 0, .5)
  }

  .modal-sm {
    width: 300px
  }
}

@media (min-width: 1090px) {
  .modal-lg {
    width: 900px
  }
}
</style>
