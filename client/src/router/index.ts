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
    redirect: "/admin",
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
