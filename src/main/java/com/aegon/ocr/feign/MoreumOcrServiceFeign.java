package com.aegon.ocr.feign;

import com.aegon.ocr.config.FeignSupportConfig;
import com.aegon.ocr.feign.dto.MoreumOcrResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(name = "moreum-ocr-service", url = "${ocr.url}", configuration = FeignSupportConfig.class)
public interface MoreumOcrServiceFeign {


    @RequestMapping(method = RequestMethod.POST, value = "/data", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    MoreumOcrResponse[] getMoreumOcrResponse(@RequestParam("ocrLibrary") String ocrLibrary,
                                             @RequestPart("dataFile") MultipartFile dataFile);

}
