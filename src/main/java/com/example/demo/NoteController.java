package com.example.demo;
import java.util.ArrayList;
import java.util.List;

import ai.peoplecode.OpenAIConversation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
public class NoteController {
    private final NoteRepository noteRepository;
    private final String OPENAIKEY;

    static class SaveNoteBody {
        public String owner;
        public String patient;
        public String muscles;
        public String bodyPart;
        public String memo;
    }

    @Autowired
    public NoteController(NoteRepository noteRepository, @Value("${app.api-key}") String OPENAIKEY) {
        this.OPENAIKEY = OPENAIKEY;
        this.noteRepository = noteRepository;
    }

    @GetMapping("/getNotes")
    @CrossOrigin(origins = "*")
    public List<Note> getAllNotes(@RequestParam String owner) {
        Iterable<Note> notes = this.noteRepository.findByOwnerOrderByDateDesc(owner);
        List<Note> noteList = new ArrayList<>();
        notes.forEach(noteList::add); {}
        return noteList;
    }

    @PostMapping("/saveNote")
    @CrossOrigin(origins = "*")
    public void saveNote(@RequestBody SaveNoteBody notesBody) {
        Item newItem = new Item(notesBody.bodyPart, notesBody.muscles, notesBody.memo);
        String summary = summarizeNote(newItem);
        String postPlan = postTreatmentPlan(summary);
        saveInfo(new Note(notesBody.owner, notesBody.patient, summary, postPlan));
    }

    @DeleteMapping("/note")
    @CrossOrigin(origins = "*")
    public void deleteNote(@RequestParam Long id) {
        this.noteRepository.deleteById(id);
    }

    public void saveInfo(Note note) {
        if (note == null) {
            throw new IllegalArgumentException("Note cannot be null");
        }
        this.noteRepository.save(note);
    }

    public String summarizeNote(Item item) {
        OpenAIConversation conversation = new OpenAIConversation(OPENAIKEY, "gpt-4o-mini");
        String context = "body part: " + item.getBodyPart() + ". muscles involved: " + item.getMuscles();
        return conversation.askQuestion(context, "can you create a few sentences in declarative note form with this information and this memo: " + item.getMemo() + ". The sentences can be fragmented. Just the sentences, no numbers and titles.");
    }

    public String postTreatmentPlan(String summarizeNotes) {
        OpenAIConversation conversation1 = new OpenAIConversation(OPENAIKEY, "gpt-4o-mini");
        return conversation1.askQuestion(summarizeNotes, "Can you create a brief paragraph using the paragraph you just provided me with which will give an example treatment plan with specific exercises for the specific problem with the patient?");
    }
}
