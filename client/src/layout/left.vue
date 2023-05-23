<template>
  <el-menu class="el-menu-vertical-demo" 
  default-active="2"     
  background-color="#545c64"
  text-color="#fff"
  active-text-color="gold"
  >
    <el-menu-item index="-1">
      <div>米哈游社区后台管理系统</div>
    </el-menu-item>
    <el-sub-menu index="1">
      <template #title>
        <span>系统管理</span>
      </template>
      <el-menu-item index="1-1" @click="to('/admin/system/user')">
        <div >账号管理</div>
      </el-menu-item>
      <el-menu-item index="1-2" @click="to('/admin/system/user_add')">
        <div >添加账号</div>
      </el-menu-item>
    </el-sub-menu>
    <el-sub-menu index="2">
      <template #title>
        <span>论坛管理</span>
      </template>
      <el-menu-item index="2-1" @click="to('/admin/posts/list')">
        <div>帖子管理</div>
      </el-menu-item>
      <el-menu-item index="2-2" @click="to('/admin/follows/list')">
        <div>跟帖管理</div>
      </el-menu-item>
    </el-sub-menu>
  </el-menu>
</template>

<script setup lang="ts">
import { useRouter } from 'vue-router';
const router = useRouter()

function to(path: string) {
  router.push(path)
}

</script>


<style scoped lang="less"></style>
