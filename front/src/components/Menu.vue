<template>
  <div id="Menu">
    欢迎！！<router-link :to="{name: 'userInfo', params: { userId: this.userId }}">{{ userName }}{{userId}}</router-link>
    <br />
    <li v-for="user in users">{{ user.userName }}</li>
  </div>
</template>
<script>
export default {
  name: "Menu",
  data() {
    return {
      userName: "",
      userId: "",
      users: []
    };
  },
  mounted() {
    this.getUser();
  },
  methods: {
    getUser: function () {
      let userInfo = localStorage.getItem("userInfo");
      if(userInfo==null){
        this.$router.push({ path: "/login" });
      }
      let user = JSON.parse(userInfo);
      this.userName = user.userName;
      this.userId = user.id;
      this.$axios
        .get("http://localhost:8080/user")
        .then((res) => {
          this.users = res.data.data;
        })
        .catch((err) => console.log(err));
    },
  },
};
</script>
