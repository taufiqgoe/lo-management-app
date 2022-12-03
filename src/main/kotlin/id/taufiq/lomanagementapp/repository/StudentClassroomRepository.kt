package id.taufiq.lomanagementapp.repository

import id.taufiq.lomanagementapp.model.jointable.StudentClassroom
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface StudentClassroomRepository : JpaRepository<StudentClassroom, Int> {

    fun findByStudentIdIgnoreCase(studentId: String, pageable: Pageable): Page<StudentClassroom>

    fun findByClassroomId(classroomId: Int, pageable: Pageable): Page<StudentClassroom>

}
