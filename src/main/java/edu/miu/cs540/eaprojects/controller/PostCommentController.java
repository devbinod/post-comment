package edu.miu.cs540.eaprojects.controller;

import edu.miu.cs540.eaprojects.dto.PostCommentDto;
import edu.miu.cs540.eaprojects.dto.PostDto;
import edu.miu.cs540.eaprojects.exception.CommentNotFoundException;
import edu.miu.cs540.eaprojects.exception.PostNotFoundException;
import edu.miu.cs540.eaprojects.services.PostCommentService;
import edu.miu.cs540.eaprojects.services.PostProxyClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostCommentController {


    @Autowired
    private PostCommentService postCommentService;

    @Autowired
    private PostProxyClient postProxyClient;

    @GetMapping("/comments")
    public ResponseEntity findByPostId(@RequestParam Long postId) {
        return ResponseEntity.ok().body(postCommentService.findAllByPostId(postId));
    }


    @PostMapping("/comments")
    public ResponseEntity saveComment(@RequestBody PostCommentDto commentDto) {
        PostDto postDto = postProxyClient.getPostById(commentDto.getPostId());
        if (postDto == null) throw new PostNotFoundException("Post not found");
        return ResponseEntity.ok().body(postCommentService.save(commentDto));

    }


    @DeleteMapping("/comments/{commentId}")
    public ResponseEntity deleteComment(@PathVariable Long commentId) {
        PostCommentDto postCommentDto = findByCommentId(commentId);
        if (postCommentDto == null) throw new CommentNotFoundException("Comment Not found");
        postCommentService.deleteCommentById(commentId);
        return ResponseEntity.ok().build();
    }


    @PutMapping("/comments/{commentId}")
    public ResponseEntity updateComment(@PathVariable Long commentId, @RequestBody PostCommentDto postCommentDto) {
        if (findByCommentId(commentId) == null)
            throw new CommentNotFoundException("Comment not found;");
        postCommentDto.setId(commentId);
        postCommentService.update(postCommentDto);
        return ResponseEntity.ok().build();
    }


    @PutMapping("/comments/by-post-list")
    public ResponseEntity getListOfCommentByPostList(@RequestBody List<Long> postListId) {
        return ResponseEntity.ok().body(postCommentService.findAllByPostList(postListId));
    }


    private PostCommentDto findByCommentId(Long commentId) {
        return postCommentService.findById(commentId);
    }


}
