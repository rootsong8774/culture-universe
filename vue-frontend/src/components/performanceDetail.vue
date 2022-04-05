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
            <div class="col-md-7">
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
                  <div class="col-md-10 text-left">
                    <p> {{ performData.startDate | yyyyMMdd }} ({{ performData.dayOfStartDate }}) -
                      {{ performData.endDate | yyyyMMdd }} ({{ performData.dayOfEndDate }})</p>
                    <p>{{ performData.placeName }}</p>
                    <p>{{ performData.playTime }}</p>
                    <p>{{ performData.audienceAge }}</p>
                    <p>{{ performData.ticketInfo }}</p>
                    <p>{{ performData.inquiryPhone }}</p>
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
                <li><a href="#reservation" data-toggle="tab">예매안내</a></li>
                <li><a href="#comment" data-toggle="tab">후기평</a></li>
              </ul>
            </div>
            <!-- Tab이 선택되면 내용이 보여지는 영역이다. -->
            <div class="tab-content">
              <div class="tab-pane fade in active" id="introduce">
                <div v-html="performData.detail"></div>
                <div class="tab-pane fade" id="reservation">예매안내</div>
                <div class="tab-pane fade" id="comment">후기평</div>
              </div>
            </div>
          </div>
        </div>
      </div>>
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
      performCode: 'smpk2202111723a01',
      performData: {}
    }
  }
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
          performCode: this.performCode,
        },
        method: 'get',
      }).then(response => {
        this.performData = response.data

      })
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
</style>
