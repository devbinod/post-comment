package edu.miu.cs540.eaprojects.services;


import edu.miu.cs540.eaprojects.dto.PostDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "post-service", url = "https://jsonplaceholder.typicode.com/")
public interface PostProxyClient {
    @RequestMapping(method = RequestMethod.GET, value = "/posts/{postId}", produces = "application/json")
    PostDto getPostById(@PathVariable("postId") Long postId);
}
