<template>
  <div>
    <div id="container">
      <div id="leftColumn">
        <h2>
          <router-link :to="{name: 'myPage'}">마이페이지</router-link>
        </h2>
        <ul>
          <h3>예매/취소내역</h3>
          <li><a href="#">예매내역</a></li>
          <li><a href="#">예매 취소내역</a></li>
        </ul>
        <ul>
          <h3>문의 내역</h3>
          <li>
            <router-link :to="{name:'myPageQna'}">나의 문의내역</router-link>
          </li>
          <li>
            <router-link :to="{name: 'qna'}">1:1 문의하기</router-link>
          </li>
        </ul>
      </div>
      <!--//end #leftColumn//-->
      <div id="centerColumn">
        <h2 id="maintitle">MY PAGE</h2>
        <blockquote>
          <p><strong>{{ username }}님, 안녕하세요!</strong><br/>
            세종문화회관을 방문해주셔서 감사합니다.</p>
        </blockquote>
        <br>
        <div class="parent">
          <div class="child" id="resev-detail">
            <h4>최근 공연 예매 내역 |</h4><h6>고객님께서 최근 3개월간 예매하신 내용입니다</h6>
            <table class="table table-hover" id="table6_2" border="1">
              <tr>
                <!--            <th colspan="2">제목</th>-->
                <th>예매일</th>
                <th>예매번호</th>
                <th>공연명</th>
                <th>관람일</th>
                <th>매수</th>
                <th>상태</th>
              </tr>
              <tbody class="performDetail">
              <tr>
                <td>2022-03-30</td>
                <td>A11000000</td>
                <td>엑스칼리버</td>
                <td>2022.05.10.</td>
                <td>2</td>
                <td>취소버튼ㄴ</td>
              </tr>
              </tbody>
            </table>
          </div>
          <!--  ad-->
<!--          <div class="child" id="ad">-->
<!--            <div class="container" id="childContainer">-->
<!--              <div class="main_blog_fashion">-->
                <div class="col-md-4">
                  <div class="blog_fashion_right">
                    <div class="fashion_test text-center">
                      <img class="poster" src="../assets/images/ad/cityLightsPoster.jpg" alt="cityLightsPoster"/>
                      <h6 class="m-top-20" style="color: #4A35B2"><b>금주 추천 공연</b></h6>
                      <p class="m-top-20">찰리 채플린 라이브 콘서트<br>
                        따뜻한 5월, 찰리 채플린의 로맨스가 <br> 한국 관객을 찾아온다!!</p>
                    </div>

                    <div class="fashion_praspect m-top-40">
                      <div class="fashion_praspect_inner bg-black">
                        <p class="text-white">인생은 가까이서 보면 비극이요, 멀리서보면 희극이다.
                          영화 또한 그렇다.</p>
                        <p class="text-white">_ 찰리 채플린(Charlie Chaplin)</p>
                      </div>
<!--                    </div>-->
<!--                  </div>-->
<!--                </div>-->
              </div>
            </div>
          </div><!-- End off ad -->
        </div> <!--        all warp-->
        <br>
      </div>      <!--//end #centerColumn//-->
    </div>
    <!--//end #container//-->
  </div>
</template>

<script>
export default {
  name: "myPage",
}
</script>

<style scoped>
/*init*/
div, span, h3, p, strong,
a, em, q, s, sub, sup, tt, var,
ul, li, form, label, legend, tfoot, thead,
caption { /*table, tr, th, td*/
  margin-left: 20px;
  padding: 0;
  border: 0;
  outline: 0;
  font-weight: inherit;
  font-style: inherit;
  font-size: 100%;
  font-family: inherit;
  vertical-align: baseline;
}

/*left-column custom*/
#leftColumn h2 {
  margin-right: 10%;
}

a {
  color: #2B3F6B;
  text-decoration: none;
}

a:hover {
  color: #cccccc;
  text-decoration: none;
}

ul {
  margin: 0 0 0 20px;
  list-style-type: disc;
}

li {
  margin: 4px 0 5px 10px;
}

#leftColumn {
  float: left;
  margin: 0;
  padding: 0;
  width: 15%;
  font-size: 15px;
}

#leftColumn p {
  padding: 10px
}

#leftColumn h2 {
  margin: 0;
  padding: 10px 0 0 10px;
  font-size: 1em;
}

#leftColumn ul {
  margin: 0 0 0 0;
  list-style: none;
}

#leftColumn li {
  margin: 4px 0 5px 10px;
}


#leftColumn li a:hover {
  text-decoration: none;
}

/*table custom*/
table {
  width: 700px;
  font-size: 13px;

}

#table6_2 table {
  width: 100%;
  margin: 15px auto;
  border: 0;
}

#table6_2 th {
  background-color: #2B3F6B;
  color: #FFFFFF
}

#table6_2, #table6_2 th, #table6_2 td {
  font-size: 0.95em;
  text-align: center;
  padding: 4px;
  border-collapse: collapse;
}

#table6_2 tr {
  border: 1px solid #ffffff;
}

.performDetail {
  padding: 4px;
  text-align: center;
}

caption, th, td {
  text-align: left;
  font-weight: normal;
}

/*login-greeting*/
blockquote:before, blockquote:after,
q:before, q:after {
  content: "";
}


blockquote {
  margin: 1em;
  padding: .5em;
  background-color: #EFF1F9;
  border-top: 1px solid #2B3F6B;
  border-bottom: 1px solid #2B3F6B;
}

#centerColumn {
  margin: 0 0 0 180px;
  padding: 0;
  background-color: #ffffff;
}

#centerColumn p {
  padding: 10px
}

#centerColumn h2 {
  margin: 0;
  padding: 10px 0 5px 0;
  letter-spacing: .1em;
}

/*custom*/
#maintitle {
  font-weight: bold;
  line-height: 1.15;
  font-size: 35px;
  margin-block-start: 0.83em;
  margin-block-end: 0.83em;
  margin-inline-start: 0.83em;
  margin-inline-end: 0.83em;
  letter-spacing: -0.03em;
}

/*#resev-detail {*/
/*  font-style: inherit;*/
/*  margin-left: auto;*/
/*}*/

h5, h6 {
  font-weight: inherit;
  font-style: inherit;
  font-size: 100%;
  font-family: inherit;
  vertical-align: baseline;
}

.parent {
  display: flex;
  margin: 0;
  padding:0;
  position: static ;
}

.child #childContainer {
  flex: 1;
  margin: 0;
  padding:0;
}

.poster {
  width: 300px;
  height: 150px;
}
.blog_fashion_right{
  margin-right: 0;
}

</style>
