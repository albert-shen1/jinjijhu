import Vue from 'vue'
import App from './App'
import router from './router'
import axios from 'axios'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'

Vue.config.productionTip = false

Vue.use(ElementUI)

axios.interceptors.request.use(config => {
  let userInfo = localStorage.getItem("userInfo")
  console.log(userInfo)
  if (userInfo != null) {
    let user = JSON.parse(userInfo);
    let token = user.token;
    config.headers = {
      "Authorization": token,
    }
  } else {
    router.replace({
      path: '/login'
    })
  }
  return config;
}, error => {
  return Promise.reject(error);
});

axios.interceptors.response.use(response => {
  return response;
}, error => {
  if (error.response) {
    switch (error.response.status) {
      case 401:
        localStorage.removeItem('token');
        router.replace({
          path: '/login'
          // query: {redirect: router.currentRoute.fullPath}
        })
    }
    return Promise.reject(error.response.data);
  }
});


Vue.prototype.$axios = axios

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})

