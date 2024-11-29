package com.example.demo;

import java.util.List;

import com.google.cloud.spring.data.datastore.repository.DatastoreRepository;
import com.google.cloud.spring.data.datastore.repository.query.Query;

public interface NoteRepository extends DatastoreRepository<Note, Long> {

    List<Note> findByOwner(String owner);

    @Query("SELECT DISTINCT owner FROM Note")
    List<String> findAllOwners();

}
