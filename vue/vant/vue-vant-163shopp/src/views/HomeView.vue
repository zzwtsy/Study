<template>
  <div>
    <Navbar :title="title" />
    <banner />
    <van-grid :column-num="3">
      <van-grid-item>
        <van-icon class="iconfont" class-prefix="icon" name="meizhuang" color="#FF94A4" size="3rem" />
        <span class="van-grid-item__text">美妆</span>
      </van-grid-item>
      <van-grid-item>
        <van-icon class="iconfont" class-prefix="icon" name="shuma" color="#88b8fb" size="3rem" />
        <span class="van-grid-item__text">数码</span>
      </van-grid-item>
      <van-grid-item text="文字">
        <van-icon class="iconfont" class-prefix="icon" name="diannao" color="#a5adf6" size="3rem" />
        <span class="van-grid-item__text">电脑</span>
      </van-grid-item>
      <van-grid-item text="文字">
        <van-icon class="iconfont" class-prefix="icon" name="fuzhuang" color="#80b7f9" size="3rem" />
        <span class="van-grid-item__text">服装</span>
      </van-grid-item>
      <van-grid-item text="文字">
        <van-icon class="iconfont" class-prefix="icon" name="xiezi" color="#FF94A4" size="3rem" />
        <span class="van-grid-item__text">鞋子</span>
      </van-grid-item>
      <van-grid-item text="文字">
        <van-icon class="iconfont" class-prefix="icon" name="huwai" color="#80b7f9" size="3rem" />
        <span class="van-grid-item__text">户外</span>
      </van-grid-item>
    </van-grid>
    <Tobbar />
  </div>
</template>

<script>
// @ is an alias to /src
import Banner from '@/components/Banner.vue';
import Tobbar from '@/components/Tobbar.vue';
import Navbar from '@/components/Navbar.vue';

import { ref } from 'vue';

export default {
  name: 'HomeView',
  components: {
    Banner,
    Tobbar,
    Navbar
  },
  setup() {
    const title = ref("首页")
    return {
      title
    }
  }
}
</script>
