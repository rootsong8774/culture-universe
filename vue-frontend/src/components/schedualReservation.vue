<template>
  <div>
    <section id="body-schedual-reservation-caution">
      <ul class="list-caution">
        <li>
          예매유의사항
        </li>
        <li>
          <div>
            <form class="exit">
              close<img src="../assets/images/item1.jpg" width="50px" onclick="window.close()"
                        style="cursor: hand">
            </form>
          </div>
        </li>
      </ul>
      <div>
        <ul class="list-group">
          <li>유의사항은 이미지로 대체???</li>
          <li>유의사항은 이미지로 대체???</li>
          <li>유의사항은 이미지로 대체???</li>

        </ul>
        <div class="correct">
          <button type="button">확인</button>
        </div>
      </div>
    </section>
  </div>
</template>

<script>


export default {
  name: "SchedualReservation",

}
</script>

<style scoped>
.list-caution {

  padding: 10px;
  margin: 5px;
  display: flex;
}

.list-caution > img {
  justify-content: flex-end;
}

.list-group > li {
  justify-content: center;
  display: flex;
}

.correct {
  justify-content: center;
  display: flex;
}

.exit {
  justify-content: flex-end;
}

</style>
