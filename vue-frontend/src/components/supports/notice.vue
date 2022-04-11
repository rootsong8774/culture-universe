<template>
  <div>
    <div id="table">
      <div id="centerColumn">
        <br>
        <h2>공지사항</h2>
        <div>

          <form class="noticeTitle">

                <select name="language">
                  <option value="none">=== 전체 ===</option>
                  <option value="idxNum">번호</option>
                  <option value="title">제목</option>
                  <option value="nregDate">등록일자</option>
                  <option value="noAndTitle">번호+제목</option>
                </select>

                <div class="searchArea">
                  <input type="search"> <span class="fa-search"></span>
                </div>
          </form>
        </div>
        <table border="1">
          <tr>
            <th>번호</th>
            <th>제목</th>
            <th>등록일(최종수정일)</th>
            <th>조회수</th>
          </tr>
          <tr v-for="(result,index) in resultList" :key="index">
            <td><router-link :to = "{name:'noticeDetails', query:{noticeIdx: result.noticeIdx}}">{{ result.noticeIdx }}</router-link></td>
            <td><router-link :to = "{name:'noticeDetails', query:{noticeIdx: result.noticeIdx}}">{{ result.noticeTitle }}</router-link></td>
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
        name: "notice",
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

.searchArea {
  width: 300px;
  height: 40px;
  border: 1px solid rgb(102, 103, 171);
  background-color: rgba(255 , 255, 255, 0.2);
  border-radius: 5px;

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
