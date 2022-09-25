package edu.miu.cs540.eaprojects.services;

import edu.miu.cs540.eaprojects.dto.PostCommentDto;
import edu.miu.cs540.eaprojects.entity.PostComment;
import edu.miu.cs540.eaprojects.mapper.PostCommentMapper;
import edu.miu.cs540.eaprojects.repository.PostCommentRepository;
import edu.miu.cs540.eaprojects.util.ApplicationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PostCommentService implements IPostComment {


    @Autowired
    private PostCommentRepository postCommentRepository;

    @Autowired
    private PostCommentMapper postCommentMapper;


    @Override
    public List<PostCommentDto> findAllByPostId(Long postId) {
        return postCommentMapper.toListDto(postCommentRepository.findAllByPostId(postId));
    }

    @Override
    public PostCommentDto findById(Long commentId) {
        return postCommentMapper.toDto(postCommentRepository.findById(commentId).orElseThrow());
    }

    @Override
    public void deleteCommentById(Long commentId) {
    postCommentRepository.deleteById(commentId);
    }

    @Override
    public PostCommentDto update(PostCommentDto postCommentDto) {
        return persistComment(postCommentDto);
    }

    @Override
    public PostCommentDto save(PostCommentDto postCommentDto) {
        postCommentDto.setUserId(ApplicationUtil.getUserId());
        return persistComment(postCommentDto);

    }

    @Override
    public List<PostCommentDto> findAllByPostList(List<Long> postListId) {
        return postCommentMapper.toListDto(postCommentRepository.findAllByPostIdIn(postListId));
    }



    @Override
    public void deleteAllByPostId(Long postId) {
        postCommentRepository.deleteAllByPostId(postId);
    }

    private PostCommentDto persistComment(PostCommentDto postCommentDto) {
        return postCommentMapper.toDto(
                postCommentRepository.saveAndFlush(postCommentMapper.toEntity(postCommentDto))
        );
    }
}
