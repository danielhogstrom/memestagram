package com.backend.meme;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemesRepository extends JpaRepository<Memes, Long> {


}