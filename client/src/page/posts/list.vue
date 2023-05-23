<template>
    <div class="app-container">
      <!-- 选项 -->
      <div class="form">
        <el-input v-model="pagination.keyword" style="width: 200px"></el-input>
        <el-button type="success" size="middle" @click="init">搜索</el-button>
      </div>
      <!-- 表格 -->
      <div>
        <el-table :data="state.list" style="width: 100%" border>
          <el-table-column prop="id" label="ID" align="center" />
          <el-table-column prop="content" label="内容" align="center" />
          <el-table-column prop="img" label="图片" align="center" >
            <template #default="scope">
              <img :src='"http://localhost:3000/posts/"+scope.row.img' style="width: 200px;height:200px" /> 
            </template>
          </el-table-column>
          <el-table-column prop="likes" label="点赞数" align="center" />
          <el-table-column prop="releaseTime" label="发布时间" align="center" />
          <el-table-column prop="title" label="标题" align="center" />
          <el-table-column prop="type" label="类型" align="center" >
            <template #default="scope">
              <div v-if="scope.row.type == 1">原神</div>
              <div v-if="scope.row.type == 2">崩三</div>
              <div v-if="scope.row.type == 3 || !scope.row.type">快速发布</div>
              <div v-if="scope.row.type == 4 ">新闻</div>
            </template>  
          </el-table-column>
          <el-table-column prop="userId" label="用户ID" align="center" >
            <template #default="scope">
              <el-button type="primary" @click="toUserDetail(scope.row.userId)">{{  scope.row.userId}} </el-button>
            </template>
          </el-table-column>
          <el-table-column prop="views" label="浏览量" align="center" />
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
    router.push("/admin/posts/edit?id=" + item.id);
  }
  
  
  async function handle_del(item: Post) {
    console.log(item);
    
    const data = await PostsAPI.del({ id: item.id });
    init();
  }
  
  async function init() {
    const data = await PostsAPI.list(pagination.value);
    state.list = data.list;
    state.total = data.total;
  }
  
  async function handelCurrentChange(page: number) {
    pagination.value.page = page;
    init();
  }
  
function toUserDetail(item: any) {
  router.push("/admin/system/user_add?id=" + item);
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
  