package com.codecool.bookclub.event.repository;

import com.codecool.bookclub.event.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}