<template>
  <div class = "winnerBoardStyle">

    <h2>당첨자 발표</h2>
    <div class="AddWrap">
      <form class="form">
        <table class="tbAdd">
          <colgroup>
            <col width="15%" />
            <col width="*" />
          </colgroup>
          <tr>
            <th>제목</th>
            <td>{{winnerData.winTitle}}</td>
            <th style="text-align: right; padding-right: 5px">최종 수정일</th>
            <td style="text-align: right; padding-right: 5px">{{winnerData.modDate | yyyyMMdd}}</td>
          </tr>
          <tr>
            <th>내용</th>
            <td colspan="3" style="height: 250px">{{winnerData.winContent}}</td>
          </tr>
          <tr>
            <th>작성자</th>
            <td colspan="3">{{winnerData.adminId}}</td>
          </tr>
        </table>
      </form>
    </div>
    <div class="btn-list_w">
      <br>
      <button class="btn-list" @click="reservation"><span>목록</span></button>
    </div>
  </div>
</template>
<script>
import axios from "axios";

export default {
  name: "winnerDetails",
  data() {
    return {
      winnerData: {}
    }
  }
  /*  props: {
      performCode: {
        type: String,
        default: ''
      }
    }*/
  ,
  created() {
    this.getDetails();
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
        url: '/api/event/winnerDetails',
        params: {
          winnerIdx: this.$route.query.winnerIdx,
        },
        method: 'get',
      }).then(response => {
        this.winnerData = response.data

      })
    },
    reservation: function () {
      this.$router.push({name: 'eventWinner'})
    },
  },
}
</script>
<style scoped>
h2{
  font-size: 30px;
  padding: 10px;
}
*{
  font-size: 20px;
}
.winnerBoardStyle {
  padding: 50px;
  text-align: center;
}

table {
  margin-left: auto;
  margin-right: auto;
}

table, td, th {
  border-collapse: collapse;
}
.comment-list > li {
  padding-left: 50px;
  list-style:none
}
.tbAdd {
  border-top: 1px solid #888;
}

.tbAdd th, .tbAdd td {
  border-bottom: 1px solid #eee;
  padding: 5px 0;
}

.tbAdd td {
  padding: 10px 10px;
  box-sizing: border-box;
  text-align: left;
}

.tbAdd td.txt_cont {
  height: 300px;
  width: 250px;
  vertical-align: top;
}

.btnWrap {
  text-align: center;
  margin: 20px 0 0 0;
}

.btnWrap a {
  margin: 0 10px;
}
</style>
