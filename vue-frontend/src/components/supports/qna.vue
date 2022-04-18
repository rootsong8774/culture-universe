<template>
  <div>
    <div id="contactWrite" style="position:relative;">
      <!-- 비회원 입력 폼 -->
      <form id="support_write_form" name="writeForm" enctype="multipart/form-data"
      @submit="postData"  method="post">
        <input type="hidden" name="is_member" value="N"/>
        <input type="hidden" name="logout">
        <fieldset>
          <div class="table-w">
            <table summary="고객명, 비밀번호, 아이디, 문의자, 연락처, 핸드폰, 문의유형, 파일첨부, 제목, 내용">
              <caption id="maintitle"><h3>1:1문의 게시판</h3></caption>
              <colgroup>
                <col width="85"/>
                <col width="*"/>
                <col width="85"/>
                <col width="*"/>
              </colgroup>
              <tbody>
<!--              <tr>-->
<!--                <th scope="col">-->
<!--                  <div class="tb-l">작성자id *</div>-->
<!--                </th>-->
<!--                <td colspan="3">-->
<!--                  <div class="tb-l">-->
<!--                    <input type="text" name="subject" value="" class="txt-input"-->
<!--                          v-model="username" style="width: 405px"/>-->
<!--                  </div>-->
<!--                </td>-->
<!--              </tr>-->
              <tr>
                <th scope="col">
                  <div class="tb-l">문의유형 *</div>
                </th>
                <td colspan="3">
                  <div class="tb-l">
                    <select name="qna_type" onchange="">
                      <option value="">문의 유형을 선택해주세요.</option>
                      <option v-for="(qnaType,key) in type"
                              v-bind:value="qnaType" :key="key"
                              v-model="type">
                        {{qnaType}}</option>
                    </select>
                  </div>
                </td>
              </tr>
              <tr>
                <th scope="col">
                  <div class="tb-l">제목 *</div>
                </th>
                <td colspan="3">
                  <div class="tb-l">
                    <input type="text" name="subject" value="" class="txt-input"
                           v-model="title"
                           style="width: 405px"/>
                  </div>
                </td>
              </tr>
              <tr>
                <th scope="col">
                  <div class="tb-l">내용 *</div>
                </th>
                <td colspan="3">
                  <div class="tb-l">
                    <p>평일 업무시간 : AM 09:30 ~ PM 18:00 (주말 , 공휴일 휴무)</p>
                    <font color=blue><b>* 정확하고 빠른 문의파악을 위해 문의사항과 관련된 필수입력정보를 확인하여<br/>내용 기재해 주시기 바랍니다.<br/></b></font>
                    <textarea name="contents" cols="70" rows="10" onchange=""
                              v-model="content"></textarea>
                  </div>
                </td>
              </tr>
              <tr>
                <td colspan="4">
                  <div class="agree">
                    <div class="tb-l">
                      "*" 필수항목입니다.
                    </div>
                  </div>
                </td>
              </tr>
              <tr>
                <td colspan="4">
                  <div class="agree">
                    <div class="tb-l" style='text-align:center;padding:10px;font-size:15px;'>
                      <h6><b>2018년 10월 18일 부터 산업안전보건법에 의거 고객응대근로자 보호 조치가 시행되었습니다.<br/>
                        고객만족을 위한 응대를 준비하고 있으니, <br/>
                        폭언이나 욕설은 삼가해 주시고, 따뜻한 마음으로 문의 접수 부탁드립니다.</b></h6>
                    </div>
                  </div>
                </td>
              </tr>
<!--              <tr>-->
<!--                <td colspan="4">-->
<!--                  <div class="tb-c">-->
<!--                    <h3 class="box-tit">개인정보 수집,이용동의 (필수)-->
<!--                    </h3>-->
<!--                    <table border="0" summary="목적, 항목, 보유기간, 동의여부" class="tbl">-->
<!--                      <caption>개인정보 수집/이용 동의</caption>-->
<!--                      <colgroup>-->
<!--                        <col width="*"/>-->
<!--                        <col width="35%"/>-->
<!--                        <col width="25%"/>-->
<!--                        <col width="16%"/>-->
<!--                      </colgroup>-->
<!--                      <thead>-->
<!--                      <tr>-->
<!--                        <th scope="col">-->
<!--                          <div>목적</div>-->
<!--                        </th>-->
<!--                        <th scope="col">-->
<!--                          <div>항목</div>-->
<!--                        </th>-->
<!--                        <th scope="col">-->
<!--                          <div>보유기간</div>-->
<!--                        </th>-->
<!--                        <th scope="col">-->
<!--                          <div>동의여부</div>-->
<!--                        </th>-->
<!--                      </tr>-->
<!--                      </thead>-->
<!--                      <tbody>-->
<!--                      <tr>-->
<!--                        <td>-->
<!--                          <div>1:1문의 답변</div>-->
<!--                        </td>-->
<!--                        <td>-->
<!--                          <div>고객명,비밀번호,이메일,연락처,IP</div>-->
<!--                        </td>-->
<!--                        <td>-->
<!--                          <div>문의내역 삭제시 까지</div>-->
<!--                        </td>-->
<!--                        <td>-->
<!--                          <div>-->
<!--                            <ul>-->
<!--                              <li><label><input type="radio" name="privacy_type_A"-->
<!--                                                value="Y" class="chk-rdo"  checked="checked"/> 동의</label></li>-->
<!--                              <li><label><input type="radio" name="privacy_type_A"-->
<!--                                                value="N" /> 미동의</label></li>-->
<!--                            </ul>-->
<!--                          </div>-->
<!--                        </td>-->
<!--                      </tr>-->
<!--                      </tbody>-->
<!--                    </table>-->
<!--                    <div class="btm-txt">* 수집하는 개인정보는 그 목적에 맞게 사용되며, 미동의 시 서비스 이용이 어렵습니다.-->
<!--                      <button type="submit" class="btn btn-default pull-right" @click="register" >-->
<!--                        문의등록-->
<!--                      </button>-->
<!--                       </div>-->
<!--                  </div>-->
<!--                </td>-->
<!--              </tr>-->
              <button type="submit" class="btn btn-default pull-right">
                문의등록
              </button>
              </tbody>
            </table>
          </div>
        </fieldset>
      </form>
    </div>
  </div>
</template>
<script>

import axios from "axios";

export default {
  name: "qna",
  props: {
  },
  data(){
    return {
      //username:'',
      type: {환불문의:'환불문의', 공연문의:'공연문의',기타:'기타'},
      title: '',
      content: ''
    }
  },
  methods:{
    DateFormat(row){
      return moment(row.regDate).format('YYYY-MM-DD');
    },
    postData:function (){
      axios({
        url: '/api/qna/register',
        method: 'post',
        data: {
          //username : this.username,
          type: this.type,
          title: this.title,
          content: this.content,
        },
        dataType: 'json',
      }).then(res => {
        console.log(res);
        alert('문의가 등록되었습니다.')
        // this.$router.replace({name: "qna"})
        $('.bs-example-modal-lg').modal('hide')
      }).catch(err => {
        console.log(err);
      });
    },
    watch() {
      this.postData();
    },
  }
}
</script>

<style scoped>
#contactWrite {
  min-height: 675px;
  _height: 675px;
}
#contactWrite th,
#contactWrite td {
  border: 1px solid #d6e2e9;
}

#contactWrite th {
  padding: 10px 0 9px;
  font-size: 14px;
  font-weight: bold;
  color: #414141;
  background-color: #f6f9fa;
}

#contactWrite th .tb-l {
  padding-left: 14px;
  letter-spacing: -1px;
}

#contactWrite td {
  padding: 8px 0 7px;
  font-size: 12px;
  color: #6b6b6b;
  background-color: #fff;
}

#contactWrite td .tb-l {
  position: relative;
  padding: 0 9px;
}

#contactWrite td .tb-l .btn-logout {
  position: absolute;
  right: 10px;
  top: -1px;
}

#contactWrite td .txt-input,
#contactWrite td textarea {
  font-size: 12px;
}

#contactWrite td .txt-input {
  height: 24px;
  line-height: 24px;
  border: 1px solid #c9d0d6;
}

#contactWrite td textarea {
  overflow-y: scroll;
  width: 490px;
  max-width: 100%;
  max-height: 180px;
  height: 180px;
  border: 1px solid #c9d0d6;
}

#contactWrite td .html {
  color: #7f9db9;
}

#contactWrite td .html-red {
  color: #ff0000;
}

#contactWrite .file-w {
  overflow: hidden;
  position: relative;
  display: inline-block;
  width: 335px;
  height: 26px;
  padding-bottom: 1px;
  font-size: 0;
  line-height: 0;
  /*background: url(./img/btn/h26_w78_addfile.gif) no-repeat right 0;*/
}

#contactWrite .file-w .ftrick {
  cursor: pointer;
  position: absolute;
  right: 0;
  top: 0;
  width: 85px;
  height: 26px;
  background: none;
  border: 0 none;
  opacity: 0;
  filter: alpha(opacity=0);
}

#contactWrite .btn-foot {
  margin-top: 45px;
  font-size: 0;
  line-height: 0;
  text-align: center;
}

#contactWrite .btn-foot .btn-sp {
  margin-left: 11px;
}

#contactWrite .btn-foot .btn-dbh48 * {
  padding-left: 35px;
  padding-right: 45px;
}

#contactWrite .btn-foot .btn-dbh48 .raw-db {
  left: -35px;
}

/* 개인정보 동의 */
#contactWrite h3.box-tit {
  position: relative;
  width: 566px;
  margin: 0 auto;
  height: 38px;
  line-height: 41px;
  padding-left: 20px;
  font-size: 14px;
  color: #333;
  font-weight: bold;
  background: #f6f6f6;
  border: 1px solid #e0e0e0;
  border-bottom: 0;
  text-align: left;
}

#contactWrite .agreement_choice {
  position: absolute;
  top: 0px;
  right: 20px;
  text-align: right;
  font-size: 12px;
  font-weight: normal;
  color: #666;
}

#contactWrite .agreement_choice input {
  width: 12px;
  height: 12px;
  vertical-align: middle;
}

#contactWrite .tbl {
  width: 98%;
  margin: 0 auto;
  border-top: 1px solid #e0e0e0;
  border-left: 1px solid #e0e0e0;
}

#contactWrite .tbl caption {
  display: none;
}

#contactWrite .tbl th,
#contactWrite .tbl td {
  height: 37px;
  padding: 0;
  margin: 0;
  border-right: 1px solid #e0e0e0;
  background: #fff;
  border-bottom: 1px solid #e0e0e0;
  font-size: 12px;
}

#contactWrite .tbl th {
  line-height: 39px;
  background: #fdfdfd;
  text-align: center;
}

#contactWrite .tbl td div {
  padding: 0 5px;
  text-align: left;
  color: #666;
}

#contactWrite .tbl td div ul {
  margin-left: 15px;
}

#contactWrite .tbl td div ul li input {
  width: 12px;
  height: 12px;
  vertical-align: middle;
}

#contactWrite .btm-txt {
  height: 30px;
  margin-left: 10px;
  padding-top: 5px;
  font-size: 11px;
  color: #666;
  text-align: left;
}
/*custom*/
#contactWrite .table-w {
  padding: 10px;
  padding-left: 25%;
  margin-left: auto;
}
#maintitle{
  text-align: center;
}
h6{
  font-size: small;
}
#qnaregister{

  }
</style>
