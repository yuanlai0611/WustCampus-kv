package com.example.wustcampus.request.bean

import com.google.gson.annotations.SerializedName

data class CourseRsp(
    @SerializedName("ClassName")
    var className: String,
    @SerializedName("TeacherName")
    var teacher: String,
    @SerializedName("StartWeek")
    var startWeek: Int,
    @SerializedName("EndWeek")
    var endWeek: Int,
    @SerializedName("TimePoint")
    var time: Int,
    @SerializedName("ClassRoom")
    var classRoom: String,
    @SerializedName("ClassWeekday")
    var weekday: Int,
    @SerializedName("ClassNo")
    var classNo: String
)