package com.example.demo;

import ai.peoplecode.OpenAIConversation;
import com.google.common.collect.Lists;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}

@ShellComponent
class NoteCommands {
    private final NoteRepository noteRepository;
    private final String openAiKey;

    public NoteCommands(NoteRepository noteRepository,
                        @Value("${app.api-key}") String openAiKey) {
        this.noteRepository = noteRepository;
        this.openAiKey = openAiKey;
    }

    @ShellMethod("saves a note")
    public String saveNote(String owner, String patient, String note) {
        Note savedNote = this.noteRepository.save(new Note(owner, patient, note));
        return savedNote.toString();
    }

    @ShellMethod("shows all notes")
    public String findAllNotes() {
        Iterable<Note> savedNotes = this.noteRepository.findAll();
        return Lists.newArrayList(savedNotes).toString();
    }

    @ShellMethod("shows all notes")
    public String findNotesByOwner(String owner) {
        Iterable<Note> savedNotes = this.noteRepository.findByOwner(owner);
        return Lists.newArrayList(savedNotes).toString();
    }

    @ShellMethod("summarize item")
    public String summarizeItem(String body, String muscle, String memo) {
        OpenAIConversation conversation = new OpenAIConversation(openAiKey, "gpt-4o-mini");
        String context = "body part: " + body + ". muscles involved: " + muscle;
        return conversation.askQuestion(context, "can you create one brief paragraph with this information and this memo: " + memo);
    }
}
