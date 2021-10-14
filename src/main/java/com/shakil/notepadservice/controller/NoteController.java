package com.shakil.notepadservice.controller;

import com.shakil.notepadservice.dtos.NoteDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public interface NoteController {

    void add(@RequestBody NoteDto noteDto);

    @GetMapping("/all")
    ResponseEntity<List<NoteDto>> getAllNotes();
}
