<template>
  <div>
    <el-row>
      <el-col :span="12"><div><el-card class="box-card">
        <div slot="header" class="clearfix">
          <span>月消费分析</span>
        </div>
        <div class="text item">
          <span>本月消费总额：</span>
          <span style="float: right"  id="monthTotal">0</span>
        </div>
        <div class="text item">
          <span>本月最大开销类型：</span>
          <span style="float: right"  id="monthType">无</span>
        </div>
        <div class="text item">
          <span>本月最大单笔开销金额：</span>
          <span style="float: right"  id="monthOutput">0</span>
        </div>
      </el-card></div></el-col>
      <el-col :span="12"><div><el-card class="box-card">
        <div slot="header" class="clearfix">
          <span>年消费分析</span>
        </div>
        <div class="text item">
          <span>年消费总额：</span>
          <span style="float: right"  id="yearTotal">0</span>
        </div>
        <div class="text item">
          <span>年最大开销类型：</span>
          <span style="float: right" id="yearType">无</span>
        </div>
        <div class="text item">
          <span>年最大单笔开销金额：</span>
          <span style="float: right" id="yearOutput">0</span>
        </div>
      </el-card></div></el-col>
    </el-row>
    <el-row>
      <el-col :span="12"><div class="grid-content bg-purple-light"></div></el-col>
      <el-col :span="12"><div class="grid-content bg-purple-light"></div></el-col>
    </el-row>
    <el-row>
      <el-col :span="12"><div><el-card class="box-card">
        <div slot="header" class="clearfix">
          <span>消费类型分析图</span>
        </div>
        <div id="myChart1" :style="{width: '500px', height: '500px'}"></div>
      </el-card></div></el-col>
      <el-col :span="12"><div><el-card class="box-card">
        <div slot="header" class="clearfix">
          <span>消费类型分析图</span>
        </div>
        <div id="myChart2" :style="{width: '500px', height: '500px'}"></div>
      </el-card></div></el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  data () {
    return {
      spuMonthTypeName: [],
      monthExpense: [],
      dataSetYear: [],
      dataSetMonth: [],
      monthTotal: '0',
      yearTotal: '0',
      monthType: '无',
      yearType: '无',
      monthOutput: '0',
      yearOutput: '0'

    }
  },
  created () {
    this.getMonthInfo()
    this.getYearInfo()
  },
  methods: {
    drawLine1: function () {
      const myChart = this.$echarts.init(document.getElementById('myChart1'))
      myChart.setOption({
        title: {
          text: '月消费分析图',
          left: 'center'
        },
        tooltip: {
          trigger: 'item',
          formatter: '{a} <br/>{b} : {c} ({d}%)'
        },
        legend: {
          orient: 'vertical',
          left: 'left',
          data: this.dataSetMonth
        },
        series: [
          {
            name: '访问来源',
            type: 'pie',
            radius: '55%',
            center: ['50%', '60%'],
            data: this.dataSetMonth,
            emphasis: {
              itemStyle: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
              }
            }
          }
        ]
      })
    },
    drawLine2: function () {
      // 基于准备好的dom，初始化echarts实例
      const myChart = this.$echarts.init(document.getElementById('myChart2'))
      // 绘制图表
      myChart.setOption({
        title: {
          text: '年消费分析图',
          left: 'center'
        },
        tooltip: {
          trigger: 'item',
          formatter: '{a} <br/>{b} : {c} ({d}%)'
        },
        legend: {
          orient: 'vertical',
          left: 'left',
          data: this.dataSetYear
        },
        series: [
          {
            name: '访问来源',
            type: 'pie',
            radius: '55%',
            center: ['50%', '60%'],
            data: this.dataSetYear,
            emphasis: {
              itemStyle: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
              }
            }
          }
        ]
      })
    },
    getMonthInfo () {
      this.$axios({
        methods: 'get',
        url: 'myshopping/buyer/getCurrentMonthExpense',
        params: this.loginForm
      }).then(response => {
        if (response.status !== 200) {
          return this.$message.error('登录失败！')
        } else {
          if (response.data.success === true) {
            const spuDataArray = response.data.data
            console.log(response.data.data)
            var tempIndex = 0
            var temp = 0
            var total = 0
            for (let i = 0; i < spuDataArray.length; i++) {
              total = total + spuDataArray[i].expense
              if (spuDataArray[i].expense > temp) {
                temp = spuDataArray[i].expense
                tempIndex = i
              }
              this.dataSetMonth.push({
                value: spuDataArray[i].expense,
                name: spuDataArray[i].spuTypeName
              })
            }
            this.monthTotal = total
            this.monthOutput = spuDataArray[tempIndex].expense
            this.monthType = spuDataArray[tempIndex].spuTypeName
            document.getElementById('monthTotal').innerText = this.monthTotal
            document.getElementById('monthType').innerText = this.monthType
            document.getElementById('monthOutput').innerText = this.monthOutput
            console.log(this.dataSetMonth)
          }
          this.drawLine1()
        }
      })
    },
    getYearInfo () {
      this.$axios({
        methods: 'get',
        url: 'myshopping/buyer/getCurrentYearExpense',
        params: this.loginForm
      }).then(response => {
        if (response.status !== 200) {
          return this.$message.error('登录失败！')
        } else {
          if (response.data.success === true) {
            const spuDataArray = response.data.data
            console.log(response.data.data)
            var tempIndex = 0
            var temp = 0
            var total = 0
            for (let i = 0; i < spuDataArray.length; i++) {
              total = total + spuDataArray[i].expense
              if (spuDataArray[i].expense > temp) {
                temp = spuDataArray[i].expense
                tempIndex = i
              }
              this.dataSetYear.push({
                value: spuDataArray[i].expense,
                name: spuDataArray[i].spuTypeName
              })
            }
            this.yearTotal = total
            this.yearOutput = spuDataArray[tempIndex].expense
            this.yearType = spuDataArray[tempIndex].spuTypeName
            document.getElementById('yearTotal').innerText = this.yearTotal
            document.getElementById('yearType').innerText = this.yearType
            document.getElementById('yearOutput').innerText = this.yearOutput
            console.log(this.dataSetYear)
          }
          this.drawLine2()
        }
      })
    }
  }
}
</script>

<style lang="less" scoped>
  .text {
    font-size: 14px;
  }
  .item {
    margin-bottom: 18px;
  }
  .box-card {
    width: 500px;
  }
  .bg-purple-light {
    background: #eaedf1;
  }
  .grid-content {
    border-radius: 4px;
    min-height: 36px;
  }
</style>
