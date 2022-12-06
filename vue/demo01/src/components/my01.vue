<template>
    <div>
        <h3>组件01</h3>
        <span>{{ title }}</span>
    </div>
</template>

<script>
export default {
    name: "myComponents",
    props: {
        title: {
            type: String,
            default: ""
        }
    }
};
</script>
<!-- scoped css只在当前文件生效 -->
<style scoped>
h3 {
    color: red;
}
</style>
