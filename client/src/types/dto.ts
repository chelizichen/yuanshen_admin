export interface User {
  userId: string;
  username: string;
  password: string;
  signature: string;
  level: string;
  loginTime: string;
  createTime: string;
  truthName: string;
  avatar: string;
}

export interface Follows {
  id: string;
  postId: string;
  toUserId: string;
  content: string;
  releaseTime: string;
  like: string;
  disLike: string;
  userId: string;
}

export interface Post {
  id: string;
  title: string;
  releaseTime: string;
  type: string;
  tags: string;
  views: string;
  like: string;
  content: string;
  img: string;
  userId: string;
}



export type Pagination = {
  page: string | number,
  size: string | number,
  keyword: string
}

export type QueryId = {
  id:string|number
}

export type Login = {
  username: string;
  password: string;
}