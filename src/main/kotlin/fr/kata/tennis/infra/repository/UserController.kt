package fr.kata.tennis.infra.repository;

import fr.kata.tennis.domain.model.User;
import org.bson.types.ObjectId
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*
import java.lang.Exception

import java.util.List;

@RestController
@RequestMapping("/users")

class UserController(
        private val userRepository: UserRepository
) {

    @GetMapping("/{id}")
    fun getOneUser(@PathVariable("id")id:String):ResponseEntity<User> {
        var user = userRepository.findOneById(ObjectId(id))
        if (user != null) {
            return ResponseEntity.ok(user)
        }
        else {
            throw Exception("Requested user does not exist.")
        }
    }

    @PostMapping
    fun createPatient(@RequestBody request: UserRequest): ResponseEntity<User> {
        val user = userRepository.save(User(
                firstname = request.firstname,
                lastname = request.lastname,
                password = request.password,
                email = request.email
        ))
        return ResponseEntity(user, HttpStatus.CREATED)
    }
}