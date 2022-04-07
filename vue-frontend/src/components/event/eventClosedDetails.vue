<template>
  <div>
    <div id="centerColumn">
      <h2>종료된 이벤트</h2>
      <div>
        <hr>
        <p>이벤트제목:</p>
        <p>이벤트기간:</p>
        <router-link :to="{name: 'eventWinner'}">당첨자발표 바로가기</router-link>
        <hr>
        <div id="container">
          <h4>이벤트 내용 또는 이미지</h4>
        </div>

        <div class="comments-area">
          <div class="contact-form blog-single-form">
            <h3>댓글이벤트 참여</h3>
            <form>
              <div class="row">
                <div class="col-sm-6 col-xs-12">
                  <div class="form-group">
                    <input type="text" class="form-control" id="firstname" placeholder="id"
                           name="firstname"
                    >
                  </div><!--/.form-group-->
                </div><!--/.col-->
              </div><!--/.row-->
              <div class="row">
                <div class="col-sm-12">
                  <div class="form-group">
                    <textarea class="form-control" rows="7" id="comment" placeholder="이벤트종료"
                              disabled></textarea>
                  </div><!--/.form-group-->
                </div><!--/.col-->
              </div><!--/.row-->
            </form><!--/form-->

          </div><!--/.contact-form-->
          <ol class="comment-list">
            <li class="comment">
              <div class="comment-body xtra-comment-body">
                <div class="comment-meta">
                  <div class="comment-author">
                    <img src="" alt="사람이미지"/>
                  </div><!-- .comment-author -->
                </div><!-- .comment-meta -->

                <div class="comment-content">
                  <b class="fn">
                    <a href="#">
                      ID입력되는곳
                      <span>댓글등록일자</span>
                    </a>
                  </b>
                  <p>
                    당첨돼서 연극보고싶어요!
                  </p>
                </div><!-- .comment-content -->
              </div><!-- .comment-body -->
            </li>
          </ol>
        </div><!--/.comments-area-->
      </div>
    </div><!--centerColumn   -->
  </div>
</template>

<script>
export default {
  name: "eventClosedDetails",
}
</script>
<style scoped>

</style>
