<template>
  <div>
    <!--    面包屑导航区-->
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/merchanthome' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>订单管理</el-breadcrumb-item>
      <el-breadcrumb-item>待发货列表</el-breadcrumb-item>
    </el-breadcrumb>

    <!--    卡片视图区-->
    <el-card>
      <!--      table表格区-->
      <el-table :data="orderslist" border stripe>
        <el-table-column type="index"></el-table-column>
        <el-table-column label="订单编号" prop="orderId"></el-table-column>
        <el-table-column label="订单数量" prop="orderNumber"></el-table-column>
        <el-table-column label="发货状态" prop="orderState">
          <template slot-scope="scope">
            {{ is_send[scope.row.orderState] }}
          </template>
        </el-table-column>
        <el-table-column label="下单时间" prop="orderDate" width="160px">
          <template slot-scope="scope">
            {{ scope.row.orderDate | dateFormat }}
          </template>
        </el-table-column>
        <el-table-column label="操作" width="130px">
          <template slot-scope="scope">
            <el-button type="primary" size="mini" icon="el-icon-edit" @click="editAddressDialog()"></el-button>
            <el-button type="success" size="mini" icon="el-icon-check" @click="showSendInfo(scope.row.orderId)"></el-button>
          </template>
        </el-table-column>
      </el-table>
      <!--      分页-->
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="queryInfo.pageNo"
        :page-sizes="[5, 10, 15, 20]"
        :page-size="queryInfo.pageSize"
        layout="total, sizes, prev, pager, next, jumper"
        :total="totalElement"
        background >
      </el-pagination>
    </el-card>
    <!--    修改地址对话框-->
    <el-dialog
      title="修改收货地址"
      :visible.sync="editAddressInfoDialogVisible"
      width="50%">
<!--      @close="addressDialogClosed"-->
        <el-form :model="addressInfoForm" :rules="addressFormRules" ref="addressFormRef" label-width="100px">
          <el-form-item label="省市区/县" prop="address1">
            <el-cascader :options="cityData" v-model="addressInfoForm.address1"></el-cascader>
          </el-form-item>
          <el-form-item label="详细地址" prop="address2">
            <el-input v-model="addressInfoForm.address2"></el-input>
          </el-form-item>
        </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="addressDialogClosed">取 消</el-button>
        <el-button type="primary" @click="editAddressInfo">确 定</el-button>
      </span>
    </el-dialog>

    <!--    发送校验对话框-->
    <el-dialog
      title="校验发货信息"
      :visible.sync="checkSendInfoDialogVisible"
      width="50%">
      <el-form label-width="120px">
        <el-form-item :model="orderInfoForm" label="订单编号：" prop="orderId">
          <el-input v-model="orderInfoForm.orderId" disabled></el-input>
        </el-form-item>
        <el-form-item :model="orderInfoForm" label="商品名称：" prop="spuName">
          <el-input v-model="orderInfoForm.spuName" disabled></el-input>
        </el-form-item>
        <el-form-item :model="orderInfoForm" label="商品数量：" prop="goodNumber">
          <el-input v-model="orderInfoForm.goodNumber" disabled></el-input>
        </el-form-item>
        <el-form-item label="下单时间：">
          <el-input v-model="orderAddDate" disabled></el-input>
        </el-form-item>
        <el-form-item label="更新收货地址：" v-if="addressInfoForm.address2 !== ''">
          <el-input v-model="addressInfoForm.address1" disabled></el-input>
          <el-input v-model="addressInfoForm.address2" disabled></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="checkSendInfoDialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="sendGood">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import cityData from './citydata.js'

export default {
  data () {
    return {
      // 查询参数对象
      queryInfo: {
        query: '未发货',
        pageNo: 1,
        pageSize: 10
      },
      orderslist: [],
      totalElement: 0,
      totalPage: 0,
      is_send: ['未发货', '已发货'],
      // 对话框
      editAddressInfoDialogVisible: false,
      checkSendInfoDialogVisible: false,
      addressForm: {
        address1: [],
        address2: ''
      },
      addressInfoForm: {
        address1: [],
        address2: ''
      },
      addressFormRules: {
        address1: [
          { required: true, message: '请选择省市区/县', trigger: 'blur' }
        ],
        address2: [
          { required: true, message: '请填写详细地址', trigger: 'blur' }
        ]
      },
      cityData,
      // 记录订单id
      recordId: 0,
      // 下单时间
      orderAddDate: '',
      orderInfoForm: {}
    }
  },
  created () {
    this.getOrderList()
  },
  methods: {
    // 时间修改
    dateForm (originVal) {
      const dt = new Date(originVal)
      const y = dt.getFullYear()
      const m = (dt.getMonth() + 1 + '').padStart(2, '0')
      const d = (dt.getDate() + '').padStart(2, '0')

      const hh = (dt.getHours() + '').padStart(2, '0')
      const mm = (dt.getMinutes() + '').padStart(2, '0')
      const ss = (dt.getSeconds() + '').padStart(2, '0')

      return `${y}-${m}-${d} ${hh}:${mm}:${ss}`
    },
    getOrderList () {
      this.$axios({
        method: 'get',
        url: 'myshopping/seller/getAllOrders',
        params: this.queryInfo
      }).then(response => {
        if (response.status !== 200) {
          return this.$message.error('获取订单列表失败！')
        }
        this.$message.success('获取订单列表成功! ')
        // console.log(response.data)
        this.orderslist = response.data.content
        this.totalElement = response.data.totalElement
        this.totalPage = response.data.totalPage
      })
    },
    // 显示编辑订单对话框
    editAddressDialog () {
      this.editAddressInfoDialogVisible = true
    },
    // 点击发货查看信息
    showSendInfo (id) {
      this.recordId = id
      this.$axios({
        method: 'get',
        url: 'myshopping/seller/getOrderInfoByOrderId',
        params: { orderId: id }
      }).then(response => {
        if (response.status !== 200) {
          return this.$message.error('查询订单详情失败！')
        }
        this.$message.success('查询订单详情成功! ')
        // console.log(response.data)
        this.orderInfoForm = response.data.data
        this.orderAddDate = this.dateForm(response.data.data.orderDate)
      })
      this.checkSendInfoDialogVisible = true
    },
    // 分页
    handleSizeChange (newSize) {
      this.queryInfo.pageSize = newSize
      this.getOrderList()
    },
    handleCurrentChange (newPage) {
      this.queryInfo.pageNo = newPage
      this.getOrderList()
    },
    // 点击取消修改收货地址对话框
    addressDialogClosed () {
      // console.log(this.addressInfoForm.address1)
      this.editAddressInfoDialogVisible = false
      this.$refs.addressFormRef.resetFields()
    },
    // 点击确认修改地址信息
    editAddressInfo () {
      this.editAddressInfoDialogVisible = false
      this.$refs.addressFormRef.validate(valid => {
        if (!valid) {
          this.$message.error('修改收货地址失败，请填写必要的表单项！')
        }
        console.log(this.addressInfoForm)
      })
    },
    // 点击确认发货
    sendGood () {
      this.checkSendInfoDialogVisible = false
      // 发送请求
      this.$axios({
        methods: 'get',
        url: 'myshopping/seller/sendGood',
        params: {
          orderId: this.recordId
        }
      }).then(response => {
        if (response.status !== 200) {
          return this.$message.error('发货失败！')
        }
        this.$message.success('发货成功！')
        this.getOrderList()
      })
      // 更新地址
      this.addressInfoForm = this.addressForm
    }
  }
}
</script>

<style scoped>
  .el-card {
    box-shadow: 0 1px 1px rgba(0, 0, 0, 0.15) !important;
    margin-top: 15px;
  }

  .el-table {
    margin-top: 15px;
    font-size: 12px;
  }

  .el-pagination {
    margin-top: 15px;
  }

  .el-cascader {
    width: 100%;
  }
</style>
