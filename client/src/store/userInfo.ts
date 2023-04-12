import { defineStore } from "pinia";



let useUserInfoStore = defineStore("useUserStore", {
  state: () => ({
    userId: undefined,
    user_info: undefined,
    owner_info:undefined
  }),
  actions: {
    getUserId() {
      if (!this.userId) {
        let userId = localStorage.getItem("userId");
        if (!userId) {
          return false;
        } else {
          return userId;
        }
      } else {
        return this.userId;
      }
    },
  },
});

export default useUserInfoStore;
