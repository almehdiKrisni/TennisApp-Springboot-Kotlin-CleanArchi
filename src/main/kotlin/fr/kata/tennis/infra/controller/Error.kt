package fr.kata.tennis.infra.controller

import com.fasterxml.jackson.annotation.JsonFormat

data class Error(
        val defaultMessage: String,
        val code: String,
        @JsonFormat(shape = JsonFormat.Shape.STRING)
        val arguments: List<Any>
)