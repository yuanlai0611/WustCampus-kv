package com.example.wustcampus.datasource.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.wustcampus.datasource.db.databean.CourseBean
import com.example.wustcampus.datasource.db.schema.CourseSchema

@Dao
interface CourseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCourseBean(courseBean: CourseBean)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCourseBeans(courseBeans: List<CourseBean>)

    @Delete
    fun deleteCourseBean(courseBean: CourseBean)

    @Delete
    fun deleteCourseBeans(courseBeans: List<CourseBean>)

    /**
     * 根据 {学生ID、学期、星期几} 来查询课程信息
     */
    @Query(
        "SELECT * FROM ${CourseSchema.TABLE_NAME} " +
                "WHERE ${CourseSchema.Cols.WEEKDAY} = :weekday " +
                "AND ${CourseSchema.Cols.STUDENT_ID} = :studentId " +
                "AND ${CourseSchema.Cols.SEMESTER} = :semester " +
                "ORDER BY ${CourseSchema.Cols.WEEKDAY}, ${CourseSchema.Cols.TIME} ASC"
    )
    fun query(studentId: Long, weekday: Int, semester: String): LiveData<List<CourseBean>>

    @Query(
        "SELECT * FROM ${CourseSchema.TABLE_NAME} " +
                "WHERE ${CourseSchema.Cols.START_WEEK} <= :week AND ${CourseSchema.Cols.END_WEEK} >= :week " +
                "AND ${CourseSchema.Cols.STUDENT_ID} = :studentId " +
                "AND ${CourseSchema.Cols.SEMESTER} = :semester " +
                "AND ${CourseSchema.Cols.WEEKDAY} = :weekday " +
                "AND ${CourseSchema.Cols.TIME} = :time"
    )
    fun query(studentId: Long, week: Int, weekday: Int, time: Int, semester: String): CourseBean

    /**
     * 获取 {学号ID、学期} 对应课程的数量
     */
    @Query(
        "SELECT COUNT(*) FROM ${CourseSchema.TABLE_NAME} " +
                "WHERE ${CourseSchema.Cols.STUDENT_ID} = :studentId " +
                "AND ${CourseSchema.Cols.SEMESTER} = :semester"
    )
    fun query(studentId: Long, semester: String): Int
}