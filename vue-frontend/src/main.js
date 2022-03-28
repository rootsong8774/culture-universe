import Vue from 'vue'
import App from './App.vue'
import 'bootstrap/dist/css/bootstrap.min.css'
import BootstrapVue from "bootstrap-vue";
import 'bootstrap-vue/dist/bootstrap-vue.min.css'

Vue.use(BootstrapVue)

Vue.config.productionTip = true
Vue.config.devtools = true

new Vue({
  el: '#app',
  render: h => h(App)
})
