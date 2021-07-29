package com.example.student.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


//@EnableMongoRepositories(basePackageClasses = arrayOf(StudentDAO::class))
@SpringBootApplication//(exclude = arrayOf(ErrorMvcAutoConfiguration::class) )
//@AutoConfigurationPackage
//@EnableAutoConfiguration
//@ComponentScan(basePackages= arrayOf("com.example.student.demo.config", "com.example.student.demo.document", "com.example.student.demo.repository","com.example.student.demo.service"))
//@ComponentScan(basePackages= arrayOf("com.example.student.demo.config"))
class DemoApplication

fun main(args: Array<String>) {
	runApplication<DemoApplication>(*args)
}
