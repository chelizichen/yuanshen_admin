<template>

  <el-card>
    <div>更新帖子信息</div>
    <el-progress
    :stroke-width="10"
    :percentage="state.progress.percentage"
    status="success"
    v-show="state.progress.show"
  />
    <el-form :model="state.val">
      <el-form-item label="标题" :label-width="formLabelWidth">
        <el-input v-model="state.val.title" autocomplete="off" />
      </el-form-item>
      <el-form-item label="内容" :label-width="formLabelWidth">
        <el-input v-model="state.val.content" autocomplete="off" />
      </el-form-item>
      <el-form-item label="图片" :label-width="formLabelWidth">
        <img :src='"http://localhost:3000/posts/"+state.val.img' autocomplete="off"  style="width: 500px;height:500px"/>
      </el-form-item>


      <!-- <el-form-item label="等级" :label-width="formLabelWidth">
        <el-input :disabled="true" v-model="state.val.level" autocomplete="off" />
      </el-form-item>
      <el-form-item label="登录时间" :label-width="formLabelWidth">
        <el-input :disabled="true" v-model="state.val.loginTime" autocomplete="off" />
      </el-form-item>
      <el-form-item label="创建时间" :label-width="formLabelWidth">
        <el-input :disabled="true" v-model="state.val.createTime" autocomplete="off" />
      </el-form-item>    
      <el-form-item label="头像" :label-width="formLabelWidth">
        <el-input :disabled="true" v-model="state.val.avatar" autocomplete="off" />
      </el-form-item> -->
  
      <div class="footer">
        <el-button @click="close">取消</el-button>
        <el-button type="primary" @click="submit"> 修改 </el-button>
      </div>
    </el-form>
  </el-card>

</template>

<script setup lang="ts">
import { computed, onMounted, reactive, ref, watch } from "vue";
import { Post } from "../../types/dto";
import { PostsAPI } from "../../api";
import { useRoute } from "vue-router";
import moment from 'moment';
import { fa } from "element-plus/es/locale";
import { ElNotification } from "element-plus";

const state = reactive({
  val: <Post>{
  },
  progress:{
    show:false,
    percentage:0
  }
});

const route = useRoute()

const isAdd = computed(()=>{
  return route.query.id?false:true;
  
})

onMounted(async () => {
  const {id} = route.query
  if(id){
    const data = await PostsAPI.one({id:String(id)})
  // @ts-ignore
    state.val = data
  }
})

const formLabelWidth = "140px";

async function submit() {
  state.progress.show = true;
  state.progress.percentage = 50
  // @ts-ignore
  state.val.id = route.query.id || undefined
  await PostsAPI.update(state.val);
  state.progress.percentage = 100
  ElNotification.success({
    'message':"更新帖子信息成功"
  })
}

function close(){
  for(let v in state.val){
    // @ts-ignore
    state.val[v] = ""
  }
}


</script>

<style scoped>
</style>
