<template>
  <img alt="Vue logo" src="./assets/logo.png">
  <!-- <HelloWorld msg="Welcome to Your Vue.js App"/> -->
  <br>
  <router-link to="/">首页</router-link> |
  <router-link to="/about">关于</router-link>
  <router-view></router-view>
</template>

<script>
// import HelloWorld from './components/HelloWorld.vue'


export default {
  name: 'App'
  // components: {
  //   // HelloWorld
  // }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
