package com.shakil.notepadservice.controller;

import com.shakil.notepadservice.dtos.NoteDto;
import com.shakil.notepadservice.entities.Note;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/default")
public interface NoteController {

    @GetMapping("/all")
    public ResponseEntity<List<NoteDto>> getAllNotes();

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody NoteDto noteDto);

    @GetMapping("/find/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable("id") String id);

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody NoteDto noteDto);

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") String id);
}
