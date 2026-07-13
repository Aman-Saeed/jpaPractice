package com.coding.prod_ready_features.prod_ready_features.services;

import com.coding.prod_ready_features.prod_ready_features.dto.PostDTO;
import com.coding.prod_ready_features.prod_ready_features.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public List<PostDTO> getAllPosts() {
        // Implementation for retrieving all posts
        return null;
    }

    @Override
    public PostDTO createPost(PostDTO inputPost) {
        // Implementation for creating a new post
        return null;
    }
}
