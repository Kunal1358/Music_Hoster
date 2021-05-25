package com.chitkara.Music_Hoster.service;


import java.io.IOException;
import java.util.stream.Stream;

import com.chitkara.Music_Hoster.model.Music;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;


import com.chitkara.Music_Hoster.repository.MusicRepository;
@Service
    public class MusicService {


        @Autowired
        private MusicRepository MusicRepo;

        public Music store(String musicname, String description,String genre, MultipartFile file) throws IOException {
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            Music FileDB = new Music(musicname,description,genre, fileName, file.getBytes());

            return MusicRepo.save(FileDB);
        }

        public Music getFile(String id) {
            return MusicRepo.findById(id).get();
        }

        public Stream<Music> getAllFiles() {
            return MusicRepo.findAll().stream();
        }

    }

