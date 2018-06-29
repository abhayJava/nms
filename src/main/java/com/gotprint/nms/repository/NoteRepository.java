package com.gotprint.nms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gotprint.nms.model.Note;


@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

}
