<template>
  <el-dialog v-model="props.dialogFormVisible" title="更新课程" @closed="close">
    <el-form :model="props.val">

      <el-form-item label="课程名称" :label-width="formLabelWidth">
        <el-input v-model="props.val.name" autocomplete="off" />
      </el-form-item>
      <el-form-item label="课程描述" :label-width="formLabelWidth">
        <el-input v-model="props.val.description" autocomplete="off" />
      </el-form-item>
      <el-form-item label="课程代码" :label-width="formLabelWidth">
        <el-input v-model="props.val.code" autocomplete="off" />
      </el-form-item>
      <el-form-item label="学期" :label-width="formLabelWidth">
        <el-input v-model="props.val.semester" autocomplete="off" />
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
import { Course } from '../../../types/dto';
import { CourseAPI } from '../../../api';

const props = defineProps<{
  dialogFormVisible: boolean,
  val: Course
}>()


const formLabelWidth = '140px'

async function submit() {
  const data = await CourseAPI.update(props.val)
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