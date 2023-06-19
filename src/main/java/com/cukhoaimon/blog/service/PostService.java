package com.cukhoaimon.blog.service;

import com.cukhoaimon.blog.data.Post;
import com.cukhoaimon.blog.repository.PostRepository;
import com.cukhoaimon.blog.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public Post findById(String id) {
        return postRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public void save(Post post) {
        postRepository.save(post);
    }

    public void deleteById(String id) {
        postRepository.deleteById(id);
    }
}
