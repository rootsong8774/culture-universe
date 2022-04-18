<template>
  <div>
    <section class="section section-faq">
      <div class="container mx-auto">
        <h1>FAQ</h1>
        <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
          <div class="panel panel-default">
            <div class="panel-heading" role="tab" id="headingOne">
              <h4 class="panel-title">
                <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne"
                   aria-expanded="true" aria-controls="collapseOne">
                  Q. 공연 시작 몇 분 전부터 입장이 가능한가요? </a>
              </h4>
            </div>
            <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
              <div class="panel-body">
                <div>
                  일반적으로 공연시작 30분 전부터는 객석에 입장이 가능하며, 원활한 공연 진행을 위해<br>늦어도 공연시작 10분 전까지는 입장하여 주시기 바랍니다.
                </div>
              </div>
            </div>
          </div>
          <div class="panel panel-default">
            <div class="panel-heading" role="tab" id="headingTwo">
              <h4 class="panel-title">
                <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo"
                   aria-expanded="false" aria-controls="collapseTwo">
                  Q. 예매한 티켓 취소/변경/환불은 언제까지 가능한가요?
                </a>
              </h4>
            </div>
            <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
              <div class="panel-body">
                <div>
                  관람일 전일 오후 5시까지 가능하며 (평일/주말(토,일,공휴일) 모두 해당)<br>
                  관람일 당일에는 취소, 변경, 환불이 불가 합니다.
                </div>
              </div>
            </div>
          </div>
            <div class="panel panel-default">
              <div class="panel-heading" role="tab" id="headingThree">
                <h4 class="panel-title">
                  <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                    Q. 티켓 예매 후 어떻게 수령하나요?
                  </a>
                </h4>
              </div>
              <div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
                <div class="panel-body">
                  예매티켓의 수령은 공연당일 공연장 로비의 현장매표소 수령과 세종문화회관 서비스플라자 방문수령 가능합니다.
                  <br>인터넷 예매의 경우, 예매확인서 또는 예매번호를 반드시 지참해 주시기 바랍니다. </div>
              </div>
          </div>
          <div class="panel panel-default">
            <div class="panel-heading" role="tab" id="headingFour">
              <h4 class="panel-title">
                <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
                  Q. 인터넷 예매시 오류가 났습니다
                </a>
              </h4>
            </div>
            <div id="collapseFour" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingFour">
              <div class="panel-body">
                세종문화회관 콜센터 (02-399-1000, 오전 9시부터 오후 8시까지 연중무휴)로 문의해 주시기 바랍니다. </div>
            </div>
          </div>
          <div class="panel panel-default">
            <div class="panel-heading" role="tab" id="headingFive">
              <h4 class="panel-title">
                <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseFive" aria-expanded="false" aria-controls="collapseFive">
                  Q. 공연중 자막을 볼 수 있나요?
                </a>
              </h4>
            </div>
            <div id="collapseFive" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingFive">
              <div class="panel-body">
                세종문화회관은 대극장 1층과 2층 좌석 앞쪽에 LCD모니터가 부착되어 있어 편리하게 자막을 보실 수 있습니다.
                <br>대극장 3층은 좌우 벽면과 천정 중앙에 대형 스크린이 설치되어 있습니다. </div>
            </div>
          </div>
          <div class="panel panel-default">
            <div class="panel-heading" role="tab" id="headingSix">
              <h4 class="panel-title">
                <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseSix" aria-expanded="false" aria-controls="collapseSix">
                  Q. 최근 공연 정보를 알고 싶습니다.
                </a>
              </h4>
            </div>
            <div id="collapseSix" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingSix">
              <div class="panel-body">
                홈페이지→공연일정 또는 콜센터(02-399-1000, 오전 10시부터 오후 8시까지 연중무휴)를 통해 공연 정보를 접하실 수 있습니다 </div>
            </div>
          </div>
        </div>
<!--        accordian end-->
      </div>

    </section>
  </div>
</template>

<script>

export default {
  name: "faq",

}
</script>

<style>

.faq-box__question {
  cursor: pointer;
}

.faq-box__question::after {
  content: "▼";
  float: right;
}

.faq-box > ul > li {
  padding: 10px;
}

.faq-box > ul > li.hover > .faq-box__question::after {
  content: "▲";
}

.faq-box__answer {
  display: none;
  background-color: rgba(0, 0, 0, 0.3);
  border-radius: 10px;
  padding: 10px;
}
</style>
