<template>
  <div>
    <div id="centerColumn">
      <h2>공지사항</h2>
      <form>
        <select name="language">
          <option value="none">=== 전체 ===</option>
          <option value="idxNum">번호</option>
          <option value="title">제목</option>
          <option value="nregDate">등록일자</option>
          <option value="noAndTitle">번호+제목</option>
        </select>
        <input type="search"> 검색 아이콘 추가
      </form>
      <table border="1">
        <tr>
          <th>번호</th>
          <th>제목</th>
          <th>등록일(최종수정일)</th>
          <th>조회수</th>
        </tr>
        <tr v-for="(result,index) in resultList" :key="index">
          <td>{{result.noticeIdx}}</td>
          <td>{{result.noticeTitle}}</td>
          <td>{{result.modDate | yyyyMMdd}}</td>
          <td>{{result.readCount}}</td>
        </tr>
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

      </table>
    </div>
  </div>
</template>

<script>

import axios from "axios";

export default {
  name: "noticeList",
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
        url: '/api/notice/noticeList',
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
        name: "noticeList",
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
  text-align: right;
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
</style>
