package com.example.musicapi.repository;

import com.example.musicapi.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AlbumRepository extends JpaRepository<Album,Long> {
    @Query("select a from Album a where a.title =:name")
    Album findByName(String name);
}
