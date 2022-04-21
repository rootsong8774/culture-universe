<template>
  <div>
    <div id="container">
      <div id="leftColumn">
        <h2>
          <router-link :to="{name: 'myPage'}">마이페이지</router-link>
        </h2>
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
          <li>
            <router-link :to="{name: 'qna'}">1:1 문의하기</router-link>
          </li>
        </ul>
      </div>
      <!--//end #leftColumn//-->
      <div id="centerColumn">
        <h2 id="maintitle">MY PAGE - 나의 문의내역 </h2>
        <br>
        <div>
          <table class="table table-hover" id=table6_2 >
            <tr>
              <th style="width: 10%">문의번호</th>
              <th style="width: 20%">문의유형</th>
              <th style="width: 40%">문의제목</th>
              <th style="width: 10%">문의등록일</th>
              <th style="width: 10%">문의답변</th>
            </tr>
            <tbody>
            <tr class="result-date" v-for="(result,index) in resultList" :key="index">
              <td>
                <router-link
                  :to="{name: 'myPageQnaDetails',query:{questionIdx: result.questionIdx}}">
                  {{ result.questionIdx }}
                </router-link>
              </td>
              <td>
                <router-link
                  :to="{name: 'myPageQnaDetails',query:{questionIdx: result.questionIdx}}">
                  {{ result.type }}
                </router-link>
              </td>
              <td>
                <router-link
                :to="{name: 'myPageQnaDetails',query:{questionIdx: result.questionIdx}}">
                  {{ result.title }}
                </router-link>
              </td>
              <td>{{ result.regDate  | yyyyMMdd }}</td>
              <td>{{ result.commentCount }}</td>
            </tr>
            </tbody>
          </table>
        </div> <!--//end #centerColumn//-->
        <br>
      </div><!--end center coulmn-main board -->
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
      <br>
    </div>      <!--//end #container//-->
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
/*init*/
div, span, h3, p, strong,
a, em, q, s, sub, sup, tt, var,
ul, li, form, label {
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

/*left-column custom*/
#leftColumn h2 {
  margin-right: 10%;
}

a {
  color: #2B3F6B;
  text-decoration: none;
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

#leftColumn {
  float: left;
  margin: 0;
  padding: 0;
  width: 15%;
  font-size: 15px;
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


#leftColumn li a:hover {
  text-decoration: none;
}

#centerColumn {
  margin: 0 0 0 180px;
  padding: 0;
  background-color: #ffffff;
}

#centerColumn p {
  padding: 10px
}

#centerColumn h2 {
  margin: 0;
  padding: 10px 0 5px 0;
  letter-spacing: .1em;
}

/*table custom*/
table {
  border-collapse: collapse;
  border-spacing: 0;
  width: 800px;
  /*margin: auto;*/
}

#table6_2 table {
  float: left;
  width: 50%;
  margin: 15px auto;
  border: 0;
}

#table6_2 th {
  background-color: #2B3F6B;
  color: #FFFFFF
}

#table6_2, #table6_2 th, #table6_2 td {
  font-size: 0.95em;
  text-align: center;
  padding: 4px;
  border-collapse: collapse;
}
#table6_2 th, #table6_2 td {
  border: 1px solid #202020;
  border-width: 1px 0 1px 0
}

#table6_2 tr {
  border: 1px solid #ffffff;
}

/*add custom css */

#maintitle {
  font-weight: bold;
  line-height: 1.15;
  font-size: 35px;
  margin-block-start: 0.83em;
  margin-block-end: 0.83em;
  margin-inline-start: 0.83em;
  margin-inline-end: 0.83em;
  letter-spacing: -0.03em;
}

</style>

