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
            <th style="text-align: right; padding-right: 5px">최종 수정일</th>
            <td style="text-align: right; padding-right: 5px">{{
                eventData.modDate | yyyyMMdd
              }}
            </td>
          </tr>
          <tr>
            <th>내용</th>
            <td colspan="3" style="height: 250px">{{ eventData.eventContent }}</td>
          </tr>
          <tr>
            <th style="width: 100px">작성자</th>
            <td colspan="3">{{ eventData.adminId }}</td>
          </tr>
        </table>
      </form>
    </div>
    <div>
      <div class="btnWrap">
        <a @click="reservation" class="btn">목록</a>
      </div>
    </div>
    <div class="comments-area" style="position: center; justify-content: center; text-align: center">
      <div class="contact-form blog-single-form" >
        <h3>댓글이벤트 참여</h3>
        <div class="rplyform" >
          <form class="replySt" >
            <div class="" >
              <div class="col-sm-6 col-xs-12" >
                <input type="text" class="form-control" id="firstname" placeholder="id"
                       name="firstname"><br>
              </div><!--/.col-->
            </div><!--/.row-->
            <div class="row" style="max-width: 1000px">
              <div class="col-sm-12">
                    <textarea class="form-control" rows="5" id="comment"
                              placeholder="댓글입력" style="width: 50%; height: 50%"></textarea><br>
              </div><!--/.col-->
            </div><!--/.row-->
            <div class="row">
              <div class="col-sm-12">
                <div class="single-contact-btn">
                  <button class="contact-btn" href="#" role="button">댓글 등록</button>
                  <br>
                </div><!--/.single-single-contact-btn-->
              </div><!--/.col-->
            </div><!--/.row-->
          </form><!--/form-->
        </div><!--/.contact-form-->
        <div style="padding-top: 15px">
          <ol class="comment-list" style="justify-content: center">
            <li class="comment"><img src="" alt="사람이미지"/></li>
            <li>ID</li>
            <li><span>당첨돼서 연극보고싶어요!</span></li>
            <li><span>댓글등록일자</span></li>
          </ol>
        </div>
      </div>
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
h2 {
  font-size: 30px;
  padding: 10px;
}

* {
  margin: 0.1rem;
  padding: 0.1rem;
  font-size: 20px;
}

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
  list-style: none
}

.form-group {
  text-align: center;
}

.comments-area {
  text-align: center;
  justify-content: center;
}

rplyform {
  text-align: center;
  justify-content: center;
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
