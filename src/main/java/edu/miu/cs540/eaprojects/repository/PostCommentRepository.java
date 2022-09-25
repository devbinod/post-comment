package edu.miu.cs540.eaprojects.repository;

import edu.miu.cs540.eaprojects.entity.PostComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostCommentRepository extends JpaRepository<PostComment,Long> {

    List<PostComment> findAllByPostId(Long postId);
}
