package com.example.wustcampus.datasource.db.databean

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.wustcampus.datasource.db.schema.UserSchema

@Entity(tableName = UserSchema.TABLE_NAME)
data class UserBean(
    @ColumnInfo(name = UserSchema.Cols.SEMESTER) val semester: String,
    @ColumnInfo(name = UserSchema.Cols.STUDENT_NAME) val studentName: String
) {
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = UserSchema.Cols.STUDENT_ID)
    var studentId: Long = 0
}