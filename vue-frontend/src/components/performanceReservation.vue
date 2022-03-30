<template>
  <div>
    <Header/>
    <div class="performance">
  <section class="">
    <div style="margin:10px;">
      <ul class="nav nav-tabs">
        <li class="active"><a href="#program" data-toggle="tab">1.프로그램</a></li>
        <li><a href="#place" data-toggle="tab">2.장소</a></li>
        <li><a href="#date" data-toggle="tab">3.날짜</a></li>
        <li><a href="#episode" data-toggle="tab">4.회차</a></li>
        <li><a href="#personnel" data-toggle="tab">5.인원</a></li>
        <li><a href="#payment" data-toggle="tab">6.결제</a></li>
      </ul>
      <!-- Tab이 선택되면 내용이 보여지는 영역이다. -->
      <div class="tab-content">
        <!-- 각 탭이 선택되면 보여지는 내용이다. 태그는 div이고 클래스는 tab-pane이다. -->
        <!-- active 클래스는 현재 선택되어 있는 탭 영역이다. -->
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
          <input type="date">
        </form>
            </li>
            <li>

            </li>
          </ul>

        </div>
        <!-- id는 고유한 이름으로 설정하고 tab의 href와 연결되어야 한다. -->
        <div class="tab-pane fade" id="place">place 메뉴</div>
        <div class="tab-pane fade" id="date">date 메뉴</div>
        <!-- fade 클래스는 선택적인 사항으로 트랜지션(transition)효과가 있다.
         in 클래스는 fade 클래스를 선언하여 트랜지션효과를 사용할 때 in은 active와 선택되어 있는 탭 영역의 설정이다. -->
        <div class="tab-pane fade" id="episode">episode 메뉴</div>
        <div class="tab-pane fade" id="personnel">personnel 메뉴</div>
        <div class="tab-pane fade" id="payment">payment 메뉴</div>
      </div>
      <button style="float: left">예매확인 및 취소</button>
      <button style="float:right;">예매확인</button>

    </div>
  </section>
      </div>
<Footer/>


  </div>
</template>

<script>
import Footer from "./footer";
import Header from "./header";
export default {
  name: "performance-reservation",
  components: {Header, Footer}
}
</script>

<style scoped>
.seat-reservation{
  justify-content: center;
  padding: 30px;

}
.table-item{
  padding-left: 30px;
}

</style>
