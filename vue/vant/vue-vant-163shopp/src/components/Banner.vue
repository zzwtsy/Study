<template>
  <van-swipe :autoplay="3000">
    <van-swipe-item v-for="item in bannerImg.data" :key="item.title">
        <img :src="item.image" :alt="item.title">
    </van-swipe-item>
  </van-swipe>
</template>

<script>
import { onMounted } from 'vue';
import { reactive } from 'vue';
import api from '@/api';

export default {
  name: "Banner",
  setup() {
    const bannerImg = reactive({
        data: []
    })
    onMounted(()=> {
        api.getBannerImg()
        .then(res => {
            bannerImg.data = res.data.data
        })
    })
    return {
        bannerImg
    }
  },
};
</script>

<style>
img {
  width: 100%;
}
</style>
