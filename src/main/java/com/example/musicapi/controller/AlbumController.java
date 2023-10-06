package com.example.musicapi.controller;

import com.example.musicapi.model.Album;
import com.example.musicapi.model.Track;
import com.example.musicapi.service.AlbumService;
import com.example.musicapi.service.ArtistService;
import com.example.musicapi.service.ImageUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/album")
public class AlbumController {
    @Autowired
    private AlbumService albumService;
    @Autowired
    private ImageUploadService imageUploadService;
    @Autowired
    private ArtistService artistService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllAlbum(){
        return new ResponseEntity<>(albumService.getAllAlbum(), HttpStatus.OK);
    }

    @PostMapping("/upload")
    public ResponseEntity<Album> uploadAlbum(
            @RequestParam("file") MultipartFile file,
            @RequestParam("title") String title,
            @RequestParam("releaseDate") String releaseDate,
            @RequestParam("artist") String artist
    ) throws IOException {
        String imageUrl = imageUploadService.uploadImage(file, "img_album");

        Album album = new Album();
        album.setTitle(title);
        album.setImageUrl(imageUrl);
        album.setReleaseDate(releaseDate);
        album.setArtist(artistService.findbyName(artist));
        albumService.saveAlbum(album);

        return ResponseEntity.ok(album);

    }
    @GetMapping("/{albumId}/tracks")
    public ResponseEntity<?> getAllTracks(@PathVariable Long albumId) {
        List<Track> tracks = albumService.getAllTracksInAlbum(albumId);
        return new ResponseEntity<>(tracks, HttpStatus.OK);
    }
}
