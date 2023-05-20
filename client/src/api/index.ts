import { Login, Pagination, QueryId, User, Post, Follows } from './../types/dto';
import API from '../utils/request'

export const UserAPI = {
  list(data: Pagination) {
    return API({
      url: "user/list",
      data,
    });
  },
  one(data: QueryId) {
    return API({
      url: "user/one",
      data,
    });
  },
  update(data: User) {
    return API({
      url: "user/update",
      data,
    });
  },
  del(data: QueryId) {
    return API({
      url: "user/del",
      data,
    });
  },
  login(data: Login) {
    return API({
      url: "user/login",
      data,
    });
  },
};

export const PostsAPI = {
  list(data: Pagination) {
    return API({
      url: "posts/list",
      data,
    });
  },
  one(data: QueryId) {
    return API({
      url: "posts/one",
      data,
    });
  },
  update(data: Post) {
    return API({
      url: "posts/update",
      data,
    });
  },
  del(data: QueryId) {
    return API({
      url: "posts/del",
      data,
    });
  },
};

export const FollowsAPI = {
  list(data: Pagination) {
    return API({
      url: "follows/list",
      data,
    });
  },
  one(data: QueryId) {
    return API({
      url: "follows/one",
      data,
    });
  },
  update(data: Follows) {
    return API({
      url: "follows/update",
      data,
    });
  },
  del(data: QueryId) {
    return API({
      url: "follows/del",
      data,
    });
  },
};


