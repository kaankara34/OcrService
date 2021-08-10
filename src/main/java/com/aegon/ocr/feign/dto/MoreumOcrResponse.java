package com.aegon.ocr.feign.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MoreumOcrResponse {

    @JsonProperty("tckn")
    private String tckn;
    @JsonProperty("responseData")
    private String responseData;
}