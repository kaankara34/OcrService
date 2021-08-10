package com.aegon.ocr.service;

import com.aegon.ocr.feign.dto.MoreumOcrResponse;
import org.springframework.web.multipart.MultipartFile;

public interface OcrService {

	MoreumOcrResponse sendFileToMoreumOcr(String ocrLibrary, MultipartFile file);
	// MoreumOcrResponse sendFileToMoreumOcr(String ocrLibrary, byte[] file);
}
