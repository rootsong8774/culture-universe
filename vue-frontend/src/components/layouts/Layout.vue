<template>
  <div>
    <Header current-class="home"/>
    <slot/>
    <Footer/>
  </div>
</template>

<script>
import Header from "../header";
import Footer from "../footer";


export default {
  name: "Layout",
  components: {
    Header,Footer
  }
}
</script>

<style scoped>

</style>
