package com.example.student.demo.repository

import com.example.student.demo.document.StudentModel
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

//@EnableMongoRepositories
@Repository
interface StudentDAO : MongoRepository<StudentModel,Long>  {

    //@Query("select * from students s where s.country = :country")
//    @Query("{country : ?0}")
//    fun getStudentListByCountry( country:String) : List<StudentModel>

}