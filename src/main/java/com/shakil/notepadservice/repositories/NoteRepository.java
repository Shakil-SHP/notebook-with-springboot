package com.shakil.notepadservice.repositories;

import com.shakil.notepadservice.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface NoteRepository extends JpaRepository<Note, Long> {
    void deleteNoteById(String id);

    Optional<Note> findNoteById(String id);

}
