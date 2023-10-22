package com.example.musicapi.controller;

import com.example.musicapi.security.UserPrincipal;
import com.example.musicapi.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/add")
    public ResponseEntity<?> addComment(@RequestParam("content") String content, @AuthenticationPrincipal UserPrincipal userPrincipal,@RequestParam("trackId") Long trackId){
        return new ResponseEntity<>(commentService.saveComment(content,trackId, userPrincipal.getId()), HttpStatus.CREATED);
    }
    @GetMapping("/all")
    public ResponseEntity<?> getCommentInTrack(@RequestParam("trackId") Long trackId){
        return new ResponseEntity<>(commentService.getCommentInTrack(trackId),HttpStatus.OK);
    }
}
