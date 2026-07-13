package com.coding.prod_ready_features.prod_ready_features.services;

import com.coding.prod_ready_features.prod_ready_features.dto.PostDTO;

import java.util.List;

public interface PostService {

    List<PostDTO> getAllPosts();

    PostDTO createPost(PostDTO inputPost);
}
