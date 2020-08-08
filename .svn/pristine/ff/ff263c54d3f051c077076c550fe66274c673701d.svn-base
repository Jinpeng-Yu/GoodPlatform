<template>
  <el-container class="buyerHome_container">
    <el-header class="buyerHome_header">
      <el-container class="header_container">
        <span>个人主页</span>
        <el-link style="float: right;font-size: 18px;" type="primary" target="_blank" @click="routerIndex">返回首页
        </el-link>
      </el-container>
    </el-header>
    <el-container>
      <el-aside width="200px">
        <keep-alive>
          <el-menu
            default-active="/information"
            class="el-menu-vertical-demo"
            @open="handleOpen"
            @close="handleClose"
            @select="handleSelect"
            background-color="#333744"
            text-color="#fff"
            router
            active-text-color="#ffd04b">
            <el-submenu index="1">
              <template slot="title">
                <i class="el-icon-message"></i>
                <span>信息数据</span>
              </template>
              <el-menu-item-group>
                <template slot="title"></template>
                <el-menu-item index="/information">消费数据</el-menu-item>
                <el-menu-item index="/userinfo">个人信息</el-menu-item>
              </el-menu-item-group>
            </el-submenu>
            <el-menu-item index="/shoppingcart">
              <i class="el-icon-shopping-cart-1"></i>
              <span slot="title">我的购物车</span>
            </el-menu-item>
            <el-menu-item index="/mycollection">
              <i class="el-icon-star-off"></i>
              <span slot="title">我的收藏</span>
            </el-menu-item>
            <el-menu-item index="/myorder">
              <i class="el-icon-s-order"></i>
              <span slot="title">我的订单</span>
            </el-menu-item>
          </el-menu>
        </keep-alive>
      </el-aside>
      <el-main>
        <keep-alive>
          <router-view></router-view>
        </keep-alive>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
export default {
  methods: {
    routerIndex () {
      this.$router.push({
        path: '/public'
      })
    },
    handleOpen (key, keyPath) {
      console.log(key, keyPath)
    },
    handleClose (key, keyPath) {
      console.log(key, keyPath)
    },
    handleSelect (key, keyPath) {
      console(key, keyPath)
    }
  }
}
</script>

<style lang="less" scoped>
  .buyerHome_container {
    height: 100%;
    font-family: "Helvetica Neue", Helvetica, "PingFang SC", "Hiragino Sans GB", "Microsoft YaHei", "微软雅黑", Arial, sans-serif;
  }

  .buyerHome_header {
    background-color: #373d41;
  }

  .el-aside {
    background-color: #333744;
  }

  .el-main {
    background-color: #eaedf1;
  }

  .header_container {
    height: 100%;
    width: 100%;
    display: flex;
    justify-content: space-between;
    padding-left: 0;
    align-items: center;

    > span {
      margin-left: 15px;
      color: white;
    }
  }
</style>
