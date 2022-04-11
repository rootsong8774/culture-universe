<template>
  <div class="eventTableSt">

    <h2>진행중인 이벤트</h2>

    <div class="AddWrap">
      <form class="form">
        <table class="tbAdd">
          <colgroup>
            <col width="15%"/>
            <col width="*"/>
          </colgroup>
          <tr>
            <th>제목</th>
            <td>{{ eventData.eventTitle }}</td>
            <th>최종 수정일</th>
            <td>{{ eventData.modDate | yyyyMMdd }}</td>
          </tr>
          <tr>
            <th>내용</th>
            <td>{{ eventData.eventContent }}</td>
            <td class="txt_cont" v-html="cont"></td>
          </tr>
          <tr>
            <th>작성자</th>
            <td>{{ eventData.adminId }}</td>
            <td></td><td></td><td></td>
          </tr>
        </table>
      </form>
    </div>
    <div>
      <div class="btnWrap">
        <a @click="reservation" class="btn">목록</a>
      </div>
    </div>
    <div class="comments-area">
      <div class="contact-form blog-single-form">
        <h3>댓글이벤트 참여</h3>
        <form class="replySt">
          <div class="row">
            <div class="col-sm-6 col-xs-12">
              <div class="form-group">
                <span>
                <input type="text" class="form-control" id="firstname" placeholder="id"
                       name="firstname">
                  </span>
              </div><!--/.form-group-->
            </div><!--/.col-->
          </div><!--/.row-->
          <div class="row">
            <div class="col-sm-12">
              <div class="form-group">
                    <textarea class="form-control" rows="5" id="comment"
                              placeholder="댓글입력" style="width: 50%; height: 50%"></textarea>
              </div><!--/.form-group-->
            </div><!--/.col-->
          </div><!--/.row-->
          <div class="row">
            <div class="col-sm-12">
              <div class="single-contact-btn">
                <button class="contact-btn" href="#" role="button">댓글 등록</button>
              </div><!--/.single-single-contact-btn-->
            </div><!--/.col-->
          </div><!--/.row-->
        </form><!--/form-->
      </div><!--/.contact-form-->
      <ol class="comment-list">
        <li class="comment"><img src="" alt="사람이미지"/></li>
        <li>ID</li>
        <li><p>당첨돼서 연극보고싶어요!</p></li>
        <li><span>댓글등록일자</span></li>
      </ol>
    </div><!--/.comments-area-->
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "eventInProgressDetails",
  data() {
    return {
      eventData: {}
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
        url: '/api/event/eventInProgressDetails',
        params: {
          eventIdx: this.$route.query.eventIdx,
        },
        method: 'get',
      }).then(response => {
        this.eventData = response.data

      })
    },
    reservation: function () {
      this.$router.push({name: 'eventInProgress'})
    },
  },
}
</script>
<style scoped>
.eventTableSt {
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
.comment-list {
  display: flex;
}
.comment-list > li {
  padding-left: 50px;
  list-style:none
}
.form-group{
  text-align: center;
}
.comments-area{
  text-align: center;
}
.form-control {
  resize: none; /* 사용자 임의 변경 불가 */
  resize: both; /* 사용자 변경이 모두 가능 */
  resize: horizontal; /* 좌우만 가능 */
  resize: none; /* 상하만 가능 */
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
