<template>
  <div>
    <div>
      <div class="container">
        <div class="sub-t">
          <h2 class="t" style="font-size: 2.5rem; margin-block-start: 0.83em; margin-block-end: 0.83em;margin-inline-start: 0.83em;
            margin-inline-end: 0.83em; font-weight: bold;text-align: center; line-height: 1.15; letter-spacing: -0.03em;">
            진행중인 이벤트</h2>
        </div>
        <div>
          <form>
<!--            <ul style="text-align: center">
              <li>
                <select name="language">
                  <option value="none">=== 전체 ===</option>
                  <option value="Num">번호</option>
                  <option value="title">제목</option>
                  <option value="wregDate">등록일자</option>
                  <option value="noAndTitle">번호+제목</option>
                </select>
              </li>
              <li>
                <div class="search">
                  <input type="text" placeholder="검색어 입력">
                </div>
              </li>
            </ul>-->
          </form>
          <br>
          <table class=table6_2>
            <tr>
              <th style="width: 10%">번호</th>
              <th style="width: 18%">제목</th>
              <th style="width: 32%">이벤트 내용</th>
              <th style="width: 30%">등록일(최종수정일)</th>
              <th>조회수</th>
            </tr>
          </table>
          <table class="table table-hover">
            <tbody>
            <tr class="result-date" v-for="(result,index) in resultList" :key="index">
              <td>
                <router-link
                  :to="{name: 'eventInProgressDetails',query:{eventIdx: result.eventIdx}}">
                  {{ result.eventIdx }}
                </router-link>
              </td>
              <td>
                <router-link
                  :to="{name:'eventInProgressDetails', query:{eventIdx: result.eventIdx}}">
                  {{ result.eventTitle }}
                </router-link>
              </td>
              <td>
                <router-link
                  :to="{name:'eventInProgressDetails', query:{eventIdx: result.eventIdx}}">
                  {{ result.eventContent }}
                </router-link>
              </td>
              <td>{{ result.regDate  | yyyyMMdd }}</td>
              <td>{{ result.readCount }}</td>
            </tr>
            </tbody>
          </table>
        </div>
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
  </div>
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
        name: "eventInProgress",
        query: {page: this.page},
      })
    }
  }

}
</script>
<style scoped>
.eventTable {
  text-align: center;
}

table {
  width: 700px;
  margin-left: 20%;
}

.table6_2 table {
  width: 100%;
  margin: 15px auto;
  border: 0;
}

.table6_2 th {
  background-color: #505050;
  color: #FFFFFF
}

.table6_2, .table6_2 th, .table6_2 td {
  font-size: 0.95em;
  text-align: center;
  padding: 4px;
  border-collapse: collapse;
}


.table6_2 tr {
  border: 1px solid #ffffff;
}

.table6_2 tr:nth-child(odd) {
  background-color: #c4c4c4;
}

.table6_2 tr:nth-child(even) {
  background-color: #ffffff;
}

.searchArea > input {
  border: 0;
  outline: none;
  width: 250px;
  height: 38px;
  color: #fff;
}

.searchArea > input:focus {
  outline: 2px solid rgba(238, 153, 123, 0.5);;
  border-radius: 5px;
}

.searchArea > span {
  width: 50px;
  background-image: url(../../assets/images/searchIcon.png);
  color: rgba(0, 0, 0, 0);
  background-repeat: no-repeat;
  background-position: center;
  font-weight: bold;
  cursor: pointer;
}
</style>
