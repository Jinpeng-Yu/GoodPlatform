<template>
  <el-container class="home-container">
    <!--    头部区域-->
      <!--      显示区域-->
      <el-main>
<!--        <el-row :gutter="20" type="flex" class="row-bg" justify="space-around">-->
        <el-row v-for="(page, index) of pages" :key="index" style="margin-top: 10px">
          <el-col :span="4" v-for="(user,index) in page" :key="index">
            <el-card :body-style="{ padding: '0px' }" shadow="hover" style="width: 200px">
              <el-image v-bind:src="'http://' + user.headImg" style="width: 120px; height: 150px" :fit="fill"></el-image>
              <div style="padding: 10px;">
                <h1>用户名：{{user.username}}</h1>
                <div>用户ID：{{user.id}}</div>
                <div class="bottom clearfix">
                  <time class="time">注册时间：{{user.registerDate | dateFormat }}</time>
                  <el-button type="text" class="button" @click="showUser(user.id)">查看详情</el-button>
                </div>
              </div>
            </el-card>
          </el-col>
        </el-row>

      </el-main>
    </el-container>
</template>

<script>
export default {
  name: 'Index',
  data () {
    return {
      queryAllUser: {
        pageNo: 0,
        pageSize: 100
      },
      allUserList: []
    }
  },
  created () {
    this.getUserList()
  },
  computed: {
    pages () {
      const pages = []
      this.allUserList.forEach((item, index) => {
        const page = Math.floor(index / 6)// 6代表6条为一行，随意更改
        if (!pages[page]) {
          pages[page] = []
        }
        pages[page].push(item)
      })
      return pages
    }
  },
  methods: {
    getCommodityItemByName ({ allUserList }) {
      this.allUserList = allUserList
    },
    showUser (userId) {
      this.$router.push({
        path: '/showUser',
        query: {
          userId: userId
        }
      })
    },
    getUserList () {
      this.$axios({
        methods: 'get',
        url: 'myshopping/test/getUserList'
        // params: this.queryAllUser
        // 另一种方法 params: { pageNo: 0, pageSize: 5}
      }).then(response => {
        if (response.status !== 200) {
          return this.$message.error('获取列表失败！')
        }
        this.allUserList = response.data.content
        // console.log(response.data.success)
      })
    },
    getUserByName ({ allUserList }) {
      this.allUserList = allUserList
    }
  }
}
</script>

<style lang="less" scoped>

</style>
