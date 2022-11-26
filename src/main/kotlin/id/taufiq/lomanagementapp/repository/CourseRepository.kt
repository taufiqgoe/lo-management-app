package id.taufiq.lomanagementapp.repository

import id.taufiq.lomanagementapp.model.Course
import org.springframework.data.jpa.repository.JpaRepository

interface CourseRepository : JpaRepository<Course, Int> {
}