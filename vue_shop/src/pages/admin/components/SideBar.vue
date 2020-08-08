<template>
  <el-menu default-active="2"
           class="el-menu-vertical-demo"
           @open="handleOpen"
           @close="handleClose"
           background-color="#333744"
           text-color="#fff"
           active-text-color="#ffd04b"
           route="true"
           unique-opened="true">
    <el-submenu index="1">
      <template slot="title">
        <span>用户管理</span>
      </template>
      <el-menu-item-group>
        <el-menu-item index="/UserManage">
          <span>用户管理</span>
        </el-menu-item>
      </el-menu-item-group>
    </el-submenu>
    <el-submenu index="2">
      <template slot="title">
        <span>商品管理</span>
      </template>
      <el-menu-item-group>
        <el-menu-item index="/SPUmanage">
          <span>商品管理</span>
        </el-menu-item>
      </el-menu-item-group>
    </el-submenu>
  </el-menu>
</template>

<script>
export default {
  name: 'SideBar',
  data () {
    return {
      commodityItemList: [],
      orderItemList: [],
      userList: []
    }
  },
  created () {
    // this.getSPUList()
    // this.getUserList()
  },
  methods: {
    getSPUList () {
      this.$axios({
        methods: 'get',
        url: 'myshopping/admin/getSPUList'
      }).then(response => {
        if (response.status !== 200) {
          return this.$message.error('获取商品项目列表失败！')
        }
        this.commodityItemList = response.data.data
        // console.log(response.data.data)
      })
    },
    getUserList () {
      this.$axios({
        methods: 'get',
        url: 'myshopping/admin/getUserList'
      }).then(response => {
        if (response.status !== 200) {
          return this.$message.error('获取用户列表失败！')
        }
        this.UserList = response.data.data
      })
    },
    getCommodityItemByName (commodityItemName) {
      this.$axios({
        methods: 'get',
        url: 'myshopping/public/showAllSPU',
        params: this.queryAllSPU
        // 另一种方法 params: { pageNo: 0, pageSize: 5}
      }).then(response => {
        if (response.status !== 200) {
          return this.$message.error('获取列表失败！')
        }
        this.allSpuList = response.data.content
        // console.log(response.data.success)
      })
    },
    getOrderItemByName (orderItemName) {

    }
  }
}
</script>

<style scoped>

</style>
