package com.backend.meme;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemesRepositoryTest {

    @Autowired
    MemesRepository underTest;

    @Test
    public void createMeme() {
        Meme meme = new Meme(1L, "www.abc.com", "good", 4L, null);
        assertThat(meme.getPicurl()).isEqualTo("www.abc.com");
    }

    @Test
    public void memeRepository() {
        List<Meme> asd = underTest.findAll();
        assertThat(asd.size()).isEqualTo(3);
        assertThat(asd.get(0).getLikes()).isEqualTo(12);
    }


}