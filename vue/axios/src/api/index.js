import axios from "../utils/request";
import path from "./path";

const api = {
  getSchoolInfo() {
    return axios.get(path.baseUrl + path.schoolInfo);
  },
  getLoginInfo() {
    return axios.post(path.baseUrl + path.loginUrl, {
      password: "zzsyzx2001@",
      email: "2102180004@ahgf.com",
      client: 1,
    });
  },
};

export default api;
