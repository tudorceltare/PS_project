package com.lab_ps.project_ps.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class LoginSuccessDTO {
    private String type;
    private Long id;
}
