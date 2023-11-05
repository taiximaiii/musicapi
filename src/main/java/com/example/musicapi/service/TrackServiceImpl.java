package com.example.musicapi.service;

import com.example.musicapi.model.Track;
import com.example.musicapi.repository.TrackRepository;
import com.example.musicapi.response.TrackResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class TrackServiceImpl implements TrackService{
    @Autowired
    private TrackRepository trackRepository;


    @Override
    public List<TrackResponse> getAllTrack() {
        List<Track> tracks = trackRepository.findAll();
        List<TrackResponse> trackResponses = new ArrayList<>();

        for (Track track : tracks) {
            TrackResponse trackResponse = new TrackResponse(
                    track.getId(),
                    track.getTitle(),
                    track.getGenre(),
                    track.getMp3Url(),
                    track.getImageUrl(),
                    track.getArtist().getName()
            );
            trackResponses.add(trackResponse);
        }

        return trackResponses;
    }
    @Override
    public List<TrackResponse> searchTrackByTitle(String keyword){
        List<Track> tracks = trackRepository.searchTrackByTitle(keyword);
        List<TrackResponse> trackResponses = new ArrayList<>();

        for (Track track : tracks) {
            TrackResponse trackResponse = new TrackResponse(
                    track.getId(),
                    track.getTitle(),
                    track.getGenre(),
                    track.getMp3Url(),
                    track.getImageUrl(),
                    track.getArtist().getName()
            );
            trackResponses.add(trackResponse);
        }

        return trackResponses;
    }

    @Override
    public Track saveTrack( Track track) {
        return trackRepository.save(track);
    }
    @Override
    public void deleteTrack(Long id){
        trackRepository.deleteById(id);
    }
}
