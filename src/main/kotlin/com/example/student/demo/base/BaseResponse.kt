package com.example.student.demo.base

import com.example.student.demo.constant.ConstantString
import org.springframework.http.HttpStatus


data class BaseResponse<T> (
        var status:HttpStatus = HttpStatus.INTERNAL_SERVER_ERROR,
        var message:String= ConstantString.SERVER_ERROR,
        var data:T?=null
)