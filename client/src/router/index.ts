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
        path: "system/user_add",
        component: () => import("@/page/system/user/edit.vue"),
      },
      {
        path: "posts/list",
        component: () => import("@/page/posts/list.vue"),
      },
      {
        path: "posts/edit",
        component: () => import("@/page/posts/edit.vue"),
      },
      {
        path: "follows/list",
        component: () => import("@/page/follows/list.vue"),
      },
      {
        path: "follows/edit",
        component: () => import("@/page/follows/edit.vue"),
      },
      {
        path: "dashboard",
        component: () => import("@/page/dashboard/index.vue"),
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
