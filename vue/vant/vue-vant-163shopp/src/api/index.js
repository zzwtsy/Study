import axios from "axios";
import path from "@/api/path";

const api = {
    getArtList() {
        return axios.get(path.baseUrl + path.artist);
    }
}

export default api;