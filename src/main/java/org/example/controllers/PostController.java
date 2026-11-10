package org.example.controllers;


import org.example.dtos.PostRequestDTO;
import org.example.dtos.PostResponseDTO;
import org.example.services.PostService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/post")
public class PostController {
    final private PostService service;

    public PostController(PostService service){
       this.service=service;
    }
    @PostMapping("/{userid}")
    public PostResponseDTO CreatePost(@RequestBody PostRequestDTO data, @PathVariable String userid){
         PostResponseDTO prd= service.createPost(data,userid);
         return prd;

    }
    @DeleteMapping("/{userid}/{postid}")
    public String DeletePost(@PathVariable String userid,@PathVariable String postid){
        return userid+"CreatePost2"+postid;
    }

    @PutMapping
    public String EditPost(){
        return "CreatePost3";
    }

    @GetMapping("/{id}")
    public String GetPostById(){
        return "CreatePost4";
    }

    @GetMapping("/user/{user_id}")
    public String GetUserPosts(){
        return "CreatePost5";
    }


}

/*
*  Post , data
*  delete id
*  Put , data
*  get , /{postid}
*  get,  /{userid}
*
*
* */