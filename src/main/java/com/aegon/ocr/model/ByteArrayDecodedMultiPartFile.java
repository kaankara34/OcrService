package com.aegon.ocr.model;

import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

public class ByteArrayDecodedMultiPartFile implements MultipartFile {
    private byte[] image;
    private String fileName;
    private String contentType;
    private File file;
    private String destPath = System.getProperty("user.dir")+ "\\src\\img\\";
    private OutputStream fileOutputStream;

    public ByteArrayDecodedMultiPartFile(byte[] image, String fileName) {
        this.image = image;
        this.fileName = fileName;
        file = new File(destPath + fileName);
    }

    @Override
    public String getName() {
        return fileName;
    }

    @Override
    public String getOriginalFilename() {
        return destPath+fileName;
    }

    @Override
    public String getContentType() {
        return MediaType.MULTIPART_FORM_DATA_VALUE;
    }

    @Override
    public boolean isEmpty() {
        return image == null || image.length == 0;
    }

    @Override
    public long getSize() {
        return image.length;
    }

    @Override
    public byte[] getBytes() throws IOException {
        return image;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return new ByteArrayInputStream(image);
    }

    @Override
    public void transferTo(File file) throws IOException, IllegalStateException {
        fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(image);
        fileOutputStream.close();
    }

    public void clearOutStreams() throws IOException {
        if (null != fileOutputStream) {
            fileOutputStream.flush();
            fileOutputStream.close();
            file.deleteOnExit();
        }
    }

    public File getFile() {
        return file;
    }
}
