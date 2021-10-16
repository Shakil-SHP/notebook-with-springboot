package com.shakil.notepadservice.controller;

import com.shakil.notepadservice.dtos.NoteDto;
import com.shakil.notepadservice.entities.Note;
import com.shakil.notepadservice.services.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
public class NoteControllerImpl implements NoteController{

    @Autowired
    private final NoteService noteService;

    @Override
    public ResponseEntity<List<NoteDto>> getAllNotes() {
        return ResponseEntity.ok(noteService.allNotes());
    }

    @Override
    public ResponseEntity<?> add(@RequestBody NoteDto noteDto) {
        noteService.save(noteDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Note> getNoteById(@PathVariable("id") String id) {
        return ResponseEntity.ok(noteService.findNote(id));
    }

    @Override
    public ResponseEntity<?> update(@RequestBody NoteDto noteDto, @PathVariable("id") String id) {
        noteService.updateNote(noteDto, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> delete(@PathVariable("id") String id) {
        noteService.deleteNote(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
