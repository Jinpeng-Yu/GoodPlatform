<template>
  <el-container class="home-container">
    <!--    头部区域-->
    <el-header>
      <NavBar></NavBar>
    </el-header>
    <!--    页面主体区域-->
    <el-container>
      <!--      侧边栏-->
      <el-aside width="200px">
        <!-- 侧边栏菜单区域 -->
<!--        <SideBar @Type="getCommodityItemByName"></SideBar>-->
        <el-row class="tac">
          <el-col :span="24">
            <el-menu
              default-active="1"
              class="el-menu-vertical-demo"
              background-color="#333744"
              text-color="#fff"
              active-text-color="#ffd04b"
              unique-opened
              router>
              <el-submenu index="1">
                <template slot="title">
                  <i class="el-icon-message"></i>
                  <span>商品管理</span>
                </template>
                <el-menu-item-group>
                  <template slot="title"></template>
                  <el-menu-item index="/SPUmanage">商品管理</el-menu-item>
                  <el-menu-item index="/adminInfo">商品情况分析</el-menu-item>
                </el-menu-item-group>
              </el-submenu>
              <el-submenu index="2">
                <template slot="title">
                  <i class="el-icon-menu"></i>
                  <span>用户管理</span>
                </template>
                <el-menu-item-group>
                  <template slot="title"></template>
                  <el-menu-item index="/UserManage">用户管理</el-menu-item>
                </el-menu-item-group>
              </el-submenu>
            </el-menu>
          </el-col>
        </el-row>
      </el-aside>
      <!--      显示区域-->
      <el-main>
        <el-col :span="24" class="content-wrapper">
          <transition name="fade" mode="out-in">
            <router-view></router-view>
          </transition>
        </el-col>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
import NavBar from '../components/Navbar'
// import SideBar from '../components/SideBar'

export default {
  components: { NavBar },
  name: 'Index',
  data () {
    return {
      queryAllSPU: {
        pageNo: 0,
        pageSize: 5
      },
      allSpuList: [],
      queryAllUser: {
        pageNo: 0,
        pageSize: 5
      },
      allUserList: []
    }
  },
  created () {
    // this.getAllSPUList()
    // this.getUserList()
  },
  methods: {
  //   getAllSPUList () {
  //     this.$axios({
  //       methods: 'get',
  //       url: 'myshopping/public/showAllSPU',
  //       params: this.queryAllSPU
  //       // 另一种方法 params: { pageNo: 0, pageSize: 5}
  //     }).then(response => {
  //       if (response.status !== 200) {
  //         return this.$message.error('获取列表失败！')
  //       }
  //       this.allSpuList = response.data.content
  //       // console.log(response.data.success)
  //     })
  //   },
  //   getCommodityItemByName ({ allSpuList }) {
  //     this.allSpuList = allSpuList
  //   },
  //   showSpu (spuId) {
  //     this.$router.push({
  //       path: '/showSpu',
  //       query: {
  //         spuId: spuId
  //       }
  //     })
  //   },
  //   showUser (userId) {
  //     this.$router.push({
  //       path: '/showUser',
  //       query: {
  //         userId: userId
  //       }
  //     })
  //   },
  //   getUserList () {
  //     this.$axios({
  //       methods: 'get',
  //       url: 'myshopping/admin/getUserList',
  //       params: this.queryAllUser
  //       // 另一种方法 params: { pageNo: 0, pageSize: 5}
  //     }).then(response => {
  //       if (response.status !== 200) {
  //         return this.$message.error('获取列表失败！')
  //       }
  //       this.allUserList = response.data.content
  //       // console.log(response.data.success)
  //     })
  //   }
  }
}
</script>

<style lang="less" scoped>
  .el-header {
    background-color: #373d41;
  }

  .el-aside {
    background-color: #333744;
  }

  .el-main {
    background-color: #eaedf1;
  }

  .home-container {
    height: 100%;
    font-family: "Helvetica Neue",Helvetica,"PingFang SC","Hiragino Sans GB","Microsoft YaHei","微软雅黑",Arial,sans-serif;
  }
</style>
