<template>
  <img alt="Vue logo" src="./assets/logo.png">
  <br>
  <span>{{ msg }}</span>
  <HelloWorld @onEvent="getData" />
</template>

<script>
import HelloWorld from './components/HelloWorld.vue'

export default {
  name: 'App',
  data() {
    return {
      msg: ""
    }
  },
  components: {
    HelloWorld
  },
  methods: {
    getData(data) {
      console.log(data);
      this.msg = data
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
