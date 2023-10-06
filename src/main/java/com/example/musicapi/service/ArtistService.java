package com.example.musicapi.service;

import com.example.musicapi.model.Artist;
import com.example.musicapi.response.TrackResponse;

import java.util.List;

public interface ArtistService {
    List<Artist> getAllArtist();
    Artist saveArtist(Artist artist);
    Artist findbyName(String name);
    List<TrackResponse> getAllTracksOfArtist(Long ArtistId);
}
