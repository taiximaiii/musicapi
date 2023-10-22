package com.example.musicapi.service;

import com.example.musicapi.model.Comment;

import java.util.List;

public interface CommentService {
    Comment saveComment(String content,Long trackId,Long userId);
    List<Comment> getCommentInTrack(Long trackId);
}
