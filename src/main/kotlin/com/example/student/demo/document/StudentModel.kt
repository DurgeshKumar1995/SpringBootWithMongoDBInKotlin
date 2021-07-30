package com.example.student.demo.document

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "students")
data class StudentModel(@Id var id :Long, val name:String, val gender:String, val dob:String, val country:String ){


//    constructor(name: String,gender: String,dob: String,country: String):this(0,name, gender, dob, country)
}
const val SEQUENCE_NAME = "students_sequence"
const val Name  = "name"
const val Gender  = "gender"
const val DOB  = "dob"
const val Country  = "country"