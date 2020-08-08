<!-- 父组件 -->
<template>
  <div>
    <my-child @childEvent="parentMethod"></my-child>
  </div>
</template>

<script>
import MyChild from './Child'

export default {
  components: {
    MyChild
  },
  data () {
    return {
      parentMessage: '我是来自父组件的消息'
    }
  },
  methods: {
    parentMethod ({ name, age }) {
      console.log(this.parentMessage, name, age)
    }
  }
}
</script>
