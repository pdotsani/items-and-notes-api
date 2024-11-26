package com.example.demo;
import java.util.ArrayList;
import java.util.List;

import ai.peoplecode.OpenAIConversation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
public class NoteController {
    private final NoteRepository noteRepository;
    private final String OPENAIKEY;

    @Autowired
    public NoteController(NoteRepository noteRepository, @Value("${app.api-key}") String OPENAIKEY) {
        this.OPENAIKEY = OPENAIKEY;
        this.noteRepository = noteRepository;
    }

    @PostMapping("/saveNote")
    @CrossOrigin(origins = "*")
    public String saveNote(@RequestBody Note note) {
        if(note == null) {
            return "invalid note";
        }
        this.noteRepository.save(note);
        return "success";
    }

    @PostMapping("/summarizeNotes")
    @CrossOrigin(origins = "*")
    public List<String> summarizeNotes(@RequestBody List<Item> items) {
        OpenAIConversation conversation = new OpenAIConversation(this.OPENAIKEY, "gpt-4o-mini");
        List<String> lines = new ArrayList<>();
        for (Item item : items) {
            String context = "body part: " + item.getBodyPart() + ". musscles involved: " + item.getMuscles();
            String line = conversation.askQuestion(context, "can you create one brief paragraph with this information and this memo: " + item.getMemo());
            lines.add(line);
        }
        return lines;
    }

    @GetMapping("/getNotes")
    @CrossOrigin(origins = "*")
    public List<Note> getAllNotes(@RequestParam String owner) {
        Iterable<Note> notes = this.noteRepository.findByOwner(owner);
        List<Note> noteList = new ArrayList<>();
        notes.forEach(noteList::add); {}
        return noteList;
    }
}
