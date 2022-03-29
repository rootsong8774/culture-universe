<template>
  <div id="app">
    <MainPage/>
  </div>
</template>

<script>

import MainPage from "./components/MainPage";



export default {
  name: 'app',
  components: {MainPage},

  data () {
    return {
      msg: 'Welcome to Your Vue.js App'
    }
  }
}
</script>

<style>


</style>
