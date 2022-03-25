package com.backend.meme;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemesRepository extends JpaRepository<Meme, Long> {

}