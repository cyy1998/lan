package com.lan.backend.Service;

import com.lan.backend.DTO.Font;
import com.lan.backend.Mapper.FontMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;

@Service
public class FontService {
    @Autowired
    FontMapper fontMapper;

    public int create(Font font) {
        fontMapper.create(font);
        File dirFile = new File("E:\\lan-dp_model\\database\\"+font.getFontId());
        dirFile.mkdirs();
        return font.getFontId();
    }

    public int getStage(int fontId) {
        File dirFile = new File("E:\\lan-dp_model\\database\\"+fontId+"\\log");
        if(dirFile.exists()) {
            File file=new File("E:\\lan-dp_model\\database\\"+fontId+"\\log\\log.txt");
            try {
                InputStreamReader read = new InputStreamReader(new FileInputStream(file));
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = bufferedReader.readLine().trim();
                System.out.println(lineTxt.length());
                if (lineTxt.equals("Training")){
                    return 1;
                }
                else if(lineTxt.equals("Complete")){
                    return 2;
                }
                else {
                    return 3;
                }
            }catch (IOException e){
                return 3;
            }
        }
        else {
            return 0;
        }
    }

    public List<Font> getFonts(int userId) {
        return fontMapper.getFonts(userId);
    }
}
