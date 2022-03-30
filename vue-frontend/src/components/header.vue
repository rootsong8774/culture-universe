<template>
  <div>
<!--    <div id="loading">
      <div id="loading-center">
        <div id="loading-center-absolute">
          <div class="object"></div>
          <div class="object"></div>
          <div class="object"></div>
          <div class="object"></div>
          <div class="object"></div>
          <div class="object"></div>
          <div class="object"></div>
          <div class="object"></div>
          <div class="object"></div>
          <div class="object"></div>
        </div>
      </div>
    </div>-->

    <!--End off Preloader -->


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
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                  <i class="fa fa-shopping-bag"></i>
                  <span class="badge">3</span>
                </a>
<!--                <ul class="dropdown-menu cart-list">
                  <li>
                    <a href="#" class="photo"><img src="../assets/images/logo.png"
                                                   class="cart-thumb" alt=""/></a>
                    <h6><a href="#">Delica omtantur </a></h6>
                    <p class="m-top-10">2x - <span class="price">$99.99</span></p>
                  </li>
                  <li>
                    <a href="#" class="photo"><img src="../assets/images/logo.png"
                                                   class="cart-thumb" alt=""/></a>
                    <h6><a href="#">Delica omtantur </a></h6>
                    <p class="m-top-10">2x - <span class="price">$99.99</span></p>
                  </li>
                  <li>
                    <a href="#" class="photo"><img src="../assets/images/logo.png"
                                                   class="cart-thumb" alt=""/></a>
                    <h6><a href="#">Delica omtantur </a></h6>
                    <p class="m-top-10">2x - <span class="price">$99.99</span></p>
                  </li>
                  &lt;!&ndash;&#45;&#45; More List &#45;&#45;&ndash;&gt;
                  <li class="total">
                    <span class="pull-right"><strong>Total</strong>: $0.00</span>
                    <a href="#" class="btn btn-cart">Cart</a>
                  </li>
                </ul>-->
              </li>

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
              <img src="../assets/images/logo.png" class="logo logo-display" alt="">
            </router-link>
          </div>
          <!-- End Header Navigation -->

          <!-- Collect the nav links, forms, and other content for toggling -->
          <div class="collapse navbar-collapse" id="navbar-menu">
            <ul class="nav navbar-nav navbar-right" data-in="fadeInDown" data-out="fadeOutUp">
              <li class="dropdown">
                <router-link :to="{name:'performanceList'}">공연</router-link>
                <ul class="dropdown-menu">
                  <li><router-link :to="{name: 'performanceList'}">공연일정</router-link></li>
                  <li><a href="#">공연달력</a></li>
                  <li><a href="#">좌석배치도</a></li>
                </ul>
              </li>
              <li class="dropdown">
                <a href="#">이벤트</a>
                <ul class="dropdown-menu">
                  <li><a href="#">진행 이벤트</a></li>
                  <li><a href="#">당첨자 발표</a></li>
                  <li><a href="#">지난 이벤트</a></li>
                </ul>
              </li>
              <li class="dropdown">
                <router-link :to="{name: 'qna'}">고객센터</router-link>
                <ul class="dropdown-menu">
                  <li><a href="#">공지 사항</a></li>
                  <li><a href="#">FAQ</a></li>
                  <li><router-link :to="{name: 'qna'}">고객 문의</router-link></li>
                </ul>
              </li>
              <li class="dropdown">
                <router-link :to="{name: 'organization'}">기관소개</router-link>
                <ul class="dropdown-menu">
                  <li><router-link :to="{name: 'organization'}">세종문화회관 소개</router-link></li>
                  <li><router-link :to="{name: 'facility'}">시설 소개</router-link></li>
                  <li><a href="#">오시는 길</a></li>
                </ul>
              </li>
              <li><router-link :to="{name: 'loginRegister'}">로그인</router-link></li>
              <li><a href="#">회원가입</a></li>

            </ul>
          </div><!-- /.navbar-collapse -->
        </div>


      </nav>


      <!--Home Sections-->

      <section id="hello" class = 'bg-mega' :class="currentClass" >
        <div class="container">
          <div class="row">
            <div class="main_home text-center">
              <div class="home_text">
                <h4 class="text-white text-uppercase">a new creative studio</h4>
                <h1 class="text-white text-uppercase">good design is always in season</h1>

                <div class="separator"></div>

                <h5 class=" text-uppercase text-white"><em>One day, the dream will come true with
                  lorem ipsum dolor sit amet,
                  consectetuer adipiscing elit, nummy nibh euismod tincidunt laoreet.</em></h5>
              </div>
            </div>
          </div><!--End off row-->
        </div><!--End off container -->
      </section> <!--End off Home Sections-->

    </div>
  </div>
</template>

<script>
export default {
  name: "header",
  props: {
    currentClass: String
  }
}

</script>

<style scoped>

</style>
