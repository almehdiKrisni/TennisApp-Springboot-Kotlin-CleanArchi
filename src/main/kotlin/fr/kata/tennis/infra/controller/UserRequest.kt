package fr.kata.tennis.infra.controller

import org.bson.types.ObjectId

class UserRequest (
        val firstname: String,
        val lastname: String,
        val password: String,
        val email: String,
)