<template>
  <div id="UserInfo">用户名：{{ userName }}</div>
</template>
<script>
export default {
  name: "UserInfo",
  data() {
    return {
      userName: "",
    };
  },
  mounted() {
    this.iniData();
  },
  methods: {
    iniData: function () {
      let userId = this.$route.params.userId;
      this.$axios
        .get("http://localhost:8080/user/" + userId)
        .then((res) => {
          this.userName = res.data.data.userName;
        })
        .catch((err) => console.log(err));
    },
  },
};
</script>
