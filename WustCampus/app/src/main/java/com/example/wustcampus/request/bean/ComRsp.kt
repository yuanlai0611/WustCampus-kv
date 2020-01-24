package com.example.wustcampus.request.bean

data class ComRsp<T>(
    var code: Int,
    var data: List<T>,
    var msg: String
)