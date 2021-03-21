package com.lan.backend.Controller;

import com.lan.backend.DTO.Note;
import com.lan.backend.Service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NoteController {
    @Autowired
    NoteService noteService;

    @PostMapping("note/save")
    String saveNote(@RequestBody Note note){
        return noteService.insertNote(note);
    }

    @GetMapping("note/get_all/{userId}")
    List<Note> getNotes(@PathVariable long userId){return noteService.getNotes(userId);}
}
