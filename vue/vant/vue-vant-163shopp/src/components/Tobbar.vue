<template>
  <router-view />
  <van-tabbar route>
    <van-tabbar-item name="home" replace to="/" icon="home-o">首页</van-tabbar-item>
    <van-tabbar-item name="about" replace to="/about" icon="search">关于</van-tabbar-item>
    <van-tabbar-item name="cart" replace to="/cart" icon="shopping-cart-o">购物车</van-tabbar-item>
    <van-tabbar-item name="setting" icon="setting-o">设置</van-tabbar-item>
  </van-tabbar>
</template>

<script>
export default {
  name: "Sidebar"
};
</script>
