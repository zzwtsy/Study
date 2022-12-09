<template>
  <div class="about">
    <Navbar :title="title"></Navbar>
    <h1>This is an about page</h1>
    <Tobbar></Tobbar>
  </div>
</template>

<script>
import Tobbar from '@/components/Tobbar.vue'
import Navbar from '@/components/Navbar.vue';
import { ref } from 'vue';

export default {
  components: {
    Tobbar,
    Navbar
  },
  setup() {
    const title = ref("关于")
    return {
      title
    }
  }
}
</script>
