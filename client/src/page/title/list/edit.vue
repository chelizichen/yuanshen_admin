<template>
  <el-dialog v-model="props.dialogFormVisible" title="更新教师" @closed="close">
    <el-form :model="props.val">

      <el-form-item label="该职称所有教师" :label-width="formLabelWidth" :disbaled="true">
        <el-check-tag v-for="item in props.val" checked style="margin-right: 8px">
          {{ item.name }}
        </el-check-tag>
      </el-form-item>
      <el-form-item label="添加老师" :label-width="formLabelWidth">
        <el-select
        v-model="state.teacherId"
        filterable
        remote
        reserve-keyword
        placeholder="请输入老师名称"
        :remote-method="remoteMethod"
        :loading="loading"
      >
        <el-option
          v-for="item in options"
          :key="item.value"
          :label="item.label"
          :value="item.value"
        />
        </el-select>
      </el-form-item>

    </el-form>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="close">取消</el-button>
        <el-button type="primary" @click="submit">
          修改
        </el-button>
      </span>
    </template>
  </el-dialog>
</template>

<script setup lang="ts">
import { reactive, ref, watch } from 'vue'
import { Pagination, Teacher,Title, TitleDTO } from '../../../types/dto';
import { TeacherAPI, TitleAPI } from '../../../api';
const loading = ref(false)
interface ListItem {
  value: string
  label: string
}
const list = ref<ListItem[]>([])
const options = ref<ListItem[]>([])

const pagination = ref<Pagination>({
  size: 10,
  keyword: "",
  page: 1
})

async function remoteMethod (query: string) {
  if (query) {
    loading.value = true
    setTimeout(async () => {
      loading.value = false
      const data = await TeacherAPI.list(pagination.value)
      list.value = data.list.map((item: { name: any;id:string; })=>{
        return {
          value:item.id,
          label:item.name
        }
      })
      options.value = list.value.filter((item) => {
        return item.label.toLowerCase().includes(query.toLowerCase())
      })
    }, 200)
  } else {
    options.value = []
  }
}

const props = defineProps<{
  dialogFormVisible: boolean,
  val: Teacher[],
  title:number,

}>()

const state = reactive<TitleDTO>({
  teacherId:0,
  titleId:props.title
})

const formLabelWidth = '140px'

async function submit() {
  const data = await TitleAPI.update({
     'teacherId':state.teacherId,
     'titleId':props.title
  })
    emit("success", "操作成功")
    emit("close")
  console.log(data);

}

const emit = defineEmits(["close", "success"])

function close() {
  emit("close")
}



</script>

<style scoped></style>