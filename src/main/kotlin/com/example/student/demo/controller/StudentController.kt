package com.example.student.demo.controller

import com.example.student.demo.base.BaseResponse
import com.example.student.demo.constant.ConstantString
import com.example.student.demo.document.SEQUENCE_NAME
import com.example.student.demo.document.StudentModel
import com.example.student.demo.repository.StudentDAO
import com.example.student.demo.service.SequenceGeneratorService
import com.example.student.demo.utils.Logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@CrossOrigin("http://localhost:8099")
@RestController
@RequestMapping("/api/v1")
class StudentController {

    @Autowired
    lateinit var studentDAO: StudentDAO

    @Autowired
    lateinit var studentService: StudentService


    @Autowired
    lateinit var seqGeneratorService: SequenceGeneratorService

    @GetMapping("/read")
    fun read(): BaseResponse<List<StudentModel>> {
//        return studentDAO.findAll()
        val model = BaseResponse<List<StudentModel>>()
        return try {
            val students = studentDAO.findAll()
            model.data = students

            if (students.isEmpty()) {
                model.run {
                    message = ConstantString.NO_DATA
                    status = HttpStatus.NO_CONTENT
                }
                model
            } else {
                model.run {
                    message = ConstantString.REQUEST_SUCCESS
                    status = HttpStatus.OK
                }
                model
            }
        } catch (e: Exception) {
            model
        }
    }

    @GetMapping("/readByCountry/{country}")
    fun readStudentsByCountry(@PathVariable country: String): BaseResponse<List<StudentModel>> {

        val model = BaseResponse<List<StudentModel>>()
        return try {
            val students = studentService.getStudentAccordingCountry(country)
            model.data = students

            if (students.isEmpty()) {
                model.run {
                    message = ConstantString.NO_DATA
                    status = HttpStatus.NO_CONTENT
                }
                model
            } else {
                model.run {
                    message = ConstantString.REQUEST_SUCCESS
                    status = HttpStatus.OK
                }
                model
            }
        } catch (e: Exception) {
            Logger.debug(e)
            model
        }
    }

    @PostMapping("/readByCountry")
    fun readStudentsByCountryInputChange(@RequestParam("country") country: String): BaseResponse<List<StudentModel>> {

        val model = BaseResponse<List<StudentModel>>()
        return try {
            val students = studentService.getStudentAccordingCountry(country)
            model.data = students

            if (students.isEmpty()) {
                model.run {
                    message = ConstantString.NO_DATA
                    status = HttpStatus.NO_CONTENT
                }
                model
            } else {
                model.run {
                    message = ConstantString.REQUEST_SUCCESS
                    status = HttpStatus.OK
                }
                model
            }
        } catch (e: Exception) {
            Logger.debug(e)
            model
        }
    }


    @PostMapping("/create")
    fun create(@RequestBody newEmployeeObject: StudentModel): BaseResponse<StudentModel> {
        val model = BaseResponse<StudentModel>()
        model.message = try {
            newEmployeeObject.id = seqGeneratorService.generateSequence(SEQUENCE_NAME)
            model.data = studentDAO.save(newEmployeeObject)
            model.status = HttpStatus.OK
            ConstantString.REQUEST_SUCCESS
        } catch (e: Exception) {
            model.status = HttpStatus.FAILED_DEPENDENCY
            ConstantString.REQUEST_FAILURE
        }
        return model
    }


    @GetMapping("/read/{id}")
    fun read(@PathVariable id: Long): BaseResponse<StudentModel> {
        val model = BaseResponse<StudentModel>()
        try {
            val employeeObj = studentDAO.findById(id)

            model.message = if (employeeObj.isPresent) {
                model.data = employeeObj.get()
                model.status = HttpStatus.OK
                ConstantString.REQUEST_SUCCESS
            } else {
                model.status = HttpStatus.NOT_FOUND
                "Student not found with id $id"
            }
        } catch (e: Exception) {
            model.status = HttpStatus.NOT_FOUND
            model.message = "Student not found with id $id"
        }
        return model
    }

    @PutMapping("/update")
    fun update(@RequestBody modifiedEmployeeObject: StudentModel): BaseResponse<StudentModel> {
        val model = BaseResponse<StudentModel>()
        model.message =try {
            if(studentDAO.existsById(modifiedEmployeeObject.id)) {
                model.status = HttpStatus.OK
                model.data = studentDAO.save(modifiedEmployeeObject)
                ConstantString.REQUEST_SUCCESS
            }else{
                model.status = HttpStatus.NOT_ACCEPTABLE
                "Request not acceptable"
            }
        } catch (e: Exception) {
            model.status = HttpStatus.NOT_ACCEPTABLE
            "Request not acceptable"
        }
        return model
    }

    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable id: Long): BaseResponse<String> {
        val model = BaseResponse<String>()
        try {

            val employeeObj = studentDAO.findById(id)

            model.message = if (employeeObj.isPresent) {
                studentDAO.delete(employeeObj.get())
                model.status = HttpStatus.OK
                "Student deleted with id $id"
            } else {
                model.status = HttpStatus.NOT_FOUND
                "Student not found for id $id"
            }
        } catch (e: Exception) {
            model.status = HttpStatus.NOT_FOUND
            model.message = "Student not found for id $id"
        }
        return model
    }
}