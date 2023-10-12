package com.example.musicapi.service;

import com.example.musicapi.model.Playlist;

import java.util.List;

public interface PlayListService {
    Playlist savePlaylist(Playlist playlist,Long userId);
    List<Playlist> getAllPlayListbyUser(Long userId);
    Playlist findByName(String name);
}
