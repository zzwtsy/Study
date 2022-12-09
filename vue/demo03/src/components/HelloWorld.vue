<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <button @click="msg = '数据已更新'">点击</button>
  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  data() {
    return {
      msg: "test"
    }
  },
  beforeCreate() {
    console.log("组件创建前");
  },
  created() {
    console.log("组件创建后");
  },
  beforeMount() {
    console.log("组件渲染前");
  }, mounted() {
    console.log("组件渲染后");
    //把网络请求放在这里
  },
  beforeUpdate() {
    console.log("组件更新前");
  },
  updated() {
    console.log("组件更新后");
  },
  beforeUnmount() {
    console.log("组件卸载前");
    //删除不需要的处理
  },
  unmounted() {
    console.log("组件卸载后");
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
