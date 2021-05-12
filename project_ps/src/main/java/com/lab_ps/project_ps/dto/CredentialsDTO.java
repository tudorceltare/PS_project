package com.lab_ps.project_ps.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CredentialsDTO {
    @JsonProperty("username")
    private String username;

    @JsonProperty("password")
    private String password;
}