package com.example.demo;

import com.google.cloud.spring.data.datastore.core.mapping.Entity;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;

@Entity(name = "Note")
public class Note {
    @Id
    private Long id;

    final private String owner;

    final private String patient;

    final private String summary;

    final private String followUp;

    public Note(String owner, String patient, String summary, String followUp) {
        this.owner = owner;
        this.patient = patient;
        this.summary = summary;
        this.followUp = followUp;
    }

    public String getOwner() {
        return this.owner;
    }

    public String getPatient() {
        return this.patient;
    }

    public String getSummary() { return this.summary; }

    public String getFollowUp() { return this.followUp; }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", owner='" + owner + '\'' +
                ", patient='" + patient + '\'' +
                ", summary='" + summary + '\'' +
                ", followUp='" + followUp + '\'' +
                '}';
    }
}
