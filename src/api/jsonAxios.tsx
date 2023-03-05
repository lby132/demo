import axios from "axios";

const headers = {
    'Content-type': 'application/json',
    'Accept': '*/*',
    'Access-Control-Allow-Origin':'*'
}


const jsonInstance = axios.create({
    baseURL: process.env.REACT_APP_API_URL,
    headers: headers,
});


export default jsonInstance;