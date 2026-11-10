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
        Post p=new Post();
        p.setContent(data.description);
        p.setUrl("/dummy");
        p.setUserId(Long.valueOf(userid));
        Post savedPost=postRepository.save(p);
        PostResponseDTO prd=new PostResponseDTO();
        prd.title= data.title;
        prd.description=data.description;
        return prd;
    }
}
