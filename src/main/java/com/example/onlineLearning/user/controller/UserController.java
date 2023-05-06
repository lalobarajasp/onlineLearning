package com.example.onlineLearning.user.controller;

import com.example.onlineLearning.user.model.User;
import com.example.onlineLearning.user.model.UserBuilder;
import com.example.onlineLearning.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("create/user")
    private ResponseEntity<UserBuilder> save(@RequestBody UserBuilder userBuilder){
        UserBuilder temporal = userService.create(userBuilder);
        try{
            return ResponseEntity.created(new URI("/"+temporal.getId())).body(temporal);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("user")
    private ResponseEntity<List<UserBuilder>> AllUserBuilder (){
        return ResponseEntity.ok(userService.getAllUserBuilder());
    }

    //Metodo get para un usuario
    @GetMapping (path="user/{userId}")
    public UserBuilder getUser(@PathVariable("userId")Long id) {
        return userService.getOnlyUser(id);
    }

//    //Metodo put para un usuario
//    @PutMapping(path="{userId}")
//    public Usuarios updateUsuarios(@PathVariable("userId") Long id,
//                                   @RequestParam(required = false) String nombre,
//                                   @RequestParam(required = false) String apellido,
//                                   @RequestParam(required = false) String telefono,
//                                   //---Se añadio linea RequestBody
//                                   @RequestBody ChangePassword changePassword) {
//        return usuariosService.updateUsuarios(id, nombre, apellido, telefono, changePassword.getContrasena(),
//                changePassword.getNewContrasena());
//    }//updateUsuarios

    //Metodo delete para un usuario
    @DeleteMapping (path="user/{userId}")
    public UserBuilder deleteOnlyUser(@PathVariable("userId") Long id) {
        return userService.deleteUser(id);
    }




}
