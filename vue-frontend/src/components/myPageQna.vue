<template>
  <div>
  <div>

    <div id="leftColumn">
      <h2>마이페이지</h2>
      <ul>
        <h3>예매/취소내역</h3>
        <li><a href="#">예매내역</a></li>
        <li><a href="#">예매 취소내역</a></li>
      </ul>
      <ul>
        <h3>문의 내역</h3>
        <li>
          <router-link :to="{name:'myPageQna'}">나의 문의내역</router-link>
        </li>
<!--        <li><a href="#">문의내역</a></li>-->
      </ul>
    </div>
    <!--//end #leftColumn//-->
    <h3 id="maintitle">나의 문의내역 </h3>
    <div>
      <div>
        <table class=table6_2>
          <tr>
            <th>문의번호</th>
            <th>문의유형</th>
            <th>문의내용</th>
            <th>문의등록일</th>
            <th>문의답변</th>
          </tr>
          <tr class="result-date"  v-for="(result,index) in resultList" :key="index">
            <td>
              <router-link
              :to="{name: 'myPageQnaDetails',query:{questionIdx: result.questionIdx}}">
              {{ result.questionIdx }}
                </router-link>
            </td>
            <td>{{ result.type }}</td>
            <td>{{ result.content }}</td>
            <td>{{ result.regDate  | yyyyMMdd }}</td>
            <td>{{ result.commentCount }}</td>
          </tr>
        </table>
      </div>
<!--     페이지 처리-->
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
  <div style="clear: both;"></div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "myPageQna",
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
    this.getList(); //methods fc받음
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
        url: '/api/qna/list',
        params: {
          page: this.page
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
        name: "myPageQna",
        query: {page: this.page},
      })
    }
  }
}
</script>

<style scoped>
#leftColumn {
  float: left;
  margin: 0;
  padding: 0;
  width: 160px;
  font-size: .9em;
}

#leftColumn p {
  padding: 10px
}


#leftColumn h2 {
  margin: 0;
  padding: 10px 0 0 10px;
  font-size: 1em;
}

#leftColumn ul {
  margin: 0 0 0 0;
  list-style: none;
}

#leftColumn li {
  margin: 4px 0 5px 10px;
}

#leftColumn li a {
  text-decoration: underline;
}

#leftColumn li a:hover {
  text-decoration: none;
}
div, span,
h1, h2, h3, h4, h5, h6, p, blockquote,
a, em, q, s, strong, sub, sup, tt, var,
ul, li, form, label, legend, tbody, tfoot, thead,
caption { /*table, tr, th, td*/
  margin-left: 20px;
  padding: 0;
  border: 0;
  outline: 0;
  font-weight: inherit;
  font-style: inherit;
  font-size: 100%;
  font-family: inherit;
  vertical-align: baseline;
}

table {
  border-collapse: collapse;
  border-spacing: 0;
}

caption, th, td {
  text-align: left;
  font-weight: normal;
}

blockquote:before, blockquote:after,
q:before, q:after {
  content: "";
}

blockquote, q {
  quotes: "" "";
}

a {
  color: #cc0000;
  text-decoration: underline;
}

a:hover {
  color: #cccccc;
  text-decoration: none;
}

ul {
  margin: 0 0 0 20px;
  list-style-type: disc;
}

li {
  margin: 4px 0 5px 10px;
}

blockquote {
  margin: 1em;
  padding: .5em;
  background-color: #eeeeee;
  border-top: 1px solid #cccccc;
  border-bottom: 1px solid #cccccc;
}

blockquote p {
  margin: .2em;
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

.table6_2 th, .table6_2 td {
  border: 1px solid #202020;
  border-width: 1px 0 1px 0
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
/*custom css */
table{
  width: 700px;
  margin: auto;
}
#maintitle{
  text-align: center;
}
</style>

