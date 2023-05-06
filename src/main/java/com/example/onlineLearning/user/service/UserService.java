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

//    // update usuario
//    public UserBuilder updateUser(Long id, String name, String lastName, String email, Long phone, String address, String city, String country, int zipCode) {
//        UserBuilder tmpUser = null;
//        if (userRepository.existsById(id)) {
//            tmpUser = userRepository.findById(id).get();
//            if (name != null) tmpUser.setName(name);
//            if (lastName != null) tmpUser.setLastName(lastName);
//            if (phone != null) tmpUser.setPhone(phone);
//            //--------------------
//            if ((contrasena !=null) & (newContrasena!=null)) {
//                if(contrasena.equals(tmpUser.getContrasena())) { //si el password es correcto
//                    tmpUser.setContrasena(newContrasena);
//                    usuariosRepository.save(tmpUser);
//                }// if password.equals
//            }//if !=null
//            //----------------------
//
//            usuariosRepository.save(tmpUser);
//        } else {
//            System.out.println("Update | El usuario con el id " + " no existe");
//        }
//        return tmpUser;
//    }//updateUsuario




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
