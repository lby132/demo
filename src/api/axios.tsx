import axios from "axios";

const headers = {
    'Content-type': 'application/x-www-form-urlencoded; charset=UTF-8',
    'Accept': '*/*'
}

const instance = axios.create({
    baseURL: process.env.REACT_APP_API_URL,
    headers: headers,
});



export default instance;