package com.lan.backend.Controller;

import com.lan.backend.DTO.Post;
import com.lan.backend.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostController {
    @Autowired
    PostService postService;

    @GetMapping("post/get_all")
    List<Post> getPosts(){return postService.getPosts();}

    @PostMapping("post/post")
    String savePost(@RequestBody Post post){
        return postService.insertPost(post);
    }
}
