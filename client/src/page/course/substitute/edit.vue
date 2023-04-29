<template>
  <el-dialog v-model="props.dialogFormVisible" title="代课更新" @closed="close">
    <el-form :model="props.val">

      <el-form-item label="原始老师" :label-width="formLabelWidth">
        <el-select
        v-model="props.val.originTeacherId"
        filterable
        remote
        reserve-keyword
        placeholder="请输入原始老师名称"
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
      <el-form-item label="新老师ID" :label-width="formLabelWidth">
        <el-select
        v-model="props.val.substituteTeacherId"
        filterable
        remote
        reserve-keyword
        placeholder="请输入代课老师名称"
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
      <el-form-item label="课程代码" :label-width="formLabelWidth">
        <el-input v-model="props.val.courseId" autocomplete="off" />
      </el-form-item>
      <el-form-item label="代课时间" :label-width="formLabelWidth">
          <el-date-picker
            v-model="props.val.substituteTime"
            type="date"
            placeholder="Pick a day"
          />
      </el-form-item>
    </el-form>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="close">取消</el-button>
        <el-button type="primary" @click="submit">
          更新
        </el-button>
      </span>
    </template>
  </el-dialog>
</template>

<script setup lang="ts">
import { reactive, ref, watch } from 'vue'
import { Pagination, Substitute, Teacher } from '../../../types/dto';
import { SubstituteAPI, TeacherAPI } from '../../../api';

const pagination = ref<Pagination>({
  size: 10,
  keyword: "",
  page: 1
})

const props = defineProps<{
  dialogFormVisible: boolean,
  val: Substitute
}>()

const loading = ref(false)
interface ListItem {
  value: string
  label: string
}
const list = ref<ListItem[]>([])
const options = ref<ListItem[]>([])

async function remoteMethod (query: string) {
  if (query) {
    loading.value = true
    setTimeout(async () => {
      loading.value = false
      pagination.value.keyword = query;
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

const formLabelWidth = '140px'

async function submit() {
  const data = await SubstituteAPI.update(props.val)
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