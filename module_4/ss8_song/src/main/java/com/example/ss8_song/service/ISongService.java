package com.example.ss8_song.service;

import com.example.ss8_song.dto.SongDto;
import com.example.ss8_song.entity.Song;

import java.util.List;

public interface ISongService {
    boolean save(SongDto song);
    boolean deleteByid(Integer id);
    boolean update(SongDto song, Integer id);
    Song findById(Integer id);
    List<Song> findAll();
}
