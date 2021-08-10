package com.aegon.ocr.exception;

import lombok.Getter;

@Getter
public class FileNotFoundException extends Exception {

	private final String message = "Lütfen TC Kimlik taraması yapmak istediğiniz dosyayı gönderiniz.";
}
