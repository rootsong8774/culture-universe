<template>
  <div>
    <div id="table">
      <div id="centerColumn">
        <br>
        <h2>이벤트 당첨자 현황</h2>
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
            <td>{{ result.winnerIdx }}</td>
            <td>{{ result.winTitle }}</td>
            <td>{{ result.modDate | yyyyMMdd }}</td>
            <td>{{ result.readCount }}</td>
          </tr>
        </table>
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
  </div>
</template>
<script>

import axios from "axios";

export default {
  name: "winnerList",
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
        url: '/api/event/winnerList',
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
        name: "eventWinner",
        query: {page: this.page},
      })
    }
  }

}
</script>
<style>
div {
  margin: 0;
}

h2 {
  text-align: center
}

form {
  padding: 10px;
  margin: 10px;
  text-align: center;
  display: flex;
}

table {
  margin-left: auto;
  margin-right: auto;
}

table, td, th {
  border-collapse: collapse;
  border: 1px solid black;
  font-size: larger;
}
.searchArea{
  margin: 5px;
  display: flex;
  width: 300px;
  height: 40px;
  border:1px solid rgb(102, 103, 171);
  background-color: rgba(238, 153, 123, 0.5);
  padding-left: 5px;
  border-radius: 5px;
  margin-top: 24px;

}
.searchArea > form >input{
  border: 0;
  outline: none;
  background-color: rgba(235, 150, 120, 0.2);
  width: 250px;
  height: 40px;
  color: #fff;
  padding-left: 10px;
}
.searchArea > form > input:focus{
  outline: 2px solid white;
  border-radius: 5px;
}

li {
  display: inline-block;
  margin: 0 10px;
}
.searchArea > form >span{
  width: 50px;
  color: rgba(0, 0, 0, 0);
  background-repeat: no-repeat;
  background-position: center;
  font-weight: bold;
  cursor: pointer;
}
</style>
