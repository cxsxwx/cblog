import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import './style/main.css';
import axios from 'axios'
import VueAxios from 'vue-axios'

const app = createApp(App)
axios.defaults.baseURL="http://localhost:4567/api/v1"
app.config.globalProperties.$axios = axios
app.use(router)
app.use(VueAxios, axios)
app.mount('#app')