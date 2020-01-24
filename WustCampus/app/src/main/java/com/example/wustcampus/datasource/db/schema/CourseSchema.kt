package com.example.wustcampus.datasource.db.schema

object CourseSchema {
    const val TABLE_NAME = "Course"

    object Cols {
        const val STUDENT_ID = "studentId"
        const val WEEKDAY = "weekday"
        const val CLASS_NAME = "className"
        const val TEACHER = "teacher"
        const val START_WEEK = "startWeek"
        const val END_WEEK = "endWeek"
        const val TIME = "time"
        const val CLASSROOM = "classroom"
        const val COLOR = "color"
        const val IS_DEFAULT = "isDefault"
        const val SEMESTER = "semester"
        const val CLASS_NO = "classNo"
    }
}