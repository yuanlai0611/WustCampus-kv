package com.example.wustcampus.datasource.db.databean

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.wustcampus.datasource.db.schema.UserSchema
import com.example.wustcampus.datasource.db.schema.WeekSchema

@Entity(
    tableName = WeekSchema.TABLE_NAME,
    foreignKeys = [
        ForeignKey(
            entity = UserBean::class,
            parentColumns = [UserSchema.Cols.STUDENT_ID],
            childColumns = [WeekSchema.Cols.STUDENT_ID],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ]
)
data class WeekBean(
    @ColumnInfo(name = WeekSchema.Cols.STUDENT_ID) val studentId: Long,
    @ColumnInfo(name = WeekSchema.Cols.WEEK) val week: Int,
    @ColumnInfo(name = WeekSchema.Cols.MONDAY) val monday: Int,
    @ColumnInfo(name = WeekSchema.Cols.TUESDAY) val tuesday: Int,
    @ColumnInfo(name = WeekSchema.Cols.WEDNESDAY) val wednesday: Int,
    @ColumnInfo(name = WeekSchema.Cols.THURSDAY) val thursday: Int,
    @ColumnInfo(name = WeekSchema.Cols.FRIDAY) val friday: Int,
    @ColumnInfo(name = WeekSchema.Cols.SATURDAY) val saturday: Int,
    @ColumnInfo(name = WeekSchema.Cols.SUNDAY) val sunday: Int,
    @ColumnInfo(name = WeekSchema.Cols.SEMESTER) val semester: String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    var id: Long = 0
}