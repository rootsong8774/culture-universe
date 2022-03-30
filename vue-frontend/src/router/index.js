import Vue from "vue";
import VueRouter from 'vue-router'
import MainPage from "../components/MainPage";
import performanceDetail from "../components/performanceDetail";
import SjFacility from "../components/SjFacility";
import SjIntroduce from "../components/SjIntroduce";
import performanceReservation from "../components/performanceReservation";
import performanceList from "../components/performanceList";
import qna from "../components/qna";
import loginRegister from "../components/loginRegister";

Vue.use(VueRouter)

const router = new VueRouter({
  mode: 'history',
  routes: [
    {
      path: '/main',
      name: 'main',
      component: MainPage,
    },
    {
      path: '',
      redirect: '/main'
    },
    {
      name: 'performanceDetail',
      path: '/performance/performanceDetail',
      component: performanceDetail,
    },
    {
      name: 'performanceReservation',
      path: '/performance/performanceReservation',
      component: performanceReservation,
    },
    {
      name: 'performanceList',
      path: '/performance/performanceList',
      component: performanceList,
    },
    {
      name: 'facility',
      path: '/organization/facility',
      component: SjFacility
    },
    {
      name: 'organization',
      path: '/organization/introduce',
      component: SjIntroduce
    },
    {
      name: 'qna',
      path: '/support/qna',
      component: qna
    },
    {
      name: 'loginRegister',
      path: '/login',
      component: loginRegister
    }


  ]
})

export default router
