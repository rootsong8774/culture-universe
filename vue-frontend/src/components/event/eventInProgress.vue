<template>
  <div>
    <div id="table">
      <div id="centerColumn">
        <br>
        <h2>진행 이벤트</h2>
        <form class="eventTitle">


          <select name="language">
            <option value="none">=== 전체 ===</option>
            <option value="winNum">번호</option>
            <option value="title">제목</option>
            <option value="wregDate">등록일자</option>
            <option value="noAndTitle">번호+제목</option>
          </select>

          <input type="search" placeholder="검색">


        </form>
        <table border="1">
          <tr>
            <th>번호</th>
            <th>제목</th>
            <th>등록일(최종수정일)</th>
            <th>조회수</th>
          </tr>
          <tr v-for="(result,index) in resultList" :key="index">
            <td>{{ result.eventIdx }}</td>
            <td>{{ result.eventTitle }}</td>
            <td>{{ result.modDate | yyyyMMdd }}</td>
            <td>{{ result.readCount }}</td>
          </tr>
        </table>
      </div>
    </div>
          <div class="pagination-part text-center">
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
          </div><!--/.pagination-part(&raquo;)-->
        </div><!--/.container-->
</template>

<script>
import axios from "axios";

export default {

  name: "eventList",
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
        url: '/api/event/eventList',
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
      this.$router.push({
        name: "event",
        query: {page: this.page},
      })
    }
  }

}
</script>
<style scoped>
.news {
  padding: 114px 0 95px;
}

.news-card {
  margin-top: 70px;
}

.news-card-pb-25 {
  padding-bottom: 25px;
}

/*single-news-box*/
.single-news-box {
  box-shadow: 0 5px 30px 0px rgba(115, 112, 215, .2);
  min-height: 504px;
  margin-bottom: 13px;
  -webkit-transition: .5s;
  -moz-transition: .5s;
  -ms-transition: .5s;
  -o-transition: .5s;
  transition: .5s;

}

.single-news-box.news-mb-20 {
  margin-bottom: 20px;
}

/*single-news-box*/

/*news-box-bg*/
.news-box-bg {
  position: relative;
  overflow: hidden;
  -webkit-transform: scale(1);
  -moz-transform: scale(1);
  -ms-transform: scale(1);
  -o-transform: scale(1);
  transform: scale(1);
  -webkit-transition: .5s;
  -moz-transition: .5s;
  -ms-transition: .5s;
  -o-transition: .5s;
  transition: .5s;
}

.single-news-box:hover .isotope-overlay {
  -webkit-transform: scaleY(1);
  -moz-transform: scaleY(1);
  -ms-transform: scaleY(1);
  -o-transform: scaleY(1);
  transform: scaleY(1);
  top: 0;
}

/*news-box-bg*/

/*news-box-inner*/
.news-box-inner {
  padding: 30px 0px 30px 20px;
  -webkit-transition: .5s;
  -moz-transition: .5s;
  -ms-transition: .5s;
  -o-transition: .5s;
  transition: .5s;
}

.news-box-inner h3 a {
  color: #4d4e54;
  display: block;
  font-size: 16px;
  margin-bottom: 17px;
  font-family: 'Playfair Display', serif;
  font-style: italic;
  max-width: 350px;
  font-weight: 600;
  line-height: 1.4;
}

.news-box-inner .team-meta {
  display: block;
  color: #4d4e54;
  font-size: 12px;
  font-family: 'Poppins', sans-serif;
}

.news-box-inner span {
  color: #908edf;

}

a.learn-btn,
a:hover.learn-btn,
a:focus.learn-btn,
a:active.learn-btn {
  color: #7086e6;
  font-size: 12px;
  font-family: 'Lato', sans-serif;
  font-weight: 700;
  text-transform: capitalize;
  margin-top: 8px;
  padding-bottom: 18px;
  opacity: 0;
  -webkit-transition: 0.5s ease-in-out;
  -moz-transition: 0.5s ease-in-out;
  -ms-transition: 0.5s ease-in-out;
  -o-transition: 0.5s ease-in-out;
  transition: 0.5s ease-in-out;
}

.single-news-box:hover .news-box-inner {
  background: #f9faff;

}

/*team-box-inner*/
.single-news-box:hover {
  box-shadow: 0 5px 35px 0px rgba(115, 112, 215, .2);
}

.single-news-box:hover .news-box-bg {
  -webkit-transform: scaleY(1.05);
  -moz-transform: scaleY(1.05);
  -ms-transform: scaleY(1.05);
  -o-transform: scaleY(1.05);
  transform: scaleY(1.05);
}

.isotope .item:hover img {
  -webkit-transform: scale(1.5);
  -moz-transform: scale(1.5);
  -ms-transform: scale(1.5);
  -o-transform: scale(1.5);
  transform: scale(1.5);
}

/*.item img*/
</style>
