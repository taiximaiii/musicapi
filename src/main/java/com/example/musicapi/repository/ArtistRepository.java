package com.example.musicapi.repository;

import com.example.musicapi.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist,Long> {
    Artist findByName(String name);
}
