package edu.miu.cs540.eaprojects.mapper;


import edu.miu.cs540.eaprojects.dto.PostCommentDto;
import edu.miu.cs540.eaprojects.entity.PostComment;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public  interface PostCommentMapper {

     PostComment toEntity(PostCommentDto commentDto);

    PostCommentDto toDto(PostComment postComment) ;


    List<PostComment> toListEntity(List<PostCommentDto> postCommentDtoList);

    List<PostCommentDto> toListDto(List<PostComment> postCommentList);


}
