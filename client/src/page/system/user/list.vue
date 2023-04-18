<template>
    <!-- 选项 -->
    <div>
      <el-button type="primary" size="small" @click="handle_add">添加</el-button>
    </div>
    <!-- 表格 -->
    <div>
      <el-table :data="state.list" style="width: 100%">
        <el-table-column prop="id" label="ID" />
        <el-table-column prop="email" label="邮箱" />
        <el-table-column prop="experience" label="经历" />
        <el-table-column prop="certification" label="证书" />
        <el-table-column prop="name" label="姓名" />
        <el-table-column prop="password" label="密码" />
        <el-table-column prop="phone" label="电话" />
        <el-table-column prop="status" label="状态" />
        <el-table-column prop="subject" label="任课" />
        <el-table-column prop="permission" label="权限" />
        <el-table-column label="操作">
          <template #default="scope">
            <el-button type="primary" size="small" @click="handle_edit(scope.row)">编辑</el-button>
            <el-popconfirm title="确认要删除吗?" @confirm="handle_del(scope.row)">
              <template #reference>
                <el-button type="danger" size="small">删除</el-button>
              </template>
            </el-popconfirm>
  
          </template>
        </el-table-column>
      </el-table>
    </div>
    <Edit :dialogFormVisible="dialogFormVisible" :val="dialogVal" @close="handle_close" @success="handle_success"></Edit>
  </template>
  
  <script setup lang="ts">
  
  import { onMounted, reactive, ref } from 'vue';
  
  import Edit from '../user/edit.vue'
  import _ from 'lodash'
  import { ElNotification } from 'element-plus';
  import { Pagination, Teacher } from '../../../types/dto';
  import { TeacherAPI } from '../../../api';
  
  const state = reactive({
    list: <Array<Teacher>>[]
  })
  const pagination = ref<Pagination>({
    size: 10,
    keyword: "",
    page: 1
  })
  // getCarPortListByCommunityId
  const dialogFormVisible = ref(false)
  const dialogVal = ref<any>()
  function handle_close() {
    dialogFormVisible.value = false
  }
  function handle_success(args: any) {
    // Notification
    ElNotification({
      title: "通知",
      message: args
    })
    init()
  }
  function handle_edit(item: any) {
    dialogFormVisible.value = true
    const newItem = _.cloneDeep(item)
    dialogVal.value = newItem
  }
  
  function handle_add() {
    dialogFormVisible.value = true
    dialogVal.value = {}
  }
  
  async function handle_del(item: Teacher) {
    const data = await TeacherAPI.del({ id: item.teacherId })
    init()
  }
  
  async function init() {
    const data = await TeacherAPI.adminList(pagination.value)
    state.list = data.list
    console.log(data);
  
  }
  
  onMounted(() => {
    init()
  })
  
  </script>
  
  <style scoped></style>