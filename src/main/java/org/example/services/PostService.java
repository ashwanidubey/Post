package org.example.services;

import org.example.Repository.PostRepository;
import org.example.dtos.PostRequestDTO;
import org.example.dtos.PostResponseDTO;
import org.example.models.Post;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    final private PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostResponseDTO createPost(PostRequestDTO data, String userid){
        System.out.println("hi 1.1");
        Post p=new Post();
        p.setContent(data.description);
        p.setUrl("/dummy");
        p.setUserId(Long.valueOf(userid));
        //p.setId(111111111111111L);
        Post savedPost=postRepository.save(p);
        System.out.println(savedPost);
        PostResponseDTO prd=new PostResponseDTO();
        //prd.id=data.id; auto generate
        prd.title= data.title;
        prd.description=data.description;
        System.out.println("hi 1.5");
        return prd;
    }
}
