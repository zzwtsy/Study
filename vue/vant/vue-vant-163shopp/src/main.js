import { createApp } from "vue";
import App from "./App.vue";
import "./registerServiceWorker";
import router from "./router";
import store from "./store";
import '@/assets/iconfont/font_3818916_pxyg4juc3y.css'

// 2. 引入组件样式
import "vant/lib/index.css";

const app = createApp(App);

app.use(store);
app.use(router);
app.mount("#app");
