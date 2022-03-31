<template>
  <div>
    <!--About Sections-->
    <section id="main1">
      <div class="schedule_w item5">
        <ul class="clearfix">
          <li class="item s1" tabindex="0">
            <div class="date_select">
                <input type="date" name="sdate"> ~
                <input type="date" name="edate" >
            </div>
          </li>
          <li class="item s2" tabindex="0">
            <div class="dropdown">
              <button class="dropbtn">
                <span class="dropbtn_icon">장르</span>
              </button>
              <div class="dropdown-content">
                <a href="#">기타공연</a>
                <a href="#">오케스트라</a>
                <a href="#">클래식</a>
                <a href="#">뮤지컬</a>
                <a href="#">국악</a>
                <a href="#">오페라</a>
                <a href="#">공연</a>
              </div>
            </div>
          </li>
          <li class="item s3" tabindex="0">
          <li class="item s2" tabindex="0">
            <div class="dropdown">
              <button class="dropbtn">
                <span class="dropbtn_icon">장소</span>
              </button>
              <div class="dropdown-content">
                <a href="#">전체</a>
                <a href="#">세종M씨어터</a>
                <a href="#">세종S씨어터</a>
                <a href="#">세종체임버홀</a>
                <a href="#">야외공연</a>
                <a href="#">삼청각</a>
                <a href="#">꿈의숲 콘서트홀</a>
              </div>
            </div>
          </li>
          <li >
            <div class="searchArea">
              <form action="">
                <input type="search" placeholder="검색"><span>?</span>
              </form>
            </div>
          </li>
        </ul>
      </div>

    </section>
    <ul>
      <li class="img_item">
        <router-link :to="{name: 'performanceDetail'}">
          <img src="../assets/images/item1.jpg" width="350px">
        </router-link>
      </li>
    </ul>

    <section>
      <div class="content_page">
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
      </div>
    </section>
    <Footer/>
  </div>
</template>

<script>


export default {
  name: "schedual",

}
</script>

<style scoped>
.content_page, .img_item{
  justify-content: center;
  display: flex;
}
.content_page > a {
  padding: 5px;
}
.clearfix{
  padding: 30px;
}
  .schedule_w .item {    padding: 0 10px 0 10px;    position: relative;  }
  .schedule_w .item {    float: left;    width: 25%;    position: relative;  }

  .date_select{
    justify-content: center;
    display: flex;
  }
  .dropdown {     position: relative;     display: inline-block;   }
  .dropbtn_icon {    font-family: 'Material Icons';  }
  .dropbtn {    border: 1px solid rgb(37, 37, 37);    border-radius: 4px;    background-color: #f5f5f5;    font-weight: 400;
    color: rgb(37, 37, 37);    padding: 12px;    width: 200px;    text-align: left;    cursor: pointer;    font-size: 12px;  }
  .dropdown-content {    display: none;    position: absolute;    z-index: 1;     font-weight: 400;    background-color: #f9f9f9;
    min-width: 200px;  }
  .dropdown-content a {    display: block;    text-decoration: none;    color: rgb(37, 37, 37);    font-size: 12px;    padding: 12px 20px;  }
  .dropdown-content a:hover {    background-color: #ececec  }
  .dropdown:hover .dropdown-content {    display: block;  }
  /*dropdown -end*/
  .searchArea {
    margin: 5px;
    display: flex;
    width: 220px;
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
    width: 250px;
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
