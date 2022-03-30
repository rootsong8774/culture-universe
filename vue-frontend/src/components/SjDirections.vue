<template>
  <div>
    <div class="container-fluid py-5">
      <div class="container py-5">
        <div class="row justify-content-center">
          <div class="col-lg-6 col-md-8 col text-center mb-4">
            <h1 class="mb-4">세종문화회관 오시는 길 </h1>

            <div class="tabmenu">
              <ul>
                <li id="tab1" class="btnCon"><input type="radio" checked name="tabmenu"
                                                    id="tabmenu1">
                  <label for="tabmenu1">자동차</label>
                  <div class="tabCon"><img id="car"> 자동차 안내 이미지</div>
                  <br><br><br><br><br>
                </li>
                <li id="tab2" class="btnCon"><input type="radio" name="tabmenu" id="tabmenu2">
                  <label for="tabmenu2">대중교통</label>
                  <div class="tabCon"><img id="transport"> 대중교통 안내 이미지</div>
                </li>
                <li id="tab3" class="btnCon"><input type="radio" name="tabmenu" id="tabmenu3">
                  <label for="tabmenu3">도보</label>
                  <div class="tabCon"><img id="walk"> 도보 안내 이미지</div>
                </li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "SjDirections",
}
</script>

<style>
* {
  margin: 0;
  padding: 0;
  font-size: 15px;
  line-height: 1.3;
}

ul {
  list-style: none;
}

.tabmenu {
  max-width: 600px;
  margin: 0 auto;
  position: relative;
}

.tabmenu ul li {
  display: inline-block;
  width: 33.33%;
  float: left;
  text-align: center;
  background: #f9f9f9;
  line-height: 40px;
}

.tabmenu label {
  display: block;
  width: 100%;
  height: 40px;
  line-height: 40px;
}

.tabmenu input {
  display: none;
}

.tabCon {
  display: none;
  text-align: left;
  padding: 20px;
  position: absolute;
  left: 0;
  top: 40px;
  box-sizing: border-box;
  border: 5px solid #f9f9f9;
}

.tabmenu input:checked ~ label {
  background: #ccc;
}

.tabmenu input:checked ~ .tabCon {
  display: block;
}
</style>
