package com.example.musicapi.service;

import com.example.musicapi.model.Playlist;
import com.example.musicapi.model.User;
import com.example.musicapi.repository.PlaylistRepository;
import com.example.musicapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayListServiceImpl implements PlayListService{

    @Autowired
    private PlaylistRepository playlistRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public Playlist savePlaylist(Playlist playlist,Long userId){

        User user = userRepository.findById(userId).orElse(null);
        playlist.setUser(user);
        Playlist saved  = playlistRepository.save(playlist);
        user.addPlaylist(saved);
        return saved ;
    }
    @Override
    public List<Playlist> getAllPlayListbyUser(Long userId){

        return playlistRepository.findAllPlaylistbyUserId(userId);
    }
    @Override
    public Playlist findByName(String name){
        return playlistRepository.findByName(name);
    }
}
