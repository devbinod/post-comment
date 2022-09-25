package edu.miu.cs540.eaprojects.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostCommentDto {

    private Long id;
    private String comment;
    private LocalDate createdDate;
    private Long postId;
    private Long userId;
}
