package com.czq.back.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PageDTO {
    private Integer page;
    private Integer size;
    private String keyword;
}
