import { defineStore } from "pinia";



let useUserInfoStore = defineStore("useUserStore", {
  state: () => ({
    user_info: undefined,
  }),
  actions: {
    getUserId() {
     
    },
  },
});

export default useUserInfoStore;
