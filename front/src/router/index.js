import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/components/Login'
import Menu from '@/components/Menu'
import AddUser from '@/components/AddUser'
import UserInfo from '@/components/UserInfo'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: '',
      component: Menu
    },
    {
      path: '/login',
      name: 'login',
      component: Login
    },
    {
      path:'/addUser',
      name:'addUser',
      component: AddUser
    },
    {
      path:'/userInfo/:userId',
      name:'userInfo',
      component: UserInfo
    }
  ]
})

