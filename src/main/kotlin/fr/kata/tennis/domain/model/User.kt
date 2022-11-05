package fr.kata.tennis.domain.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class User (
    @Id
    val id: ObjectId = ObjectId.get(),
    val firstname: String,
    val lastname: String,
    val password: String,
    val email: String,
)