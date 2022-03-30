<template>
  <div>
    <Header current-class="EventClosed"/>
    <!--nwes start -->
    <section class="news">
      <div class="container">
        <div class="news-details">
          <div class="section-header text-center">
            <br/>
            <h2>종료된 이벤트</h2>
            <p>당첨자 확인은 당첨자 페이지에서 확인 해주세요</p>

          </div><!--/.section-header-->
          <div class="news-card">
            <div class="row">
              <div class="col-md-8">
                <div class="blog-left">
                  <div class="col-sm-6">
                    <div class="single-news-box news-mb-20">
                      <div class="news-box-bg">
                        <img src="" alt="종료된이벤트이미지 어둡게">
                        <div class="isotope-overlay">
                          <a href="./eventClosedConn.vue">
                            <span class="lnr lnr-link"></span>
                          </a>
                        </div>
                      </div><!--/.team-box-bg-->
                      <div class="news-box-inner">
                        <h3>
                          <a href="#">
                            종료된 이벤트
                          </a>
                        </h3>
                        <p class="news-meta">
                          이벤트 기간:2022.01.02~2022.02.01
                        </p>
                      </div><!--/.news-box-inner-->
                    </div><!--/.single-news-box-->
                  </div><!--.col-->

                  <div class="pagination-part text-center">
                    <ul class="pagination">
                      <li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>
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
    <Footer/>
  </div>
</template>

<script>
import Header from "./header";
import Footer from "./footer";

export default {
  name: "eventClosed",
  components: {Header, Footer}
}
</script>

<style scoped>

</style>
