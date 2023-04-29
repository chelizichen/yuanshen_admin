<template>
  <el-dialog v-model="props.dialogFormVisible" title="考勤更新" @closed="close">
    <el-form :model="props.val">

      <el-form-item label="考勤时间" :label-width="formLabelWidth">
        <el-input v-model="props.val.date" autocomplete="off" />
      </el-form-item>
      <el-form-item label="是否在场" :label-width="formLabelWidth">
        <el-input v-model="props.val.present" autocomplete="off" />
      </el-form-item>
      <el-form-item label="排课地点" :label-width="formLabelWidth">
        <el-input v-model="props.val.sectionId" autocomplete="off" />
      </el-form-item>
      <el-form-item label="学生ID" :label-width="formLabelWidth">
        <el-input v-model="props.val.studentId" autocomplete="off" />
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
import { Attendance } from '../../../types/dto';
import { TeacherAPI } from '../../../api';

const props = defineProps<{
  dialogFormVisible: boolean,
  val: Attendance
}>()


const formLabelWidth = '140px'

async function submit() {
  const data = await TeacherAPI.update(props.val)
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