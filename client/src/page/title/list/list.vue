<template>
    <!-- 选项 -->
    <div>
      <el-button type="primary" size="small" @click="handle_add">添加</el-button>
    </div>
    <!-- 表格 -->
    <div>
      <el-table :data="state.list" style="width: 100%">
        <el-table-column prop="id" label="ID" />
        <el-table-column prop="name" label="职称" />
        <el-table-column prop="desc" label="描述" />
        <el-table-column label="操作">
          <template #default="scope">
            <el-button type="primary" size="small" @click="handle_edit(scope.row)">添加老师</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
    <Edit :dialogFormVisible="dialogFormVisible" :val="dialogVal" @close="handle_close" @success="handle_success" :title="state.currTitle"></Edit>
  </template>
  
  <script setup lang="ts">
  
  import { onMounted, reactive, ref } from 'vue';
  
  import Edit from './edit.vue'
  import _ from 'lodash'
  import { ElNotification } from 'element-plus';
  import { Pagination, Teacher,Title,TitleDTO } from '../../../types/dto';
  import { TitleAPI } from '../../../api';
  
  const state = reactive({
    list: <Array<Teacher>>[],
    currTitle:0,

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
  async function handle_edit(item: Title) {
    dialogFormVisible.value = true
    const { id }= item;
    
    let data = await TitleAPI.one({
        titleId:Number(id),
        teacherId:0
    })
    dialogVal.value = data
    state.currTitle = item.id;
  }
  
  function handle_add() {
    dialogFormVisible.value = true
    dialogVal.value = {}
  }
  
  async function init() {
    const data = await TitleAPI.list(pagination.value)
    state.list = data
  }
  
  onMounted(() => {
    init()
  })
  
  </script>
  
  <style scoped></style>