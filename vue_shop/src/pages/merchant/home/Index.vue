<template>
  <el-container class="home-container">
    <!--    头部区域-->
    <el-header>
      <div>
        <span>商户工作台</span>
      </div>
      <el-button type="primary" plain @click="backHome">返回首页</el-button>
<!--      <el-button type="primary" plain @click="loginOut">退出登录</el-button>-->
    </el-header>
    <!--    页面主体区域-->
    <el-container>
      <!--      侧边栏-->
      <el-aside :width="isCollapse ? '64px' : '200px'">
        <div class="toggle-button" @click="toggleCollapse">|||</div>
        <!-- 侧边栏菜单区域 -->
        <el-menu
          background-color="#333744"
          text-color="#fff"
          active-text-color="#409eff"
          unique-opened
          :collapse="isCollapse"
          :collapse-transition="false"
          router
          :default-active="activePath">
<!--          一级菜单-->
          <el-submenu :index="item.id + ''" v-for="item in menuList" :key="item.id">
<!--            一级菜单模区域-->
            <template slot="title">
              <i :class="iconObj[item.id]"></i>
              <span>{{ item.authName }}</span>
            </template>
<!--            二级菜单-->
            <el-menu-item :index="'/' + subItem.path" v-for="subItem in item.children" :key="subItem.id"
              @click="saveNavState('/' + subItem.path)">
              <template slot="title">
                <i class="el-icon-menu"></i>
                <span>{{ subItem.authName }}</span>
              </template>
            </el-menu-item>
          </el-submenu>
        </el-menu>
      </el-aside>
      <!--      显示区域-->
      <el-main>
<!--        路由占位符-->
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
export default {
  data () {
    return {
      menuList: [
        {
          id: 101,
          order: 1,
          authName: '商品管理',
          path: 'goods',
          children: [
            { id: 121, order: 1, authName: '商品列表', path: 'goods', children: [] },
            { id: 122, order: 2, authName: '添加商品', path: 'add', children: [] }
          ]
        },
        {
          id: 102,
          order: 2,
          authName: '订单管理',
          path: 'orders',
          children: [
            { id: 123, order: 1, authName: '订单列表', path: 'orders', children: [] },
            { id: 124, order: 2, authName: '发货处理', path: 'send', children: [] }
          ]
        },
        {
          id: 103,
          order: 3,
          authName: '数据统计',
          path: 'data',
          children: [
            { id: 125, order: 1, authName: '统计报表', path: 'data', children: [] }
          ]
        }
      ],
      iconObj: {
        101: 'el-icon-goods',
        102: 'el-icon-tickets',
        103: 'el-icon-document'
      },
      isCollapse: false,
      activePath: ''
    }
  },
  created () {
    this.activePath = window.sessionStorage.getItem('activePath')
  },
  methods: {
    backHome () {
      this.$router.push('/public')
    },
    // loginOut () {
    //   this.$router.push('/public')
    // },
    // 点击按钮切换侧边栏展开
    toggleCollapse () {
      this.isCollapse = !this.isCollapse
    },
    // 保存链接的激活状态
    saveNavState (activePath) {
      window.sessionStorage.setItem('activePath', activePath)
      this.activePath = activePath
    }
  }
}
</script>

<style lang="less" scoped>
  .el-header {
    background-color: #373d41;
    display: flex;
    justify-content: space-between;
    padding-left: 0;
    align-items: center;
    color: #fff;
    font-size: 20px;
    > div {
      display: flex;
      align-items: center;
      span {
        margin-left: 15px;
      }
    }
  }

  .el-aside {
    background-color: #333744;
    .el-menu {
      border-right: none;
    }
  }

  .el-main {
    background-color: #eaedf1;
  }

  .home-container {
    height: 100%;
    font-family: "Helvetica Neue",Helvetica,"PingFang SC","Hiragino Sans GB","Microsoft YaHei","微软雅黑",Arial,sans-serif;
  }

  .toggle-button {
    background-color: #4a5064;
    font-size: 10px;
    line-height: 24px;
    color: #fff;
    text-align: center;
    letter-spacing: 0.2em;
    cursor: pointer;
  }
</style>
