package com.example.wustcampus.util

import android.content.Context
import com.example.wustcampus.R
import com.example.wustcampus.repository.CourseRepository

object DrawableUtils {
    private var studentId: String = ""
    private var semester: String = ""
    private var colorIndex: Int = 0

    private val colorList by lazy {
        listOf(
            R.drawable.layer_color_class_1,
            R.drawable.layer_color_class_2,
            R.drawable.layer_color_class_3,
            R.drawable.layer_color_class_4,
            R.drawable.layer_color_class_5,
            R.drawable.layer_color_class_6,
            R.drawable.layer_color_class_7,
            R.drawable.layer_color_class_8,
            R.drawable.layer_color_class_9,
            R.drawable.layer_color_class_10,
            R.drawable.layer_color_class_no_class
        )
    }

    fun getColorIndex(ctx: Context, studentId: String, semester: String): Int {
        if (this.studentId == studentId && this.semester == semester) {
            return colorIndex++
        }
        colorIndex = CourseRepository.queryLastColorIndex(ctx, studentId, semester) ?: 0
        this.studentId = studentId
        this.semester = semester
        return colorIndex++
    }

    fun getDrawableIndex(index: Int): Int {
        return colorList[index]
    }
}