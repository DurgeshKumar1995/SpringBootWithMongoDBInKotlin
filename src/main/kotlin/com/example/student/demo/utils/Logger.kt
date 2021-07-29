package com.example.student.demo.utils

import org.slf4j.LoggerFactory
import java.util.*


object Logger {

    private const val TAG = "Logger"
    var logger = LoggerFactory.getLogger(TAG)
    fun debug(msg: String, tag: String? = TAG){
        if (logger.isDebugEnabled){
            logger.debug(tag,msg)
        }

    }
    fun debug(msg: Exception?, tag: String = TAG){
        if (logger.isDebugEnabled){
            logger.debug(tag,msg?.localizedMessage?.toString())
        }
    }

    fun error(msg: String, tag: String = TAG){
        if (logger.isDebugEnabled){
            logger.error(tag,msg)
        }
    }
    fun error(msg: Exception?, tag: String = TAG){
        if (logger.isDebugEnabled){
            logger.error(tag,msg?.localizedMessage?.toString())
        }
    }


}