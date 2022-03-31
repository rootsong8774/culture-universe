<template>
  <div>

    <div class="seat-reservation">
      <section class="">
        <ul class="nav nav-tabs">
          <li class="active"><a href="#program" data-toggle="tab">1.프로그램</a></li>
          <li><a href="#place1" data-toggle="tab">2.장소</a></li>
          <li><a href="#date" data-toggle="tab">3.날짜</a></li>
          <li><a href="#episode" data-toggle="tab">4.회차</a></li>
          <li><a href="#personnel" data-toggle="tab">5.인원</a></li>
          <li><a href="#payment" data-toggle="tab">6.결제</a></li>
        </ul>
        <!-- Tab이 선택되면 내용이 보여지는 영역이다. -->
        <div class="tab-content">
          <div class="tab-pane fade in active" id="program">program 메뉴
            <div class="item">
              <div>
                <img src="../assets/images/item1.jpg" width="150px">
              </div>
              <table class="table-item">
                <th>
                  <tr>
                    <td>뮤지컬</td>
                    <td>item-list-name</td>
                  </tr>
                  <tr>
                    <td>티켓</td>
                    <td>item-ticket</td>
                  </tr>
                  <tr>
                    <td>문의</td>
                    <td>item-tel</td>
                  </tr>
                </th>
              </table>
            </div>
            <br>
            <br>
            <ul>
              <li>
                1.날짜선택
                <form>
                  <input type="date">~<input type="date">
                </form>
              </li>
            </ul>
          </div>
          <!-- id는 고유한 이름으로 설정하고 tab의 href와 연결되어야 한다. -->
          <div class="tab-pane fade" id="place1">place 메뉴
            <div class="seat-picture">
              <img src="../assets/images/seat.jpg" width="350px" height="350px">
            </div>
            <div class="seat-text">
              <form>
                <ul>
                  <li><input type="text"></li>
                  <li><input type="text"></li>
                  <li><input type="text"></li>
                </ul>
              </form>
            </div>
          </div>
          <div class="tab-pane fade " id="date">
            <div class="cont">
              <div class="book_ex">
                <div class="poster">
                  <img src="src/assets/images/poster.jpg" width="250px" height="200px">
                </div>
                <div class="txt">
                  <h3 class="tit" title="2022 SOMEDAY THEATRE CANTABILE">2022 SOMEDAY THEATRE CANTABILE</h3>
                  <ul class="detail">
                    <li><span class="dt">기간</span> 2022.04.09 (토) ~ 2022.04.10 (일)</li>
                    <li><span class="dt">장소</span> 세종문화회관 대극장</li>
                  </ul>
                </div>
              </div>
              <ul class="book-sel clearfix">
                <li class="l">
                  <h3 class="book-tit">1. 날짜 선택</h3>
                  <div class="book_com calendar" style="padding: 0px;overflow-y: auto; height: 240px;">
                    <ul class="calen_box_first">
                      <!-- 캘린더 -->
                      <li class="calendar2" id="calendar2">
                      </li>
                    </ul>
                  </div></li>
                <li class="r">
                  <h3 class="book-tit">2. 회차 선택</h3>
                  <div class="book_com">
                    <ul id="play_seq_cd" class="book_th dot">
                      <div id="play_seq_cd_List"><li class="item">

                          <span>1회차</span>
                          <!-- 전시, 1회만 있는 경우 회차시간 표시 안함 -->
                          <span class="time">13:30</span>
                          <span class="seat">481석</span>
                      </li>
                        <li class="item">
                            <span>2회차</span>
                            <span class="time">19:00</span>
                            <span class="seat">533석</span>
                        </li>
                        </div>
                    </ul>
                  </div>
                </li>
              </ul>
              <div class="pop_btn_w clearfix">
                <button class="l btn-st1" onclick="javascript:goMypage();">예매확인 및 취소</button>
                <button class="r btn-st1" onclick="javascript:goBooking_seat();return false;">예매하기</button>
              </div>
            </div>
          </div>
          <div class="tab-pane fade" id="episode">episode 메뉴
          </div>
          <div class="tab-pane fade" id="personnel">
            <div class="cont">
              <div class="book_steps3">
                <div class="tit-st1">
                  <br>
                  <h3 class="t">좌석 수량 선택 <span title="2022 SOMEDAY THEATRE CANTABILE">2022 SOMEDAY THEATRE CANTABILE</span></h3>
                  <div class="total-st1">총 결제금액 <strong class="color-purple" id="Tot_payment_seat">0</strong><strong class="color-purple">원</strong></div>
                </div>
                <p class="txt_box">
                  R석 <span id="sumTicketLimit_02">1</span>매 중 <strong class="color-purple"><span id="sumTicket1_02">0</span>매</strong>를 선택하셨습니다.
                </p>
                <ul class="detail dot">
                  <li class="item">
                    <ul class="clearfix">
                      <li class="tit">일반</li>
                      <li class="price">110,000 원</li>
                      <li class="amount">
                        <label for="conTicket1_1" class="hide">일반 수량</label>
                        <input type="text" name="" id="conTicket1_1" title="일반 수량" value="0" onchange="calSeatChg_Input(this.value, '1', '000001', '02', '0', '2', '110000');return false;"> 매
                      </li>
                      <li class="plus clearfix">
                        <button type="button" class="bg-black_r" onclick="calSeatChg(1, '1', '000001', '02', '0', '2', '110000');return false;" style="width: 22%" alt="+1 버튼">+1</button>
                        <button type="button" class="bg-black_r" onclick="calSeatChg(2, '1', '000001', '02', '0', '2', '110000');return false;" style="width: 22%" alt="+2 버튼">+2</button>
                        <button type="button" class="bg-black_r" onclick="calSeatChg(3, '1', '000001', '02', '0', '2', '110000');return false;" style="width: 22%" alt="+3 버튼">+3</button>
                        <button type="button" class="bg-black_r" onclick="calSeatChg(4, '1', '000001', '02', '0', '2', '110000');return false;" style="width: 22%" alt="+4 버튼">+4</button>
                      </li>
                      <li class="reset">
                        <button type="button" class="bg-black2_r" onclick="calSeatChgClear(0, '1', '000001', '02', '0', '2', '110000');return false;" alt="정정 버튼">정정</button>
                      </li>
                    </ul>
                  </li>
                  <li class="item">
                    <ul class="clearfix">
                      <li class="tit">국가유공자</li>
                      <li class="price">55,000 원</li>
                      <li class="amount">
                        <label for="conTicket1_2" class="hide">국가유공자 수량</label>
                        <input type="text" name="" id="conTicket1_2" title="국가유공자 수량" value="0" onchange="calSeatChg_Input(this.value, '2', '000049', '02', '0', '2', '55000');return false;"> 매
                      </li>
                      <li class="plus clearfix">
                        <button type="button" class="bg-black_r" onclick="calSeatChg(1, '2', '000049', '02', '0', '2', '55000');return false;" style="width: 22%" alt="+1 버튼">+1</button>
                        <button type="button" class="bg-black_r" onclick="calSeatChg(2, '2', '000049', '02', '0', '2', '55000');return false;" style="width: 22%" alt="+2 버튼">+2</button>
                        <button type="button" class="bg-black_r" onclick="calSeatChg(3, '2', '000049', '02', '0', '2', '55000');return false;" style="width: 22%" alt="+3 버튼">+3</button>
                        <button type="button" class="bg-black_r" onclick="calSeatChg(4, '2', '000049', '02', '0', '2', '55000');return false;" style="width: 22%" alt="+4 버튼">+4</button>
                      </li>
                      <li class="reset">
                        <button type="button" class="bg-black2_r" onclick="calSeatChgClear(0, '2', '000049', '02', '0', '2', '55000');return false;" alt="정정 버튼">정정</button>
                      </li>
                    </ul>
                  </li>
                  <li class="item">
                    <ul class="clearfix">
                      <li class="tit">장애인(1~3급)</li>
                      <li class="price">55,000 원</li>
                      <li class="amount">
                        <label for="conTicket1_3" class="hide">장애인(1~3급) 수량</label>
                        <input type="text" name="" id="conTicket1_3" title="장애인(1~3급) 수량" value="0" onchange="calSeatChg_Input(this.value, '3', '503730', '02', '0', '2', '55000');return false;"> 매
                      </li>
                      <li class="plus clearfix">
                        <button type="button" class="bg-black_r" onclick="calSeatChg(1, '3', '503730', '02', '0', '2', '55000');return false;" style="width: 22%" alt="+1 버튼">+1</button>
                        <button type="button" class="bg-black_r" onclick="calSeatChg(2, '3', '503730', '02', '0', '2', '55000');return false;" style="width: 22%" alt="+2 버튼">+2</button>
                        <button type="button" class="bg-black_r" onclick="calSeatChg(3, '3', '503730', '02', '0', '2', '55000');return false;" style="width: 22%" alt="+3 버튼">+3</button>
                        <button type="button" class="bg-black_r" onclick="calSeatChg(4, '3', '503730', '02', '0', '2', '55000');return false;" style="width: 22%" alt="+4 버튼">+4</button>
                      </li>
                      <li class="reset">
                        <button type="button" class="bg-black2_r" onclick="calSeatChgClear(0, '3', '503730', '02', '0', '2', '55000');return false;" alt="정정 버튼">정정</button>
                      </li>
                    </ul>
                  </li>
                  <li class="item">
                    <ul class="clearfix">
                      <li class="tit">장애인(4~6급)</li>
                      <li class="price">55,000 원</li>
                      <li class="amount">
                        <label for="conTicket1_4" class="hide">장애인(4~6급) 수량</label>
                        <input type="text" name="" id="conTicket1_4" title="장애인(4~6급) 수량" value="0" onchange="calSeatChg_Input(this.value, '4', '503731', '02', '0', '2', '55000');return false;"> 매
                      </li>
                      <li class="plus clearfix">
                        <button type="button" class="bg-black_r" onclick="calSeatChg(1, '4', '503731', '02', '0', '2', '55000');return false;" style="width: 22%" alt="+1 버튼">+1</button>
                        <button type="button" class="bg-black_r" onclick="calSeatChg(2, '4', '503731', '02', '0', '2', '55000');return false;" style="width: 22%" alt="+2 버튼">+2</button>
                        <button type="button" class="bg-black_r" onclick="calSeatChg(3, '4', '503731', '02', '0', '2', '55000');return false;" style="width: 22%" alt="+3 버튼">+3</button>
                        <button type="button" class="bg-black_r" onclick="calSeatChg(4, '4', '503731', '02', '0', '2', '55000');return false;" style="width: 22%" alt="+4 버튼">+4</button>
                      </li>
                      <li class="reset">
                        <button type="button" class="bg-black2_r" onclick="calSeatChgClear(0, '4', '503731', '02', '0', '2', '55000');return false;" alt="정정 버튼">정정</button>
                      </li>
                    </ul>
                  </li>
                </ul>
              </div>
              <div class="pop_btn_w clearfix">
                <button class="l btn-st1 bg-black_r" onclick="javascript:goMypage();" alt="예매확인 및 취소 버튼">예매확인 및 취소</button>
                <div class="r clearfix">
                  <button class="btn-st2 bg-black_r" onclick="javascript:btnBack();" alt="이전 버튼">이전</button>
                  <button class="btn-st2 bg-purple" onclick="javascript:btnNext();" alt="다음 버튼">다음</button>
                </div>
              </div>
            </div>
          </div>

          <div class="tab-pane fade" id="payment">
            <div class="cont">
              <div class="book_steps5">
                <h3 class="tit-st3">결제수단을 선택하세요</h3>
                <div class="total-st1">결제금액 <strong class="color-purple" >{{ n }}</strong><strong class="color-purple">원</strong></div>
                <ul class="pay_w clearfix dot">
                  <li><input type="radio" name="pay" id="pay1" value="CD" checked=""> <label for="pay1">신용카드</label></li>
                  <li><input type="radio" name="pay" id="pay2" value="VA"> <label for="pay2">가상계좌</label></li>
                </ul>
                <div class="pay_w_in">
                  <div class="pay2">
                    <div class="pay_com2 dot">
                      <div class="group">
                        <ul>
                          <li><label for="Va_Bank" class="t">은행</label>
                            <select name="Va_Bank" id="Va_Bank">
                              <option value="03">기업</option>
                              <option value="04">국민</option>
                              <option value="05">외환</option>
                              <option value="07">수협</option>
                              <option value="11">농협</option>
                              <option value="20">우리</option>
                              <option value="23">SC제일</option>
                              <option value="26">신한</option>
                              <option value="32">부산</option>
                              <option value="34">광주</option>
                              <option value="81">하나</option>
                              <option value="71">우체국</option>
                            </select></li>
                          <li>
                            <label for="payee" class="t">수취인</label> <input type="text" name="" id="payee" value="세종문화회관" disabled=""></li>
                          <li><label for="name" class="t">이름</label> <input type="text" name="" id="name" value="" disabled=""></li>
                          <li><span class="t">연락처</span>
                            <div class="tel">
                              <label for="VA_mobile1" class="hide">연락처 앞자리</label>
                              <select name="" id="VA_mobile1">
                                <option value="010" selected="">010</option>
                                <option value="011">011</option>
                                <option value="016">016</option>
                                <option value="017">017</option>
                                <option value="018">018</option>
                                <option value="019">019</option>
                                <option value="050">050</option>
                                <option value="070">070</option>
                              </select>
                              <label for="VA_mobile2" class="hide">연락처 중간자리</label>
                              <input type="text" id="VA_mobile2" name="VA_mobile2" maxlength="4" onkeypress="onlyNumber();" alt="휴대폰번호 중간 번호를 입력하여 주세요." title="휴대폰번호 중간 번호">
                              <label for="VA_mobile3" class="hide">연락처 끝자리</label>
                              <input type="text" id="VA_mobile3" name="VA_mobile3" maxlength="4" onkeypress="onlyNumber();" alt="휴대폰번호 끝 번호를 입력하여 주세요." title="휴대폰번호 끝 번호">
                            </div>
                          </li>
                          <li><span class="t">이메일</span>
                            <div class="email">
                              <label for="VA_email1" class="hide">이메일 앞자리</label>
                              <input type="text" name="VA_email1" id="VA_email1" maxlength="90" alt="이메일 앞자리를 입력하여 주세요." title="이메일 앞자리">
                              <span class="dash">@</span>
                              <label for="VA_email2" class="hide">이메일 끝자리</label>
                              <input type="text" name="VA_email2" id="VA_email2" maxlength="90" alt="이메일 끝자리를 입력하여 주세요." title="이메일 끝자리">
                            </div>
                          </li>
                        </ul>
                        <p class="txt">※ 선택하신 가상계좌는 현금 영수증을 발행 받으실 수 있습니다.</p>
                      </div>
                      <div class="group">
                        <ul>
                          <li class="issue"><span class="t">현금영수증 발행</span>
                            <div class="radio">
                              <input type="radio" name="cash_issue" id="cash_issue1" value="Y" onclick="javascript:btncash_issue1();"> <label for="cash_issue1">발행</label>
                              <input type="radio" name="cash_issue" id="cash_issue2" value="N" onclick="javascript:btncash_issue2();" checked="checked"> <label for="cash_issue2">미발행</label>
                            </div>
                          </li>
                          <li class="detail use" id="cash_use_il"><span class="t">현금영수증 용도</span>
                            <div class="radio">
                              <input type="radio" name="cash_use" id="cash_use1" value="p" onclick="javascript:btncash_use1();"> <label for="cash_use1">개인 소득공제용</label>
                              <input type="radio" name="cash_use" id="cash_use2" value="g" onclick="javascript:btncash_use2();"> <label for="cash_use2">사업자 지출증빙용</label>
                            </div>
                          </li>
                          <li class="detail" id="VA_regno_il"><label for="VA_regno" class="t name">휴대폰번호</label>
                            <input type="text" name="VA_regno" id="VA_regno" maxlength="19" onkeypress="onlyNumber();" alt="현금영수증 발행용 휴대폰번호를 입력하여 주세요." title="현금영수증 발행용 휴대폰번호"> ("-" 제외)
                          </li>
                        </ul>
                      </div>
                    </div>
                  </div>
                  <div class="pay3">실시간 계좌이체 영역</div>
                  <div class="pay5"> 휴대폰 결제 후 결제월이 지나거나 공제금액 발생 시 CMS 환불처리가 됩니다.</div>
                </div>
                <div class="pop_btn_w clearfix">
                  <button class="l btn-st1 bg-black_r" id="goMypage" onclick="javascript:goMypage();" alt="예매확인 및 취소 버튼">예매확인 및 취소</button>

                  <div class="r clearfix">
                    <button class="btn-st2 bg-black_r" id="btnBackID" onclick="javascript:btnBack();" alt="이전 버튼">이전</button>
                    <button class="btn-st2 bg-purple" id="btnNextID" onclick="javascript:btnNext();" alt="결제하기 버튼">결제하기</button>
                  </div>
                </div>
              </div>
            </div></div>
        </div>
      </section>
    </div>



  </div>
</template>

<script>


export default {
  name: "seat",

}
</script>

<style scoped>
.modal_w{background:rgba(0,0,0,.7); position:fixed; position:fixed; z-index:9999; width:100%; height:100%; left:0; top:0}
.modal_w > .in{position:relative;top:50%;max-width:1024px;background: #fff;z-index: 10000;width: 97%;margin: auto;max-height: 97%;overflow-y: auto;transform:translateY(-50%);}

.color-navy{color: #0e0e71}
.color-purple{color: #930c71}


.tit-st1{position: relative; font-size: 20px;color: #000;margin-bottom: 18px;}
.tit-st1 .t > span{position: relative;display: inline-block;padding-left: 10px;margin-left: 10px;font-weight: 400;}
.tit-st1 .t > span:before{width: 1px;height: 10px;content: '';background: #ddd;left: 0;top:50%;margin-top: -5px;position: absolute;}

.tit-st2{padding: 15px 20px;font-size: 26px; position: relative;color: #000;border-bottom: 1px solid #ccc;;}
.tit-st2 button{position: absolute; right: 20px;top:50%;margin-top: -12px}
.tit-st3{color: #111; font-size: 20px;font-size: 1.333rem;margin-bottom: 1em;line-height: 1.15;}


.bul-dot > li,.bul-dot.b{position: relative;padding-left: 15px;margin-top: 5px;}
.bul-dot > li:before,.bul-dot.b:before{position: absolute;left: 0;top:0.5em;width: 5px;height: 5px;background: #333;content: '';border-radius: 50%}
.bul-dot > li:first-child,.bul-dot.b{margin-top: 0;}

.bul-dot2 > li{position: relative;padding-left: 11px;margin-top: 5px;}
.bul-dot2 > li:before{position: absolute;left: 0;top:0.63em;width: 3px;height: 3px;background: #666;content: '';border-radius: 50%}
.bul-dot2 > li:first-child{margin-top: 0;}

.box-st1{background: #f8f8f8;border:1px solid #ddd}
.box-st1 .book_com{height: 200px}

.btn-st1{width: 200px;height: 53px;display: block;font-size: 17px;}
a.btn-st1{line-height: 50px;}
.btn-st2{width: 150px;height: 53px;display: block;font-size: 17px;}
a.btn-st2{line-height: 50px;}
.btn-st3{font-size: 13px;line-height: 1;padding: 3px;display: inline-block;}
.btn-reset{width: 100px;height: 35px;font-size: 16px;}

.icon-st1{display: inline-block;width: 11px;height: 11px;white-space: nowrap;overflow: hidden;text-indent: -999px;margin-right: 3px;vertical-align: middle;}

.tbl-st1{font-size: 15px;border-top: 1px solid #000; width: 100%;}
.tbl-st1 th{border-bottom: 1px solid #000;padding: 1.333em 10px}
.tbl-st1 td{text-align: center; padding: 1.33em 10px;border-bottom: 1px solid #ddd;}
.tbl-st1.f13{font-size: 13px;}
.tbl-st1.f13 th{padding: 10px 3px}
.tbl-st1.f13 td{padding: 5px}

.tbl-st1 .btn-st3{margin-top: 3px;}
.tbl-st1 .btn-st3:first-child{margin-top: 0;}

.tbl-st2{border-top: 1px solid #ddd;position: relative;display: -webkit-flex;
  display: -ms-flex;
  display: flex;;flex-wrap: wrap;font-size: 13px;letter-spacing: 0;}
.tbl-st2:before{position: absolute;left: 50%;top:0;width: 1px;height: 100%;content: '';background: #ddd}
.tbl-st2 > li{float: left;width: 50%;border-bottom: 1px solid #ddd;padding: 10px 10px 10px 145px;position: relative;}
.tbl-st2 .dt{position: absolute;left:15px;top:10px;font-weight: normal;font-weight: 700;}

.tabs-st1{text-align: center;color:#999;font-weight: 500;border-left: 1px solid #ddd;font-size: 16px;margin-bottom: 1.5em;}
.tabs-st1 a{display: block;padding: .8em 10px}
.tabs-st1 > li{float: left; width:50%;border:1px solid #ddd;position:relative;border-left: 0;}
.tabs-st1 .active{color:#111}
.tabs-st1 .active:before{position:absolute;left: -1px;top:-1px;right: -1px;bottom: -1px;margin: auto;border:1px solid #111;content: ''}


.total-st1{font-size: 20px;color: #000;text-align: right;}
.total-st1 strong{font-size: 28px;margin-left: 10px;}

.sch-st1{text-align: center;margin-bottom: 15px;font-size: 0;}
.sch-st1 input[type="text"],.sch-st1 button{height: 35px;font-size: 13px;}
.sch-st1 input[type="text"]{width: 350px;padding: 0 10px;}
.sch-st1 button{width: 115px;margin-left: -1px;}

.txt_box{background: #f8f8f8;border:1px solid #ddd;padding: 20px;font-size: 18px;text-align: center;margin-bottom: 20px;}

.paging{text-align: center;font-size: 0;margin-top: 25px;}
.paging > li{display: inline-block;font-size: 15px;margin: 0 2px;border:1px solid #ddd;width: 40px;height: 40px;line-height: 40px;vertical-align: middle;}
.paging .active{background: #000;color: #fff}
.paging a{display: block;}
.paging .arrow{white-space: nowrap;overflow: hidden;text-indent: -999px}

/* 팝업 공통 */

.label_w span{padding: 0 3px;margin-right: 5px;}
.pop_btn_w{margin-top: 15px;}
.pop_btn_w .l{float: left;}
.pop_btn_w .r{float: right;}
.pop_btn_w .r.clearfix button{float: right;}
.pop_btn_w .r.clearfix button:first-child{float: left;margin-right: 10px;}
.pop_btn_w2{text-align: center;margin-top: 25px;}
.pop_btn_w2 button{display: inline-block;margin: 0 5px !important;}

.pop-st1  .pop_btn_w2 .btn-st1{margin-top: 0;}

.book_ex{position: relative;padding-left: 163px;}
.book_ex .poster{position: absolute;left: 0;top:0;width: 130px;box-shadow: 3px 7px 21px rgba(0,0,0,.13)}
.book_ex .poster .img{width: 100%}
.book_ex .tit{font-size: 25px;display: block;margin-bottom: 10px;letter-spacing: -0.05em;line-height: 1.35;}
.book_ex .detail{letter-spacing: -0.03em}
.book_ex .detail > li{position: relative;border-bottom: 1px solid #ddd;;padding: 8px 0 8px 53px}
.book_ex .detail .dt{position: absolute;left: 0;top:8px}
.book_ex .txt{min-height: 185px}

.book-sel{margin-top: 35px;border:1px solid #ddd}
.book-sel > li{float: left;width: 50%;}
.book-sel .r{border-left: 1px solid #ddd;}
.book-tit{font-size: 15px;text-align: center;color: #000;padding: .8em 0 1em 0;font-weight: 700;background: #fff;border-bottom: 1px solid #ddd;line-height: 1;}

.book_com{background: #f8f8f8;height: 240px;overflow-y: auto;padding: 10px}

.book_th{font-size: 13px;}
.book_th .item{border-bottom: 1px solid #ddd;letter-spacing: 0}
.book_th a,.book_th .pack_s{white-space: nowrap;overflow: hidden;text-overflow: ellipsis;}
.book_th .item > a{display: block;position: relative; padding: 8px 10px}
.book_th .item .time{margin-left: 60px;}
.book_th .item .seat{position: absolute;right: 20px;top:10px}
.book_th .item .active{background: #fff;border:1px solid #930c71;color: #930c71;font-weight: 700;}

.book_il{font-size: 10px;}
.book_il .item{border-bottom: 0px solid #ddd;letter-spacing: 0}
.book_il a,.book_th .pack_s{white-space: nowrap;overflow: hidden;text-overflow: ellipsis;}
.book_il .item > a{display: block;position: relative; padding: 8px 10px}
.book_il .item .time{margin-left: 60px;}
.book_il .item .seat{position: absolute;right: 20px;top:10px}
.book_il .item .active{background: #fff;border:1px solid #930c71;color: #930c71;font-weight: 700;}

.book_steps2 .tit-st1{padding-right: 137px;}
.book_steps2 .btn-reset{position: absolute;right: 0;top: 0}
.book_steps2 > .l{float: left; width: 62%}
.book_steps2 > .r{float: right;width: 35%}
.book_steps2 > .r .bg-grey{margin-bottom: 5px;border:1px solid #ddd;position: relative;padding-top: 35px;}
.book_steps2 > .r .t{font-size: 15px;color: #000;padding: 7px 10px;background: #fff;height: 35px;position: absolute;left: 0;top:0;width: 100%}
.book_steps2 .tbl{height: 150px;overflow-y: auto;}
.book_steps2 .tbl table{width: 100%}
.book_steps2 .tbl th{font-size: 15px;color: #000;background: #fff;text-align: center;height: 30px}
.book_steps2 .tbl td{padding: 2px 10px;text-align: right;font-size: 13px;letter-spacing: 0}
.book_steps2 .tbl tbody>tr:first-child>td{padding-top: 3px;}
.book_steps2 > .r .bg-grey.tbl{padding: 0}
.book_steps2 .btn-st1{width: 100%}
.book_steps2 .t{background: #fff}

.book_steps2 .info ul{padding: 5px 10px;overflow-y: auto;height: 94px;font-size: 13px;letter-spacing: 0}
.book_steps2 .info li{position: relative; padding-right: 30px;}
.book_steps2 .info span{margin-left: 14px;}
.book_steps2 .info span:first-child{margin-left: 0;}
.book_steps2 .info span,.book_steps2 .info button{display: inline-block;vertical-align: middle;}
.book_steps2 .info .i1{width: 30px}
.book_steps2 .info .i2{width: 30px}
.book_steps2 .info .i3{width: 30px}
.book_steps2 .info .i4{width: 50px}
.book_steps2 .info button{position: absolute;right: 0;top:50%;margin-top: -7px;}

.book_steps2_free .tit-st1{padding-right: 270px;}
.book_steps2_free .total-st1{position: absolute;right: 0;bottom: 0}
.book_steps2_free .detail{border-top: 1px solid #ddd}
.book_steps2_free .detail .item{border-bottom: 1px solid #ddd}
.book_steps2_free .detail ul{display: table;display: table;width: 100%}
.book_steps2_free .detail ul li{display: table-cell;vertical-align: middle;padding: 10px 15px}
.book_steps2_free .detail input[type="text"]{width: 63px;margin-right: 5px;padding: 0 10px;text-align: right;}
.book_steps2_free .detail input[type="text"],.book_steps3 .detail button{height: 33px}
.book_steps2_free .detail .reset{width: 117px}
.book_steps2_free .detail .reset button{width: 100%}
.book_steps2_free .detail .plus{width: 230px}
.book_steps2_free .detail .tit{width: 200px}
.book_steps2_free .detail .price{width: 150px}
.book_steps2_free .detail .plus{margin-left:-3% ;}
.book_steps2_free .detail .plus button{float: left; width: 30.3333333333333%;margin-left: 3%;}
.book_steps2_free .detail .plus .w100{width: 97% !important;float: none}

.book_steps3 .tit-st1{padding-right: 270px;}
.book_steps3 .total-st1{position: absolute;right: 0;bottom: 0}
.book_steps3 .detail{border-top: 1px solid #ddd}
.book_steps3 .detail .item{border-bottom: 1px solid #ddd}
.book_steps3 .detail ul{display: table;display: table;width: 100%}
.book_steps3 .detail ul li{display: table-cell;vertical-align: middle;padding: 10px 15px}
.book_steps3 .detail input[type="text"]{width: 63px;margin-right: 5px;padding: 0 10px;text-align: right;}
.book_steps3 .detail input[type="text"],.book_steps3 .detail button{height: 33px}
.book_steps3 .detail .reset{width: 117px}
.book_steps3 .detail .reset button{width: 100%}
.book_steps3 .detail .plus{width: 230px}
.book_steps3 .detail .tit{width: 250px}
.book_steps3 .detail .price{width: 150px}
.book_steps3 .detail .plus{margin-left:-3% ;}
.book_steps3 .detail .plus button{float: left; width: 20.3333333333333%;margin-left: 3%;}
.book_steps3 .detail .plus .w100{width: 97% !important;float: none}

.serial_w input{width: 115px;height: 35px;font-size: 15px;}
.serial_w .dash{margin: 0 5px; color: #b9b9b9}
.serial_w button{height: 35px;font-size: 15px;padding: 0 20px;margin-left: 10px;}



.pop_cancle{position: relative;}
.pop_cancle.o{padding-right: 230px;}
.pop_cancle .side{position: absolute;right: 0;top:0;width: 230px;background: #f9f2f7;padding-top: 75px;height: 100%}
.pop_cancle .side .t{font-size: 25px; padding: 0 20px;margin-bottom: 15px;}
.pop_cancle .side ul{border-top: 1px solid #efdbe9;}
.pop_cancle .side li{padding: 15px;border-bottom: 1px solid #efdbe9;}
.pop_cancle .side label{margin-left: 3px;}
.cancle_w{margin-left: -2%;}
.cancle_w > dl{float: left; width: 31.3333333333333%;margin-left: 2%;background: #f8f8f8;border:1px solid #ddd}
.cancle_w dt{padding: 10px 15px;font-size: 16px;background: #fff;font-weight: 500;}
.cancle_w dd{padding: 10px 15px;font-size: 13px;border-top: 1px solid #ddd;position: relative;letter-spacing: 0;}
.cancle_w dd:after{content: '';display: block;clear: both}
.cancle_w dd .dd{float: right;}
.cancle_w .total{text-align: right;font-size: 20px;font-family: 'Noto Sans KR';}
.cancle_w .total .dt{position: absolute;left: 15px;bottom: 15px;font-size: 13px;color: #333}

.caution .bul-dot > li > strong{display: block;margin-bottom: 10px;}
.caution .bul-dot2 > li{margin-top: 15px;}
.caution .bul-dot2 > li:first-child{margin-top: 0;}

.book_th .label-st1{margin-right: 5px;}
.book_com .bul-mark{font-size: 13px;margin-bottom: 10px;}
.book_com .pack_s{padding: 10px 140px 10px 10px;position: relative;}
.book_com .pack_s select{position: absolute;right: 0;top:50%;width: 125px;height: 28px;margin-top: -14px;}

.pack_s input{margin-right: 5px;}
.pack_s_l{display: block;white-space: nowrap;overflow: hidden;text-overflow: ellipsis;}
.pack_price{font-size:15px;padding-top: 10px;text-align: right;position: relative;}
.pack_price:before{position: absolute;left: 0;top:-1px;width: 100%;height: 1px;background: #0f0f71;content: ''}

.non .box-st1{border-bottom: 0;}
.package .book_com{height: 200px}

.pay_com{margin: -1.5% 0 0 -1.5%;}
.pay_com li{position: relative;float: left;width: 18.5%;margin: 1.5% 0 0 1.5%;}
.pay_com input {position:absolute;top:0;left:0;width:100%;height: 100%;margin: 0;}
.pay_com input:checked+label{border:1px solid #000}
.pay_com label{position: relative;z-index: 1;display: block;background: #fff;height: 97px;border:1px solid #ddd;}
.pay_com label img{left: 0;top:0;right: 0;bottom: 0;margin:auto;position: absolute;display: block;max-width: 95%;max-height: 95%}

.pay_com2 .group{margin-top: 2em;color: #000;}
.pay_com2 .group:first-child{margin-top: 0;}
.pay_com2 .group > ul{border-top: 1px solid #d1d1d1;}
.pay_com2 .group > ul > li{position: relative;padding: 8px 0 8px 200px;border-bottom: 1px solid #d1d1d1;line-height: 33px;}
.pay_com2 .group .t{position: absolute;left: 30px;top:8px;}
.pay_com2 input[type="text"],.pay_com2 select{height: 33px;width: 191px}
.pay_com2 input[type="text"]:disabled{background: none;padding-left: 0;padding-right: 0;background: none !important;border:0}
.pay_com2 .tel input[type="text"],.pay_com2 .tel select{width: 93px}
.pay_com2 .tel input[type="text"]{margin-left: 3px;}
.pay_com2 .email input[type="text"]{width: 160px}
.pay_com2 .email input[type="text"]:last-child{width: 240px}
.pay_com2 .email .dash{margin: 0 5px;}
.pay_com2 .txt{margin-top: 10px;font-size: .933em;}
.pay_com2 .radio{line-height: 33px;}
.pay_com2 .radio label{margin: 0 30px 0 3px;}
.pay_com2 .radio label:last-child{margin-right: 0;}
.pay_com2 .detail{display: none;}
.book_steps3 .detail {
  border-top: 1px solid #ddd;
}
.book_steps3 .detail .tit {
  width: 250px;
}
.book_steps3 .detail ul li {
  display: table-cell;
  vertical-align: middle;
  padding: 10px 15px;
}
li {
  display: list-item;
  text-align: -webkit-match-parent;
}
.dot {
  font-family: 'dotum','Noto Sans KR','맑은고딕',Malgun Gothic,Arial;
}
</style>
