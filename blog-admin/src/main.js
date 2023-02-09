import Vue from 'vue'
import App from './App.vue'
import ViewUI from 'view-design';
import 'view-design/dist/styles/iview.css';
import VueRouter from 'vue-router';
import router from "./router"
import mavonEditor from 'mavon-editor'
import 'mavon-editor/dist/css/index.css'
import axios from 'axios'

Vue.prototype.$axios = axios
axios.defaults.baseURL='http://127.0.0.1:4567/api/v1'
Vue.use(mavonEditor)
Vue.config.productionTip = false
Vue.use(VueRouter);
Vue.use(ViewUI);

new Vue({
  router: router,
  render: h => h(App),
}).$mount('#app')
