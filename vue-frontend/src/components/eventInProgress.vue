<template>
  <div>
    <!--nwes start -->
    <section class="news">
      <div class="container">
        <div class="news-details">
          <div class="section-header text-center">
            <br/>
            <h2>진행중인 이벤트</h2>
            <p>
              이벤트를 확인해 주세요
            </p>

          </div><!--/.section-header-->
          <div class="news-card">
            <div class="row">

              <div class="col-md-8">
                <div class="blog-left">
                  <div class="col-sm-6">
                    <router-link :to="{name: 'eventInProgressDetails'}">
                      <div class="single-news-box news-mb-20">
                        <div class="news-box-bg">

                          <img src="../assets/images/SJ/event.jpg" alt="이벤트이미지">
                          <div class="isotope-overlay">
                            <a>
                              <span class="lnr lnr-link"></span>
                            </a>
                          </div>
                        </div><!--/.team-box-bg-->
                        <div class="news-box-inner">
                          <h3>
                            <a>
                              댓글이벤트
                            </a>
                          </h3>
                          <p class="news-meta">
                            이벤트 기간:2022.02.03~2022.04.16
                          </p>
                        </div><!--/.news-box-inner-->
                      </div><!--/.single-news-box-->
                    </router-link>
                  </div><!--.col-->

                  <div class=" col-sm-6">
                    <router-link :to="{name: 'eventInProgressDetails'}">
                      <div class="single-news-box news-mb-20">
                        <div class="news-box-bg">
                          <img src="../assets/images/SJ/event.jpg" alt="두번째이미지">
                          <div class="isotope-overlay">
                            <a>
                              <span class="lnr lnr-link"></span>
                            </a>
                          </div>

                        </div><!--/.team-box-bg-->
                        <div class="news-box-inner">
                          <h3>
                            <a>
                              댓글 이벤트 2
                            </a>
                          </h3>
                          <p class="news-meta">
                            이벤트 기간:2022.02.03~2022.04.16
                          </p>
                          <!-- <a href="#" class="learn-btn">
                            learn more
                          </a> -->
                        </div><!--/.news-box-inner-->
                      </div><!--/.single-news-box-->
                    </router-link>
                  </div><!--.col-->

                  <div class="pagination-part text-center">
                    <ul class="pagination">
                      <li class="active"><a href="#">1 <span class="sr-only">(current)</span></a>
                      </li>
                      <li><a href="#">2</a></li>
                      <li><a href="#">3</a></li>
                      <li>
                        <a href="#">
                          Next
                          <span class="fa fa-angle-right">
													</span>
                        </a>
                      </li>
                    </ul>
                  </div><!--/.pagination-part(&raquo;)-->
                </div><!--/.blog-left-->
              </div><!--/.row-->
            </div><!--/.news-card-->
          </div><!--/news-details-->
        </div><!--/.container-->
      </div>
    </section><!--/news-->
    <!--news end-->
  </div>
</template>

<script>


export default {
  name: "eventInProgress",
}
</script>
<style scoped>
.news {
  padding: 114px 0 95px;
}

.news-card {
  margin-top: 70px;
}

.news-card-pb-25 {
  padding-bottom: 25px;
}

/*single-news-box*/
.single-news-box {
  box-shadow: 0 5px 30px 0px rgba(115, 112, 215, .2);
  min-height: 504px;
  margin-bottom: 13px;
  -webkit-transition: .5s;
  -moz-transition: .5s;
  -ms-transition: .5s;
  -o-transition: .5s;
  transition: .5s;

}

.single-news-box.news-mb-20 {
  margin-bottom: 20px;
}

/*single-news-box*/

/*news-box-bg*/
.news-box-bg {
  position: relative;
  overflow: hidden;
  -webkit-transform: scale(1);
  -moz-transform: scale(1);
  -ms-transform: scale(1);
  -o-transform: scale(1);
  transform: scale(1);
  -webkit-transition: .5s;
  -moz-transition: .5s;
  -ms-transition: .5s;
  -o-transition: .5s;
  transition: .5s;
}

.single-news-box:hover .isotope-overlay {
  -webkit-transform: scaleY(1);
  -moz-transform: scaleY(1);
  -ms-transform: scaleY(1);
  -o-transform: scaleY(1);
  transform: scaleY(1);
  top: 0;
}

/*news-box-bg*/

/*news-box-inner*/
.news-box-inner {
  padding: 30px 0px 30px 20px;
  -webkit-transition: .5s;
  -moz-transition: .5s;
  -ms-transition: .5s;
  -o-transition: .5s;
  transition: .5s;
}

.news-box-inner h3 a {
  color: #4d4e54;
  display: block;
  font-size: 16px;
  margin-bottom: 17px;
  font-family: 'Playfair Display', serif;
  font-style: italic;
  max-width: 350px;
  font-weight: 600;
  line-height: 1.4;
}

.news-box-inner .team-meta {
  display: block;
  color: #4d4e54;
  font-size: 12px;
  font-family: 'Poppins', sans-serif;
}

.news-box-inner span {
  color: #908edf;

}

a.learn-btn,
a:hover.learn-btn,
a:focus.learn-btn,
a:active.learn-btn {
  color: #7086e6;
  font-size: 12px;
  font-family: 'Lato', sans-serif;
  font-weight: 700;
  text-transform: capitalize;
  margin-top: 8px;
  padding-bottom: 18px;
  opacity: 0;
  -webkit-transition: 0.5s ease-in-out;
  -moz-transition: 0.5s ease-in-out;
  -ms-transition: 0.5s ease-in-out;
  -o-transition: 0.5s ease-in-out;
  transition: 0.5s ease-in-out;
}

.single-news-box:hover .news-box-inner {
  background: #f9faff;

}

/*team-box-inner*/
.single-news-box:hover {
  box-shadow: 0 5px 35px 0px rgba(115, 112, 215, .2);
}

.single-news-box:hover .news-box-bg {
  -webkit-transform: scaleY(1.05);
  -moz-transform: scaleY(1.05);
  -ms-transform: scaleY(1.05);
  -o-transform: scaleY(1.05);
  transform: scaleY(1.05);
}

.isotope .item:hover img {
  -webkit-transform: scale(1.5);
  -moz-transform: scale(1.5);
  -ms-transform: scale(1.5);
  -o-transform: scale(1.5);
  transform: scale(1.5);
}

/*.item img*/
</style>
