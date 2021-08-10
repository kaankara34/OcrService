package com.aegon.ocr.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.aegon.ocr.feign.MoreumOcrServiceFeign;
import com.aegon.ocr.feign.dto.MoreumOcrResponse;
import com.aegon.ocr.service.OcrService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OcrServiceImpl implements OcrService {

	private final MoreumOcrServiceFeign ocrServiceFeign;

	@Override
	public MoreumOcrResponse sendFileToMoreumOcr(String ocrLibrary, MultipartFile file) {

		MoreumOcrResponse[] response = new MoreumOcrResponse[1];
		if (StringUtils.isEmpty(ocrLibrary) && !ocrLibrary.equals("R")) {
			response = ocrServiceFeign.getMoreumOcrResponse("R", file);
		} else {
			response = ocrServiceFeign.getMoreumOcrResponse(ocrLibrary, file);
		}

		return response[0];

	}

	/*
	 * @Override public MoreumOcrResponse sendFileToMoreumOcr(String ocrLibrary,
	 * byte[] file) { String fileName = "img.png"; ByteArrayDecodedMultiPartFile
	 * customMultipartFile = new ByteArrayDecodedMultiPartFile(file, fileName); try
	 * { customMultipartFile.transferTo(customMultipartFile.getFile());
	 * 
	 * } catch (IllegalStateException e) { System.out.println(e);
	 * //log.info("IllegalStateException : " + e); } catch (IOException e) {
	 * System.out.println(e); //log.info("IOException : " + e); }
	 * 
	 * MoreumOcrResponse[] moreumOcrResponse =
	 * ocrServiceFeign.getMoreumOcrResponse(ocrLibrary, customMultipartFile); return
	 * moreumOcrResponse[0]; }
	 */
}
