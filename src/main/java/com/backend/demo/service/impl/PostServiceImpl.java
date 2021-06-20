package com.backend.demo.service.impl;

import com.backend.demo.model.Post;
import com.backend.demo.repository.BlogRepository;
import com.backend.demo.service.iInterface.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostServiceImpl implements PostService<Post> {

    @Autowired
    BlogRepository blogRepository;

    @Autowired
    PostService postService;

    @Override
    public Iterable<Post> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Post save(Post post) {
        return blogRepository.save(post);
    }

    @Override
    public Optional<Post> findById(Long id) {
        return blogRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Post updateById(Long id, Post post) {
        Optional<Post> currentPost = blogRepository.findById(id);
        if (currentPost.isPresent()){
            post.setId(id);
            postService.save(post);
            return post;
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        Optional<Post> post = postService.findById(id);
        if (post.isPresent()){
            postService.remove(id);
        }
    }
}
