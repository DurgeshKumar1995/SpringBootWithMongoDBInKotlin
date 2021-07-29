package com.example.student.demo.service

import com.example.student.demo.document.DatabaseSequence
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.FindAndModifyOptions
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.Update
import org.springframework.stereotype.Service
import java.util.*

@Service
class SequenceGeneratorService {
    @Autowired
    private val mongo: MongoOperations? = null
    fun generateSequence(seqName: String?): Long {
        val counter = mongo!!.findAndModify(Query.query(Criteria.where("_id").`is`(seqName)),
                Update().inc("seq", 1), FindAndModifyOptions.options().returnNew(true).upsert(true),
                DatabaseSequence::class.java)
        return if (!Objects.isNull(counter)) counter!!.seq else 1
    }
}