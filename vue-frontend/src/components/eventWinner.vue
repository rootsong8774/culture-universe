<template>
  <div>
    <Header current-class="EventWinner"/>
    <div id="centerColumn">
      <h2>이벤트 당첨자 발표</h2>
      <form>
        <select name="language">
          <option value="none">=== 전체 ===</option>
          <option value="korean">번호</option>
          <option value="english">제목</option>
          <option value="chinese">등록일자</option>
          <option value="spanish">번호+제목</option>
        </select>
        <input type="search"> 검색 아이콘 추가
      </form>
      <table border="1">
        <tr>
          <th>번호</th>
          <th>제목</th>
          <th>등록일</th>
          <th>조회</th>
        </tr>
        <tr>
          <td>3</td>
          <td> '따뜻한 봄 날 연극 보러 가자!' 당첨자 발표 </td>
          <td>2022.03.30</td>
          <td>30</td>
        </tr>
        <tr>
          <td colspan="6">
            <center>
              <a href="#">1</a>
              <a href="#">2</a>
              <a href="#">3</a>
              <a href="#">4</a>
              <a href="#">다음▶</a>
            </center>
          </td>
        </tr>

      </table>
    </div>
    <Footer/>
  </div>
</template>
<script>
import Header from "./header";
import Footer from "./footer";

export default {
  name: "eventWinner",
  components: {Header, Footer}
}
</script>

<style >
div{margin: 0;}
h2 {text-align: center}
form {
  text-align: right;
}
table {
  margin-left:auto;
  margin-right:auto;
}

table, td, th {
  border-collapse : collapse;
  border : 1px solid black;
  font-size: larger;
}
</style>
