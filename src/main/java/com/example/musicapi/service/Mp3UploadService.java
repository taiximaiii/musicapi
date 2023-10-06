package com.example.musicapi.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class Mp3UploadService {

    @Autowired
    private GcsUploadService gcsUploadService;

    public String uploadMp3(MultipartFile mp3File, String folderName) {
        return gcsUploadService.uploadFile(mp3File, folderName,"audio/mpeg");
    }
}
