// Teacher.ts
export type Teacher = {
  teacherId: number;
  name: string;
  email: string;
  phone?: string;
  subject?: string;
  experience?: number;
  certification?: string;
  password: string;
  status: string;
};

// Student.ts
export type Student = {
  studentId: number;
  name: string;
  email: string;
  enrollmentDate: string;
}

// Course.ts
export type Course = {
  courseId: number;
  name: string;
  code: string;
  description: string;
  semester: string;
}

// Section.ts
export type Section = {
  sectionId: number;
  sectionNumber: number;
  days: string;
  startTime: string;
  endTime: string;
  location: string;
  courseId: number;
}

// Schedule.ts
export type Schedule = {
  scheduleId: number;
  startDate: string;
  endDate: string;
  teacherId: number;
  sectionId: number;
}

// Attendance.ts
export type Attendance = {
  attendanceId: number;
  date: string;
  present: boolean;
  studentId: number;
  sectionId: number;
}

// Assignment.ts
export type Assignment = {
  assignmentId: number;
  name: string;
  type: string;
  dueDate: string;
  maxPoints: number;
  sectionId: number;
}

// Research.ts
export type Research = {
  researchId: number;
  teacherId: number;
  researchTopic: string;
  paperTitle: string;
  paperJournal: string;
  paperDate: string;
  paperVolume: number;
  paperIssue: number;
  paperPages: string;
  awardName: string;
  awardDate: string;
}

// Research.ts
export type Substitute = {
  id: number;
  originalTeacher: Teacher;
  newTeacher: Teacher;
  course: Course;
  courseId:string;
  originTeacherId:string;
  substituteTeacherId:string;
  substituteTime: string;
};

// Research.ts
export type Title = {
  id: number;
  name:string;
  desc:string;
};

export type TitleDTO = {
  teacherId: number;
  titleId:number;
};

export type Pagination = {
  page: string | number,
  size: string | number,
  keyword: string
}

export type QueryId = {
  id:string|number
}

export type Login = {
  phone: string;
  password: string;
}