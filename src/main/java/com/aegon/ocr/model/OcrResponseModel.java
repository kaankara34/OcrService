package com.aegon.ocr.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OcrResponseModel {

    private String tckn;
    private String responseData;
}
