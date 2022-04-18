<template>
  <div>
    <div id="container">
      <div id="leftColumn">
        <h2>마이페이지</h2>
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
        </ul>
      </div>
      <!--//end #leftColumn//-->
      <div id="centerColumn">
        <h2>마이페이지</h2>
        <h5>공연 최근 예매 내역</h5>
        <p>고객님께서 최근 3개월간 예매하신 내용입니다</p>
        <table border="1">
          <tr>
            <!--            <th colspan="2">제목</th>-->
            <th>예매일</th>
            <th>예매번호</th>
            <th>공연명</th>
            <th>관람일</th>
            <th>매수</th>
            <th>취소가능일</th>
            <th>상태</th>
          </tr>
          <tr>
            <td>2022-03-30</td>
            <td>A11000000</td>
            <td>엑스칼리버</td>
            <td>2022.05.10.</td>
            <td>2</td>
            <td>2022.04.22.</td>
            <td>예약확정</td>
          </tr>
          <tr>
            <td>2022-03-30</td>
            <td>B12000000</td>
            <td>라이언킹</td>
            <td>2022.04.10.</td>
            <td>1</td>
            <td>2022.03.30.</td>
            <td>예약취소</td>
          </tr>
        </table>

        <blockquote>
          <p><strong>기타 안내 또는 추가 문구</strong><br/>
            정해진 문구 없음</p>
        </blockquote>
      </div>
      <!--//end #centerColumn//-->

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

div, span,
h1, h2, h3, h4, h5, h6, p, blockquote,
a, em, q, s, strong, sub, sup, tt, var,
ul, li, form, label, legend, tbody, tfoot, thead,
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

table {
  border-collapse: collapse;
  border-spacing: 0;
}

caption, th, td {
  text-align: left;
  font-weight: normal;
}

blockquote:before, blockquote:after,
q:before, q:after {
  content: "";
}

blockquote, q {
  quotes: "" "";
}

a {
  color: #cc0000;
  text-decoration: underline;
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

blockquote {
  margin: 1em;
  padding: .5em;
  background-color: #eeeeee;
  border-top: 1px solid #cccccc;
  border-bottom: 1px solid #cccccc;
}

blockquote p {
  margin: .2em;
}


#leftColumn {
  float: left;
  margin: 0;
  padding: 0;
  width: 160px;
  font-size: .9em;
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

#leftColumn li a {
  text-decoration: underline;
}

#leftColumn li a:hover {
  text-decoration: none;
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
  font-size: 1.3em;
  letter-spacing: .1em;
}


</style>
