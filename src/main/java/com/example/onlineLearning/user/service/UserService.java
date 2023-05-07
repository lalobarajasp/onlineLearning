package com.example.onlineLearning.user.service;

import com.example.onlineLearning.user.model.User;
import com.example.onlineLearning.user.model.UserBuilder;
import com.example.onlineLearning.user.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserBuilder create(UserBuilder userBuilder){
        return userRepository.save(userBuilder);
    }

    public List<UserBuilder> getAllUserBuilder(){
        return userRepository.findAll();
    }

    //getUser only
    public UserBuilder getOnlyUser(Long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("The user with id: " + id +" doesn't exist.")
        );
    }

    // update usuario
    public UserBuilder updateUser(Long id, String name, String lastName, String email, String password, String newPassword, Long phone, String address) {
        UserBuilder tmpUser = null;
        if (userRepository.existsById(id)) {
            tmpUser = userRepository.findById(id).get();
            if (name != null) tmpUser.setName(name);
            if (lastName != null) tmpUser.setLastName(lastName);
            if (email != null) tmpUser.setEmail(email);
            if (phone != null) tmpUser.setPhone(phone);
            if (address != null) tmpUser.setAddress(address);
            //--------------------
            if ((password !=null) & (newPassword!=null)) {
                if(password.equals(tmpUser.getPassword())) { //si el password es correcto
                    tmpUser.setPassword(newPassword);
                    userRepository.save(tmpUser);
                }// if password.equals
            }//if !=null
            //----------------------
            userRepository.save(tmpUser);
        } else {
            System.out.println("Update | The user with the id: " + id + " doesn't exist.");
        }
        return tmpUser;
    }//updateUsuario

    public UserBuilder forgotPassword(Long id, String name, String lastName, String email, String password, String newPassword, Long passwordCode) {
        UserBuilder tmpUser = null;
        if (userRepository.existsById(id)) {
            tmpUser = userRepository.findById(id).get();
            if (name != null) tmpUser.setName(name);
            if (lastName != null) tmpUser.setLastName(lastName);
            if (email != null) tmpUser.setEmail(email);
            //--------------------
            if ((password !=null) & (newPassword!=null)) {
                if(passwordCode.equals(tmpUser.getPasswordCode())) { //si el password es correcto
                    tmpUser.setPassword(newPassword);
                    userRepository.save(tmpUser);
                }// if password.equals
            }//if !=null
            //----------------------
            userRepository.save(tmpUser);
        } else {
            System.out.println("Update | The user with the id: " + id + " doesn't exist.");
        }
        return tmpUser;
    }//updateUsuario




    // delete usuarios
    public UserBuilder deleteUser(Long id) {
        UserBuilder tmpUser = null;
        if (userRepository.existsById(id)) {
            tmpUser = userRepository.findById(id).get();
            userRepository.deleteById(id);
        }
        return tmpUser;
    }

}
