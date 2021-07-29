package com.example.student.demo.controller

import com.example.student.demo.document.StudentModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Sort
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Service

@Service
class StudentService {
    @Autowired
    lateinit var mongoTemplate: MongoTemplate
    fun getStudentAccordingCountry(country: String?): List<StudentModel> {
        val query = Query().addCriteria(Criteria.where("country").`is`(country))
                .with(Sort.by(Sort.Order.desc("name")))
                .limit(10)
        return mongoTemplate.find(query, StudentModel::class.java)
    }
}