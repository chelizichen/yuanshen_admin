import { TitleDTO } from './../types/dto';
import { Assignment, Attendance, Course, Login, Pagination, QueryId, Research, Schedule, Section, Student, Teacher } from '../types/dto'
import API from '../utils/request'

export const AssignmentAPI = {
  list(data: Pagination) {
    return API({
      url: "assignments/list",
      data,
    });
  },
  one(data: QueryId) {
    return API({
      url: "assignments/one",
      data,
    });
  },
  update(data: Assignment) {
    return API({
      url: "assignments/update",
      data,
    });
  },
  del(data: QueryId) {
    return API({
      url: "assignments/del",
      data,
    });
  },
};

export const AttendanceAPI = {
  studentList(data: Pagination) {
    return API({
      url: "attendance/student/list",
      data,
    });
  },
  teacherList(data: Pagination) {
    return API({
      url: "attendance/teacher/list",
      data,
    });
  },
  one(data: QueryId) {
    return API({
      url: "attendance/one",
      data,
    });
  },
  update(data: Attendance) {
    return API({
      url: "attendance/update",
      data,
    });
  },
  del(data: QueryId) {
    return API({
      url: "attendance/del",
      data,
    });
  },
};

export const CourseAPI = {
  list(data: Pagination) {
    return API({
      url: "courses/list",
      data,
    });
  },
  one(data: QueryId) {
    return API({
      url: "courses/one",
      data,
    });
  },
  update(data: Course) {
    return API({
      url: "courses/update",
      data,
    });
  },
  del(data: QueryId) {
    return API({
      url: "courses/del",
      data,
    });
  },
};

export const ResearchAPI = {
  list(data: Pagination) {
    return API({
      url: "research/list",
      data,
    });
  },
  one(data: QueryId) {
    return API({
      url: "research/one",
      data,
    });
  },
  update(data: Research) {
    return API({
      url: "research/update",
      data,
    });
  },
  del(data: QueryId) {
    return API({
      url: "research/del",
      data,
    });
  },
};
export const SectionAPI = {
  list(data: Pagination) {
    return API({
      url: "sections/list",
      data,
    });
  },
  one(data: QueryId) {
    return API({
      url: "sections/one",
      data,
    });
  },
  update(data: Section) {
    return API({
      url: "sections/update",
      data,
    });
  },
  del(data: QueryId) {
    return API({
      url: "sections/del",
      data,
    });
  },
};

export const StudentAPI = {
  list(data: Pagination) {
    return API({
      url: "students/list",
      data,
    });
  },
  one(data: QueryId) {
    return API({
      url: "students/one",
      data,
    });
  },
  update(data: Student) {
    return API({
      url: "students/update",
      data,
    });
  },
  del(data: QueryId) {
    return API({
      url: "students/del",
      data,
    });
  },
};

export const TeacherAPI = {
  list(data: Pagination) {
    return API({
      url: "teachers/list",
      data,
    });
  },
  one(data: QueryId) {
    return API({
      url: "teachers/one",
      data,
    });
  },
  update(data: Teacher) {
    return API({
      url: "teachers/update",
      data,
    });
  },
  del(data: QueryId) {
    return API({
      url: "teachers/del",
      data,
    });
  },
  login(data:Login) {
    return API({
      url: "teachers/login",
      data,
    });
  },
  adminList(data:Pagination){
    return API({
      url: "teachers/admin/list",
      data,
    });
  }
};

export const SubstituteAPI = {
  list(data: Pagination) {
    return API({
      url: "substitutes/list",
      data,
    });
  },
  one(data: QueryId) {
    return API({
      url: "substitutes/one",
      data,
    });
  },
  update(data: Teacher) {
    return API({
      url: "substitutes/update",
      data,
    });
  },
  del(data: QueryId) {
    return API({
      url: "substitutes/del",
      data,
    });
  },

};

export const ScheduleAPI = {
  list(data: Pagination) {
    return API({
      url: "schedules/list",
      data,
    });
  },
  one(data: QueryId) {
    return API({
      url: "schedules/one",
      data,
    });
  },
  update(data: Schedule) {
    return API({
      url: "schedules/update",
      data,
    });
  },
  del(data: QueryId) {
    return API({
      url: "schedules/del",
      data,
    });
  },
  getById(data:QueryId){
    return API({
      url: "schedules/getById",
      data,
    });
  }
};


export const TitleAPI = {
  // 查询所有的职称了表
  list(data: Pagination) {
    return API({
      url: "title/list",
      data,
    });
  },
  // 查询单个职称所代表的含义
  // 并且查询出职称上所有的教师
  one(data: TitleDTO) {
    return API({
      url: "title/getByTitle",
      data,
    });
  },
  update(data: TitleDTO) {
    return API({
      url: "title/setTitle",
      data,
    });
  },
};
