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

    @GetMapping("/getNotes")
    @CrossOrigin(origins = "*")
    public List<Note> getAllNotes(@RequestParam String owner) {
        Iterable<Note> notes = this.noteRepository.findByOwner(owner);
        List<Note> noteList = new ArrayList<>();
        notes.forEach(noteList::add); {}
        return noteList;
    }

    @PostMapping("/saveNotes")
    @CrossOrigin(origins = "*")
    public void saveNotes(NoteCommands.SaveNotesBody notesBody) {
        ArrayList<Note.SummaryFollowUpPair> pairs = new ArrayList<>();
        for (Item item: notesBody.items) {
            String summary = summarizeNote(item);
            String postPlan = postTreatmentPlan(summary);

            Note.SummaryFollowUpPair pair = new Note.SummaryFollowUpPair(summary, postPlan);
            pairs.add(pair);
        }
        saveNote(new Note(notesBody.owner, notesBody.patient, pairs));
    }

    public void saveNote(@RequestBody Note note) {
        if (note == null) {
            throw new IllegalArgumentException("Note cannot be null");
        }
        this.noteRepository.save(note);
    }

    public String summarizeNote(@RequestBody Item item) {
        OpenAIConversation conversation = new OpenAIConversation(OPENAIKEY, "gpt-4o-mini");
        String context = "body part: " + item.getBodyPart() + ". musscles involved: " + item.getMuscles();
        return conversation.askQuestion(context, "can you create one brief paragraph with this information and this memo: " + item.getMemo());
    }

    public String postTreatmentPlan(@RequestBody String summarizeNotes) {
        OpenAIConversation conversation1 = new OpenAIConversation(OPENAIKEY, "gpt-4o-mini");
        return conversation1.askQuestion(summarizeNotes, "Can you create a brief paragraph using the paragraph you just provided me with which will give an example treatment plan with specific exercises for the specific problem with the patient?");
    }
}
