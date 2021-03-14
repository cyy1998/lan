package com.lan.backend.Controller;

import com.lan.backend.Service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;

@RestController
public class FileController {
    @Autowired
    FileService fileService;

    @GetMapping("file/download/{fontId}")
    ResponseEntity<FileSystemResource> download(@PathVariable("fontId") Integer fontId){
        String path = "E://lan-dp_model//database//"+fontId.toString()+"//testfont.ttf";
        File file = new File(path);
        if (file.exists()) {
            return export(file);
        }

        return null;
    }
    public ResponseEntity<FileSystemResource> export(File file) {
        if (file == null) {
            return null;
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Content-Disposition", "attachment; filename=" + file.getName());
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        headers.add("Last-Modified", new Date().toString());
        headers.add("ETag", String.valueOf(System.currentTimeMillis()));
        return ResponseEntity.ok().headers(headers).contentLength(file.length()).contentType(MediaType.parseMediaType("application/octet-stream")).body(new FileSystemResource(file));
    }

    @PostMapping("file/upload")
    public String upload(@RequestParam("fontId") int fontId,@RequestParam("file") MultipartFile file){
        return fileService.upload(fontId,file);
    }
}
