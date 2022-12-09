<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <p>{{ message }}</p>
  </div>
</template>

<script>
import { inject, onMounted } from 'vue';
export default {
  name: 'HelloWorld',
  props: {
    msg: String
  },
  setup(props) {

    const message = inject("message")

    const msg = props.msg;
    onMounted(() => {
      console.log("test");
    })

    return {
      msg,
      message
    }
  }

}
</script>
