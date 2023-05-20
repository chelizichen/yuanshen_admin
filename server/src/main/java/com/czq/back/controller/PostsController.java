package com.czq.back.controller;

import com.czq.back.dto.ListRet;
import com.czq.back.dto.PageDTO;
import com.czq.back.dto.QueryIdDTO;
import com.czq.back.entity.Follows;
import com.czq.back.entity.Post;
import com.czq.back.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("posts")
public class PostsController {

    @Autowired
    private PostService postService;

    @PostMapping("/list")
    public ListRet getAll(@RequestBody PageDTO pageDTO) {
        pageDTO.setPage(pageDTO.getPage() - 1);
        return postService.getAll(pageDTO);
    }

    @PostMapping("/one")
    public Post getById(@RequestBody QueryIdDTO queryIdDTO) {
        return postService.getById(queryIdDTO.getId());
    }

    @PostMapping("/update")
    public Post update(@RequestBody Post post) {
        return postService.save(post);
    }

    @PostMapping("/del")
    public ResponseEntity<?> delete(@RequestBody QueryIdDTO queryIdDTO) {
        postService.deleteById(queryIdDTO.getId());
        return ResponseEntity.ok().build();
    }
}
