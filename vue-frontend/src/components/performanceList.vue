<template>
  <div>
    <!--About Sections-->
    <section id="main1">

      <!--input은 form으로 감싼다-->
      <form action="">
        <ul class="nav1">
          <li><input type="date"></li>
          <li><input type="date"></li>
          <li>
            <div class="dropdown">
              <button class="dropbtn">
                <span class="dropbtn_icon">장르</span>
              </button>
              <div class="dropdown-content">
                <a href="#">뮤지컬</a>
                <a href="#">오케스트라</a>
                <a href="#">공연</a>
              </div>
            </div>
          </li>

          <li>
            <div class="searchArea">
              <form action="">
                <input type="search" placeholder="검색"><span>검색</span>
              </form>
            </div>
          </li>
        </ul>

        <div class="">
          <button class="button is-checked" data-filter="*">최신순</button>
          <button class="button" data-filter=".metal">인기순</button>
        </div>
      </form>
    </section>
    <ul>
      <li>
        <router-link :to="{name: 'performanceDetail'}"><img src="../assets/images/item1.jpg"
                                                            width="350px"></router-link>
      </li>
    </ul>

    <section>
      <button><<</button>
      <a class="" href="#carousel-example-generic" role="button"
         data-slide="Previous"></a>
      <a class="" href="#carousel-example-generic" role="button"
         data-slide="prev">
        <span class="fa fa-long-arrow-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
      </a>
      <a>1</a>
      <a>2</a>
      <a>3</a>
      <a>4</a>
      <a>5</a>
      <a class="" href="#carousel-example-generic" role="button"
         data-slide="next">
        <span class="fa fa-long-arrow-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
      </a>
      <a class="" href="#carousel-example-generic" role="button"
         data-slide="next"></a>
      <button>>></button>
    </section>
  </div>
</template>

<script>
export default {
  name: "performanceList",
}
</script>

<style scoped>
.dropdown {
  position: relative;
  display: inline-block;
}

.dropbtn_icon {
  font-family: 'Material Icons';
}

.dropbtn {
  border: 1px solid rgb(37, 37, 37);
  border-radius: 4px;
  background-color: #f5f5f5;
  font-weight: 400;
  color: rgb(37, 37, 37);
  padding: 12px;
  width: 200px;
  text-align: left;
  cursor: pointer;
  font-size: 12px;
}

.dropdown-content {
  display: none;
  position: absolute;
  z-index: 1; /*다른 요소들보다 앞에 배치*/
  font-weight: 400;
  background-color: #f9f9f9;
  min-width: 200px;
}

.dropdown-content a {
  display: block;
  text-decoration: none;
  color: rgb(37, 37, 37);
  font-size: 12px;
  padding: 12px 20px;
}

.dropdown-content a:hover {
  background-color: #ececec
}

.dropdown:hover .dropdown-content {
  display: block;
}

/*dropdown -end*/
.searchArea {
  margin: 5px;
  display: flex;
  width: 200px;
  height: 40px;
  border: 1px solid rgb(102, 103, 171);
  background-color: rgba(0, 0, 0, 0.2);
  padding-left: 5px;
  border-radius: 5px;
  margin-top: 24px;

}

.searchArea > form > input {
  border: 0;
  outline: none;
  background-color: rgba(0, 0, 0, 0.2);
  width: 330px;
  height: 40px;
  color: #fff;
  padding-left: 10px;
}

.searchArea > form > input:focus {
  outline: 2px solid white;
  border-radius: 5px;
}

.searchArea > form > span {
  width: 20px;
  /*background-image: url(./image/search.svg);*/
  color: rgba(0, 0, 0, 0);
  background-repeat: no-repeat;
  background-position: center;
  font-weight: bold;
  cursor: pointer;
}

.nav1 {
  margin: 5px;
  display: flex;
  justify-content: center;
  line-height: 30px;
  width: calc(1280px - 400px);

}

.nav1 > li {
  padding: 10px;
  justify-items: center;
  margin-left: 50px;
  font-weight: bold;
}

.nav1 > li > a {
  color: #fff;
}

</style>
