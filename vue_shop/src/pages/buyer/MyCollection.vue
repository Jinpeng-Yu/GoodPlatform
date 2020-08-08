<template>
  <el-table
    :data="tableData"
    style="width: 100%"
    :row-class-name="tableRowClassName">
    <el-table-column
      fixed
      prop="id"
      label="序号"
      width="220">
    </el-table-column>
    <el-table-column
      prop="storeDescription"
      label="店铺"
      width="150">
    </el-table-column>
    <el-table-column
      prop="name"
      label="商品名称"
      width="300">
    </el-table-column>
    <el-table-column
      prop="date"
      label="创建日期"
      width="300">
      <template slot-scope="scope">
        {{scope.row.date | dateFormat}}
      </template>
    </el-table-column>
    <el-table-column
      fixed="right"
      label="操作"
      width="100">
      <template slot-scope="scope">
        <el-button @click="deleteCollection(scope.row.spuId)" type="text" size="small">删除{{scope.row.spuId}}</el-button>
      </template>
    </el-table-column>
  </el-table>
</template>

<style>
  .el-table .warning-row {
    background: oldlace;
  }

  .el-table .success-row {
    background: #f0f9eb;
  }
</style>

<script>
export default {
  methods: {
    tableRowClassName ({ row, rowIndex }) {
      if (rowIndex === 1) {
        return 'warning-row'
      } else if (rowIndex === 3) {
        return 'success-row'
      }
      return ''
    },
    getCollection () {
      this.$axios({
        methods: 'get',
        url: 'myshopping/buyer/getCollection',
        params: { userId: this.userId }
      }).then(response => {
        if (response.status !== 200) {
          return this.$message.error('获取列表失败！')
        }
        this.tableData = response.data.data
      })
    },
    deleteCollection (spuId) {
      this.$axios({
        methods: 'get',
        url: 'myshopping/buyer/deleteCollection',
        params: { userId: this.userId, spuId: spuId }
      }).then(response => {
        if (response.status !== 200) {
          return this.$message.error('获取列表失败！')
        }
        this.getCollection()
      })
    }
  },
  created () {
    this.getCollection()
  },
  data () {
    return {
      userId: window.sessionStorage.getItem('userId'),
      tableData: []
    }
  }
}
</script>

<style lang="less" scoped>
  .el-row {
    margin-bottom: 20px;
  &:last-child {
     margin-bottom: 0;
   }
  }
  .el-col {
    border-radius: 4px;
  }
  .bg-purple-dark {
    background: #99a9bf;
  }
  .bg-purple {
    background: #d3dce6;
  }
  .bg-purple-light {
    background: #e5e9f2;
  }
  .grid-content {
    border-radius: 4px;
    min-height: 36px;
  }
  .row-bg {
    padding: 10px 0;
    background-color: #f9fafc;
  }
</style>
