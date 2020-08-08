<template>
  <el-container class="home-container">
    <span>管理员工作台</span>
    <el-button type="primary" plain @click="loginOut">退出登录</el-button>
  </el-container>
</template>

<script>
export default {
  name: 'NavBar',
  data () {
    return {

    }
  },
  methods: {
    backHome () {
      this.$router.push({
        path: '/public',
        query: {
          // spuId: spuId
        }
      })
    },
    loginOut () {
      this.$router.push({
        path: '/adminLogin',
        query: {
          // spuId: spuId
        }
      })
    }
  }
}
</script>

<style lang="less" scoped>
  .home-container {
    height: 100%;
    width: 100%;
    display: flex;
    justify-content: space-between;
    padding-left: 0;
    align-items: center;

    > div {
      display: flex;
      align-items: center;
      margin-left: auto;
      margin-right: auto;
    }

    > span {
      margin-left: 15px;
      color: white;
    }
  }
</style>
