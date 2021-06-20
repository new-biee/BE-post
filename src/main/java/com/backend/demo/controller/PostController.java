package com.backend.demo.controller;

import com.backend.demo.model.Post;
import com.backend.demo.service.iInterface.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public ResponseEntity<Iterable<Post>> getPost() {
        List<Post> listPost = (List<Post>) postService.findAll();
        if (listPost.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listPost, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable("id") Long id){
        Optional<Post> post = postService.findById(id);
        if (post.isPresent()){
            Post post1 = post.get();
            return new ResponseEntity<>(post1,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post){
        postService.save(post);
        return new ResponseEntity<>(post, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable ("id") Long id, @RequestBody Post post){
        postService.updateById(id, post);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable ("id") Long id){
        postService.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
