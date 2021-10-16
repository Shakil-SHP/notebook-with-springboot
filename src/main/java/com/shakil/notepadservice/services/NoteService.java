package com.shakil.notepadservice.services;

import com.shakil.notepadservice.dtos.NoteDto;
import com.shakil.notepadservice.entities.Note;
import com.shakil.notepadservice.exceptions.NoteNotFoundException;
import com.shakil.notepadservice.mappers.NoteMapper;
import com.shakil.notepadservice.repositories.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {

    @Autowired
    private final NoteRepository noteRepository;

    @Autowired
    private final NoteMapper noteMapper;

    public List<NoteDto> allNotes() {
        return noteMapper.noteToNoteDtos(noteRepository.findAll());
    }

    @Transactional
    public void save(NoteDto noteDto) {
        this.noteRepository.save(noteMapper.noteDtoToNote(noteDto));
    }

    public void updateNote(NoteDto noteDto, String id){
        var note = findNote(id);
        note.setBody(noteDto.getBody());
        this.noteRepository.save(note);
    }

    public Note findNote(String id){
        return noteRepository.findNoteById(id)
                .orElseThrow(() -> new NoteNotFoundException("Note by id" + id + "was not found."));
    }

    public void deleteNote(String id){
        noteRepository.deleteNoteById(id);
    }


}
