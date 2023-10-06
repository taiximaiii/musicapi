package com.example.musicapi.service;

import com.example.musicapi.model.Track;
import com.example.musicapi.response.TrackResponse;

import java.util.List;

public interface TrackService {
    List<TrackResponse> getAllTrack();
    Track saveTrack( Track track);
    public void deleteTrack(Long id);
}
