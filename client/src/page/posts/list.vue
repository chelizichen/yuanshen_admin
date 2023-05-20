<template>
    <div class="app-container">
      <!-- 选项 -->
      <div class="form">
        <el-input v-model="pagination.keyword" style="width: 200px"></el-input>
        <el-button type="success" size="middle" @click="init">搜索</el-button>
        <el-button type="primary" size="middle" @click="handle_add">添加</el-button>
      </div>
      <!-- 表格 -->
      <div>
        <el-table :data="state.list" style="width: 100%" border>
          <el-table-column prop="userId" label="ID" align="center" />
          <el-table-column prop="password" label="密码" align="center" />
          <el-table-column prop="username" label="用户名" align="center" />
          <el-table-column prop="truthName" label="真实姓名" align="center" />
          <el-table-column prop="signature" label="个性签名" align="center" />
          <el-table-column prop="level" label="等级" align="center" />
          <el-table-column prop="loginTime" label="登录时间" align="center" />
          <el-table-column prop="createTime" label="创建时间" align="center" />
          <el-table-column prop="avatar" label="头像" align="center" />
          <el-table-column label="操作">
            <template #default="scope">
              <el-button type="primary" size="small" @click="handle_edit(scope.row)"
                >编辑</el-button
              >
              <el-popconfirm title="确认要删除吗?" @confirm="handle_del(scope.row)">
                <template #reference>
                  <el-button type="danger" size="small">删除</el-button>
                </template>
              </el-popconfirm>
            </template>
          </el-table-column>
        </el-table>
        <el-pagination
          class="page"
          layout="prev, pager, next, total"
          :total="state.total"
          @current-change="handelCurrentChange"
          v-model:current-page="pagination.page"
        />
      </div>
    </div>
  </template>
  
  <script setup lang="ts">
  import { onMounted, reactive, ref, watch } from "vue";
  import _ from "lodash";
  import { ElNotification } from "element-plus";
  import { Pagination, Post } from "../../types/dto";
  import { PostsAPI } from "../../api";
  import { useRouter } from "vue-router";
  
  const router = useRouter();
  
  const state = reactive({
    list: <Array<Post>>[],
    total: "",
  });
  const pagination = ref<Pagination>({
    size: 10,
    keyword: "",
    page: 1,
  });
  
  function handle_edit(item: any) {
    router.push("/admin/system/user_add?id=" + item.userId);
  }
  
  function handle_add() {
    router.push("/admin/system/user_add");
  }
  
  async function handle_del(item: Post) {
    const data = await PostAPI.del({ id: item.id });
    init();
  }
  
  async function init() {
    const data = await PostAPI.list(pagination.value);
    state.list = data.list;
    state.total = data.total;
  }
  
  async function handelCurrentChange(page: number) {
    pagination.value.page = page;
    init();
  }
  
  onMounted(() => {
    init();
  });
  </script>
  
  <style scoped>
  .form {
    display: flex;
    width: 400px;
    justify-content: space-between;
    align-items: center;
    margin-bottom: 20px;
  }
  .app-container {
    padding: 20px;
  }
  .page {
    margin: 20px 0;
    float: right;
  }
  </style>
  