package com.example.demo;

import java.util.List;

import com.google.cloud.spring.data.datastore.repository.DatastoreRepository;

public interface NoteRepository extends DatastoreRepository<Note, Long> {

    List<Note> findByOwner(String owner);

}
