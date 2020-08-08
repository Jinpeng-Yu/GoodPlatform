<template>
  <el-container class="home-container">
    <!--  头部区域  -->
    <el-header>
      <Head @Name="getSpuByName" v-show="!isLogged"></Head>
      <BuyerHead @Name="getSpuByName" v-show="isLogged"></BuyerHead>
    </el-header>
    <!--    页面主体区域-->
    <el-container>
      <!--      侧边栏-->
      <el-aside width="200px">
        <!-- 侧边栏菜单区域 -->
        <Navigation @Type="getSpuByType"></Navigation>
      </el-aside>
      <!--      显示区域-->
      <el-main>
        <el-row type="flex" class="row-bg">
          <el-col :span="8">
            <el-image v-bind:src="'http://' + img" style="width: 300px; height: 250px" :fit="fill"></el-image>
          </el-col>
          <el-col :span="12">
            <h2>{{name}}</h2>
            <span>
              <div v-html="description"></div>
            </span>
            <el-divider></el-divider>
            <el-row>
              <el-col :span="12">
                <h4>商品种类</h4>
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
              <el-col :span="8">
                <h4>店内库存</h4>
                <h3>价格：{{price}}&yen;</h3>
                <span>数量：{{stock}}</span>
              </el-col>
            </el-row>
            <el-divider></el-divider>
            <el-row>
              <el-col :span="6">
                <span>收藏本商品：</span>
                <el-button type="warning" icon="el-icon-star-off" @click="addCollection" circle></el-button>
              </el-col>
              <el-col :span="12">
                <span>加入我的购物车：</span>
                <el-input-number v-model="num" controls-position="right" @change="handleChange" :min="1" :max="200"></el-input-number>
                <el-button type="primary" plain  @click="addShoppingCart">添加</el-button>
              </el-col>
            </el-row>
            <el-row >
              <span>店铺：{{storeName}}</span>
            </el-row>
          </el-col>
        </el-row>
        <el-row>
          <h2>商品评论</h2>
        </el-row>
        <el-divider></el-divider>
        <el-row>
          <div class="block">
            <el-rate
              v-model="grade"
              :colors="colors">
            </el-rate>
          </div>
          <el-col :span="12">
            <el-input
              type="textarea"
              autosize
              placeholder="请输入内容"
              @input="change($event)"
              v-model="comment">
            </el-input>
          </el-col>
          <el-button type="primary" plain  @click="addComment">添加</el-button>
        </el-row>
        <el-row v-for="(comment,index) in commentList" :key="index">
          <el-divider></el-divider>
          <el-row type="flex" class="row-bg">
            <el-col :span="4">
              <el-image v-bind:src="'http://' + comment.headImg" style="width: 30px; height: 25px" :fit="fill"></el-image>
              <span>{{comment.username}}</span>
            </el-col>
            <el-col :span="8">
              <el-rate
                v-model="comment.grade"
                disabled
                show-score
                text-color="#ff9900"
                score-template="{value}">
              </el-rate>
              <time class="time">{{ comment.date| dateFormat}}</time>
              <p>{{comment.content}}</p>
            </el-col>
            <el-col :span="4">
              <el-tag v-for="(attribute, key) in comment.attribute"
                      :key="key"
                      type=''
                      effect="plain">
                {{key}}:{{attribute}}
              </el-tag>
            </el-col>
          </el-row>
        </el-row>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
import Navigation from '../../components/Navigation'
import Head from '../../components/Head'
import BuyerHead from '../../components/buyer/BuyerHead'

export default {
  components: { Navigation, Head, BuyerHead },
  name: 'ShowSpu',
  data () {
    return {
      spuId: this.$router.history.current.query.spuId,
      userId: window.sessionStorage.getItem('userId'),
      skuId: 0,
      img: '',
      name: '',
      description: '',
      storeName: '',
      radioList: [],
      price: 0,
      attributeList: [],
      commentList: [],
      skuList: [],
      attributeMap: {},
      map: {},
      stock: 0,
      num: 1,
      isLogged: false,
      colors: ['#99A9BF', '#F7BA2A', '#FF9900'],
      grade: null,
      comment: null
    }
  },
  created () {
    this.getSpu()
    this.getCommentList()
    this.getLog()
  },
  methods: {
    getLog () {
      if (this.userId !== null) {
        this.isLogged = true
      } else {
        this.isLogged = false
      }
    },
    getSpu () {
      this.$axios({
        methods: 'get',
        url: 'myshopping/public/showSPU',
        params: { spuId: this.spuId }
      }).then(response => {
        if (response.status !== 200) {
          return this.$message.error('获取列表失败！')
        }
        this.img = response.data.data.img
        this.name = response.data.data.name
        this.description = response.data.data.description
        this.storeName = response.data.data.storeDescription
        this.attributeList = response.data.data.attributeList
        this.skuList = response.data.data.skuResultList
        // 获取radio的列表
        var list = []
        for (var key in this.attributeList) {
          list = this.attributeList[key]
          this.radioList.push(list[0].name)
          this.attributeMap[key] = list[0].name
        }
        this.getPriceAndStock()
      })
    },
    attributeUpdate (attributeType, attribute) {
      this.attributeMap[attributeType] = attribute
      this.getPriceAndStock()
    },
    getCommentList () {
      this.$axios({
        methods: 'get',
        url: 'myshopping/public/showSPUComment',
        params: { spuId: this.spuId }
      }).then(response => {
        if (response.status !== 200) {
          return this.$message.error('获取列表失败！')
        }
        this.commentList = response.data.data
      })
    },
    // 获取sku中的skuAttribute键值对，进行比对后确定当前sku价格
    getPriceAndStock () {
      var len = this.skuList.length
      var flag = 1
      for (var i = 0; i < len; i++) {
        this.map = this.skuList[i].skuAttribute
        flag = 1
        for (var attrbuteType in this.map) {
          if (this.map[attrbuteType].name !== this.attributeMap[attrbuteType]) {
            flag = 0
          }
        }
        if (flag === 1) {
          this.price = this.skuList[i].price
          this.stock = this.skuList[i].stock
          this.skuId = this.skuList[i].skuId
          break
        }
      }
      if (flag === 0) {
        this.price = 0
        this.stock = 0
      }
    },
    // 添加收藏
    addCollection () {
      if (this.userId == null) {
        this.$message.error('你尚未登录！')
      } else {
        this.$axios({
          method: 'post',
          url: 'myshopping/buyer/addCollection',
          params: {
            spuId: this.spuId,
            userId: this.userId
          }
        }).then(response => {
          if (response.data.message === '添加成功!') {
            this.$message({
              message: '添加收藏成功！',
              type: 'success'
            })
          } else {
            this.$message.error(response.data.message)
          }
        })
      }
    },
    // 添加购物车
    addShoppingCart () {
      if (this.userId == null) {
        this.$message.error('你尚未登录！')
      } else {
        this.$axios({
          method: 'post',
          url: 'myshopping/buyer/addShoppingCart',
          params: {
            skuId: this.skuId,
            userId: this.userId,
            number: this.num
          }
        }).then(response => {
          if (response.data.message === '添加成功!') {
            this.$message({
              message: '添加购物车成功！',
              type: 'success'
            })
          } else {
            this.$message.error(response.data.message)
          }
        })
      }
    },
    // 添加评论
    addComment () {
      if (this.userId == null) {
        this.$message.error('你尚未登录！')
      } else {
        this.$axios({
          method: 'post',
          url: 'myshopping/buyer/addSPUComment',
          params: {
            spuId: this.spuId,
            userId: this.userId,
            grade: this.grade,
            comment: this.comment
          }
        }).then(response => {
          if (response.data.message === '添加成功!') {
            this.$message({
              message: '添加评论成功！',
              type: 'success'
            })
          } else {
            this.$message.error(response.data.message)
          }
        })
      }
    },
    change (e) {
      this.$forceUpdate()
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
