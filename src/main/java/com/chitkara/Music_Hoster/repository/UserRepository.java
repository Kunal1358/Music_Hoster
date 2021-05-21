package com.chitkara.Music_Hoster.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.chitkara.Music_Hoster.model.User;


@Repository
public interface UserRepository extends JpaRepository<User,String>{


}

