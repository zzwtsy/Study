<template>
  <div class="hello">
    <!-- <h1>{{ msg }}</h1> -->
    <swiper :modules="modules" :pagination="{ clickable: true }">
      <swiper-slide>
        <img src="../assets/banner/202208161143306594_banner1920x780.jpg" alt="">
      </swiper-slide>
      <swiper-slide>
        <img src="../assets/banner/202209201321552174_1920780.jpg" alt="">
      </swiper-slide>
      <swiper-slide>
        <img src="../assets/banner/202211101009047483_官网banner1920x780.jpg" alt="">
      </swiper-slide>
      <swiper-slide>
        <img src="../assets/banner/202210172148429620_官网banner1920x780psd.jpg" alt="">
      </swiper-slide>
    </swiper>
  </div>
</template>

<script>
import { Swiper, SwiperSlide } from 'swiper/vue';
import { Pagination } from 'swiper';
import 'swiper/css';
import 'swiper/css/pagination'
export default {
  components: {
    Swiper,
    SwiperSlide,
  },
  data() {
    return {
      modules: [Pagination]
    }
  },
  name: 'HelloWorld',
  props: {
    msg: String
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
img {
  width: 100%;
}
</style>
