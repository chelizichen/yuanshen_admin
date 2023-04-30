import {
  createRouter,
  createWebHistory,
  RouteRecordRaw,
} from "vue-router";

/**
 * 判断是否有业主 token
 */


const routes: RouteRecordRaw[] = [
  {
    path: "/",
    redirect: "/login",
  },
  {
    path: "/login",
    component: () => import("@/page/login/index.vue"),
  },
  {
    path: "/create",
    component: () => import("@/page/login/create.vue"),
  },
  {
    path: "/admin",
    component: () => import("@/page/admin/index.vue"),
    children: [
      {
        path: "system/user",
        component: () => import("@/page/system/user/list.vue"),
      },
      {
        path: "dashboard",
        component: () => import("@/page/dashboard/index.vue"),
      },
      {
        path: "attendance/student",
        component: () => import("@/page/attendance/student/list.vue"),
      },
      {
        path: "attendance/teacher",
        component: () => import("@/page/attendance/teacher/list.vue"),
      },
      {
        path: "teacher/teacher",
        component: () => import("@/page/teacher/teacher/list.vue"),
      },
      {
        path: "teacher/research",
        component: () => import("@/page/teacher/research/list.vue"),
      },
      {
        path: "course/course",
        component: () => import("@/page/course/course/list.vue"),
      },
      {
        path: "course/schedule",
        component: () => import("@/page/course/schedule/list.vue"),
      },
      {
        path: "course/substitutes",
        component: () => import("@/page/course/substitute/list.vue"),
      },
      {
        path: "course/section",
        component: () => import("@/page/course/section/list.vue"),
      },
      {
        path: "title/add",
        component: () => import("@/page/title/add/list.vue"),
      },
      {
        path: "title/title",
        component: () => import("@/page/title/list/list.vue"),
      },
    ],
  },
];

const router = createRouter({
  routes,
  history: createWebHistory(),
});

router.beforeEach(async (to, from, next) => {
  next()

});

export default router;
