package com.example.musicapi.service;

import com.example.musicapi.model.Album;
import com.example.musicapi.model.Track;

import java.util.List;

public interface AlbumService {
    List<Album> getAllAlbum();
    Album saveAlbum(Album album);
    Album findbyName(String name);
    List<Track> getAllTracksInAlbum(Long albumId);
}
