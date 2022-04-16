<template>
  <div class="body">
    <div class="inner">
      <div class="sub-t">
        <h2 class="t" style="font-size: 2.5rem; margin-block-start: 0.83em; margin-block-end: 0.83em;margin-inline-start: 0.83em;
            margin-inline-end: 0.83em; font-weight: bold;text-align: center; line-height: 1.15; letter-spacing: -0.03em;">
          세종문화회관 소개</h2>
      </div>
      <div class="tab-box">
        <ul class="tabs-st1 clearfix li5">
          <li v-for="(tab, index) in tabList2" :key="index" :class="{active:currentTab2 === index}">
            <div class="tab-content">
              <a href="#" @click.prevent="currentTab2 = index" class="contents">{{ tab }}</a>
            </div>
          </li>
        </ul>
      </div>
      <div>
        <!--개요-->
        <div>
            <div v-show="currentTab2 == 0" class="tab-cont">
              <div class="contents">
                <div class="tab-box">
                  <ul class="tab-btn-list">
                    <li v-for="(tab, index) in tabList" :key="index" :class="{active:currentTab === index}" style="padding: 20px">
                      <div class="tab-content">
                        <a href="#" @click.prevent="currentTab = index">{{ tab }}</a>
                      </div>
                    </li>
                  </ul>
                </div>
                <!--개요-->
                <div v-show="currentTab == 0" class="tab-cont">
                  <article class="sub_page" style="display: block; font-size: 14px">
                    <div class="inner f18 intro_outline" style="margin: 50px">
                      <div class="top-st1">
                        <div class="tit-st2" style="text-align: center"><span class="block-pc">세종문화회관은 서울특별시가 설립한</span>
                          기관으로 서울의 대표적인 <strong class="color-purple">문화예술기관</strong>입니다.
                        </div>
                        <p class="txt" style="text-align: center"><span class="block-pc"
                                                                        style="text-align: center">
              1978년 준공, 1999년 재단법인으로 재 탄생하여 한국 공연 문화의 산실이자</span>
                          서울시공연예술의 허브역할을 다하고 있습니다.</p>
                      </div>
                      <ul class="cont-st1 clearfix">
                        <li class="l">
                          <ul class="s">
                            <li><img src="src/assets/images/outline.jpg" alt="세종문화회관 건물 사진"></li>
                          </ul>
                        </li>
                        <li class="r">
                          <h3 class="f26 t">세종문화회관은 1961년 우남회관으로 출발해,
                            <strong class="color-purple block-pc">1972년 화재로 소실된 시민회관의 뒤를 이어 1978년 4월 14일
                              개관하였습니다.</strong></h3>
                          <p class="txt">
                            세계 유수의 공연장으로 인정받는 한국 공연예술의 등용문이자 국제공연예술의 유일한 통로였고 70~80년대에는 한국 순수예술의
                            요람이었습니다.<br><br>
                            이처럼 세종문화회관은 한국 공연예술의 살아있는 역사이자 예술을 사랑하는 사람들의 추억의 공간, 그리고 한국을 대표하는 문화예술기관으로 20여 년간
                            그
                            명성을 유지해 왔습니다. 1999년에는 21세기를 앞두고 또 한 번의 도약을 위해 재단법인으로 출범했습니다. 재단법인 세종문화회관의 출범은 창의성과
                            자율성이 강조되는 민간문화예술 활성화의 신호탄이자 한국문화예술의 세계화를 향한 첫걸음이었습니다.
                            <br><br>
                            이후 세종문화회관은 세종대극장 리모델링에 이어 세종체임버홀, 세종M씨어터, 예술동 증축, 세종미술관, 세종S씨어터 등 하드웨어의 개편을 진행했고
                            예술로
                            동행 등 각종 문화행사를 통하여 서울시 문화예술 허브의 역할을 다하고 있습니다. 문화예술인들에게는 창작과 발표의 공간으로 문화를 사랑하는
                            대중들에게는
                            아름다움과 자긍심을 심어줄 복합공간으로서 언제나 서울시민들과 함께할 것입니다.
                            <br><br>
                            세종문화회관은 문화향유 기회를 확대하고, 문화 창달에 기여할 수 있는 문화예술 운영을 통해 시민문화 복지구현에 이바지함을 설립목적으로 시민이 더
                            행복한
                            예술 랜드마크를 만들어 가고 있습니다.
                          </p>
                        </li>
                      </ul>
                    </div><!-- .inner -->
                  </article>
                </div>
                <br>
                <!-- 연혁-->
                <div v-show="currentTab == 1">
                  <article class="sub_page">
                    <div class="inner f18">
                      <div class="history clearfix">
                        <div class="group r clearfix" style="border: #ce8483">
                          <h3 class="year color-purple">2000년대 ~ 현재</h3>
                          <ol class="in">
                            <li class="item">
                              <strong class="date">2019.06.19</strong>
                              <div class="cont">세종 아티스트라운지 개관
                              </div>
                            </li>
                            <li class="item">
                              <strong class="date">2019.05.28</strong>
                              <div class="cont">라바키즈 아이들세상 개관
                              </div>
                            </li>
                            <li class="item">
                              <strong class="date">2018.10.18</strong>
                              <div class="cont">
                                세종 S씨어터 개관
                                <div class="img"><img src="/src/assets/images/2018-1.jpg" alt="세종 S씨어터 이미지">
                                </div>
                              </div>
                            </li>
                            <li class="item">
                              <strong class="date">2015.04.06</strong>
                              <div class="cont">
                                세종미술관 재개관
                              </div>
                            </li>
                            <li class="item">
                              <strong class="date">2012.12.01</strong>
                              <div class="cont">
                                세종예술동 증축
                              </div>
                            </li>
                            <li class="item">
                              <strong class="date">2011.01.15</strong>
                              <div class="cont">예술이 있는 외식공간 광화문 아띠 조성
                              </div>
                            </li>
                            <li class="item">
                              <strong class="date">2010.04.28</strong>
                              <div class="cont">충무공이야기 개관
                              </div>
                            </li>
                            <li class="item">
                              <strong class="date">2009.10.17</strong>
                              <div class="cont">북서울 꿈의 숲 아트센터 개관
                              </div>
                            </li>
                            <li class="item">
                              <strong class="date">2009.10.09</strong>
                              <div class="cont">세종이야기 개관

                              </div>
                            </li>
                            <li class="item">
                              <strong class="date">2007.12.01</strong>
                              <div class="cont">세종M씨어터 개관
                                <div class="img"><img src="/src/assets/images/2007-1.jpg" alt="세종  M씨어터 이미지">
                                </div>
                              </div>
                            </li>
                            <li class="item">
                              <strong class="date">2007.06.19</strong>
                              <div class="cont">세종예술 아카데미 개원
                              </div>
                            </li>
                            <li class="item">
                              <strong class="date">2007.03.31</strong>
                              <div class="cont">세종 예술의 정원 완공
                              </div>
                            </li>
                            <li class="item">
                              <strong class="date">2006.08.14</strong>
                              <div class="cont">세종체임버홀 개관
                                <div class="img"><img src="/src/assets/images/2006-1.jpg" alt="세종  체임버홀 이미지">
                                </div>
                              </div>
                            </li>
                            <li class="item">
                              <strong class="date">2004.03.02</strong>
                              <div class="cont">대극장 시설 개,보수공사 준공 및 재개관
                                <div class="img"><img src="/src/assets/images/2004-1.jpg" alt="세종  대극장 이미지">
                                </div>
                              </div>
                            </li>
                          </ol>
                        </div>
                      </div>

                      <div class="history clearfix mt">
                        <div class="group l clearfix">
                          <h3 class="year color-purple">1990 ~ 1930년대</h3>
                          <ol class="in">
                            <li class="item">
                              <strong class="date">1999.07.01</strong>

                              <div class="cont">
                                재단법인 세종문화회관 설립 출범
                              </div>
                            </li>
                            <li class="item">
                              <strong class="date">1978.07.01</strong>

                              <div class="cont">
                                세종문화회관 증축

                              </div>
                            </li>
                            <li class="item">
                              <strong class="date">1978.04.14</strong>

                              <div class="cont">
                                세종문화회관 준공 및 개관
                                <div class="img"><img src="/src/assets/images/1978-1.jpg" alt="세종문화회관 건물 이미지">
                                </div>
                              </div>
                            </li>
                            <li class="item">
                              <strong class="date">1974.01.01</strong>

                              <div class="cont">
                                세종문화회관 착공
                              </div>
                            </li>
                            <li class="item">
                              <strong class="date">1961.11.07</strong>

                              <div class="cont">
                                시민회관 개관식
                                <div class="img"><img src="/src/assets/images/1691-1" alt="시민회관 이미지"></div>
                              </div>
                            </li>
                            <li class="item">
                              <strong class="date">1961.10.31</strong>

                              <div class="cont">
                                우남회관 준공
                              </div>
                            </li>
                            <li class="item">
                              <strong class="date">1960.08.11</strong>

                              <div class="cont">
                                우남회관을 시민회관으로 변경
                              </div>
                            </li>
                            <li class="item">
                              <strong class="date">1956.06.20</strong>

                              <div class="cont">
                                우남회관 건물 기공식
                              </div>
                            </li>
                            <li class="item">
                              <strong class="date">1935.12.10</strong>

                              <div class="cont">
                                부민관 완공
                              </div>
                            </li>
                            <li class="item">
                              <strong class="date">1934.07.03</strong>
                              <div class="cont">
                                부민관 기공
                              </div>
                            </li>
                          </ol>
                        </div>
                      </div>
                    </div><!-- .inner -->
                  </article>
                </div>
                <br>
                <!--비전-->
                <div v-show="currentTab == 2" class="tab-cont">
                  <article class="sub_page">
                    <div class="inner f18 vision">
                      <div class="tit f26">
                        <strong class="l"><span class="vertical" style="font-size: 23px; font-weight: bold">VISION</span></strong>
                        <p>특별한 경험으로 시민 삶에 가치를 더하는,<br><span class="big-size">세종문화회관</span></p>
                      </div>
                      <div class="renew-box">
                        <div class="left-tit">전략목표</div>
                        <ul class="top-li">
                          <li>세계예술의 흐름을 선도하는 제작극장</li>
                          <li>최고의 예술 작품으로 차별화하는 예술단</li>
                          <li>시민의 삶에 변화를 가져오는 예술</li>
                        </ul>
                      </div>
                      <div class="renew-box tops">
                        <div class="left-tit">전략과제</div>
                        <ul class="middle-li">
                          <li>
                            <div class="num-top1"><span
                              class="num-top"><strong>I. 세계수준의 콘텐츠 제작극장</strong></span><br></div>
                            <div class="num-bot">1. 공연장 운영방식의 전환 '세종시즌'<br>2. 프로그램 제작 방식의 변화<br>3. MZ세대 중심의
                              콘텐츠 제작
                            </div>
                          </li>
                          <li>
                            <div class="num-top1"><span
                              class="num-top"><strong>II. 예술단의 변화와 혁신</strong></span><br></div>
                            <div class="num-bot">4. 새로운 예술 리더십 발굴<br>5. 서울에술단의 정채성 회복<br>6. 청소년예술단 운영반향 정립
                            </div>
                          </li>
                          <li>
                            <div class="num-top1"><span
                              class="num-top"><strong>III. 시민 예술 프로그램 확대</strong></span><br></div>
                            <div class="num-bot">7. 트렌디한 '예술교육, 전시'<br>8. 시민 문화 충전 프로젝트<br>9. 디지털 공간으로 확장
                            </div>
                          </li>
                          <li>
                            <div class="num-top1"><span class="num-top">IV. 복합문화공간 가치 창출</span><br></div>
                            <div class="num-bot">10. 세종문화회관 공간 재구조화<br>11. 무대기계, 설비 및 접근성 개선 (리모델링)<br>12. 시민
                              편의시설 확충
                            </div>
                          </li>
                          <li>
                            <div class="num-top1"><span class="num-top">V. 지속가능 경영체계 구축</span><br></div>
                            <div class="num-bot">13. 조직역량 및 재정 건전성 강화<br>14. 사회적 책임 실천(ESG경영)<br>15. 안전 경영 체계
                              마련
                            </div>
                          </li>
                        </ul>
                      </div>
                      <div class="renew-box third">
                        <div class="left-tit">기반</div>
                        <ul class="middle-li grey">
                          <li>
                            <span style="font-weight: bold"><strong>문화예술의 살아 있는 역사, 대한민국을 대표하는 문화예술기관</strong></span>
                          </li>
                        </ul>
                      </div>

                      <div class="renew-box fourth">
                        <div class="left-tit">핵심가치</div>
                        <ul class="middle-li botts">
                          <li>
                            <div class="num-top1"><span class="num-top">차 의 (Creative)</span><br></div>
                            <span class="num-bot">창의성을 예술가와 협력하려는 의지</span>
                          </li>
                          <li>
                            <div class="num-top1"><span class="num-top">도 전 (Challenge)</span><br></div>
                            <span class="num-bot">위험을 극복하려는 용기와 도전</span>
                          </li>
                          <li>
                            <div class="num-top1"><span class="num-top">통 찰 (Insight)</span><br></div>
                            <span class="num-bot">역사와 경험으로부터 배우는 통찰</span>
                          </li>
                        </ul>
                      </div>
                    </div>
                  </article>
                </div></div>
            </div>
        </div>
        <!--CEO인사말-->
        <div>
          <div v-show="currentTab2 == 1" class="tab-cont">
            <div class="contents" >

              <div class="inner f18">
                <div class="top-st1">
                  <div class="tit-st2" style="text-align: center"><!--<span class="block-pc">개관 40주년,</span>-->
                    <h2 style="text-align: center; padding: 30px;">CEO인사말</h2>
                    <strong class="color-purple">예술로 시민의 삶이 변화하는 곳, </strong>
                    세종문화회관에 오신 것을 환영합니다! </div>
                </div>
                <ul class="cont-st1 clearfix ceo" style="display: flex; margin: 15px; text-align: center;justify-content: center">
                  <li class="l">
                    <br>
                    <img src="src/assets/images/ceo.jpg" alt="세문화회관사장 사진" >
                  </li>
                  <li class="r" style="width: 750px; margin-left: 10px">
                    <p>1978년 개관한 세종문화회관은 문화예술계의 살아있는 역사이자 한국을 대표하는 문화예술기관입니다.  또한 시민들의 예술적 참여와 향유 확대를 위해 힘쓰며, <br>서울시 문화예술 허브로서의 역할을 다하고 있습니다. <br><br>예술공간의 정통성을 잇고 있는 세종문화회관은 한걸음 더 나아가 세계적 수준의 공연과 전시, 교육을 선보이는 최고의 문화예술 명소로 자리매김하기 위해 끊임없이 변화하고 있습니다.  특히 서울시예술단의 창작역량을 바탕으로 도전적이고 차별화된 작품을 선보임으로써 시대적 요구에 부응하는 제작극장의 정체성을 확고히 하고자 합니다.<br>이를 통해 세종문화회관을 서울의 품격과 문화적 긍지를 보여주는 세계적 예술공간으로 만들어나가겠습니다. <br><br>예술로 시민의 삶에 변화를 가져오는 예술의 명소,<br>세계적 예술의 흐름을 선도하는 세종문화회관으로 시민 여러분과 함께 하겠습니다. <br>감사합니다. <br><br>
                      <img src="src/assets/images/sign.jpg" alt="세종문화회관 사장 안호상 " width="526" height="93">
                    </p>
                  </li>
                </ul>
              </div>
            </div>
          </div>
        </div>
        <!--CI소개-->
        <div>
          <div v-show="currentTab2 == 2" class="tab-cont">
            <div class="contents">
              <div style="text-align: center">
                <br><br>
                <p class="txt">
                  전지인을 3채널 컬러 팔레트 시스템으로 구현합니다.<br><br>
                  천(天)은 하늘색, 지(地)는 황토색, 인(人)은 노란색을 기본으로 하되 총천연색으로 변경 가능한 변수를 두어, 인간(관람객)의 다양성을 표상합니다.
                </p>
                <img src="src/assets/images/color.jpg">
              </div>
            </div>
          </div>
        </div>
        <div>
          <div v-show="currentTab2 == 3" class="tab-cont">
            <div class="contents" style="text-align: center">
              <img src="src/assets/images/hierarchy.jpg">
            </div>
          </div>
        </div>
        <div>
          <div v-show="currentTab2 == 4" class="tab-cont">
            <div class="contents">
              <div class="rows" style="margin:90px; padding:0px;width: 1200px;text-align: center; justify-content: center; display: grid">
                <div >
                  <a href="http://sjartgroups.or.kr/sjartgroups/main/main.do" value="바로가기">
                    <img src="src/assets/images/bg_08.jpg"></a >
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <br>

    </div>
  </div>

</template>
<script>
export default {
  name: "SjIntroduce",
  data() {
    return {
      currentTab: 0,
      currentTab2: 0,
      tabList: ['개요', '연혁', '비전'],
      tabList2: ['개요', 'CEO인사말', 'CI소개', '조직도', '예술단소개']
    }
  }
}
</script>
<style scoped>
a {
  font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;

  color: #000000;
}
p {
  display: block;
  margin-block-start: 1em;
  margin-block-end: 1em;
  margin-inline-start: 0px;
  margin-inline-end: 0px;
}

body {
  line-height: 1.5;
  color: #333;
  overflow-y: scroll;
  font-weight: 300;
  letter-spacing: -0.03em;
}

.inner {
  max-width: 1400px;
  margin: 0 auto;
}

.tab-btn-list {
  justify-content: center;
  display: flex;
  width: 640px;
  margin: 4em auto;
}

.tab-content {
  border-right-color: grey;
}

h2, ul {
  margin: 0;
  padding: 0;
  border: 0;
}

.tabs-st1 {
  font-size: 1.125rem;
  margin-bottom: 1.667em;
  border: 1px solid #000;
  text-align: center;
  border-right: 0;
  border-bottom: 0;
}

ol, li {
  margin-top: 10px;
  text-align: center;
  list-style: none;
}

.tabs-st1 {
  border-color: rgba(0, 0, 0, 0.05);
  position: relative;
  display: flex;
  width: 1280px;
  background: #fff;
  box-shadow: 5px 5px 5px rgba(0, 0, 0, 0.1);
  margin: auto;

}

.tabs-st1 > li {
  flex: 1;
  height: 50px;
}

.tabs-st1 > li > div {
  display: grid;
  text-align: center;
  height: 50px;
}

.tabs-st1 > li > span {
  margin-top: 30px;
  padding-top: 30px;
}
.top-st1 .tit-st2 {
  margin-bottom: 0;
}
.tit-st2 {
  font-size: 34px;
  font-size: 2.125rem;
  text-align: center;
  line-height: 1.15;
  margin-bottom: 1.1em;
  font-weight: 500;
  word-break: keep-all;
}


.vision {
  background: url("https://www.sejongpac.or.kr/static/organization/img/intro/vision_new.gif") center 60px no-repeat;
}

.contents {
  color: #000000;
  margin-top: 5px;
  margin-bottom: 5px;
  font-size: 20px;
  font-weight: 100;
}

.year {
  margin: 50px;
  color: #c36d15;
  font-weight: bold;
}

.vertical {
  display: table-cell;
  vertical-align: middle;
}

.vision .tit {
  width: 580px;
  margin: 0 auto;
  background: #ffe902;
  border-radius: 100px;
  color: #000;
  text-align: center;
  display: table;
  height: 130px;
  position: relative;
  line-height: 1.35;
  font-weight: 700;
}

.vision .tit p {
  display: table-cell;
  vertical-align: middle;
  font-size: 1.325rem;
  padding-left: 18%;
  line-height: 1.6;
}

.vision .tit .big-size {
  font-size: 1.65rem;
}

.vision .tit .l {
  position: absolute;
  left: 0;
  display: table;
  width: 130px;
  height: 130px;
  border-radius: 50%;
  background: #fff9bb;
  font-size: 0.846em;
  font-weight: 500;
}

.vision .group_w > li {
  width: 31.3333333333333%;
  margin-left: 2%;
  border: 1px solid #ddd;
  background: #fff;
  float: left;
  padding: 0 40px 40px
}

.vision .t span {
  display: table-cell;
  vertical-align: middle;
}

.vision .renew-box {
  display: flex;
  justify-content: space-between;
  margin: 80px 0 50px 0;
  align-items: center;
}

.vision .renew-box.tops {
  align-items: flex-start;
}

.vision .top-li {
  display: flex;
  justify-content: space-between;
  width: 85%;
}

.vision .top-li li {
  background: #111;
  padding: 15px 40px;
  border: 1px solid #111;
  border-radius: 30px;
  color: #fff;
  font-size: 1.25rem;
  word-break: keep-all;
  margin-right: 0.5em;
}

.vision .left-tit {
  width: 15%;
  font-size: 1.625rem;
  font-weight: bold;
}

.vision .middle-li {
  display: flex;
  justify-content: space-between;
  width: 85%;
}

.vision .middle-li li {
  width: 18%;
  border: 1px solid #111;
  border-radius: 30px;
  padding: 20px;
  background: #fff;
}

.vision .middle-li li .num-top1 {
  border-bottom: 1px solid #ccc;
  padding-bottom: 20px;
  margin-bottom: 20px;
}

.vision .num-top {
  font-size: 1.125rem;
  font-weight: 500;
  word-break: keep-all;
}

.vision .middle-li .num-bot {
  font-size: 0.875rem;
  word-break: keep-all;
  line-height: 1.3;
}

.vision .middle-li.grey li {
  width: 100%;
  border: 1px solid #ccc;
  border-radius: 30px;
  padding: 15px;
  background: #ccc;
  text-align: center;
  font-size: 1.625rem;
  font-weight: 500;
  word-break: keep-all;
}

.vision .middle-li.botts li {
  width: 28%;
  border: 1px solid #eee;
  border-radius: 30px;
  padding: 20px 35px;
  background: #eee;
  text-align: center;
}

.vision .middle-li.botts li > div {
  margin-bottom: 10px;
  padding-bottom: 10px;
}

.vision .middle-li.botts li .num-top {
  font-size: 1.5rem;
}

</style>
