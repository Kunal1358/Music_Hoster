package com.chitkara.Music_Hoster.service;

import com.chitkara.Music_Hoster.model.User;
import com.chitkara.Music_Hoster.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;


@Service
public class UserService {

    @Autowired
    public UserRepository UserRepository;

    public boolean adduser(User user)
    {

        if(this.UserRepository.existsById(user.getEmailAddress())){
            return false;
        }
        else{
            try {
                this.UserRepository.save(user);
            }
            catch (Exception e)
            {
                return false;
            }
            return true;
        }

    }


    public List<User> getallusers()
    {
        return (List<User>) this.UserRepository.findAll();
    }


    public void deleteuser(String email)
    {
        this.UserRepository.deleteById(email);
    }


    public void update(User user)
    {
        this.UserRepository.save(user);


    }

}
