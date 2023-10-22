package com.example.musicapi.service;

import com.example.musicapi.model.Comment;

public interface CommentService {
    Comment saveComment(String content,Long trackId,Long userId);
}
