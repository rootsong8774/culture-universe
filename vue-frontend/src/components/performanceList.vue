<template>
  <div>
    <!--About Sections-->
    <section id="gallery" class="gallery margin-top-120 bg-white">
      <div class="schedule_w item5">
        <ul class="clearfix">
          <li class="item s1" tabindex="0">
            <div class="date_select">
              <input type="date" name="sdate"> ~
              <input type="date" name="edate">
            </div>
          </li>
          <li class="item s2" tabindex="0">
            <div class="dropdown">
              <button class="dropbtn">
                <span class="dropbtn_icon">장르</span>
              </button>
              <div class="dropdown-content">
                <a href="#">기타공연</a>
                <a href="#">오케스트라</a>
                <a href="#">클래식</a>
                <a href="#">뮤지컬</a>
                <a href="#">국악</a>
                <a href="#">오페라</a>
                <a href="#">공연</a>
              </div>
            </div>
          </li>
          <li class="item s2" tabindex="0">
            <div class="dropdown">
              <button class="dropbtn">
                <span class="dropbtn_icon">장소</span>
              </button>
              <div class="dropdown-content">
                <a href="#">전체</a>
                <a href="#">세종M씨어터</a>
                <a href="#">세종S씨어터</a>
                <a href="#">세종체임버홀</a>
                <a href="#">야외공연</a>
                <a href="#">삼청각</a>
                <a href="#">꿈의숲 콘서트홀</a>
              </div>
            </div>
          </li>
          <li class="item s3" tabindex="0">
            <div class="searchArea">
              <form action="">
                <input type="search" placeholder="검색"><span>?</span>
              </form>
            </div>
          </li>
        </ul>
      </div>

      <div class="container">
        <div class="row">
          <div class="main-gallery main-model roomy-80">
            <div style="clear: both;"></div>
            <div class="grid models text-center">
              <div class="grid-item model-item transition metal ium"
                   v-for="(result,index) in resultList" :key="index">
                <img :src="result.fileUrlMi" :alt="result.title">
                <input type="hidden" name="performCode" v-model:value="result.performCode">
                <strong class="result-title">{{ result.title }}</strong>

                <span class="result-date"
                      v-if="JSON.stringify(result.startDate)!==JSON.stringify(result.endDate)">
                      {{ result.startDate | yyyyMMdd }} -
                      {{ result.endDate | yyyyMMdd }} </span>
                <span class="result-date" v-else>{{
                    result.startDate | yyyyMMdd
                  }}</span>

                <p class="result-genre">{{ result.genreName }}</p>
                <router-link
                  :to="{name: 'performanceDetail', params: {performCode: result.performCode}}"
                  class="btn btn-default m-top-20">
                  View Details <i class="fa fa-long-arrow-right"></i>
                </router-link>
              </div><!-- End off grid item -->

            </div>
            <div class="grid models text-center" id="pagination-margin">
              <ul class="pagination h-100 justify-content-center align-items-center">

                <li class="page-item " v-if="pageData.prev">
                  <a class="page-link" @click="setPage(pageData.start-1)" tabindex="-1"
                     style="cursor:pointer;">Previous</a>
                </li>

                <li class="page-item" :class=" (pageData.page === page)? 'active' : '' "
                    v-for="page in pageData.pageList">
                  <a class="page-link" @click="setPage(page)" style="cursor:pointer;">
                    {{ page }}
                  </a>
                </li>
                <li class="page-item" v-if="pageData.next">
                  <a class="page-link"
                     @click="setPage(pageData.end+1)" style="cursor:pointer;">Next</a>
                </li>

              </ul>
            </div>
            <div style="clear: both;"></div>
          </div>

        </div>


      </div>


    </section>
  </div>
</template>

<script>

import axios from "axios";

export default {
  name: "PerformanceList",
  data() {
    return {
      page: 1,
      resultList: [],
      pageData: {
        dtoList: [],
        totalPage: 13,
        size: 12,
        start: 1,
        end: 10,
        prev: false,
        next: true,
        pageList: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
      }
    }
  },
  created() {
    this.getList();
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
    getList: function () {
      axios({
        url: '/api/performancesList',
        params: {
          page: this.page,
        },
        method: 'get',
      }).then(response => {
        let jsonData = response.data;
        this.resultList = jsonData.dtoList;
        this.pageData = jsonData;
        console.log(jsonData);

      })
    },
    setPage: function (value) {
      this.page = value;
    },

  },
  watch: {
    page: function () {
      this.getList();
    }
  }

}
</script>

<style scoped>
.result-title {
  display: block;
  color: black;
  height: 2.8em;
  margin: 1em 0 0.8em 0;
  line-height: 1.35;
  font-size: 1.125em;
  font-weight: 700;
  overflow: hidden;
  text-align: left;
}

.result-date {
  float: left;
}

.result-genre {
  float: right;
}

.content_page > a {
  padding: 5px;
}

.clearfix {
  padding: 30px;
}

.schedule_w .item {
  padding: 0 10px 0 10px;
  position: relative;
}

.schedule_w .item {
  float: left;
  width: 25%;
  position: relative;
}

.date_select {
  justify-content: center;
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
  z-index: 1;
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
.searchArea {
  display: flex;
  width: 220px;
  height: 40px;
  border: 1px solid rgb(102, 103, 171);
  background-color: rgba(0, 0, 0, 0.2);
  border-radius: 5px;


}

.searchArea > form > input {
  border: 0;
  outline: none;
  background-color: rgba(0, 0, 0, 0.2);
  width: 220px;
  height: 40px;
  color: #fff;
  padding-left: 10px;
  border-radius: 5px;
}

.searchArea > form > input:focus {
  outline: 2px solid black;
  border-radius: 5px;
}

.searchArea > form > span {
  width: 20px;
  color: rgba(0, 0, 0, 0);
  background-repeat: no-repeat;
  background-position: center;
  font-weight: bold;
  cursor: pointer;
}


.nav1 > li {
  padding: 10px;
  justify-items: center;
  margin-left: 50px;
  font-weight: bold;
}

.nav1 > li > a {
  color: #fff;
}

#pagination-margin {
  margin-top: 40px;
}
</style>
