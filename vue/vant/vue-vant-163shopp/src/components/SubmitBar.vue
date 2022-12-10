<template>
  <van-submit-bar :price="3050" button-text="提交订单" @submit="onSubmit" safe-area-inset-bottom="false" placeholder="true" >
    <van-checkbox v-model="checked">全选</van-checkbox>
  </van-submit-bar>
</template>

<script lang="js">
import { showToast } from 'vant';

export default {
    name: 'SubmitBar',
    setup() {
      const onSubmit = () => showToast('点击按钮');
      return {
      onSubmit,
    };
    }
}
</script>
