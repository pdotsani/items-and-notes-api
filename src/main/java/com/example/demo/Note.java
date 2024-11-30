package com.example.demo;

import com.google.cloud.spring.data.datastore.core.mapping.Entity;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;

@Entity(name = "Note")
public class Note {
    static class SummaryFollowUpPair {
        String summary;
        String followUp;

        public SummaryFollowUpPair(String summary, String followUp) {
            this.summary = summary;
            this.followUp = followUp;
        }
    }

    @Id
    private Long id;

    final private String owner;

    final private String patient;

    private ArrayList<SummaryFollowUpPair> summaryAndFollowUps;

    public Note(String owner, String patient, ArrayList<SummaryFollowUpPair> pairs) {
        this.owner = owner;
        this.patient = patient;
        this.summaryAndFollowUps = pairs;
    }

    public String getOwner() {
        return this.owner;
    }

    public String getPatient() {
        return this.patient;
    }

    public ArrayList<SummaryFollowUpPair> getSummaryAndFollowUps() {
        return this.summaryAndFollowUps;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", owner='" + owner + '\'' +
                ", patient='" + patient + '\'' +
                ", summaryAndFollowUps=" + summaryAndFollowUps +
                '}';
    }
}
