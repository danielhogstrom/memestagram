package com.backend;

import com.backend.meme.Meme;
import com.backend.meme.MemesRepository;
import com.backend.user.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    public void createUser() {
        Set<Meme> myMemes = new HashSet<>();
        User user = new User(null, "User", "pw", "myemail@great.com", "asdgg", myMemes);
        assertThat(user.getUsername()).isEqualTo("User");
        assertThat(user.getEmail()).isEqualTo("myemail@great.com");
    }

    @Test
    public void memeRepositoryLoadingExistingData() {
        List<Meme> listOfMemes = underTest.findAll();
        assertThat(listOfMemes.size()).isEqualTo(3);
    }

    @Test
    public void memeRepositorySavingData() {
        underTest.save(new Meme(null,"asd", "hej1", 9L, null));
        underTest.save(new Meme(null,"asdasd", "hej2", 14L, null));
        List<Meme> listOfMemes = underTest.findAll();
        assertThat(listOfMemes.size()).isEqualTo(5);
    }

    @Test
    public void deleteMemeRepositoryAndAddNewData () {
        underTest.deleteAll();
        underTest.save(new Meme(null,"www.test.se", "this is a description", 5L, null));
        List<Meme> listOfMemes = underTest.findAll();
        assertThat(listOfMemes.get(0).getPicurl()).isEqualTo("www.test.se");
        assertThat(listOfMemes.get(0).getDescription()).isEqualTo("this is a description");
        assertThat(listOfMemes.size()).isEqualTo(1);
    }


}
