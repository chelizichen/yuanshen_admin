<template>
  <el-menu class="el-menu-vertical-demo" 
  default-active="2"     
  background-color="#545c64"
  text-color="#fff"
  active-text-color="gold"
  >
    <el-menu-item index="-1">
      <div>教师管理系统</div>
    </el-menu-item>
    <el-sub-menu index="1">
      <template #title>
        <span>系统管理</span>
      </template>
      <el-menu-item index="1-1" @click="to('/admin/system/user')">
        <div >账号管理</div>
      </el-menu-item>
    </el-sub-menu>
    <el-sub-menu index="2">
      <template #title>
        <span>教师管理</span>
      </template>
      <el-menu-item index="2-1" @click="to('/admin/teacher/teacher')">
        <div>教师信息</div>
      </el-menu-item>
      <el-menu-item index="2-2" @click="to('/admin/teacher/research')">
        <div>教师科研</div>
      </el-menu-item>
      <el-menu-item index="2-3" @click="to('/admin/teacher/task')">
        <div>教学任务</div>
      </el-menu-item>
    </el-sub-menu>
    <el-sub-menu index="3">
      <template #title>
        <span>课程管理</span>
      </template>
      <el-menu-item index="3-1" @click="to('/admin/course/course')">
        <div>课程信息</div>
      </el-menu-item>
      <el-menu-item index="3-2" @click="to('/admin/course/schedule')">
        <div>课程安排</div>
      </el-menu-item>
      <el-menu-item index="3-3" @click="to('/admin/course/section')">
        <div>课表安排</div>
      </el-menu-item>
      <el-menu-item index="3-4" @click="to('/admin/course/substitutes')">
        <div>代课安排</div>
      </el-menu-item>
    </el-sub-menu>
    <el-sub-menu index="4">
      <template #title>
        <span>考勤管理</span>
      </template>
      <el-menu-item index="4-1" @click="to('/admin/attendance/teacher')">
        <div>教师考勤</div>
      </el-menu-item>
      <el-menu-item index="4-2" @click="to('/admin/attendance/student')">
        <div>学生考勤</div>
      </el-menu-item>
    </el-sub-menu>
    <el-sub-menu index="5">
      <template #title>
        <span>职称管理</span>
      </template>
      <el-menu-item index="5-1" @click="to('/admin/title/add')">
        <div>分配职称</div>
      </el-menu-item>
      <el-menu-item index="5-2" @click="to('/admin/title/title')">
        <div>职称列表</div>
      </el-menu-item>
    </el-sub-menu>
    <el-sub-menu index="6">
      <template #title>
        <span>职称管理</span>
      </template>
      <el-menu-item index="6-1">
        <div>分配职称</div>
      </el-menu-item>
      <el-menu-item index="6-2">
        <div>职称列表</div>
      </el-menu-item>
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

function to(path: string) {
  router.push(path)
}

</script>


<style scoped lang="less"></style>
