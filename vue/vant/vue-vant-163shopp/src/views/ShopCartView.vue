<template>
  <div>
    <Navbar :title="title"></Navbar>
    <van-checkbox-group v-model="checked" ref="checkboxGroup">
      <van-card
        :price="item.price"
        v-for="item in arts.artList"
        :key="item.gid"
      >
        <template #thumb>
          <van-image class="ml-25" :src="item.image"></van-image>
          <van-checkbox
            @click="sumPrice"
            :name="item.gid"
            class="checkbox"
          ></van-checkbox>
        </template>
        <template #num>
          <van-button
            v-model="test"
            icon="minus"
            size="mini"
            :disabled="mapGoodsNum.get(item.gid) <= 0"
            @click="subGoodsNum(item.gid)"
          ></van-button>
          <van-button disabled size="mini">{{
            mapGoodsNum.get(item.gid)
          }}</van-button>
          <van-button
            v-model="test"
            icon="plus"
            size="mini"
            @click="addGoodsNum(item.gid)"
          ></van-button>
        </template>
        <template #desc>
          <p style="text-align: left">{{ item.title }}</p>
        </template>
      </van-card>
    </van-checkbox-group>
    <div style="height: 50px"></div>
    <van-submit-bar
      style="margin-bottom: 50px"
      :price="price"
      button-text="提交订单"
      @submit="onSubmit"
    >
      <van-button @click="checkAll()" round size="mini">全选</van-button>
    </van-submit-bar>
    <Tobbar></Tobbar>
  </div>
</template>

<script lang="js">
import {onMounted, reactive, ref } from 'vue';
import Navbar from '@/components/Navbar.vue';
import Tobbar from '@/components/Tabbar.vue';
import {showToast} from 'vant';
import api from "@/api";

export default {
  components: {
    Navbar,
    Tobbar,
  },
  setup() {
    const title = ref("购物车");
    const checked = ref([]);
    const checkboxGroup = ref(false);
    const mapPrice = new Map();
    let mapGoodsNum = new Map();
    let goodsNum =ref(1);
    let test = ref(0);
    let price = ref(0);
    let checkAllStatus = false;
    let arts = reactive({
      artList: []
    });
    const addGoodsNum = (gid) => {
      let num = mapGoodsNum.get(gid);
      mapGoodsNum.set(gid,num + 1);
      test.value = test.value + 1;
      sumPrice();
    }
    const subGoodsNum = (gid) => {
      let num = mapGoodsNum.get(gid);
      mapGoodsNum.set(gid,num - 1);
      test.value = test.value - 1;
      sumPrice();
    }
    //选择商品时计算已选择商品的总价格
    const sumPrice = () => {
      let count = 0;
      checked.value.forEach(value => {
        count += mapPrice.get(value) * mapGoodsNum.get(value);
      });
      price.value = count * 100;
    }
    const checkAll = () => {
      if(checkAllStatus === false){
        checkAllStatus = true;
        checkboxGroup.value.toggleAll(true);
        totalsPrice();
      } else {
        checkAllStatus = false;
        checkboxGroup.value.toggleAll(false);
        price.value = 0;
      }
    };
    // 计算购物车所有商品总价格
    const totalsPrice = () => {
      let count = 0;
      arts.artList.forEach(element => {
        count = count + (element.price * mapGoodsNum.get(element["gid"]));
      });
      price.value = count * 100;
    };
    const onSubmit = () => showToast('点击按钮');
    onMounted(() => {
      api.getGoodsLevel().then(res => {
        const length = res.data.data.length
        for (let i = 0; i < length; i++) {
          let tmparr = [];
          tmparr[0] = res.data.data[i].items;
          for (let index = 0; index < tmparr[0].length; index++) {
            arts.artList.push(tmparr[0][index])
            mapPrice.set(tmparr[0][index]['gid'],tmparr[0][index]['price']);
            mapGoodsNum.set(tmparr[0][index]['gid'],1);
          }
        }
      })
    })
    return {
      title,
      arts,
      checked,
      checkAll,
      onSubmit,
      sumPrice,
      addGoodsNum,
      subGoodsNum,
      totalsPrice,
      checkboxGroup,
      checkAllStatus,
      price,
      goodsNum,
      mapGoodsNum,
      test
    }
  }
}
</script>

<style scoped>
.ml-25 {
  margin-left: 10px;
}

.checkbox {
  position: absolute;
  left: -14px;
  top: 35%;
}
</style>
