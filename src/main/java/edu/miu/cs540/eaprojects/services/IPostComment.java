package edu.miu.cs540.eaprojects.services;

import edu.miu.cs540.eaprojects.dto.PostCommentDto;
import edu.miu.cs540.eaprojects.entity.PostComment;

import java.util.List;

public interface IPostComment {

    List<PostCommentDto> findAllByPostId(Long postId);

    PostCommentDto findById(Long commentId);

    void deleteCommentById(Long commentId);

    PostCommentDto update(PostCommentDto postCommentDto);

    PostCommentDto save(PostCommentDto postCommentDto);
}
