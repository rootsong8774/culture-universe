<template>
  <div>
    <section>
      <div class="row">
        <div class="item">
          <div>
            <figure>
              <img src="../assets/images/item1.jpg" width="150px">
            </figure>
            <button type="submit">티켓예매</button>
          </div>
          <table>
            <th>
              <tr>
                <td>뮤지컬</td>
                <td>item-list-name</td>
              </tr>
              <tr>
                <td>기간</td>
                <td>item-date-list</td>
              </tr>
              <tr>
                <td>장소</td>
                <td>item-location</td>
              </tr>
              <tr>
                <td>시간</td>
                <td>item-time</td>
              </tr>
              <tr>
                <td>연령</td>
                <td>item-age</td>
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
      </div>

    </section>


    <!--Portfolio Section-->
    <section id="gallery" class="gallery margin-top-120 bg-white">
      <!-- Portfolio container-->
      <div class="container">
        <div class="row">

          <div class="filters-button-group sm-text-center">
            <button class="button is-checked" data-filter="*">작품소개</button>
            <button class="button" data-filter=".metal">예매안내</button>
            <button class="button" data-filter=".transition">후기평</button>
          </div>
          <div>
            <hr>
            <br>
            <div>
              <button type="button">리뷰</button>
              관람객 평점 ★★★★★
            </div>
            <br>
            <form action="">
              <input type="text" placeholder="감상평을 등록해주세요"><span>등록</span>
            </form>
            <br>
            <br>
            <div class="dropdown">
              <button class="dropbtn">
                <span class="dropbtn_icon">최신순</span>
              </button>
              <div class="dropdown-content">
                <a href="#">인기순</a>
              </div>
              <br>
              <br>
              <br>
              <div id="board_write">
                <h4>글을 작성하는 공간입니다.</h4>
                <div id="write_area">
                  <form enctype="multipart/form-data"
                        action="write_ok.php?board_id=<?echo $board_id;?>" method="post">
                    <div id="in_title">
                      <textarea name="title" id="utitle" rows="1" cols="55" placeholder="제목"
                                maxlength="100" required></textarea>
                    </div>

                    <!--<div class="wi_line"></div>
                    <div id="in_content">
                      <textarea name="content" id="ucontent" placeholder="내용" required></textarea>
                    </div>-->
                  </form>
                </div>
              </div>

            </div>
          </div>
        </div>
      </div><!-- Portfolio container end -->
    </section><!-- End off portfolio section -->
  </div>
</template>
<script>
export default {
  name: "performanceDetail",
}
</script>

<style scoped>
.item {
  justify-content: center;
  padding: 10px;
  margin: 5px;
  display: flex;
}

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
</style>
