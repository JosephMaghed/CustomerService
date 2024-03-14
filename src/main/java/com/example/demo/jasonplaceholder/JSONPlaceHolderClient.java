package com.example.demo.jasonplaceholder;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(value = "jsonplaceholder",
url = "https://jsonplaceholder.typicode.com/"
)
public interface JSONPlaceHolderClient {
    @GetMapping("posts")
    List<Post>getPosts();

    @GetMapping("posts/{postId}")
    Post getPost(@PathVariable("postId")Integer postId);

}
