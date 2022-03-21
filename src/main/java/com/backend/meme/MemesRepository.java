package com.backend.meme;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemesRepository extends JpaRepository<Memes, Long> {


}