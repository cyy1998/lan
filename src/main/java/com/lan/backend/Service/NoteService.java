package com.lan.backend.Service;

import com.lan.backend.DTO.Note;
import com.lan.backend.Mapper.NoteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    @Autowired
    NoteMapper noteMapper;

    public String insertNote(Note note){
        if(noteMapper.insertNote(note)==1){
            return "success";
        }else {
            return "failed";
        }

    }
    public List<Note> getNotes(long userId){
        return noteMapper.getNotes(userId);
    }
}
