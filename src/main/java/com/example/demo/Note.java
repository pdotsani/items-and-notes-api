package com.example.demo;

import com.google.cloud.spring.data.datastore.core.mapping.Entity;
import org.springframework.data.annotation.Id;
import java.time.ZoneId;
import java.time.LocalDateTime;

@Entity(name = "Note")
public class Note {
    @Id
    private Long id;

    private LocalDateTime date;

    private String owner;

    private String patient;

    private String summary;

    private String followUp;

    public Note(String owner, String patient, String summary, String followUp) {
        this.owner = owner;
        this.patient = patient;
        this.summary = summary;
        this.followUp = followUp;
        this.date = LocalDateTime.now(ZoneId.of("America/Los_Angeles"));
    }

    public Long getId() {
        return id;
    }

    public String getOwner() {
        return this.owner;
    }

    public String getPatient() {
        return this.patient;
    }

    public String getSummary() { return this.summary; }

    public String getFollowUp() { return this.followUp; }

    public String getDate() { return this.date.toString(); }

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
