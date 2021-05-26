package com.chitkara.Music_Hoster.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.chitkara.Music_Hoster.security.JwtUtil;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.chitkara.Music_Hoster.service.MusicService;
import com.chitkara.Music_Hoster.message.ResponseMessage;
import com.chitkara.Music_Hoster.model.Music;


@Controller
@CrossOrigin(origins = "http://localhost:3000",
        methods = {RequestMethod.OPTIONS, RequestMethod.GET,
                RequestMethod.POST, RequestMethod.PUT,
                RequestMethod.DELETE}, allowedHeaders = "*",
        allowCredentials = "true")
public class MusicController {


    @Autowired
    private MusicService MusicService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtHelper;

    @PostMapping("/upload")

    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("musicname") String title ,@RequestParam("genre") String genre,@RequestParam("description") String desc  ,@RequestParam ("file") MultipartFile file) throws ExpiredJwtException {
        String message = "";
        try {
        //Date d =jwtHelper.getExpirationDateFromToken(Token);

        ////if(d.getTime()<System.currentTimeMillis())
        //{
        //    message="token expired, Please login again";
         //   return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        //}


            MusicService.store(title, genre, desc,file);
            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        }
        catch(ExpiredJwtException f){
            message ="Session Expired, Redirecting to login";
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ResponseMessage(message));
        }

        catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "! ,either Session Expired or Bad File Format";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @GetMapping("/files")
    public ResponseEntity<List<Music>> getListFiles() throws ExpiredJwtException {
        String message="";
        List<Music> files = MusicService.getAllFiles().map(dbFile -> {
            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/files/")
                    .path(dbFile.getId())
                    .toUriString();

            return new Music(
                    dbFile.getMusicName(),
                    fileDownloadUri,
                    dbFile.getGenre(),
                    dbFile.getDescription(),
                    dbFile.getData().length);
        }).collect(Collectors.toList());
            return ResponseEntity.status(HttpStatus.OK).body(files);
    }

    @GetMapping("/files/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable String id) {
        Music fileDB = MusicService.getFile(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getName() + "\"")
                .body(fileDB.getData());
    }
    @DeleteMapping("/files/{id}")
    public ResponseEntity<ResponseMessage> delete(@PathVariable String id) throws ExpiredJwtException{
        try{
        MusicService.Delete(id);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("Deleted Successfuly"));
        }
        catch (ExpiredJwtException  e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ResponseMessage("Not Deleted"));
        }
    }
}
