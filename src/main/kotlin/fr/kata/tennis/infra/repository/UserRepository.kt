package fr.kata.tennis.infra.repository

import fr.kata.tennis.domain.model.User
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepository : MongoRepository<User, String> {
    fun findOneById(id: ObjectId): User
    override fun deleteById(id: String)
    override fun deleteAll()
}

