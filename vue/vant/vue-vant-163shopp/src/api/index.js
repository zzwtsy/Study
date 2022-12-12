import axios from "axios";

const api = {
    getBannerImg() {
        return axios.get('http://vueshop.glbuys.com/api/home/index/slide?token=1ec949a15fb709370f');
    },
    getGoodsLevel() {
        return axios.get('http://vueshop.glbuys.com/api/home/index/goodsLevel?token=1ec949a15fb709370f');
    }
}

export default api;