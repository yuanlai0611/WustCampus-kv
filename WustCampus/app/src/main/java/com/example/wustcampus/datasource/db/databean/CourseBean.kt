package com.example.wustcampus.datasource.db.databean

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.wustcampus.datasource.db.schema.CourseSchema
import com.example.wustcampus.datasource.db.schema.UserSchema

@Entity(
    tableName = CourseSchema.TABLE_NAME,
    foreignKeys = [
        ForeignKey(
            entity = UserBean::class,
            parentColumns = [UserSchema.Cols.STUDENT_ID],
            childColumns = [CourseSchema.Cols.STUDENT_ID],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ]
)
data class CourseBean(
    @ColumnInfo(name = CourseSchema.Cols.STUDENT_ID) val studentId: String,
    @ColumnInfo(name = CourseSchema.Cols.WEEKDAY) val weekDay: Int,
    @ColumnInfo(name = CourseSchema.Cols.CLASS_NAME) val className: String,
    @ColumnInfo(name = CourseSchema.Cols.TEACHER) val teacher: String,
    @ColumnInfo(name = CourseSchema.Cols.START_WEEK) val startWeek: Int,
    @ColumnInfo(name = CourseSchema.Cols.END_WEEK) val endWeek: Int,
    @ColumnInfo(name = CourseSchema.Cols.TIME) val time: Int,
    @ColumnInfo(name = CourseSchema.Cols.CLASSROOM) val classRoom: String,
    @ColumnInfo(name = CourseSchema.Cols.COLOR) val color: Int,
    @ColumnInfo(name = CourseSchema.Cols.IS_DEFAULT) val isDefault: Boolean,
    @ColumnInfo(name = CourseSchema.Cols.SEMESTER) val semester: String,
    @ColumnInfo(name = CourseSchema.Cols.CLASS_NO) val classNo: String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long = 0
}