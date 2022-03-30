<template>
  <div id="app">
    <Layout>
      <router-view/>
    </Layout>

  </div>
</template>

<script>
import Layout from "./components/layouts/Layout";

export default {
  name: 'app',
  components: {
    Layout
  },
  data () {
    return {
      msg: 'Welcome to Your Vue.js App'
    }
  }
}
</script>

<style>


</style>
