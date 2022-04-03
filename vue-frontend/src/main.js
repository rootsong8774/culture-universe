import Vue from 'vue'
import App from './App.vue'
import router from "./router";



Vue.config.productionTip = true
Vue.config.devtools = true

new Vue({
  el: '#app',
  render: h => h(App),
  router,

})
