package com.example.student.demo.controller

import org.springframework.boot.web.servlet.error.ErrorController
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest


@CrossOrigin("http://localhost:8099")
@RestController
class MyErrorController : ErrorController {

    @RequestMapping("/error")
    @ResponseBody
    fun handleError( request: HttpServletRequest): String? {
        val statusCode = request.getAttribute("javax.servlet.error.status_code") as Int
        val exception = request.getAttribute("javax.servlet.error.exception") as Exception?
        return String.format("<html><body><h2>Error Page</h2><div>Status code: <b>%s</b></div>"
                + "<div>Exception Message: <b>%s</b></div><body></html>",
                statusCode, if (exception == null) "N/A" else exception.message)

    }

    override fun getErrorPath(): String {
        return "/error"
    }

}