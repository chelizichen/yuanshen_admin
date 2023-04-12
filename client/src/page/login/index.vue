<template>
  <div class="login">
    <el-card class="login-card">
      <div class="login-form">
        <h3 class="login-title">教师管理平台</h3>
        <el-form :model="data.form" label-width="0px" size="medium">
          <el-form-item>
            <el-input v-model="data.form.phone" placeholder="请输入电话号码"></el-input>
          </el-form-item>
          <el-form-item>
            <el-input v-model="data.form.password" type="password" placeholder="请输入密码"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="login">登录</el-button>
          </el-form-item>
        </el-form>
      </div>
    </el-card>
  </div>
</template>
<script setup lang="ts">
import { defineComponent, reactive } from 'vue'
import { useRouter } from 'vue-router';

const router = useRouter()

const data = reactive({
  form: {
    phone: '',
    password: ''
  }
})

function login() {
  router.push("/admin")
}
</script>

<style scoped>
.login {
  background-color: #F0F2F5;
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
}

.login-card {
  width: 400px;
}

.login-form {
  padding: 20px;
}

.login-title {
  text-align: center;
}
</style>
