<template>
  <div id="app">
    <img alt="Vue logo" src="./assets/logo.png">
    <my-01-Vue :title="title" />
    <HelloWorld :schoolList="schoolList" />
  </div>
</template>

<script>
import HelloWorld from './components/HelloWorld.vue';
import my01Vue from './components/my01.vue';

export default {
  name: 'App',
  components: {
    HelloWorld,
    my01Vue
  },
  data() {
    return {
      title: '标题',
      schoolList: [
        {
          "name": "安徽财经大学",
          "email": "@aufe.com",
          "school": "2348",
          "display_order": "AHCJDX"
        },
        {
          "name": "安徽财经大学商学院",
          "email": "@acsxy.com",
          "school": "2362",
          "display_order": "AHCJDXSXY"
        },
        {
          "name": "安徽长江职业学院",
          "email": "@ahcjxy.com",
          "school": "2923",
          "display_order": "AHCJZYXY"
        },
        {
          "name": "安徽城市管理职业学院",
          "email": "@cmoc.com",
          "school": "2902",
          "display_order": "AHCSGLZYXY"
        },
        {
          "name": "安徽财贸职业学院",
          "email": "@aftvc.com",
          "school": "2907",
          "display_order": "AHCMZYXY"
        }
      ]
    }
  }
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
