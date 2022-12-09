<template>
    <van-tabbar v-model="active">
        <van-tabbar-item icon="home-o"><router-link to="/">首页</router-link></van-tabbar-item>
        <van-tabbar-item icon="search"><router-link to="/about/关于">关于</router-link></van-tabbar-item>
        <van-tabbar-item icon="friends-o">标签</van-tabbar-item>
        <van-tabbar-item icon="setting-o">设置</van-tabbar-item>
    </van-tabbar>
</template>

<script>
import { ref } from 'vue';

export default {
    name: 'Sidebar',
    setup() {
        const active = ref(0);
        return {
            active
        }
    }
}
</script>