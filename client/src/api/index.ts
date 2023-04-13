import { Assignment, Attendance, Course, Login, Pagination, QueryId, Research, Section, Student, Teacher } from '../types/dto'
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
  list(data: Pagination) {
    return API({
      url: "attendance/list",
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
  }
};




