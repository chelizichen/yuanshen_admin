<template>
  <el-dialog v-model="props.dialogFormVisible" title="更新课表" @closed="close">
    <el-form :model="props.val">

      <el-form-item label="开始时间" :label-width="formLabelWidth">
        <div class="block">
          <el-date-picker
            v-model="props.val.startDate"
            type="date"
            placeholder="Pick a day"
          />
        </div>
      </el-form-item>
      <el-form-item label="结束时间" :label-width="formLabelWidth">
        <div class="block">
          <el-date-picker
            v-model="props.val.endDate"
            type="date"
            placeholder="Pick a day"
          />
        </div>
      </el-form-item>
      <el-form-item label="排课时间" :label-width="formLabelWidth">
        <el-input v-model="props.val.sectionId"></el-input>
      </el-form-item>
      <el-form-item label="任课老师" :label-width="formLabelWidth">
        <el-input v-model="props.val.teacherId"></el-input>
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
import { Schedule } from '../../../types/dto';
import { TeacherAPI } from '../../../api';

const props = defineProps<{
  dialogFormVisible: boolean,
  val: Schedule
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