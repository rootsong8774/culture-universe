<template>
  <div>


    <section id="wrap">
      <div class="row">
        <div class="poster">
          <div>
            <img src="../assets/images/item1.jpg" width="150px">
          </div>
          <div class="text">
            <div class="tit">
              <h2>뮤지컬{{ item - list - name }}</h2>
            </div>
            <ul>
              <li><span>기간 : </span>item-date-list</li>
              <li><span>장소 : </span>item-location</li>
              <li><span>시간 : </span>item-time</li>
              <li><span>연령 : </span>item-age</li>
              <li><span>티켓 : </span>item-ticket</li>
              <li><span>문의 : </span>item-tel</li>
              <li><span>티켓 : </span>item-ticket</li>
            </ul>
            <button> 관심공연</button>
            <button type="submit">티켓예매</button>
          </div>
        </div>
      </div>
    </section>
    <!--Portfolio Section-->
    <section id="content" >
            <div style="margin:10px;">
              <ul class="nav nav-tabs clearfix li3">
                <li class="active"><a href="#introduce" data-toggle="tab">작품소개</a></li>
                <li><a href="#reservation" data-toggle="tab">예매안내</a></li>
                <li><a href="#comment" data-toggle="tab">후기평</a></li>
              </ul>
            </div>
            <!-- Tab이 선택되면 내용이 보여지는 영역이다. -->
            <div class="tab-content">
              <div class="tab-pane fade in active" id="introduce">작품소개
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
                      </form>
                    </div>
                  </div>
                </div>
              </div>
              <div class="tab-pane fade" id="reservation">예매안내</div>
              <div class="tab-pane fade" id="comment">후기평</div>
            </div>
          </section>

  </div>
</template>
<script>


export default {
  name: "PerformanceDetail",

}
</script>

<style scoped>

li {
  display: list-item;
  text-align: -webkit-match-parent;
}
.poster {
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
