package com.shakil.notepadservice.controller;

import com.shakil.notepadservice.dtos.NoteDto;
import com.shakil.notepadservice.services.NoteService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@NoArgsConstructor
@RequestMapping("/notes")
public class NoteControllerImpl {

    @Autowired
    private NoteService noteService;

    public NoteControllerImpl(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping("/add")
    public void add( NoteDto noteDto) {
        noteService.save(noteDto);
    }



    public ResponseEntity<List<NoteDto>> getAllNotes() {
        return ResponseEntity.ok(noteService.allNotes());
    }
}
