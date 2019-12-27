import Vue from 'vue'
import App from './App.vue'
import router from './router'
import axios from 'axios'
import vuex from 'vuex'
import promise from 'es6-promise/auto'
import {store} from './store'
import VSwitch from 'v-switch-case'
Vue.prototype.$http = axios
Vue.config.productionTip = false
Vue.use(VSwitch)

new Vue({
  render: h => h(App),
  router,
  axios,
  vuex,
  promise,
  store
}).$mount('#app')
