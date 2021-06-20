package com.backend.demo.service.iInterface;

import com.backend.demo.model.Post;

public interface PostService<B> extends iService<Post> {

    Post updateById(Long id, Post post);

    void deleteById(Long id);
}
