package com.backend.Repository;

import com.backend.Entity.Memes;
import org.springframework.data.repository.CrudRepository;

public interface MemeRepository extends CrudRepository <Memes,Long> {
}
