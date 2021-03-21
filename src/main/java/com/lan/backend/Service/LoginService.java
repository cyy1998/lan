package com.lan.backend.Service;

import com.lan.backend.DTO.User;
import com.lan.backend.Mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    LoginMapper loginMapper;

    public long login(User user){
        User result = loginMapper.findUser(user);
//        System.out.println(result.getUserName());
//        System.out.println(result.getPassword());
//        System.out.println(result.getUserId());



        if(result == null){
            loginMapper.createUser(user);
//            System.out.println(user.getUserId());
            return user.getUserId();
        }else{
//            System.out.println(result.getPassword());
//            System.out.println(user.getPassword());
//            System.out.println(result.getPassword() == user.getPassword());

            if(result.getPassword().equals(user.getPassword())){
                return result.getUserId();
            }else {
                return -1;
            }
        }
    }

}
