package com.example.student.demo.controller

import com.example.student.demo.base.BasePaginationModel
import com.example.student.demo.document.Country
import com.example.student.demo.document.Name
import com.example.student.demo.document.StudentModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
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
        val query = Query().addCriteria(Criteria.where(Country).`is`(country))
                .with(Sort.by(Sort.Order.desc(Name)))
                .limit(10)
        return mongoTemplate.find(query, StudentModel::class.java)
    }

    fun getStudentListPageWise(country: String?, page: Int, size: Int): BasePaginationModel<StudentModel> {

        val model = BasePaginationModel<StudentModel>()
        return try {
            val paging = PageRequest.of(page-1, size)

            val query = Query()
            country?.run {
                query.addCriteria(Criteria.where(Country).`is`(country))
            }
            val total = mongoTemplate.count(query, StudentModel::class.java)
            query.with(paging)
            val stories = mongoTemplate.find(query, StudentModel::class.java)

            model.run {
                data = stories
                totalCounts = total
                pageNo = page
                val count = (size * page).toLong()
                itemCount = count.coerceAtMost(total)
            }

            model
        } catch (e: Exception) {
            model
        }

    }


}