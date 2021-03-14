package com.lan.backend.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

@Service
public class FileService {
    public String train(int fontId) {
        try {
            String[] cmd=new String[]{"E:\\Anaconda3\\envs\\tf\\python.exe","E:\\lan-dp_model\\model\\model.py",
                                        "--style_dir E:\\lan-dp_model\\database\\0\\input",
                                        "--font_dir E:\\lan-dp_model\\database\\0",
                                        "--itrs 20000"};
            Process proc =Runtime.getRuntime().exec(cmd);
            InputStream is = proc.getInputStream();
            BufferedReader bf = new BufferedReader(new InputStreamReader(is));
            String line = null;
            while ((line = bf.readLine()) != null) {
                System.out.println(line);
            }
            bf.close();
            int res=proc.waitFor();
            System.out.println("Waiting over.");
            System.out.println(res);
        }
        catch (IOException e){
            e.printStackTrace();
            return "fail";
        }
        catch (InterruptedException e){
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }

    public String upload(int fontId, MultipartFile file) {
        if(!file.isEmpty()){
            String filename = file.getOriginalFilename();
            String filePath = String.format("E:\\lan-dp_model\\database\\%d\\input\\",fontId);
            File dest = new File(filePath + filename);
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            try {
                file.transferTo(dest);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "success";
    }
}
