package id.taufiq.lomanagementapp.repository

import id.taufiq.lomanagementapp.model.Classroom
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface ClassroomRepository : JpaRepository<Classroom, Int> {

    fun findByCourseId(courseId: Int, pageable: Pageable): Page<Classroom>

    fun findByCourseProgramId(programId: Int, pageable: Pageable): Page<Classroom>

}