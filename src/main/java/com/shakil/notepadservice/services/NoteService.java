package com.shakil.notepadservice.services;

import com.shakil.notepadservice.dtos.NoteDto;
import com.shakil.notepadservice.entities.Note;
import com.shakil.notepadservice.mappers.NoteMapper;
import com.shakil.notepadservice.repositories.NoteRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;



    @Transactional
    public void save(NoteDto noteDto) {
        var note = new Note();
        note.setTitle(noteDto.getTitle());
        note.setBody(noteDto.getBody());
        if(noteDto.getId() != null)
            note.setId(noteDto.getId());
        this.noteRepository.save(note);
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
}
