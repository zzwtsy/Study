<template>
  <div>
    <Navbar :title="title"></Navbar>
    <div>
      <SubmitBar></SubmitBar>
    </div>
    <div style="height: 5rem;">
      <Tobbar></Tobbar>
    </div>
  </div>
</template>

<script lang="js">
import { ref } from 'vue';
import Navbar from '@/components/Navbar.vue';
import Tobbar from '@/components/Tobbar.vue';
import SubmitBar from '@/components/SubmitBar.vue';

export default {
    components: {
        Navbar,
        Tobbar,
        SubmitBar
    },
    setup() {
        const title = ref("购物车");
        return {
            title
        }
    }
}
</script>
