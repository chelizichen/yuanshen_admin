<template>
  <el-menu class="el-menu-vertical-demo" default-active="2" >
    <el-menu-item index="-1">
      <div>教师管理系统</div>
    </el-menu-item>
    <el-sub-menu>
      <template #title>
        <el-icon>
          <location />
        </el-icon>
        <span>测试菜单 </span>
      </template>
    </el-sub-menu>
  </el-menu>
</template>

<script setup lang="ts">
import {
  Document,
  Menu as IconMenu,
  Location,
  Setting,
} from '@element-plus/icons-vue'
import { useRouter } from 'vue-router';
import Logo from '/Logo.jpeg'
const router = useRouter()


</script>


<style scoped lang="less">
</style>
