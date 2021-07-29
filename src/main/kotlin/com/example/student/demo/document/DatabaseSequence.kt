package com.example.student.demo.document

import org.springframework.data.annotation.Id

class DatabaseSequence {
    @Id
    var id: String? = null
    var seq: Long = 0

}