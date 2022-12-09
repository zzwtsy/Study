<template>
  <h3>自定义事件</h3>
  <button @click="onClick">发送数据</button>
</template>

<script>
export default {
  name: 'HelloWorld',
  props: {
    msg: String
  },
  data() {
    return {
      message: "我是数据"
    }
  },
  methods: {
    onClick() {
      this.$emit("onEvent", this.message)
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
