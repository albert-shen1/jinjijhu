<template>
  <div id="Login">
  
<!-- <div id="app">
  <p>单个复选框：</p>
  <input type="checkbox" id="checkbox" v-model="checked">
  <label for="checkbox">{{ checked }}</label>
    
  <p>多个复选框：</p>
  <input type="checkbox" id="runoob" value="Runoob" v-model="checkedNames">
  <label for="runoob">Runoob</label>
  <input type="checkbox" id="google" value="Google" v-model="checkedNames">
  <label for="google">Google</label>
  <input type="checkbox" id="taobao" value="Taobao" v-model="checkedNames">
  <label for="taobao">taobao</label>
  <br>
  <span>选择的值为: {{ checkedNames }}</span>
</div> -->

    <el-form ref="form" :model="form" label-width="80px">
      <el-form-item label="用户名:">
        <el-input v-model="userName"></el-input>
      </el-form-item>
      <el-form-item label="用户名:">
        <el-input v-model="password" type="password"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="login">提交</el-button>
           <router-link :to="{path: '/addUser',query: { 'action': 'register' }}">用户注册</router-link>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
export default {
  name: "Login",
  data() {
    return {
      userName: "",
      password: "",
    };
  },
  methods: {
    login: function () {
      this.$axios
        .post("http://localhost:8080/user/login", {
          userName: this.userName,
          password: this.password,
        })
        .then((res) => {
          console.log(res);
          localStorage.setItem("userInfo", JSON.stringify(res.data.data));
          this.$router.push({ path: "/" });
        })
        .catch((err) => console.log(err));
    },
  },
};
</script>
