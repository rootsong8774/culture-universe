<template>
  <div>
    <div>
      <div>
        <h3 id="maintitle">나의 문의내역 상세페이지</h3>
        <br>
        <span>
          <a href="#qna">나의 문의 내역</a> /
          <a href="#adminComment">답변 확인</a>
        </span>
      </div>
      <div>
        <!--          나의 문의 내역 테이블-->
        <div>
          <div class="myQna">
            <table class=table6_2>
              <h6 class="qna">나의 문의 내역</h6>
              <tr>
                <th>문의유형</th>
                <th>문의제목</th>
                <th>문의내용</th>
                <th>문의등록일</th>
              </tr>
              <tr >
                <td><a href="#qnadetails">{{ qna.type }}</a></td>
                <td>{{ qnaDetailData.title }}</td>
                <td>{{ qnaDetailData.content }}</td>
                <td>{{ qnaDetailData.regDate }}</td>
              </tr>
            </table>
          </div>
          <br>
          <!--          관리자 답변 테이블-->
          <div class="comment">
            <table class=table6_2>
              <h6 class="adminComment">관리자 답변</h6>
              <tr>
                <th>담당자</th>
                <th>답변</th>
                <th>답변등록일</th>
              </tr>
              <tr class="result-date" >
                <td>{{ commentDetailData.adminId }}</td>
                <td>{{ commentDetailData.commentContent }}</td>
                <td>{{ commentDetailData.regDate }}</td>
              </tr>
            </table>
          </div>
        </div>
<!--        목록처리-->
        <div class="btnWrap">
          <a @click="reservation" class="btn">목록</a>
        </div>
      </div>
    </div>
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
      commentDetailData: {}
    }
  },
  created() {
    this.getDetails();
    this.getComments();
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
    reservation: function () {
      this.$router.push({name: 'myPageQna'})
    }
  },
  watch: {
    page: function () {
      this.getComments();

    }
  }
}
</script>

<style scoped>
.table6_2 table {
  width: 100%;
  margin: 15px auto;
  border: 0;
}

.table6_2 th {
  background-color: #505050;
  color: #FFFFFF
}

.table6_2, .table6_2 th, .table6_2 td {
  font-size: 0.95em;
  text-align: center;
  padding: 4px;
  border-collapse: collapse;
}

.table6_2 th, .table6_2 td {
  border: 1px solid #202020;
  border-width: 1px 0 1px 0
}

.table6_2 tr {
  border: 1px solid #ffffff;
}

.table6_2 tr:nth-child(odd) {
  background-color: #c4c4c4;
}

.table6_2 tr:nth-child(even) {
  background-color: #ffffff;
}

/*custom css */
table {
  width: 700px;
  margin-left: 20%;
}

#maintitle {
  text-align: center;
}
</style>

