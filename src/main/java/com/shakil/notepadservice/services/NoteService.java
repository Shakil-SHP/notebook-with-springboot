package com.shakil.notepadservice.services;

import com.shakil.notepadservice.dtos.NoteDto;
import com.shakil.notepadservice.entities.Note;
import com.shakil.notepadservice.exceptions.NoteNotFoundException;
import com.shakil.notepadservice.repositories.NoteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NoteService {

    @Autowired
    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<NoteDto> allNotes() {
        return this.noteRepository.findAll().stream()
                .map(note -> {
                    var noteDto = new NoteDto();
                    BeanUtils.copyProperties(note, noteDto);
                    return noteDto;
                })
                .collect(Collectors.toList());
    }

    @Transactional
    public void save(NoteDto noteDto) {
        Note note = new Note();
        note.setTitle(noteDto.getTitle());
        note.setBody(noteDto.getBody());
        if(noteDto.getId() != null){
            note.setId(noteDto.getId());
        }
        this.noteRepository.save(note);
    }

    public void updateNote(NoteDto noteDto){
        var note = new Note();
        note.setBody(noteDto.getBody());
        this.noteRepository.save(note);
    }

    public Note findNoteById(String id){
        return noteRepository.findNoteById(id)
                .orElseThrow(() -> new NoteNotFoundException("Note by id" + id + "was not found."));
    }

    public void deleteNote(String id){
        noteRepository.deleteNoteById(id);
    }


}
