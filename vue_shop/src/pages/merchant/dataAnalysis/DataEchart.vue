<template>
  <div>
    <el-row style="margin-left: 100px">
      <div><el-card class="box-card">
        <div slot="header" class="clearfix">
          <span>月销量分析</span>
        </div>
        <div class="text item">
          <span>本月销售最多单品：</span>
          <span style="float: right"  id="monthTop">无</span>
        </div>
        <div class="text item">
          <span>本月销售最少单品：</span>
          <span style="float: right"  id="monthBottom">无</span>
        </div>
      </el-card></div>
    </el-row>
    <el-row style="margin-left: 100px;margin-top: 10px">
      <div><el-card class="box-card">
        <div id="myChart" :style="{width: '800px', height: '600px'}"></div>
      </el-card></div>
    </el-row>
  </div>
</template>

<script>
export default {
  data () {
    return {
      top: '',
      bottom: '',
      nameDataSet: [],
      salesDataSet: []
    }
  },
  created () {
    this.dataset()
  },
  methods: {
    drawLine () {
      // 基于准备好的dom，初始化echarts实例
      const myChart = this.$echarts.init(document.getElementById('myChart'))
      // 绘制图表
      myChart.setOption({
        title: { text: '销量信息数据统计' },
        tooltip: {
          trigger: 'axis'
        },
        xAxis: {
          name: '商品名称',
          data: this.nameDataSet
        },
        yAxis: {
          name: '销量'
        },
        series: [{
          name: '销量',
          type: 'bar',
          data: this.salesDataSet
        }]
      })
    },
    dataset () {
      this.$axios({
        methods: 'get',
        url: 'myshopping/seller/getStoreSPUSales'
      }).then(response => {
        if (response.status !== 200) {
          return this.$message.error('登录失败！')
        } else {
          if (response.data.success === true) {
            console.log(response.data.data)
            const dataList = response.data.data
            this.top = dataList[0].spuName
            this.bottom = dataList[dataList.length - 1].spuName
            for (let i = 0; i < dataList.length; i++) {
              this.nameDataSet.push({ value: dataList[i].spuName, name: dataList[i].spuName })
              this.salesDataSet.push({ value: dataList[i].sales, name: dataList[i].sales })
            }
            document.getElementById('monthTop').innerText = this.top
            document.getElementById('monthBottom').innerText = this.bottom
            console.log(this.nameDataSet)
            console.log(this.salesDataSet)
            this.drawLine()
          }
        }
      })
    }
  }
}
</script>

<style lang="less" scoped>
  .box-card {
    width: 1000px;
  }
</style>
