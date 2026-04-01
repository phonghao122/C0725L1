package com.example.ss8_song.validation;


import com.example.ss8_song.dto.SongDto;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class SongValidation implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SongDto song = (SongDto) target;
        if (song.getName() == null || song.getName().isEmpty()) {
            errors.rejectValue("name", "name.empty", "Name must not be empty");
        }else if (song.getName().length() < 3) {
            errors.rejectValue("name", "name.length", "Name must be at least 3 characters");
        }
        if (song.getArtist() == null || song.getArtist().isEmpty()) {
            errors.rejectValue("artist", "artist.empty", "Artist must not be empty");
        }else if (song.getArtist().length() < 3) {
            errors.rejectValue("artist", "artist.length", "Artist must be at least 3 characters");
        }
        if (song.getGenre() == null || song.getGenre().isEmpty()) {
                errors.rejectValue("genre", "genre.empty", "Genre must not be empty");
        }else if (song.getGenre().length() < 3) {
            errors.rejectValue("genre", "genre.length", "Genre must be at least 3 characters");
        }
    }
}
