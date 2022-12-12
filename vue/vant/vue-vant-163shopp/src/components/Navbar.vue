<template>
  <div>
    <van-nav-bar
      :title="title"
      left-text="返回"
      left-arrow
      @click-left="onClickLeft"
    />
  </div>
</template>

<script>

export default {
  name: "Navbar",
  props: {
    title: String,
  },
  setup(props) {
    const title = props.title;
    const onClickLeft = () => history.back();
    return {
      title,
      onClickLeft,
    };
  },
};
</script>
