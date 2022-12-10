import { createApp } from "vue";
import App from "./App.vue";
import "./registerServiceWorker";
import router from "./router";
import store from "./store";
import { Button } from "vant";
import { AddressList } from "vant";
import { Swipe, SwipeItem } from "vant";
import { Sidebar, SidebarItem } from "vant";
import { NavBar } from 'vant';
import { Tabbar, TabbarItem } from 'vant';
import { Grid, GridItem } from 'vant';
import { Icon } from 'vant';
import { Lazyload } from 'vant';
import { ActionBar, ActionBarIcon, ActionBarButton } from 'vant';
import { SubmitBar } from 'vant';
import '@/assets/iconfont/font_3818916_pxyg4juc3y.css'

// 2. 引入组件样式
import "vant/lib/index.css";

const app = createApp(App);

app.use(Swipe);
app.use(SwipeItem);
app.use(AddressList);
app.use(store);
app.use(router);
app.use(Button);
app.use(Sidebar);
app.use(SidebarItem);
app.use(NavBar);
app.use(Tabbar);
app.use(TabbarItem);
app.use(Grid);
app.use(GridItem);
app.use(Icon);
app.use(Lazyload);
app.use(ActionBar);
app.use(ActionBarIcon);
app.use(ActionBarButton);
app.use(SubmitBar);
app.mount("#app");
