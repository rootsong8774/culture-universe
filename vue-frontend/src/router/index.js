import Vue from "vue";
import VueRouter from 'vue-router'
import MainPage from "../components/mainPage";
import performanceDetail from "../components/performance/performanceDetail";
import SjFacility from "../components/introduction/SjFacility";
import SjIntroduction from "../components/introduction/SjIntroduction";
import performanceReservation from "../components/performance/performanceReservation";
import performanceList from "../components/performance/performanceList";
import qna from "../components/supports/qna";
import SjDirections from "../components/introduction/SjDirections";

import notice from "../components/supports/notice";
import noticeDetails from "../components/supports/noticeDetails";

import faq from "../components/supports/faq";

import eventInProgress from "../components/event/eventInProgress";
import eventInProgressDetails from "../components/event/eventInProgressDetails";

import eventWinner from "../components/event/eventWinner";
import winnerDetails from "../components/event/winnerDetails";

import eventClosed from "../components/event/eventClosed";
import eventClosedDetails from "../components/event/eventClosedDetails";
import myPage from "../components/myPage";
import myPageQna from "../components/myPageQna";
import myPageQnaDetails from "../components/myPageQnaDetails";

Vue.use(VueRouter)

const router = new VueRouter({
  routes: [
    {
      path: '/main',
      name: 'main',
      component: MainPage,
    },
    {
      path: '',
      redirect: {name : 'main'}
    },
    {
      name: 'performanceDetail',
      path: '/performances/performanceDetail',
      component: performanceDetail,
      props: (route) => ({
        performCode: route.query.performCode
      })
    },
    {
      name: 'performanceReservation',
      path: '/performances/performanceReservation',
      component: performanceReservation,
    },
    {
      path: '/performances',
      redirect: {name : 'performanceList'}
    },
    {
      name: 'performanceList',
      path: '/performances/performanceList',
      component: performanceList,
      props: (route) => ({
        page: route.query.page
      })
    },
    {
      name: 'noticeDetails',
      path: '/notice/noticeDetails',
      component: noticeDetails,
      props: (route) => ({
        noticeIdx: route.query.noticeIdx
      })
    },
    {
      name: 'winnerDetails',
      path: '/event/winnerDetails',
      component: winnerDetails,
      props: (route) => ({
        winnerIdx: route.query.winnerIdx
      })
    },
    {
      name: 'eventInProgressDetails',
      path: '/event/eventInProgressDetails',
      component: eventInProgressDetails,
      props: (route) => ({
        eventIdx: route.query.eventIdx
      })
    },
    {
      path: '/eventInProgress',
      redirect: {name: eventInProgress}
    },

    {
      name: 'eventInProgress',
      path: '/event/eventList',
      component: eventInProgress
    },
    {
      name: 'eventInProgressDetails',
      path: '/event/eventInProgressDetails',
      component: eventInProgressDetails
    },
    {
      name: 'eventWinner',
      path: '/event/winnerList',
      component: eventWinner
    },
    {
      name: 'winnerDetails',
      path: '/event/winnerDetails',
      component: winnerDetails
    },
    {
      name: 'eventClosed',
      path: '/event/closed',
      component: eventClosed
    },
    {
      name: 'eventClosedDetails',
      path: '/event/closedDetails',
      component: eventClosedDetails
    },


    {
      name: 'organization',
      path: '/organization/introduction',
      component: SjIntroduction
    },
    {
      name: 'facility',
      path: '/organization/facility',
      component: SjFacility
    },
    {
      name: 'direction',
      path: '/organization/direction',
      component: SjDirections
    },
    {
      path: '/organization',
      redirect: {name: SjIntroduction}
    },
    {
      name: 'notice',
      path: '/support/noticeList',
      component: notice
    },
    {
      name: 'noticeDetails',
      path: '/support/noticeDetails',
      component: noticeDetails
    },
    {
      name: 'faq',
      path: '/support/faq',
      component: faq
    },
    {
      name: 'qna',
      path: '/support/qna',
      component: qna
    },
    {
      name: 'myPage',
      path: '/myPage/list',
      component: myPage
    },
    //확인용 추가
    {
      name: 'myPageQna',
      path: '/myPageQna/list',
      component: myPageQna
    },
    {
      name: 'myPageQnaDetails',
      path: '/myPageQna/myPageQnaDetails',
      component: myPageQnaDetails,
      props: (route) => ({
        questionIdx: route.query.questionIdx
      })
    },
    {
      path: '/myPage',
      redirect: {name: 'myPage'}
    }
    ]
})

export default router
