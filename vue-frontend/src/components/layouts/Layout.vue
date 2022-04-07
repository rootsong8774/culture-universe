<template>
  <div>
    <LayoutHeader current-class="home"/>
    <slot/>
    <LayoutFooter/>
  </div>
</template>

<script>
import LayoutHeader from "../header";
import LayoutFooter from "../footer";


export default {
  name: "Layout",
  components: {
    LayoutHeader,LayoutFooter
  }
}
</script>

<style scoped>

</style>
