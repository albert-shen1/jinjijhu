<template>
 <div id="AddUser">
      添加用户
      <br/>
     用户名<input type="text" id="userName" name="userName" v-model="userName"/></br>
     密码<input type="password" id="password" name="password" v-model="password"/></br>
     <button @click="saveUser">提交</button>
</div>
</template>
<script>
export default {
  name: "AddUser",
  data() {
    return {
      action: "addUser",
      userName: "",
      password: "",
    };
  },
  mounted() {
    this.initData();
  },
  methods: {
    saveUser: function () {
      this.$axios
        .post("http://localhost:8080/user", {
          userName: this.userName,
          password: this.password,
        })
        .then((res) => {
          console.log("添加成功");
          if (this.action == "register") {
            this.$router.push({ path: "/login" });
          }
        })
        .catch((err) => console.log(err));
    },
    initData: function () {
      var query = this.$route.query;
      let action = query.action;
      this.action = action;
      console.log(action);
    },
  },
};
</script>
