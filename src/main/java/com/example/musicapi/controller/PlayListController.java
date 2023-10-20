package com.example.musicapi.controller;

import com.example.musicapi.model.Playlist;
import com.example.musicapi.model.Track;
import com.example.musicapi.security.UserPrincipal;
import com.example.musicapi.service.PlayListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/{playlistId}/addTrack/{trackId}")
    public ResponseEntity<String> addTrackToPlaylist(
            @PathVariable Long playlistId,
            @PathVariable Long trackId
    ) {
        boolean trackAlreadyExists = playListService.checkIfTrackExistsInPlaylist(trackId,playlistId);

        if (trackAlreadyExists) {
            return new ResponseEntity<>("Track already exists in the playlist.", HttpStatus.BAD_REQUEST);
        }
        playListService.addTracktoPlaylist(trackId,playlistId);
        return new ResponseEntity<>("Track added to playlist successfully.", HttpStatus.OK);
    }
    @PostMapping("/{playlistId}/removeTrack/{trackId}")
    public ResponseEntity<String> removeTrackfromPlaylist(
            @PathVariable Long playlistId,
            @PathVariable Long trackId
    ) {
        playListService.removeTrackfromPlaylist(trackId,playlistId);
        return new ResponseEntity<>("Track removed successfully.", HttpStatus.OK);
    }

    @GetMapping("/{playlistId}/tracks")
    public ResponseEntity<?> getTracksInPlaylist( @PathVariable Long playlistId){
        List<Track> tracks = playListService.getTracksInPlaylist(playlistId);
        return new ResponseEntity<>(tracks,HttpStatus.OK);
    }
}
