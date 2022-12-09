<template>
  <div class="hello">
    <p>{{ msg }}</p>
    <p v-for="item in nams.list">{{ item }}</p>
    <button @click="click">click me</button>
    <p>{{ test }}</p>
  </div>
</template>

<script>
import { ref, reactive } from 'vue';

export default {
  name: 'HelloWorld',
  props: {
    test: String
  },
  //组合式api,setup中没有this关键字
  setup(props,ctx) {
     
    //ref
    const msg = ref("消息");

    // reactive
    const nams = reactive({
      list: ["张三", "李四", "王五"]
    })

    function click() {
      msg.value = "new";
    }

    const test = props.test;

    return {
      msg,
      nams,
      click,
      test
    }

  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  display: inline-block;
  margin: 0 10px;
}

a {
  color: #42b983;
}
</style>
