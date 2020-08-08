<template>
  <el-table
    :data="tableData"
    border
    style="width: 100%">
    <el-table-column
      fixed
      prop="orderid"
      label="订单号"
      width="220">
    </el-table-column>
    <el-table-column
      prop="amount"
      label="商品数量"
      width="120">
    </el-table-column>
    <el-table-column
      prop="price"
      label="价格"
      width="150">
    </el-table-column>
    <el-table-column
      prop="date"
      label="时间"
      width="300">
      <template slot-scope="scope">
        {{scope.row.date | dateFormat}}
      </template>
    </el-table-column>
    <el-table-column
      prop="spuName"
      label="商品名"
      width="150">
    </el-table-column>
    <el-table-column
      fixed="right"
      label="操作"
      width="100">
      <template slot-scope="scope">
        <el-button @click="deleteOrder(scope.row.orderid)" type="text" size="small">删除</el-button>
      </template>
    </el-table-column>
  </el-table>
</template>

<script>
export default {
  created () {
    this.getData()
    this.setTime()
  },
  methods: {
    handleClick (row) {
      console.log(row)
    },
    deleteOrder (orderId) {
      this.$axios({
        methods: 'get',
        url: 'myshopping/buyer/deleteOrder',
        params: { orderId: orderId }
      }).then(response => {
        if (response.status !== 200) {
          return this.$message.error('获取列表失败！')
        }
      })
    },
    setTime () {
    },
    getData () {
      this.$axios({
        methods: 'get',
        url: 'myshopping/buyer/getOrderByUserId'
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
