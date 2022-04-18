<template>
  <div>


    <div class="culmn">
      <!--Home page style-->

      <nav class="navbar navbar-default navbar-fixed white no-background bootsnav text-uppercase">
        <!-- Start Top Search -->
        <div class="top-search">
          <div class="container">
            <div class="input-group">
              <span class="input-group-addon"><i class="fa fa-search"></i></span>
              <input type="text" class="form-control" placeholder="Search">
              <span class="input-group-addon close-search"><i class="fa fa-times"></i></span>
            </div>
          </div>
        </div>
        <!-- End Top Search -->

        <div class="container">
          <!-- Start Atribute Navigation -->
          <div class="attr-nav">
            <ul>
              <li class="search"><a href="#"><i class="fa fa-search"></i></a></li>
<!--              <li class="dropdown">-->
<!--                <a href="#" class="dropdown-toggle" data-toggle="dropdown">-->
<!--                  <i class="fa fa-shopping-bag"></i>-->
<!--                  <span class="badge">3</span>-->
<!--                </a>-->

<!--              </li>-->

            </ul>
          </div>
          <!-- End Attribute Navigation -->

          <!-- Start Header Navigation -->
          <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target="#navbar-menu">
              <i class="fa fa-bars"></i>
            </button>
            <router-link :to="{name:'main'}" class="navbar-brand">
              <img src="src/assets/images/logo.png" class="logo logo-display" alt="">
              <img src="src/assets/images/logo.png" class="logo logo-scrolled" alt="">
            </router-link>
          </div>
          <!-- End Header Navigation -->

          <!-- Collect the nav links, forms, and other content for toggling -->
          <div class="collapse navbar-collapse" id="navbar-menu">
            <ul class="nav navbar-nav navbar-right" data-in="fadeInDown" data-out="fadeOutUp">
              <li class="dropdown">
                <router-link :to="{name:'performanceList', params: {page: 1}}">공연</router-link>
<!--                <ul class="dropdown-menu">-->
<!--                  <li>-->
<!--                    <router-link :to="{name: 'performanceList', params: {page: 1}}">공연일정</router-link>-->
<!--                  </li>-->
<!--                  <li><a href="#">공연달력</a></li>-->
<!--                  <li><a href="#">좌석배치도</a></li>-->
<!--                </ul>-->
              </li>
              <li class="dropdown">
                <router-link :to="{name: 'eventInProgress'}">이벤트</router-link>
                <ul class="dropdown-menu">
                  <li>
                    <router-link :to="{name: 'eventInProgress'}">진행 이벤트</router-link>
                  </li>
                  <li>
                    <router-link :to="{name: 'eventWinner'}">당첨자 발표</router-link>
                  </li>
                  <li>
                    <router-link :to="{name: 'eventClosed'}">지난 이벤트</router-link>
                  </li>
                </ul>
              </li>
              <li class="dropdown">
                <router-link :to="{name: 'qna'}">고객센터</router-link>
                <ul class="dropdown-menu">
                  <li>
                    <router-link :to="{name: 'notice'}">공지 사항</router-link>
                  </li>
                  <li>
                    <router-link :to="{name: 'faq'}">FAQ</router-link>
                  </li>
                  <li>
                    <router-link :to="{name: 'qna'}">고객 문의</router-link>
                  </li>
                </ul>
              </li>
              <li class="dropdown">
                <router-link :to="{name: 'organization'}">기관소개</router-link>
                <ul class="dropdown-menu">
                  <li>
                    <router-link :to="{name: 'organization'}">세종문화회관 소개</router-link>
                  </li>
                  <li>
                    <router-link :to="{name: 'facility'}">시설 소개</router-link>
                  </li>
                  <li>
                    <router-link :to="{name: 'direction'}">오시는 길</router-link>
                  </li>
                </ul>
              </li>
              <li><a href="#" data-toggle="modal" data-target=".bs-example-modal-sm">로그인/회원가입</a></li>
              <li><router-link :to="{name: 'myPage'}">마이페이지</router-link></li>
              <!-- login modal -->
              <div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog"
                   aria-labelledby="mySmallModalLabel">
                <div class="modal-dialog modal-sm" role="document">
                  <div class="modal-content">
                    <div class="modal-header">
                      <button type="button" class="close" data-dismiss="modal" aria-label="Close">
											 	<span aria-hidden="true">
											 		<i class="fa fa-close"></i>
											 	</span>
                      </button>
                      <h4 class="modal-title" id="mySmallModalLabel">
                        Sign In
                      </h4>
                      <form class="sm-frm" style="padding:25px">
                        <label>ID :</label>
                        <input type="text" class="form-control" placeholder="Enter Email">
                        <label>Password :</label>
                        <input type="text" class="form-control" placeholder="Enter Password">
                        <label><input type="checkbox" name="personality" class="remember"> Remember
                          Me</label>
                        <br>
                        <button type="button" class="btn btn-default pull-right">로그인</button>
                        <button type="button" data-toggle="modal" data-target=".bs-example-modal-lg"
                                class="btn btn-default pull-left">회원가입
                        </button>
                      </form>
                    </div>
                  </div>
                </div>
              </div>
              <!-- register modal -->
              <div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog"
                   aria-labelledby="myLargeModalLabel">
                <div class="modal-dialog modal-dialog" role="document">
                  <div class="modal-content">
                    <div class="modal-header">
                      <button type="button" class="close" data-dismiss="modal" aria-label="Close">
											 	<span aria-hidden="true">
											 		<i class="fa fa-close"></i>
											 	</span>
                      </button>
                      <h4 class="modal-title" id="myLargeModalLabel">Register</h4>
                      <form class="lg-frm" style="padding:25px">
                        <label>이름 :</label>
                        <input type="text" class="form-control" placeholder="Enter Name"
                               v-model:name="username">
                        <label>아이디 :</label>
                        <input type="text" class="form-control" placeholder="Enter ID"
                               v-model:name="name">
                        <label>비밀번호 :</label>
                        <input type="text" class="form-control" placeholder="Enter Password"
                               v-model:name="pw">
                        <label>이메일 :</label>
                        <input type="email" class="form-control" placeholder="Enter Email"
                               v-model:name="email">
                        <label>휴대폰 :</label>
                        <input type="text" class="form-control" v-model:name="phoneNum"><br>
                        <button type="submit" class="btn btn-default pull-right" @click="register" >
                          회원가입 완료
                        </button>
                      </form>
                    </div>
                  </div>
                </div>
              </div>

            </ul>
          </div><!-- /.navbar-collapse -->
        </div>


      </nav>


      <!--Home Sections-->

      <section id="hello" class='bg-mega' :class="currentClass">
        <div class="container">
          <div class="row">
            <div class="main_home text-center">
              <div class="home_text">
<!--                <h4 class="text-white text-uppercase">a new creative studio</h4>-->
<!--                <h1 class="text-white text-uppercase">good design is always in season</h1>-->

<!--                <div class="separator"></div>-->

<!--                <h5 class=" text-uppercase text-white"><em>One day, the dream will come true with-->
<!--                  lorem ipsum dolor sit amet,-->
<!--                  consectetuer adipiscing elit, nummy nibh euismod tincidunt laoreet.</em></h5>-->
              </div>
            </div>
          </div><!--End off row-->
        </div><!--End off container -->
      </section> <!--End off Home Sections-->

    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: "LayoutHeader",
  props: {
    currentClass: String
  },
  data() {
    return {
      username: '',
      name: '',
      pw: '',
      email: '',
      phoneNum: ''
    }
  },
  methods: {
    register: function () {
      axios({
        url: '/api/register',
        method: 'post',
        data: {
          username: this.username,
          name: this.name,
          pw: this.pw,
          email: this.email,
          phoneNum: this.phoneNum
        },
      }).then(function (response) {
        console.log(response);
        alert('회원가입 성공');
        $('.bs-example-modal-lg').modal('hide');
      }).catch(function (error) {
        console.log(error);
      });



    }
  }
}


</script>


<style scoped>
.modal-header {
  border-bottom: none;
}

.modal-title {
  font-size: 30px;
  font-weight: 500;
  color: #eb751b;
}

.modal-open {
  overflow: hidden;
  padding-right: 0 !important;
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
  overflow-y: auto;


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
  -webkit-box-shadow: 0 3px 9px;
  box-shadow: 0 3px 9px rgba(0, 0, 0, .5)
}

.modal-header {
  padding: 15px;

}

.modal-header .close {
  margin-top: -2px
}

.modal-title {
  margin: 0;
  line-height: 1.42857143
}

.btn + .btn {
  margin-bottom: 0;
  margin-left: 5px
}

.remember {
  padding: 1px;
  text-align: left;
}

form {
  text-align: left !important;
}

/*modal box location*/
@media (min-width: 1090px) {
  .modal-dialog {
    width: 600px;
    margin: 30px auto;
  }

  .modal-content {
    -webkit-box-shadow: 0 5px 15px rgba(0, 0, 0, .5);
    box-shadow: 0 5px 15px rgba(0, 0, 0, .5);
    height: 100%;
    padding-bottom: 20px;

  }

  .modal-sm {
    width: 400px;

  }
}

/*register*/
@media (min-width: 1090px) {

  .modal-lg {
    width: 900px
  }
}

.pull-left {
  float: bottom;
  left: auto;
}

.pull-right {
  float: bottom;
}
</style>
