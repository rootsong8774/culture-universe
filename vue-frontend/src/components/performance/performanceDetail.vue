<template>
  <div>
    <section id="p_details_info" class="m_details roomy-100 fix">
      <div class="container">
        <div class="row">
          <div class="main_details">
            <div class="col-md-5">
              <div class="m_details_img">
                <img :src="performData.fileUrlMi" alt="" style="width: 350px"/>
              </div>
            </div>
            <div class="col-md-6">
              <div class="m_details_content m-bottom-40">
                <h2>{{ performData.title }}</h2>
              </div>
              <hr/>
              <div class="person_details m-top-40">
                <div class="row">
                  <div class="col-md-2 text-left">
                    <p>기간</p>
                    <p>장소</p>
                    <p>시간</p>
                    <p>연령</p>
                    <p>티켓</p>
                    <p>문의</p>
                  </div>
                  <div class="col-md-8 text-left">
                    <p v-if="JSON.stringify(performData.startDate)!==JSON.stringify(performData.endDate)">
                      {{ performData.startDate | yyyyMMdd }} ({{ performData.dayOfStartDate }}) -
                      {{ performData.endDate | yyyyMMdd }} ({{ performData.dayOfEndDate }})</p>
                    <p v-else>{{ performData.startDate | yyyyMMdd }} ({{ performData.dayOfStartDate }})</p>
                    <p>{{ performData.placeName }}</p>
                    <p>{{ performData.playTime }}</p>
                    <p>{{ performData.audienceAge }}</p>
                    <p>{{ performData.ticketInfo }}</p>
                    <p>{{ performData.inquiryPhone }}</p>
                  </div>
                </div>
                <hr>

                <div class="m-top-20">
                  <div class="row">
                    <button type="button" class="col-md-3 btn btn-default">⭐ 관심공연</button>
                    <button type="button" class="col-md-3 btn btn-primary" @click="reservation">예매하기</button>
                  </div>
                </div>
              </div>


            </div>
          </div>
        </div>
      </div>
    </section>
    <section id="p_details" class="m_details roomy-20 fix">
      <div class="container">
        <div class="row">
          <div class="main_details">
            <!--          Tab Start  -->
            <div style="margin:10px;">
              <ul class="nav nav-tabs clearfix li3">
                <li class="active"><a href="#introduce" data-toggle="tab">작품소개</a></li>
                <li><a href="#reservation" data-toggle="tab">취소 및 환불안내</a></li>
                <li><a href="#comment" data-toggle="tab">후기평</a></li>
              </ul>
            </div>
            <!-- Tab이 선택되면 내용이 보여지는 영역이다. -->
            <div class="tab-content">
              <div class="tab-pane fade in active" id="introduce">
                <div class="col-md-10 col-md-offset-1">
                  <div v-if="performData.detail" v-html="performData.detail"></div>
                  <div v-else-if="performData.info" v-html="performData.info"></div>
                  <p v-else>{{ noInfo }}</p>
                </div>
              </div>

              <div class="tab-pane fade" id="reservation">
                <div class="col-md-10 col-md-offset-1">
                  예매 안내
                </div>
              </div>

              <div class="tab-pane fade" id="comment">
                <div class="col-md-10 col-md-offset-1">
                  후기
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      >
    </section>


    <!--Portfolio Section-->
    <section id="content">

    </section>

  </div>
</template>
<script>
import axios from "axios";
export default {
  name: "PerformanceDetail",
  data() {
    return {
      noInfo: '공연 정보가 아직 준비되지 않았습니다.',
      performData: {}
    }
  }/*,
  props: {
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
        url: '/api/performancesDetails',
        params: {
          performCode: this.$route.query.performCode,
        },
        method: 'get',
      }).then(response => {
        this.performData = response.data
      })
    },
    reservation: function () {
      this.$router.push({name: 'performanceReservation'})
    },
  },
}
</script>

<style scoped>
li {
  display: list-item;
  text-align: -webkit-match-parent;
}
.poster {
  justify-content: center;
  padding: 10px;
  margin: 5px;
  display: flex;
}
.dropdown {
  position: relative;
  display: inline-block;
}
.dropbtn_icon {
  font-family: 'Material Icons';
}
.dropbtn {
  border: 1px solid rgb(37, 37, 37);
  border-radius: 4px;
  background-color: #f5f5f5;
  font-weight: 400;
  color: rgb(37, 37, 37);
  padding: 12px;
  width: 200px;
  text-align: left;
  cursor: pointer;
  font-size: 12px;
}
.dropdown-content {
  display: none;
  position: absolute;
  z-index: 1; /*다른 요소들보다 앞에 배치*/
  font-weight: 400;
  background-color: #f9f9f9;
  min-width: 200px;
}
.dropdown-content a {
  display: block;
  text-decoration: none;
  color: rgb(37, 37, 37);
  font-size: 12px;
  padding: 12px 20px;
}
.dropdown-content a:hover {
  background-color: #ececec
}
.dropdown:hover .dropdown-content {
  display: block;
}
/*dropdown -end*/
#introduce {
  padding: 20px 0;
}
</style>
