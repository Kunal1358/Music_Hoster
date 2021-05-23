package com.chitkara.Music_Hoster.repository;

import com.chitkara.Music_Hoster.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface MusicRepository extends JpaRepository<Music,String>{
}
