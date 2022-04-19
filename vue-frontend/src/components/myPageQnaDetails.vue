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
      </div>      <!--//end #leftColumn//-->
      <div id="centerColumn">
        <h2 id="maintitle">MY PAGE - 나의 문의내역 상세페이지</h2>
        <br>
<!--        <div class="myQna">-->
          <h6 class="qna">나의 문의 내역</h6>
          <table class="table table-hover" id="table6_2">
            <tr>
              <th>문의유형</th>
              <th>문의제목</th>
              <th>문의내용</th>
              <th>문의등록일</th>
            </tr>
            <tbody>
            <tr>
              <td>{{ qnaDetailData.type }}</td>
              <td>{{ qnaDetailData.title }}</td>
              <td>{{ qnaDetailData.content }}</td>
              <td>{{ qnaDetailData.regDate  | yyyyMMdd }}</td>
            </tr>
            </tbody>
          </table>
<!--        </div>-->
        <br>
        <!--          관리자 답변 테이블-->
<!--        <div class="comment">-->
          <h6 class="adminComment">관리자 답변</h6>
          <table class="table table-hover" id="table6_3">
            <tr>
              <th>담당자</th>
              <th>답변</th>
              <th>답변등록일</th>
            </tr>
            <tbody>
            <tr class="result-date" v-for="(comment,index) in commentDetailData" :key="index">
              <td>{{ comment.adminId }}</td>
              <td>{{ comment.commentContent }}</td>
              <td>{{ comment.regDate | yyyyMMdd }}</td>
            </tr>
            </tbody>
          </table>
<!--        </div>-->
        <br><br>
      </div><!--      center column-->
    </div><!--    container-->
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "myPageQnaDetails",
  data() {
    return {
      noInfo: '문의 내역이 없습니다.',
      qnaDetailData: {},
      commentDetailData: []
    }
  },
  created() {
    this.getDetails();
    this.getComments();
  },
  filters: {
    yyyyMMdd: function (value) {
      if (value === '') {
        return '';
      }
      // 연도, 월, 일 추출
      let year = value[0];
      let month = value[1];
      let day = value[2];
      // 월, 일의 경우 한자리 수 값이 있기 때문에 공백에 0 처리
      if (month < 10) {
        month = '0' + month;
      }
      if (day < 10) {
        day = '0' + day;
      }
      // 최종 포맷 (ex - '2021.10.08')
      return year + '.' + month + '.' + day;
    }
  },
  methods: {
    getDetails: function () {
      axios({
        url: 'api/qna/read',
        params: {
          questionIdx: this.$route.query.questionIdx,
        },
        method: 'get',
      }).then(response => {
        this.qnaDetailData = response.data
      })
    },
    getComments: function () {
      axios({
        url: 'api/qna/adminComment',
        params: {
          questionIdx: this.$route.query.questionIdx,
        },
        method: 'get',
      }).then(response => {
        this.commentDetailData = response.data
      })
    },
  },
  // watch: {
  //   page: function () {
  //     this.getComments();
  //   }
  // }
}
</script>

<style scoped>
/*init*/
div, span, h3, p, strong,
a, em, q, s, sub, sup, tt, var,
ul, li, form, label { /*table, tr, th, td*/
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

/*centerColum*/
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

/*table */
table {
  border-collapse: collapse;
  border-spacing: 0;
  width: 800px;
  /*margin: auto;*/
}

#table6_2 table {
  width: 100%;
  margin-left:0;
  /*margin: 15px auto;*/
  border: 0;
}

#table6_3 table {
  width: 100%;
  /*margin: 15px auto;*/
  border: 0;
}

#table6_2 th {
  background-color: #2B3F6B;
  color: #FFFFFF
}

#table6_3 th {
  background-color: #2B3F6B;
  color: #FFFFFF
}

#table6_2, #table6_2 th, #table6_2 td {
  font-size: 0.95em;
  text-align: center;
  padding: 4px;
  border-collapse: collapse;
}

#table6_3, #table6_3 th, #table6_3 td {
  font-size: 0.95em;
  text-align: center;
  padding: 4px;
  border-collapse: collapse;
}

#table6_2 th, #table6_2 td {
  border: 1px solid #202020;
  border-width: 1px 0 1px 0
}

#table6_3 th, #table6_3 td {
  border: 1px solid #202020;
  border-width: 1px 0 1px 0
}

#table6_2 tr {
  border: 1px solid #ffffff;
}

#table6_3 tr {
  border: 1px solid #ffffff;
}


/*custom css */


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

h6{
  font-weight: bold;
  font-size: 17px;
  color:#7B8EA9;
}
</style>

