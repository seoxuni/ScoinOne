package com.scoinone.core.dto.response.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserResponseDto {
    private String userId;
    private String username;
    private String email;
    private String updatedAt;
}