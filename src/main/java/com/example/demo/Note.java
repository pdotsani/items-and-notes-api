package com.example.demo;

import com.google.cloud.spring.data.datastore.core.mapping.Entity;
import org.springframework.data.annotation.Id;

@Entity(name = "Note")
public class Note {
    @Id
    private Long id;

    private String owner;

    private String patient;

    private String note;

    public Note(String owner, String patient, String note) {
        this.owner = owner;
        this.patient = patient;
        this.note = note;
    }

    public String getOwner() {
        return this.owner;
    }

    public String getPatient() {
        return this.patient;
    }

    public String getNote() {
        return this.note;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", owner='" + owner + '\'' +
                ", patient='" + patient + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
