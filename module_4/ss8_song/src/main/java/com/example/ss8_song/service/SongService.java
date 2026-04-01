package com.example.ss8_song.service;

import com.example.ss8_song.dto.SongDto;
import com.example.ss8_song.entity.Song;
import com.example.ss8_song.repository.ISongRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService implements ISongService {
    @Autowired
    private ISongRepository songRepository;
    @Override
    public boolean save(SongDto song) {
        if (song != null){
            Song newSong = new Song();
            BeanUtils.copyProperties(song, newSong);
            songRepository.save(newSong);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteByid(Integer id) {
        Song song = songRepository.findById(id).orElse(null);
        if (song != null){
            songRepository.delete(song);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(SongDto song, Integer id) {
        if (song != null){
            Song newSong = songRepository.findById(id).orElse(null);
            if (newSong != null){
                BeanUtils.copyProperties(song, newSong);
                songRepository.save(newSong);
            return true;
            }
        }
        return false;
    }

    @Override
    public Song findById(Integer id) {
        return songRepository.findById(id).orElse(null);
    }

    @Override
    public List<Song> findAll() {
        return songRepository.findAll();
    }
}
