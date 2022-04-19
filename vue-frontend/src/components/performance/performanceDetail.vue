<template>
  <div>
    <section id="p_details_info" class="m_details roomy-100 fix">
      <div class="container">
        <div >
          <div class="main_details">
            <div class="col-md-5">
              <div class="m_details_img">
                <img :src="performData.fileUrlMi" alt="" style="width: 350px"/>
              </div>
            </div>
            <div class="col-md-7">
              <div class="m_details_content m-bottom-40">
                <h2>{{ performData.title }}</h2>
              </div>
              <hr/>
              <div class="person_details m-top-40">
                <div class="row">
                  <div class="col-md-2 text-left col-md-offset-1">
                    <p>기간</p>
                    <p>장소</p>
<!--                    <p>시간</p>-->
<!--                    <p>연령</p>-->
<!--                    <p>티켓</p>-->
                    <p>문의</p>
                  </div>
                  <div class="col-md-8 text-left">
                    <p v-if="JSON.stringify(performData.startDate)!==JSON.stringify(performData.endDate)">
                      {{ performData.startDate | yyyyMMdd }} ({{ performData.dayOfStartDate }}) -
                      {{ performData.endDate | yyyyMMdd }} ({{ performData.dayOfEndDate }})</p>
                    <p v-else>{{ performData.startDate | yyyyMMdd }} ({{ performData.dayOfStartDate }})</p>
                    <p>{{ performData.placeName }}</p>
<!--                    <p>{{ performData.playTime }}</p>-->
<!--                    <p>{{ performData.audienceAge }}</p>-->
<!--                    <p>{{ performData.ticketInfo }}</p>-->
                    <p>{{ performData.inquiryPhone }}</p>
                  </div>
                </div>
                <hr>

                <div class="m-top-20">
                  <div class="row">
                    <button type="button" class="col-md-offset-1 col-md-3 btn btn-default">⭐ 관심공연</button>
                    <button type="button" class="col-md-offset-1 col-md-3 btn btn-primary" @click="reservation">예매하기</button>
                  </div>
                </div>
              </div>


            </div>
          </div>
        </div>
      </div>
    </section>


    <section id="p_details" class="m_details roomy-50 fix">
      <div class="container">
        <div class="row">
          <div class="col-md-12 ">
            <nav>
              <div class="nav nav-tabs nav-fill" id="nav-tab" role="tablist">
                <a class="nav-item nav-link" id="nav-program-tab" data-toggle="tab" href="#nav-program" role="tab" aria-controls="nav-program" aria-selected="true">작품소개</a>
                <a class="nav-item nav-link" id="nav-schedule-tab" data-toggle="tab"  href="#nav-schedule" role="tab" aria-controls="nav-schedule" aria-selected="false">취소 및 환불안내</a>
                <a class="nav-item nav-link" id="nav-seats-tab" data-toggle="tab" href="#nav-seats" role="tab" aria-controls="nav-seats" aria-selected="false">후기</a>
              </div>
            </nav>
            <div class="tab-content py-3 px-3 px-sm-0" id="nav-tabContent">
              <div class="tab-pane fade active in" id="nav-program" role="tabpanel" aria-labelledby="nav-program-tab">
                <div v-if="performData.detail" v-html="performData.detail"></div>
                <div v-else-if="performData.info" v-html="performData.info"></div>
                <p v-else>{{ noInfo }}</p>
              </div>
              <div class="tab-pane fade" id="nav-schedule" role="tabpanel" aria-labelledby="nav-schedule-tab">
                <p>예매 안내</p>
              </div>
              <div class="tab-pane fade" id="nav-seats" role="tabpanel" aria-labelledby="nav-seats-tab">
                  <p>후기</p>
              </div>
            </div>
          </div>
        </div>
      </div>

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
  },
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
      this.$router.push({name: 'performanceReservation', query: {performCode: this.performData.performCode}})
    },
  },
}
</script>

<style scoped>

.nav {
  display: flex;
  flex-wrap: wrap;
  padding-left: 0;
  margin-bottom: 0;
}
nav > .nav.nav-tabs{

  border: none;
  color:#fff;
  background:#272e38;
  border-radius:0;

}

.tab-content{
  background: #fdfdfd;
  line-height: 25px;
  border: 1px solid #ddd;
  border-top:5px solid #ee997b;
  border-bottom:5px solid #ee997b;
  padding:30px 25px;
}

nav > div a.nav-item.nav-link,
nav > div a.nav-item.nav-link.active {
  border: none;
  padding: 18px 25px;
  color: #fff;
  background: #272e38;
  border-radius: 0;
}

nav > div a.nav-item.nav-link:hover,
nav > div a.nav-item.nav-link:focus
{
  border: none;
  background: #ee997b;
  color:#fff;
  border-radius:0;
  transition:background 0.20s linear;
}
.nav-fill .nav-item {
  -ms-flex:1 1 auto;
  flex:1 1 auto;
  text-align:center
}
</style>
