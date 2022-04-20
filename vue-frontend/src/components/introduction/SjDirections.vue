<template>
  <div class="">
    <div class="container">
      <div class="container-fluid py-5">
        <div class="sub-t">
          <h2 class="t" style="font-size: 2.5rem; margin-block-start: 0.83em; margin-block-end: 0.83em;margin-inline-start: 0.83em;
            margin-inline-end: 0.83em; font-weight: bold;text-align: center; line-height: 1.15; letter-spacing: -0.03em;">
            오시는 길</h2>
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
        <div class="round-section">
          <br>
          <br>
          <div>
            <div v-show="currentTab == 0" class="tab-cont">
              <br>
              <img src="src/assets/images/p1.jpg" alt=""><br><br>
            </div>
            <div v-show="currentTab == 1" class="tab-cont">
              <br>
              <img src="src/assets/images/p2.jpg" alt=""><br><br>
            </div>
            <div v-show="currentTab == 2" class="tab-cont">
              <img src="src/assets/images/p3.jpg" alt="지하철"><br>
            </div>
          </div>
          <br>
        </div>
      </div>
    </div>
    <br><br>
  </div>
</template>


<script>
export default {
  name: "SjFacilty",
  data() {
    return {
      currentTab: 0,
      tabList: ['주차장가는길', '주차장에서 공연장 가는길', '대중교통 이용시']
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
  border-bottom: 1px solid #FAB99B;
}

.tabItem {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 60px;
  flex-basis: 20%;
  flex-shrink: 0;
  border-left: 1px solid #FAB99B;
  border-right: 1px solid #FAB99B;
  border-top: 1px solid #FAB99B;
  border-radius: 10px 10px 0 0;
  font-weight: bold;
  text-align: center;
}

.tabItem.active {
  background-color: #FAB99B;
}

.tabContent {
  position: relative;
}

.tabContent > a {
  color: #ce8483;
}

.tabMenu {
  display: flex;
  justify-content: left;
  list-style: none;
  border-bottom: 1px solid #FAB99B;
}

.round-section {
  border: 0.4em outset #FAB99B;
  border-radius: 2px;
}
</style>
