package com.example.student.demo.base

data class BasePaginationModel<T> (
        var totalCounts:Long=0,
        var pageNo:Int=0,
        var itemCount:Long=0,
        var data :List<T> = ArrayList()
)