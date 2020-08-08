<template>
  <el-table
    :data="tableData"
    style="width: 100%">
<!--    <el-table-column-->
<!--      label="日期"-->
<!--      width="50">-->
<!--      <template slot-scope="scope">-->
<!--        <i class="el-icon-time"></i>-->
<!--        <span style="margin-left: 10px">{{ scope.row.date }}</span>-->
<!--      </template>-->
<!--    </el-table-column>-->
    <el-table-column
      label="详细信息"
      width="400">
      <template slot-scope="scope">
        <el-popover trigger="hover" placement="top">
          <p>商品名: {{ scope.row.spuName }}</p>
          <p>单价: {{ scope.row.price }}</p>
          <div slot="reference" class="name-wrapper">
            <el-tag size="medium">数量：{{ scope.row.amount }}</el-tag>
          </div>
        </el-popover>
      </template>
    </el-table-column>
    <el-table-column label="操作">
      <template slot-scope="scope">
        <el-button
          size="mini"
          @click="jump(scope.row.amount,scope.row.spuId,scope.row.price,scope.row.skuId,scope.row.spuName)">购买</el-button>
        <el-button
          size="mini"
          type="danger"
          @click="handleDelete(scope.row)">删除</el-button>
      </template>
    </el-table-column>
  </el-table>
</template>

<script>
export default {
  created () {
    this.getData()
  },
  methods: {
    handleClick (row) {
      console.log(row)
    },
    jump (amount, spuId, price, skuId, spuName) {
      this.$router.push({
        path: '/creatOrder',
        query: {
          userId: window.sessionStorage.getItem('userId'),
          amount: amount,
          spuId: spuId,
          price: price,
          skuId: skuId,
          spuName: spuName
          // spuId: spuId
        }
      })
    },
    handleEdit (spuId, amount, price, skuId) {
      this.$axios({
        methods: 'get',
        url: 'myshopping/buyer/addOrder',
        params: { spuId: spuId, skuId: skuId, amount: amount }
      }).then(response => {
        if (response.status !== 200) {
          return this.$message.error('提交失败！')
        }
      })
    },
    handleDelete (row) {
      console.log(row)
      this.$axios({
        methods: 'get',
        url: 'myshopping/buyer/deleteShoppingCart',
        params: { skuId: row.skuId }
      }).then(response => {
        if (response.status !== 200) {
          return this.$message.error('提交失败！')
        }
        return this.$message.success('成功！')
      })
      this.getData()
    },
    getData () {
      this.$axios({
        methods: 'get',
        url: 'myshopping/buyer/getShoppingCart'
      }).then(response => {
        if (response.status !== 200) {
          return this.$message.error('获取列表失败！')
        }
        this.tableData = response.data.data
      })
    }
  },
  data () {
    return {
      tableData: []
    }
  }
}
</script>

<style scoped>

</style>
