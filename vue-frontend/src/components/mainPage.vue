<template>
  <div>
    <section id="body-main" class='bg-white '>
      <button type="button" class="btn-default" id="reservation">예매하기</button>
      <button type="button" class="btn-primary" id="details">상세보기</button>
      <div class="container">
        <div class="row">
          <div class="main_home text-center" >
            <div class="home_text" >
            </div>
          </div>
        </div><!--End off row-->
      </div><!--End off container -->
    </section> <!--End off Home Sections-->
  </div>

</template>

<script>
export default {
  name: "mainPage",
}
</script>

<style scoped>
#body-main {
  position: relative;
  width: 1920px;
  height: 960px;
  background: url(../assets/images/background/sample.jpg) no-repeat bottom center;
  z-index: 1;
  overflow-x: hidden;
}

#reservation {
  position: absolute;
  left: 25%;
  top : 620px;
}

#details {
  position: absolute;
  left: 35%;
  top : 620px;
}
</style>
