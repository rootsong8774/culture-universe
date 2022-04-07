<template>
  <div>
    <div class="container-fluid py-5">
      <div class="container py-5">
        <div class="row justify-content-center">
          <div class="col-lg-6 col-md-8 col text-center mb-4">
            <h1 class="mb-4">시설 안내</h1>
          </div>
        </div>
      </div>
    </div>
    <div id="tabs">
      <ul>
        <li><a href="#theater"><span>세종대극장</span></a></li>
        <li><a href="#mTheater"><span>세종M씨어터</span></a></li>
        <li><a href="#cTheater"><span>세종체임버홀</span></a></li>
        <li><a href="#"><span>세종S시어터</span></a></li>
        <li><a href="#artTheater"><span>세종예술동</span></a></li>
      </ul>
    </div>
    <div>
      <br>
      <img id="theater" hidden> 대극장 이미지 <br>
      <img id="mTheater" hidden> 세종M씨어터 이미지 <br>
      <img id="cTheater" hidden> 세종체임버홀 이미지 <br>
      <img id="sTheater" hidden> 세종s씨어터 이미지 <br>
      <img id="artTheater" hidden> 세종예술동 이미지 <br>
      <br>
    </div>
  </div>
</template>


<script>
export default {
  name: "SjFacilty",
}
</script>

<style scoped>
body {
  font: bold 11px/1.5em Verdana;
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

#tabs {
  float: left;
  width: 100%;
  font-size: 93%;
  line-height: normal;
  border-bottom: 1px solid #6b78a9;
}

#tabs ul {
  margin: 0;
  padding: 10px 10px 0 50px;
  list-style: none;
}

#tabs li {
  display: inline;
  margin: 0;
  padding: 0;
}

#tabs a {
  float: left;
  background: url("../../assets/images/SJ/tableft.gif") no-repeat left top;
  margin: 0;
  padding: 0 0 0 7px;
  text-decoration: none;
}

#tabs a span {
  float: left;
  display: block;
  background: url("../../assets/images/SJ/tableft.gif") no-repeat right top;
  padding: 5px 15px 4px 6px;
  color: #6b78a9;
}

/* Commented Backslash Hack hides rule from IE5-Mac \*/
#tabs a span {
  float: none;
}

/* End IE5-Mac hack */
#tabs a:hover span {
  color: #6b78a9;
}

#tabs a:hover {
  background-position: 0% -42px;
}

#tabs a:hover span {
  background-position: 100% -42px;
}

</style>
