<template>
  <router-view></router-view>
</template>

<script lang="js">
  import HomeViewVue from './views/HomeView.vue';
  export default {
    components: {
      HomeViewVue
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
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}
</style>
