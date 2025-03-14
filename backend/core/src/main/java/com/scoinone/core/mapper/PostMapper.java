package com.scoinone.core.mapper;

import com.scoinone.core.dto.common.PageInfoDto;
import com.scoinone.core.dto.response.post.*;
import com.scoinone.core.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapper {
    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    @Mapping(source = "postId", target = "postId")
    @Mapping(source = "postType", target = "postType")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "content", target = "content")
    @Mapping(source = "user.userId", target = "userId")
    @Mapping(source = "createdAt", target = "createdAt", dateFormat = "yyyy-MM-dd'T'HH:mm:ss")
    @Mapping(source = "updatedAt", target = "updatedAt", dateFormat = "yyyy-MM-dd'T'HH:mm:ss")
    CreatePostResponseDto postToCreatePostResponseDto(Post post);

    @Mapping(source = "postId", target = "postId")
    @Mapping(source = "postType", target = "postType")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "content", target = "content")
    @Mapping(source = "user.userId", target = "userId")
    @Mapping(source = "createdAt", target = "createdAt", dateFormat = "yyyy-MM-dd'T'HH:mm:ss")
    @Mapping(source = "updatedAt", target = "updatedAt", dateFormat = "yyyy-MM-dd'T'HH:mm:ss")
    GetPostResponseDto postToGetPostResponseDto(Post post);

    @Mapping(source = "postId", target = "postId")
    @Mapping(source = "postType", target = "postType")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "content", target = "content")
    @Mapping(source = "user.userId", target = "userId")
    @Mapping(source = "createdAt", target = "createdAt", dateFormat = "yyyy-MM-dd'T'HH:mm:ss")
    @Mapping(source = "updatedAt", target = "updatedAt", dateFormat = "yyyy-MM-dd'T'HH:mm:ss")
    UpdatePostResponseDto postToUpdatePostResponseDto(Post post);

    List<GetPostResponseDto> postsToGetPostResponseDtos(List<Post> posts);

    default GetPostListResponseDto pageToGetPostListResponseDto(Page<Post> page) {
        GetPostListResponseDto responseDto = new GetPostListResponseDto();
        responseDto.setPosts(postsToGetPostResponseDtos(page.getContent()));
        responseDto.setPageInfo(PageInfoDto.builder()
                .totalElements(page.getTotalElements())
                .totalPages(page.getTotalPages())
                .build());

        return responseDto;
    }
}
