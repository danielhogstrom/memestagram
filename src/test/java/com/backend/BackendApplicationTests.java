package com.backend;

import com.backend.meme.Meme;
import com.backend.meme.MemesRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class BackendApplicationTests {

    @Autowired
    MemesRepository underTest;

    @Test
    public void createMeme() {
        Meme meme = new Meme(null, "www.abc.com", "good", 4L, null);
        assertThat(meme.getPicurl()).isEqualTo("www.abc.com");
    }

    @Test
    public void memeRepository() {
        List<Meme> asd = underTest.findAll();
        assertThat(asd.size()).isEqualTo(3);
    }

    @Test
    public void asd() {
        underTest.save(new Meme(null,"aa", "hej", 9L, null));
        underTest.save(new Meme(null,"aa", "hej", 9L, null));
        List<Meme> asd = underTest.findAll();
        assertThat(asd.size()).isEqualTo(5);
    }

    @Test
    public void deleteRepositoryAndAddNewMeme () {
        underTest.deleteAll();
        underTest.save(new Meme(null,"www.test.se", "this is a description", 5L, null));
        List<Meme> asd = underTest.findAll();
        assertThat(asd.get(0).getId()).isEqualTo(4);
        assertThat(asd.get(0).getPicurl()).isEqualTo("www.test.se");
        assertThat(asd.get(0).getDescription()).isEqualTo("this is a description");
    }

}
