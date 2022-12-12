<template>
  <div>
    <van-nav-bar title="首页"/>
    <banner></banner>
    <van-grid :column-num="3">
      <van-grid-item>
        <van-icon
            class="iconfont"
            class-prefix="icon"
            name="meizhuang"
            color="#FF94A4"
            size="3rem"
        />
        <span class="van-grid-item__text">美妆</span>
      </van-grid-item>
      <van-grid-item>
        <van-icon
            class="iconfont"
            class-prefix="icon"
            name="shuma"
            color="#88b8fb"
            size="3rem"
        />
        <span class="van-grid-item__text">数码</span>
      </van-grid-item>
      <van-grid-item>
        <van-icon
            class="iconfont"
            class-prefix="icon"
            name="diannao"
            color="#a5adf6"
            size="3rem"
        />
        <span class="van-grid-item__text">电脑</span>
      </van-grid-item>
      <van-grid-item>
        <van-icon
            class="iconfont"
            class-prefix="icon"
            name="fuzhuang"
            color="#80b7f9"
            size="3rem"
        />
        <span class="van-grid-item__text">服装</span>
      </van-grid-item>
      <van-grid-item>
        <van-icon
            class="iconfont"
            class-prefix="icon"
            name="xiezi"
            color="#FF94A4"
            size="3rem"
        />
        <span class="van-grid-item__text">鞋子</span>
      </van-grid-item>
      <van-grid-item>
        <van-icon
            class="iconfont"
            class-prefix="icon"
            name="huwai"
            color="#80b7f9"
            size="3rem"
        />
        <span class="van-grid-item__text">户外</span>
      </van-grid-item>
    </van-grid>
    <div class="p-10">
      <van-grid :column-num="2" :gutter="5" square icon-size="9rem">
        <van-grid-item
            v-for="item in arts.artList"
            :key="item.gid"
            :icon="item.image"
        />
      </van-grid>
    </div>
    <Tobbar></Tobbar>
  </div>
</template>

<script lang="js">
// @ is an alias to /src
import Banner from '@/components/Banner.vue';
import Tobbar from '@/components/Tabbar.vue';
import api from '@/api/index'
import {reactive, onMounted} from 'vue';

export default {
  name: 'HomeView',
  components: {
    Banner,
    Tobbar,
  },
  setup() {
    let arts = reactive({
      artList: []
    });
    onMounted(() => {
      api.getGoodsLevel().then(res => {
        const length = res.data.data.length
        for (let i = 0; i < length; i++) {
          let tmparr = [];
          tmparr[0] = res.data.data[i].items;
          for (let index = 0; index < tmparr[0].length; index++) {
            arts.artList.push(tmparr[0][index])
          }
        }
      })
    })
    return {
      arts
    }
  }
}
</script>

<style scoped>
.p-10 {
  padding: 0.5rem;
}
</style>
