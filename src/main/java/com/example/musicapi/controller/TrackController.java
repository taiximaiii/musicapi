package com.example.musicapi.controller;

import com.example.musicapi.model.Track;
import com.example.musicapi.response.MessageResponse;
import com.example.musicapi.response.TrackResponse;
import com.example.musicapi.service.*;
import com.example.musicapi.validation.ValidFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/track")
public class TrackController {
    @Autowired
    private TrackService trackService;
    @Autowired
    private Mp3UploadService mp3UploadService;
    @Autowired
    private ImageUploadService imageUploadService;
    @Autowired
    private ArtistService artistService;
    @Autowired
    private AlbumService albumService;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadTrack(
            @RequestParam("mp3File") MultipartFile mp3File,
            @RequestParam("imgFile") MultipartFile imgFile,
            @RequestParam("title") String title,
            @RequestParam("genre") String genre,
            @RequestParam("artist") String artist,
            @RequestParam(value = "album", required = false) String album
    ) throws IOException {
        String imageUrl = imageUploadService.uploadImage(imgFile, "img_track");
        String mp3Url = mp3UploadService.uploadMp3(mp3File, "mp3");

        Track track = new Track();
        track.setTitle(title);
        track.setGenre(genre);
        track.setImageUrl(imageUrl);
        track.setMp3Url(mp3Url);
        track.setArtist(artistService.findbyName(artist));

        if (album != null) {
            track.setAlbum(albumService.findbyName(album));
        } else {
            track.setAlbum(null);
        }

        return new ResponseEntity<>(trackService.saveTrack(track), HttpStatus.OK);
    }


    @GetMapping("/all")
    public ResponseEntity<?> getAllTrack(){
        return new ResponseEntity<>(trackService.getAllTrack(),HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam Long id){
        trackService.deleteTrack(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
