package com.backend.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsername(String username);

 @Query (value = "SELECT FRIEND_ID FROM USER_FOLLOW WHERE USER_ID = ?", nativeQuery = true)
   List <Long> followList(Long id); // gets number of followers

@Query(value="SELECT USER_ID FROM  USER_FOLLOW WHERE FRIEND_ID=?", nativeQuery = true)
    List <Long> followingList(Long id); // gets number of user that follows you
}
