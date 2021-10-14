package com.shakil.notepadservice.mappers;

import com.shakil.notepadservice.dtos.NoteDto;
import com.shakil.notepadservice.entities.Note;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface NoteMapper {

    NoteMapper INSTANCE = Mappers.getMapper( NoteMapper.class );

    NoteDto noteToNoteDto(Note note);

    Note noteDtoToNote(NoteDto noteDto);
}
