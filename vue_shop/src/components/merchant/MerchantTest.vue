<template>
  <div>
<!--    <el-button @click="add">添加</el-button>-->
<!--    <el-table :data="data">-->
<!--      <el-table-column prop="name" label="名称">-->
<!--        <template  slot-scope="scope">-->
<!--          <el-input v-model="data[scope.$index].name"></el-input>-->
<!--        </template>-->
<!--      </el-table-column>-->
<!--      <el-table-column prop="age" label="年龄">-->
<!--        <template  slot-scope="scope">-->
<!--          <el-input v-model="data[scope.$index].age"></el-input>-->
<!--        </template>-->
<!--      </el-table-column>-->
<!--      <el-table-column prop="age" label="年龄">-->
<!--        <template  slot-scope="scope">-->
<!--          <el-button @click="deleteRow(scope.$index)">删除</el-button>-->
<!--        </template>-->
<!--      </el-table-column>-->
<!--    </el-table>-->

    <el-form :model="dynamicValidateForm" ref="dynamicValidateForm" label-width="100px" class="demo-dynamic">
      <el-form-item
        prop="email"
        label="邮箱"
        :rules="[
      { required: true, message: '请输入邮箱地址', trigger: 'blur' },
      { type: 'email', message: '请输入正确的邮箱地址', trigger: 'blur,change' }
    ]"
      >
        <el-input v-model="dynamicValidateForm.email"></el-input>
      </el-form-item>
      <el-form-item
        v-for="(domain, index) in dynamicValidateForm.domains"
        :label="'域名' + index"
        :key="domain.key"
        :prop="'domains.' + index + '.value'"
        :rules="{
      required: true, message: '域名不能为空', trigger: 'blur'
    }"
      >
        <el-input v-model="domain.value"></el-input><el-button @click.prevent="removeDomain(domain)">删除</el-button>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm('dynamicValidateForm')">提交</el-button>
        <el-button @click="addDomain">新增域名</el-button>
        <el-button @click="resetForm('dynamicValidateForm')">重置</el-button>
      </el-form-item>
    </el-form>

  </div>
<!--  <div>-->
<!--    <el-button @click="AddList">添加</el-button>-->
<!--    <div v-for="(v,i) in list" :key="i">-->
<!--      <el-input v-model="list[i].a"></el-input>-->
<!--      <el-input v-model="list[i].b"></el-input>-->
<!--    </div>-->
<!--  </div>-->
</template>

<script>
export default {
  name: 'MerchantTest',
  data () {
    return {
      data: [],
      list: [
        { a: '', b: '' },
        { a: '', b: '' }
      ],
      dynamicValidateForm: {
        domains: [{
          value: ''
        }],
        email: ''
      }
    }
  },
  methods: {
    add () {
      this.data.push({})
    },
    deleteRow (index) {
      this.data.splice(index, 1)
    },
    AddList () {
      this.list.push({ a: '', b: '' })
    },
    submitForm (formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          alert('submit!')
        } else {
          console.log('error submit!!')
          return false
        }
      })
    },
    resetForm (formName) {
      this.$refs[formName].resetFields()
    },
    removeDomain (item) {
      var index = this.dynamicValidateForm.domains.indexOf(item)
      if (index !== -1) {
        this.dynamicValidateForm.domains.splice(index, 1)
      }
    },
    addDomain () {
      this.dynamicValidateForm.domains.push({
        value: '',
        key: Date.now()
      })
    }
  }
}
</script>

<style scoped>

</style>
