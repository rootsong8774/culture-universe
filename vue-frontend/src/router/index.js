import Vue from "vue";
import VueRouter from 'vue-router'
import MainPage from "../components/mainPage";
import performanceDetail from "../components/performanceDetail";
import SjFacility from "../components/SjFacility";
import SjIntroduction from "../components/SjIntroduction";
import performanceReservation from "../components/performanceReservation";
import performanceList from "../components/performanceList";
import qna from "../components/qna";
import SjDirections from "../components/SjDirections";
import notice from "../components/notice";
import faq from "../components/faq";
import eventInProgress from "../components/eventInProgress";
import eventInProgressDetails from "../components/eventInProgressDetails";
import eventWinner from "../components/eventWinner";
import eventClosed from "../components/eventClosed";
import eventClosedDetails from "../components/eventClosedDetails";
import myPage from "../components/myPage";
import loginRegister from "../components/loginRegister";

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
    },
    {
      name: 'eventInProgress',
      path: '/event/progress',
      component: eventInProgress
    },
    {
      name: 'eventInProgressDetails',
      path: '/event/progressDetails',
      component: eventInProgressDetails
    },
    {
      name: 'eventWinner',
      path: '/event/winner',
      component: eventWinner
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
      path: '/event',
      redirect: {name: eventInProgress}
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
      path: '/support/notice',
      component: notice
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
      name: 'loginRegister',
      path: '/loginRegister',
      component: loginRegister
    },
    {
      name: 'myPage',
      path: '/myPage/list',
      component: myPage
    },
    {
      path: '/myPage',
      redirect: {name: 'myPage'}
    }


  ]
})

export default router
