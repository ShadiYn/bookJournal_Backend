package com.bookjournal.proyecto.bookJournal.Controllers.repositories;

import com.bookjournal.proyecto.bookJournal.Controllers.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByBookId(Long bookId);
}
