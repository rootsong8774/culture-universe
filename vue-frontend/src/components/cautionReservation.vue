<template>
<div>
  <div class="in pop-st1 pop-ex">
    <div class="tit-st2">
      <h2 class="t">예매 유의사항</h2>
      <button type="button" id="pop_NoticeClosebtn1" class="close-st1" alt="예매 유의사항 닫기 버튼" tabindex="4" onclick="javascript:popNoticeClose();return false;">CLOSE</button>
    </div>
    <div class="cont" tabindex="5">
      <ul class="bul-dot dot">
        <li>구매 매수 제한이 적용되는 할인티켓 구매 시, 제한 매수 확인 바랍니다.<br>
          (초과 구매 또는 증빙자료 미지참시 할인 불가. 차액 지불 후 티켓 수령 가능)</li>
        <li>장애인석(휠체어석)은 휠체어 사용 장애인 전용공간으로 좌석이 존재하지 않으니 구매 시 주의 바랍니다.<br>
          (현장에서 휠체어 미사용 시, 티켓 수령 및 입장이 제한됩니다.)</li>
        <li>예매 및 환불관련 자세한 사항은 홈페이지 예매안내를 참고 바랍니다.</li>
        <li>공연에 따라 입장연령이 제한될 수 있습니다.</li>
      </ul>
      <button type="button" id="pop_NoticeClosebtn2" alt="예매 유의사항 확인 버튼" class="btn-st1 bg-purple" tabindex="6" onclick="javascript:popNoticeClose();return false;">확인</button>
    </div>
  </div>
</div>
</template>

<script>

export default {
  name: "cautionReservation"
}
</script>

<style scoped>

.tit-st2 button{position: absolute; right: 20px;top:50%;margin-top: -12px}
.tit-st2{padding: 15px 20px;font-size: 26px; position: relative;color: #000;border-bottom: 1px solid #ccc;;}
.tit-st2 .t{position: relative;padding-left: 50px;}
.caution .bul-dot > li > strong{display: block;margin-bottom: 10px;}
.pop-ex .bul-dot > li:first-child{margin-top: 0;}
.pop-ex .bul-dot > li{margin-top: 25px;}
.bul-dot > li{position: relative;padding-left: 15px;margin-top: 5px;}
.bul-dot > li:before:before{position: absolute;left: 0;top:0.5em;width: 5px;height: 5px;background: #333;content: '';border-radius: 50%}
.bul-dot > li:first-child{margin-top: 0;}

.btn-st1{width: 200px;height: 53px;display: block;font-size: 17px;}
a.btn-st1{line-height: 50px;}
</style>
