package com.example.ss8_song.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SongDto {
    @NotBlank(message = "Song name is required")
    @Size(max = 800, message = "Max 800 characters")
    @Pattern(regexp = "^[^@;,.=\\-+]+$", message = "No special characters (@ ; , . = - +)")
    private String name;

    @NotBlank(message = "Artist is required")
    @Size(max = 300, message = "Max 300 characters")
    @Pattern(regexp = "^[^@;,.=\\-+]+$", message = "No special characters (@ ; , . = - +)")
    private String artist;

    @NotBlank(message = "Genre is required")
    @Size(max = 1000, message = "Max 1000 characters")
    @Pattern(regexp = "^[^@;.=\\-+]+$", message = "Only comma allowed, no special characters")
    private String genre;
}
