<template>
  <div class="home">
    <img alt="Vue logo" src="../assets/logo.png">
    <HelloWorld msg="Welcome to Your Vue.js App" />
    <p>{{ getCounter }}</p>
    <button @click="addClick">click me</button>
    <button @click="addAsyncClick">异步增加</button>
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'
import { mapGetters, mapMutations, mapActions } from 'vuex';

export default {
  name: 'HomeView',
  components: {
    HelloWorld
  },
  computed: {
    ...mapGetters(["getCounter"])
  },
  methods: {
    ...mapMutations(["setCounter"]),
    ...mapActions(["asyncAddCounter"]),
    addClick() {
      // this.$store.commit("setCounter",10)
      this.setCounter(15)
    },
    addAsyncClick() {
      this.asyncAddCounter();
    }
  }
}
</script>
