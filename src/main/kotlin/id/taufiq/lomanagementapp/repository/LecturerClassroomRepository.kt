package id.taufiq.lomanagementapp.repository

import id.taufiq.lomanagementapp.model.jointable.LecturerClassroom
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface LecturerClassroomRepository : JpaRepository<LecturerClassroom, Int> {

    fun findByLecturerIdIgnoreCase(lecturerId: String, pageable: Pageable): Page<LecturerClassroom>


    fun findByClassroomId(classroomId: Int, pageable: Pageable): Page<LecturerClassroom>

}