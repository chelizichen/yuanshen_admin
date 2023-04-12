import API from '../utils/request'
const Api = {
  // 登录接口
  login: (params) => API.post("/api/login", params),

  // 获取教师列表接口
  getTeachers: () => API.get("/api/teachers"),

  // 创建教师接口
  createTeacher: (params) => API.post("/api/teachers", params),

  // 更新教师接口
  updateTeacher: (id, params) => API.put(`/api/teachers/${id}`, params),

  // 删除教师接口
  deleteTeacher: (id) => API.delete(`/api/teachers/${id}`),

  // 获取课程列表接口
  getCourses: () => API.get("/api/courses"),

  // 创建课程接口
  createCourse: (params) => API.post("/api/courses", params),

  // 更新课程接口
  updateCourse: (id, params) => API.put(`/api/courses/${id}`, params),

  // 删除课程接口
  deleteCourse: (id) => API.delete(`/api/courses/${id}`),

  // 获取考勤列表接口
  getAttendance: (params) => API.get("/api/attendance", { params }),

  // 创建考勤接口
  createAttendance: (params) => API.post("/api/attendance", params),

  // 更新考勤接口
  updateAttendance: (id, params) => API.put(`/api/attendance/${id}`, params),

  // 删除考勤接口
  deleteAttendance: (id) => API.delete(`/api/attendance/${id}`),
};

export default Api;
