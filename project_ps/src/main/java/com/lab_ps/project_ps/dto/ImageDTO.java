package com.lab_ps.project_ps.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class ImageDTO {
    MultipartFile file;
    Long id_item;
}
