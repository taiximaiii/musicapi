package com.example.musicapi.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TrackResponse {
    private Long id;
    private String title;
    private String genre;
    private String duration;
    private String mp3Url;
    private String imageUrl;
    private String artist;

    public TrackResponse(Long id, String title, String genre, String duration, String mp3Url,String imageUrl) {
        super();
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.imageUrl = imageUrl;
        this.mp3Url = mp3Url;
    }
}
