<template>
    <van-swipe :autoplay="3000">
        <van-swipe-item>
            <img src="../assets/banner/202208161143306594_banner1920x780.jpg" alt="">
        </van-swipe-item>
        <van-swipe-item>
            <img src="../assets/banner/202209201321552174_1920780.jpg" alt="">
        </van-swipe-item>
        <van-swipe-item>
            <img src="../assets/banner/202210172148429620_官网banner1920x780psd.jpg" alt="">
        </van-swipe-item>
        <van-swipe-item>
            <img src="../assets/banner/202211101009047483_官网banner1920x780.jpg" alt="">
        </van-swipe-item>
    </van-swipe>
</template>

<script>
export default {
    name: 'Banner'
}
</script>

<style>
    img{
        width: 100%;
    }
</style>