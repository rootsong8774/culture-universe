<template>
  <div class="">
    <div class="container">
      <div class="container-fluid py-5">
        <div class="sub-t">
          <h2 class="t" style="font-size: 2.5rem; margin-block-start: 0.83em; margin-block-end: 0.83em;margin-inline-start: 0.83em;
            margin-inline-end: 0.83em; font-weight: bold;text-align: center; line-height: 1.15; letter-spacing: -0.03em;">
            시설 소개</h2>
        </div>
      </div>
      <div class="content-round">
        <ul class="tabMenu">
          <li class="tabItem" v-for="(tab, index) in tabList" :key="index"
              :class="{active:currentTab === index}">
            <div class="tabContent">
              <a href="#" @click.prevent="currentTab = index">{{ tab }}</a>
            </div>
          </li>
        </ul>
        <br>
        <br>
        <div>
          <div v-show="currentTab == 0" class="tab-cont">
            <img id="theater" src="src/assets/images/t1.jpg" alt="대극장 이미지"><br>
          </div>
          <div v-show="currentTab == 1" class="tab-cont">
            <img id="mTheater" src="src/assets/images/t2.jpg" alt="세종M씨어터 이미지"><br>
          </div>
          <div v-show="currentTab == 2" class="tab-cont">
            <img id="cTheater" src="src/assets/images/t3.jpg" alt="세종체임버홀 이미지"><br>
          </div>
          <div v-show="currentTab == 3" class="tab-cont">
            <img id="sTheater" src="src/assets/images/t4.jpg" alt="세종s씨어터 이미지"><br>
          </div>
          <div v-show="currentTab == 4" class="tab-cont">
            <img id="artTheater" src="src/assets/images/t5.jpg" alt="세종예술동 이미지"><br>
          </div>
        </div>
        <br>
      </div>
    </div>

  </div>
</template>


<script>
export default {
  name: "SjFacilty",
  data() {
    return {
      currentTab: 0,
      tabList: ['세종대극장', '세종M씨어터', '세종체임버홀', '세종S씨어터', '세종예술동']
    }
  }
}
</script>

<style scoped>
button {
  color: white;
}

img {
  width: 70%;
  height: 70%;
}

body {
  font: bold 11px/1.5em Verdana;
}

.content-round {
  max-width: 1800px;
  text-align: center;
}

h1 {
  font-family: Verdana, Arial, Helvetica, sans-serif;
  font-size: 16px;
  font-weight: bold;
  margin: 0;
  padding: 0;
}

hr {
  border: none;
  border-top: 1px solid #cccccc;
  height: 1px;
  margin-bottom: 25px;
}

.tab-cont {
  text-align: center;
}

* {
  box-sizing: border-box;
}

ul, li {
  margin: 0;
  padding: 0;
  list-style: none;
}

.tabMenu {
  display: flex;
  justify-content: space-around;
  align-items: flex-end;
  list-style: none;
  border-bottom: 1px solid #ffa594;
}

.tabItem {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 60px;
  flex-basis: 20%;
  flex-shrink: 0;
  border-left: 1px solid #ffa594;
  border-right: 1px solid #ffa594;
  border-top: 1px solid #ffa594;
  border-radius: 10px 10px 0 0;
  font-weight: bold;
  text-align: center;
}

.tabItem.active {
  background-color: #ffa594;
}

.tabContent {
  position: relative;
}

.tabContent > a {
  color: #ce8483;
}

.tabMenu {
  display: flex;
  justify-content: space-around;
  align-items: flex-end;
  list-style: none;
  border-bottom: 1px solid #ffa594;
}

</style>
