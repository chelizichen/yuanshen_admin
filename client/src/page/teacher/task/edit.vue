<template>
  <el-dialog v-model="props.dialogFormVisible" title="更新教师" @closed="close">
    <el-form :model="props.val">
      <el-form-item label="教师姓名" :label-width="formLabelWidth">
        <el-input v-model="props.val.name" autocomplete="off" />
      </el-form-item>
      <el-form-item label="认证信息" :label-width="formLabelWidth">
        <el-input v-model="props.val.certification" autocomplete="off" />
      </el-form-item>

      <el-form-item label="教师电话" :label-width="formLabelWidth">
        <el-input v-model="props.val.phone" autocomplete="off" />
      </el-form-item>
      <el-form-item label="密码" :label-width="formLabelWidth">
        <el-input v-model="props.val.password" autocomplete="off" />
      </el-form-item>
      <div v-for="item in state.data">
        <el-form-item label="工作时间" :label-width="formLabelWidth">
          <div>{{ new Date(item.startDate).toDateString() }} - {{ new Date(item.endDate).toDateString()  }}</div>
          <div></div>
        </el-form-item>
        <el-form-item label="工作日" :label-width="formLabelWidth">
          <div>{{ item.section.days }}</div>
        </el-form-item>
        <el-form-item label="工作地点" :label-width="formLabelWidth">
          <div>{{ item.section.location }}</div>
        </el-form-item>
        <el-form-item label="课程名" :label-width="formLabelWidth">
          <div>{{ item.section.course.name }}</div>
        </el-form-item>
      </div>
    </el-form>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="close">取消</el-button>
        <el-button type="primary" @click="submit"> 修改 </el-button>
      </span>
    </template>
  </el-dialog>
</template>

<script setup lang="ts">
import { reactive, ref, watch } from "vue";
import { Teacher } from "../../../types/dto";
import { TeacherAPI, ScheduleAPI } from "../../../api";

const props = defineProps<{
  dialogFormVisible: boolean;
  val: Teacher;
}>();

const state = reactive({
  data: [],
});

watch(props, async () => {
  if (props.val) {
    const data = await ScheduleAPI.getById({ id: props.val.id });
    state.data = data.list;
  }
});

const formLabelWidth = "140px";

async function submit() {
  const data = await TeacherAPI.update(props.val);
  emit("success", "操作成功");
  emit("close");
  console.log(data);
}

const emit = defineEmits(["close", "success"]);

function close() {
  emit("close");
}
</script>

<style scoped></style>
