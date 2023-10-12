package com.example.musicapi.controller;

import com.example.musicapi.model.Playlist;
import com.example.musicapi.security.UserPrincipal;
import com.example.musicapi.service.PlayListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/playlist")
public class PlayListController {
    @Autowired
    private PlayListService playListService;

    @PostMapping("/create")
    public ResponseEntity<?> createPlaylist(@RequestBody Playlist playlist, @AuthenticationPrincipal UserPrincipal userPrincipal){
        Playlist existingPlaylist = playListService.findByName(playlist.getName());
        if (existingPlaylist != null) {
            String errorMessage = "Playlist with the same name already exists.";
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(playListService.savePlaylist(playlist,userPrincipal.getId()), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<?> getAllPlayListbyUser(@AuthenticationPrincipal UserPrincipal userPrincipal){
        return new ResponseEntity<>(playListService.getAllPlayListbyUser(userPrincipal.getId()),HttpStatus.OK);
    }

}
