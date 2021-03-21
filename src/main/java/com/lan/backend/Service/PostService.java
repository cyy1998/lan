package com.lan.backend.Service;

import com.lan.backend.DTO.Post;
import com.lan.backend.Mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    PostMapper postMapper;

    public String insertPost(Post post){
        if(postMapper.insertPost(post) == 1){
            return "success";
        }else {
            return "failed";
        }
    }
    public List<Post> getPosts(){
        return postMapper.getPosts();
    }
}
