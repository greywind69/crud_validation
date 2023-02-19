package com.example.crud_validation.Service;


import com.example.crud_validation.Dao.userrepo;
import com.example.crud_validation.Model.user;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserService {


    @Autowired
    userrepo userRepository;

    List<user> userList;
    public user save(user user) {
        return userRepository.save(user);
    }

    public List<user> getUsersById(Integer userId) {
        if(null!=userId){
            userList = new ArrayList<>();
            userList.add(userRepository.findById(userId).get());
        }else{
            return userRepository.findAll();
        }
        return userList;
    }

    public user updateUsers(JSONObject user) {
        user newUser = new user();
        newUser.setUserId(user.getInt("userId"));
        newUser.setUserName(user.getString("userName"));
        newUser.setDateOfBirth(user.getString("dateOfBirth"));
        newUser.setUserPhoneNumber(user.getString("userPhoneNumber"));
        newUser.setEmail(user.getString("email"));
        userRepository.save(newUser);
        return newUser;
    }

    public void delete(Integer userId) {
        if(null!=userId){
            userRepository.deleteById(userId);
        }else{
            userRepository.deleteAll();
        }
    }
}
