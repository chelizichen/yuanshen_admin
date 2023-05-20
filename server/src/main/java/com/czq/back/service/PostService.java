package com.czq.back.service;

import com.czq.back.dto.ListRet;
import com.czq.back.dto.PageDTO;
import com.czq.back.entity.Follows;
import com.czq.back.entity.Post;
import com.czq.back.repo.FollowsRepository;
import com.czq.back.repo.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostsRepository postsRepository;

    public Post save(Post post) {
        Post save = postsRepository.save(post);
        return save;
    }

    public Post getById(Long id) {
        Optional<Post> userOptional = postsRepository.findById(id);
        if (userOptional.isPresent()) {
            Post post = userOptional.get();
            return post;
        }
        throw new EntityNotFoundException("user not found with id " + id);
    }

    public Post update(Post post) {
        Post post1 = postsRepository.save(post);
        return post1;
    }

    public void deleteById(Long id) {
        Optional<Post> userOptional = postsRepository.findById(id);
        if (userOptional.isPresent()) {
            postsRepository.delete(userOptional.get());
        } else {
            throw new EntityNotFoundException("user not found with id " + id);
        }
    }

    public ListRet getAll(PageDTO pageDTO) {
        Pageable pageable = PageRequest.of(pageDTO.getPage(), pageDTO.getSize());
        Page<Post> byKeyword = postsRepository.findByKeyword(pageDTO.getKeyword(),pageable);
        List<Post> content = byKeyword.getContent();
        long totalElements = byKeyword.getTotalElements();
        ListRet listRet = new ListRet(content, totalElements);
        return listRet;
    }
}
