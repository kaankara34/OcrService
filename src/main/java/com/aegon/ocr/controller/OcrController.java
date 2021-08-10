package com.aegon.ocr.controller;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.aegon.ocr.exception.FileNotFoundException;
import com.aegon.ocr.feign.dto.MoreumOcrResponse;
import com.aegon.ocr.service.OcrService;

import lombok.AllArgsConstructor;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@AllArgsConstructor
public class OcrController {

	private final OcrService ocrService;

	@PostMapping(value = "/do-ocr")
	public MoreumOcrResponse getOcrResponse(@RequestParam(name = "ocrLibrary", required = false) String ocrLibrary,
			@RequestParam(name = "file", required = false) MultipartFile file) throws FileNotFoundException {
		if (StringUtils.isEmpty(file) || file.isEmpty()) {
			throw new FileNotFoundException();
		}
		return ocrService.sendFileToMoreumOcr(ocrLibrary, file);

	}

	/*
	 * @PostMapping(value = "/do-ocr-byte", consumes =
	 * MediaType.MULTIPART_FORM_DATA_VALUE, produces =
	 * MediaType.APPLICATION_JSON_VALUE) public MoreumOcrResponse
	 * getOcrResponseWithByteArray(@RequestParam("ocrLibrary") String
	 * ocrLibrary, @RequestParam("file") byte[] file) { return
	 * ocrService.sendFileToMoreumOcr(ocrLibrary, file);
	 * 
	 * }
	 */

}
