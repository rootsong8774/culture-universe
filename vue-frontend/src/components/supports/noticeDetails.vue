<template>
  <div class="noticeBoardSt">
    <h2>공지 내용</h2>
    <br>
    <div class="AddWrap">
      <form class="form">
        <table class="tbAdd">
          <colgroup>
            <col width="15%" />
            <col width="*" />
          </colgroup>
          <tr>
            <th>제목</th>
            <td>{{noticeData.noticeTitle}}</td>
            <th style="text-align: right; padding-right: 5px">최종 수정일</th>
            <td style="text-align: right; padding-right: 5px">{{noticeData.modDate | yyyyMMdd}}</td>
          </tr>
          <tr>
            <th>내용</th>
            <td colspan="3" style="height: 250px">{{noticeData.noticeContent}}</td>
          </tr>
          <tr>
            <th style="width: 100px">작성자</th>
            <td colspan="3">{{noticeData.adminId}}</td>
          </tr>
        </table>
      </form>
    </div>
  <br>
    <div class="prev_next">
      <dl class="prev">
        <dt><a @click="setList" style="cursor: pointer">이전글</a></dt>
      </dl>
      <dl class="next">
        <dt><span>다음글</span></dt>
      </dl>
    </div>

    <div class="btn-list_w">
      <button class="btn-list" @click="reservation"><span>목록</span></button>
    </div>
  </div>
</template>
<script>
import axios from "axios";

export default {
  name: "noticeDetails",
  data() {
    return {

      noticeData: {}
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
        url: '/api/notice/noticeDetails',
        params: {
          noticeIdx: this.$route.query.noticeIdx,
        },
        method: 'get',
      }).then(response => {
        this.noticeData = response.data
      })
    },
    reservation: function () {
      this.$router.push({name: 'notice'})
    },
    setList:function (value){
      this.list = value-1;
    }
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
.noticeBoardSt {
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
