package com.example.musicapi.repository;

import com.example.musicapi.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    @Query(value = "select c from Comment c where c.track.id = :trackId")
    List<Comment> getCommentInTrack(Long trackId);
}
