package fr.kata.tennis.infra.controller;

import fr.kata.tennis.domain.model.User;
import fr.kata.tennis.infra.repository.UserRepository
import org.bson.types.ObjectId
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*
import java.lang.Exception

@RestController
@RequestMapping("/users")

class UserController(
        private val userRepository: UserRepository
) {
    // ResponseEntity represents the protocol answer
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
    fun createUser(@RequestBody request: UserRequest): ResponseEntity<User> {
        val user = userRepository.save(User(
                firstname = request.firstname,
                lastname = request.lastname,
                password = request.password,
                email = request.email
        ))
        return ResponseEntity(user, HttpStatus.CREATED)
    }

    @PutMapping("/{id}")
    fun updateUser(@RequestBody request: UserRequest, @PathVariable("id") id: String): ResponseEntity<User> {
        val user = userRepository.findOneById(ObjectId(id))
        val updatedUser = userRepository.save(User(
                id = user.id,
                firstname = request.firstname,
                lastname = request.lastname,
                password = request.password,
                email = request.email
        ))
        return ResponseEntity.ok(updatedUser)
    }

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable("id") id: String): ResponseEntity<Unit> {
        userRepository.deleteById(id)
        return ResponseEntity.noContent().build()
    }
}