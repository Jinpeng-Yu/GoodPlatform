<template>
  <el-container class="home-container">
    <!--  头部区域  -->
    <el-header class="buyerHome_header">
      <el-container class="header_container">
        <el-link style="float: right;font-size: 18px;" type="primary" target="_blank" @click="routerIndex">返回首页
        </el-link>
      </el-container>
    </el-header>
    <!--    页面主体区域-->
    <el-container>
      <!--      显示区域-->
      <el-main>
        <el-row type="flex" class="row-bg">
          <el-col :span="12">
            <h2>{{name}}</h2>
            <span>{{description}}</span>
            <el-divider></el-divider>
            <el-row>
              <el-col :span="12">
                <span>商品：{{spuName}}</span>
                <h4>数量：{{amount}}</h4>
                <h4>价格：{{price}}</h4>
                <h4>时间：{{time| dateFormat}}</h4>
                <div style="margin-top: 20px" v-for="(attribute, attributeType,index) in attributeList"
                     :key="attributeType">
                  <el-row>
                    <el-col :span="4">
                      <h4>{{attributeType}}</h4>
                    </el-col>
                    <el-col :span="8">
                      <el-row v-for="one in attribute" :key="one.id">
                        <input type="radio" v-model="radioList[index]" :value="one.name"
                               @click="attributeUpdate(attributeType,one.name)">
                        <span>{{one.name}}</span>
                      </el-row>
                    </el-col>
                  </el-row>
                </div>
              </el-col>
            </el-row>
            <el-divider></el-divider>
            <el-row>
              <el-col :span="12">
                <el-button type="primary" plain @click="addOrder">提交订单</el-button>
              </el-col>
              <el-col :span="12">
                <el-button type="primary" plain @click="this.routerBack()">取消</el-button>
              </el-col>
            </el-row>
          </el-col>
        </el-row>
        <el-divider></el-divider>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
export default {
  name: 'CreatOrder',
  data () {
    return {
      time: '',
      userId: this.$router.history.current.query.userId,
      amount: this.$router.history.current.query.amount,
      spuId: this.$router.history.current.query.spuId,
      price: this.$router.history.current.query.price,
      skuId: this.$router.history.current.query.skuId,
      spuName: this.$router.history.current.query.spuName
    }
  },
  created () {
    this.getTime()
    // this.getUser()
    // this.getCommentList()
  },
  methods: {
    routerIndex () {
      this.$router.push({
        path: '/public'
      })
    },
    routerBack () {
      this.$router.push({
        path: '/myOrder'
      })
    },
    deleteShoppingCart () {
      this.$axios({
        methods: 'get',
        url: 'myshopping/buyer/deleteShoppingCart',
        params: { skuId: this.skuId }
      }).then(response => {
        if (response.status !== 200) {
          return this.$message.error('提交失败！')
        }
        return this.$message.success('成功！')
      })
    },
    getTime () {
      var mydate = new Date()
      this.time = mydate.getTime()
    },
    addOrder () {
      this.$axios({
        methods: 'get',
        url: 'myshopping/buyer/addOrder',
        params: {
          time: this.time,
          amount: this.amount,
          spuId: this.spuId,
          price: this.price,
          skuId: this.skuId,
          spuName: this.spuName
        }// 另一种方法 params: { pageNo: 0, pageSize: 5}
      }).then(response => {
        if (response.status !== 200) {
          return this.$message.error('获取列表失败！')
        }
        this.deleteShoppingCart()
        this.$router.push({
          path: '/myOrder'
        })
        // console.log(response.data.success)
      })
    }
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
    display: flow;
  }

  .home-container {
    height: 100%;
    font-family: "Helvetica Neue", Helvetica, "PingFang SC", "Hiragino Sans GB", "Microsoft YaHei", "微软雅黑", Arial, sans-serif;
  }

  .el-row {
    margin-bottom: 10px;

    &:first-child {
      margin-bottom: 20px;
    }
  }

  .row-bg {
    padding: 10px 0;
  }
</style>
