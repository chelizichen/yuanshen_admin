package com.czq.back.controller;

import com.czq.back.dto.ListRet;
import com.czq.back.dto.PageDTO;
import com.czq.back.dto.QueryIdDTO;
import com.czq.back.entity.Follows;
import com.czq.back.service.FollowsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("follows")
public class FollowsController {

    @Autowired
    private FollowsService followsService;

    @PostMapping("/list")
    public ListRet getAllFollows(@RequestBody PageDTO pageDTO) {
        pageDTO.setPage(pageDTO.getPage() - 1);
        return followsService.getAll(pageDTO);
    }

    @PostMapping("/one")
    public Follows getFollowsById(@RequestBody QueryIdDTO queryIdDTO) {
        return followsService.getById(queryIdDTO.getId());
    }

    @PostMapping("/update")
    public Follows updateFollows(@RequestBody Follows followsDetails) {
        return followsService.save(followsDetails);
    }

    @PostMapping("/del")
    public ResponseEntity<?> deleteFollows(@RequestBody QueryIdDTO queryIdDTO) {
        followsService.deleteById(queryIdDTO.getId());
        return ResponseEntity.ok().build();
    }
}
