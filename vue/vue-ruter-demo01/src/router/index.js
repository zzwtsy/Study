import { createRouter,createWebHashHistory } from "vue-router";
import HomeView from "../views/HomeView"
import AboutView from "../views/AboutView"

//配置信息需要页面相关配置

const routes = [
    {
        path: "/",
        component: HomeView
    },
    {
        path: "/about",
        component: AboutView
    }
]

const router = createRouter({
    // createWebHistory: 需要后台重定向
    history: createWebHashHistory(),
    routes
})

export default router;