<template xmlns="http://www.w3.org/1999/html">
  <div>
    <section id="p_details" class="m_details roomy-50 fix">
      <div class="container">
        <div class="row">
          <div class="col-md-12 ">
            <h1>예약</h1>
            <hr>
            <nav>
              <div class="nav nav-tabs nav-fill col-md-12" id="nav-tab" role="tablist">
                <a class="nav-item nav-link active show" id="nav-program-tab" data-toggle="tab"
                   href="#nav-program" role="tab" aria-controls="nav-program" aria-selected="true">프로그램
                  정보</a>
                <a class="nav-item nav-link" id="nav-schedule-tab" data-toggle="tab"
                   href="#nav-schedule" role="tab" aria-controls="nav-schedule"
                   aria-selected="false" @click="chooseSchedule">일정 선택</a>
                <a class="nav-item nav-link" id="nav-seats-tab" data-toggle="tab" href="#nav-seats"
                   role="tab" aria-controls="nav-seats" aria-selected="false">좌석 선택</a>
              </div>
            </nav>
            <div class="tab-content py-3 px-3 px-sm-0 col-md-12" id="nav-tabContent">
              <div class="tab-pane fade active in" id="nav-program" role="tabpanel"
                   aria-labelledby="nav-program-tab">
                <div class="col-md-5">
                  <div class="m_details_img">
                    <img :src="performData.fileUrlMi" alt="" style="width: 300px"/>
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="m_details_content m-bottom-20">
                    <h2>{{ performData.title }}</h2>
                  </div>
                  <hr/>
                  <div class="person_details m-top-20">
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
                        <p
                          v-if="JSON.stringify(performData.startDate)!==JSON.stringify(performData.endDate)">
                          {{ performData.startDate | yyyyMMdd }} ({{ performData.dayOfStartDate }})
                          -
                          {{ performData.endDate | yyyyMMdd }} ({{ performData.dayOfEndDate }})</p>
                        <p v-else>{{ performData.startDate | yyyyMMdd }}
                          ({{ performData.dayOfStartDate }})</p>
                        <p>{{ performData.placeName }}</p>
                        <p>{{ performData.playTime }}</p>
                        <p>{{ performData.audienceAge }}</p>
                        <p>{{ performData.ticketInfo }}</p>
                        <p>{{ performData.inquiryPhone }}</p>
                      </div>
                    </div>
                  </div>
                  <hr>
                  <button type="button" class="col-md-3 btn btn-default col-md-offset-8"
                          href="#nav-schedule" @click="chooseSchedule">일정 선택
                  </button>
                </div>

              </div>
              <div class="tab-pane fade" id="nav-schedule" role="tabpanel"
                   aria-labelledby="nav-schedule-tab">
                <div class="table-responsive">
                  <table class="table table-striped table-bordered">
                    <tr>
                      <th scope="col" class="text-center col-md-3">날짜</th>
                      <th scope="col" class="text-center col-md-3">회차</th>
                      <th scope="col" class="text-center col-md-3">시간</th>
                      <th scope="col" class="text-center col-md-1">남은 좌석</th>
                    </tr>
                    <tbody>
                    <tr v-for="(scheduleData, index) in scheduleList.dtoList" :key="index" @click="findSeats">
                      <input type="hidden" name="scheduleCode" value="scheduleData.scheduleCode">
                      <td class="text-center">{{ scheduleData.scheduleDate| yyyyMMdd }}</td>
                      <td class="text-center">{{ index % 2 + 1 }} 회차</td>
                      <td class="text-center">{{ scheduleData.scheduleTime| hhMM }}</td>
                      <td class="text-center"></td>
                    </tr>
                    </tbody>
                  </table>
                </div>
                <div class="grid models text-center" id="pagination-margin">
                  <ul class="pagination h-100 justify-content-center align-items-center">

                    <li class="page-item " v-if="scheduleList.prev">
                      <a class="page-link" @click="setPage(scheduleList.start-1)" tabindex="-1"
                         style="cursor:pointer;">Previous</a>
                    </li>

                    <li class="page-item" :class=" (scheduleList.page === page)? 'active' : '' "
                        v-for="page in scheduleList.pageList">
                      <a class="page-link" @click="setPage(page)" style="cursor:pointer;">
                        {{ page }}
                      </a>
                    </li>
                    <li class="page-item" v-if="scheduleList.next">
                      <a class="page-link"
                         @click="setPage(scheduleList.end+1)" style="cursor:pointer;">Next</a>
                    </li>

                  </ul>
                </div>
                <div style="clear: both;"></div>

              </div>
              <div class="tab-pane fade" id="nav-seats" role="tabpanel"
                   aria-labelledby="nav-seats-tab">
                좌석 선택
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
  name: "seat",
  data() {
    return {
      page: 1,
      resultList: [],
      performData: {},
      scheduleList: {
        dtoList: [],
        totalPage: 12,
        size: 12,
        start: 1,
        end: 10,
        prev: false,
        next: true,
        pageList: []
      }
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
    },
    hhMM: function (value) {
      if (value === '') {
        return '';
      }

      let hour = value[0];
      let minute = value[1];

      if (hour < 10) {
        hour = '0' + hour;
      }
      if (minute < 10) {
        minute = '0' + minute;
      }

      return hour + '시 ' + minute + '분';
    },
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
    chooseSchedule: function () {
      $('a[href="#nav-schedule"]').tab('show');
      axios({
        url: '/api/reservation/schedule',
        params: {
          performCode: this.$route.query.performCode,
          page: this.page,
        },
        method: 'get',
      }).then(response => {
        this.scheduleList = response.data
      })

    },
    setPage: function (value) {
      this.page = value;
    },
  },
  watch: {
    page: function () {
      this.chooseSchedule();

    }
  }
}
</script>

<style lang="css" scoped>
@import "../../assets/css/calendar-style.css";

.nav {
  display: flex;
  flex-wrap: wrap;
  padding-left: 0;
  margin-bottom: 0;
}

nav > .nav.nav-tabs {

  border: none;
  color: #fff;
  background: #272e38;
  border-radius: 0;

}

nav > div a.nav-item.nav-link,
nav > div a.nav-item.nav-link.active {
  border: none;
  padding: 18px 25px;
  color: #fff;
  background: #272e38;
  border-radius: 0;
}

nav > div a.nav-item.nav-link.active:after {
  content: "";
  position: relative;
  bottom: -60px;
  left: -10%;
  border: 15px solid transparent;
  border-top-color: #ee997b;
}

.tab-content {
  background: #fdfdfd;
  line-height: 25px;
  border: 1px solid #ddd;
  border-top: 5px solid #ee997b;
  border-bottom: 5px solid #ee997b;
  padding: 50px;
}

nav > div a.nav-item.nav-link:hover,
nav > div a.nav-item.nav-link:focus {
  border: none;
  background: #ee997b;
  color: #fff;
  border-radius: 0;
  transition: background 0.20s linear;
}

.nav-fill .nav-item {
  -ms-flex: 1 1 auto;
  flex: 1 1 auto;
  text-align: center
}
</style>
