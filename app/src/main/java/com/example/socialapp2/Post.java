package com.example.socialapp2;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Post {
    public String id;
    public String uid;
    public String author;
    public String authorPhotoUrl;
    public String content;
    public String mediaUrl;
    public String mediaType;
    public Map<String, Boolean> likes = new HashMap<>();
    public long time;


    public Post() {}

    public Post(String uid, String author, String authorPhotoUrl, String content, String mediaUrl, String mediaType, long time) {
        this.uid = uid;
        this.author = author;
        this.authorPhotoUrl = authorPhotoUrl;
        this.content = content;
        this.mediaType = mediaType;
        this.mediaUrl = mediaUrl;
        this.time = time;
    }
}