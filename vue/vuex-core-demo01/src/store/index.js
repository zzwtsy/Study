import { createStore } from "vuex";
import axios from "axios";

export default createStore({
  state: {
    counter: 110,
  },
  getters: {
    getCounter(state) {
      return state.counter > 0 ? state.counter : "counter数据异常";
    },
  },
  mutations: {
    setCounter(state, num) {
      state.counter += num;
    },
  },
  // 异步操作
  actions: {
    asyncAddCounter({ commit }) {
      axios.get("http://iwenwiki.com/api/generator/list.php").then((res) => {
        console.log(res);
        commit("setCounter", res.data[0]);
      });
    },
  },
  modules: {},
});
