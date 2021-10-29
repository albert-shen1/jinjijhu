<template>
  <div id="app">
    <!-- <h1>site : {{ site }}</h1>
    <h1>url : {{ url }}</h1>
    <h1>{{ details() }}</h1>
    <button @click="change">修改</button>
    <div>
      <li v-for="site in sites">
        {{ site }}
      </li>
    </div>
    <input type="text" id="username" v-model="userName" />
    <label for="username">{{ userName }}</label>
    <input type="checkbox" id="runoob" value="Runoob" v-model="checkedNames" />
    <label for="runoob">Runoob</label>
    <span>选择的值为: {{ checkedNames }}</span>
    -->
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  name: "App"
  // data() {
  //   return {
  //     site: "菜鸟教程",
  //     url: "www.runoob.com",
  //     alexa: "10000",
  //     sites: [{ name: "Runoob" }, { name: "Google" }, { name: "Taobao" }],
  //     userName: "",
  //     checkedNames: [],
  //   };
  // },
  // methods: {
  //   details: function () {
  //     return this.site + " - 学的不仅是技术，更是梦想！";
  //   },
  //   change: function () {
  //     this.site = "ccccc";
  //   },
  // },
};
</script>

<style>
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
