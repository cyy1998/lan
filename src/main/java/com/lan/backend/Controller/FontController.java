package com.lan.backend.Controller;

import com.lan.backend.DTO.Font;
import com.lan.backend.Service.FontService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FontController {
    @Autowired
    FontService fontService;

    @PostMapping("font/create")
    int create(@RequestBody Font font){
        return fontService.create(font);
    }

    @GetMapping("font/fonts/{userId}")
    List<Font> getFonts(@PathVariable int userId){
        return fontService.getFonts(userId);
    }

    @GetMapping("font/stage/{fontId}")
    int getStage(@PathVariable int fontId){
        return fontService.getStage(fontId);
    }
}
