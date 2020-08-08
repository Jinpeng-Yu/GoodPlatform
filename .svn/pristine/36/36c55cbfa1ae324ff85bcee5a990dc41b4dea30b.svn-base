<template>
  <div class="forget_container">
    <div class="forget_box">
      <div style="width: 650px">
        <p class="forget_title">密码找回</p>
      </div>
      <el-form :model="forgetForm" class="forget_form" label-width="0px">
        <p style="font-size: 16px">邮箱</p>
        <el-form-item prop="email">
          <el-input v-model="forgetForm.email" prefix-icon="iconfont icon-youxiang"></el-input>
        </el-form-item>
        <p style="font-size: 16px">输入验证码</p>
        <el-form-item  prop="verificationCode" class="code">
          <el-input v-model="forgetForm.verificationCode" prefix-icon="iconfont icon-bianji"></el-input>
          <el-button type="primary" @click="sendCode">发送验证码</el-button>
        </el-form-item>
        <el-form-item></el-form-item>
        <el-form-item class="btn_s">
          <el-button type="primary" style="font-size: 20px" @click="forget">确定</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
export default {
  data () {
    return {
      forgetForm: {
        email: '',
        verificationCode: ''
      }
    }
  },
  methods: {
    forget () {
      this.$message.success('请稍等！')
      this.$axios({
        methods: 'get',
        url: 'myshopping/public/forget',
        params: { email: this.forgetForm.email, captcha: this.forgetForm.verificationCode }
      }).then(response => {
        if (response.status !== 200) {
          this.$message.error('发送失败')
          return this.$message.error('发送失败！')
        } else {
          console.log(response.data.success)
          if (response.data.success === true) {
            this.$message.success('新的密码已发送至邮箱')
            this.routerLogin()
          }
        }
      })
    },
    sendCode () {
      this.$message.success('请稍等！')
      this.$axios({
        methods: 'get',
        url: 'myshopping/public/sendVerifyMailPW',
        params: { email: this.forgetForm.email }
      }).then(response => {
        if (response.status !== 200) {
          this.$message.error('发送失败')
          return this.$message.error('发送失败！')
        } else {
          console.log(response.data.success)
          this.$message.success('发送成功')
        }
      })
    },
    routerLogin () {
      this.$router.push({
        path: '/login'
      })
    }
  }
}
</script>

<style lang="less" scoped>
  .forget_container{
    background-color: #FFE1FF;
    height: 100%;
  }

  .forget_box{
    width: 650px;
    height: 380px;
    background-color: #fff;
    border-radius: 3px;
    position: absolute;
    left: 50%;
    top: 50%;
    transform: translate(-50%, -50%);
  }
  .forget_form{
    position: absolute;
    bottom: 0;
    width: 100%;
    padding: 0 20px;
    box-sizing: border-box;
  }
  .btn_s{
    display: flex;
    justify-content: center;
  }
  .code {
    .el-input {
      width: 60%;
      float: left;
      display: inline-block;
    }
    .el-button {
      width: 35%;
      float: left;
      margin-left: 5%;
      display: inline-block;
      font-size: 18px;
    }
  }
  .forget_title {
    text-align: center;
    width: 100%;
    margin-top: 30px;
    font-size: 40px;
  }
</style>
