package id.taufiq.lomanagementapp.repository

import id.taufiq.lomanagementapp.model.Course
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface CourseRepository : JpaRepository<Course, Int> {

    fun findByProgramId(programId: Int, pageable: Pageable): List<Course>

}