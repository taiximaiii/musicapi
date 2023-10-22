package com.example.musicapi.service;

import com.example.musicapi.model.Comment;
import com.example.musicapi.model.Track;
import com.example.musicapi.model.User;
import com.example.musicapi.repository.CommentRepository;
import com.example.musicapi.repository.TrackRepository;
import com.example.musicapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TrackRepository trackRepository;
    @Override
    public Comment saveComment(String content,Long trackId,Long userId){
        Comment comment = new Comment();
        ZoneId vietnamZone = ZoneId.of("Asia/Ho_Chi_Minh");
        ZonedDateTime now = ZonedDateTime.now(vietnamZone);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy");
        String formattedTimestamp = now.format(formatter);
        comment.setTimestamp(formattedTimestamp);
        User user = userRepository.findById(userId).orElse(null);
        Track track = trackRepository.findById(trackId).orElse(null);
        comment.setUser(user);
        comment.setTrack(track);
        comment.setContent(content);
        return commentRepository.save(comment);
    }
    @Override
    public List<Comment> getCommentInTrack(Long trackId){
        return commentRepository.getCommentInTrack(trackId);
    }
}
