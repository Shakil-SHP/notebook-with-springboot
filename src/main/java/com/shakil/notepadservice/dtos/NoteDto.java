package com.shakil.notepadservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoteDto implements Serializable {

    private String id;
    private String title;
    private String body;

}
