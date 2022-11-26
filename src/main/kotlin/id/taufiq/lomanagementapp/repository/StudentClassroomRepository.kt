package id.taufiq.lomanagementapp.repository

import id.taufiq.lomanagementapp.model.jointable.StudentClassroom
import org.springframework.data.jpa.repository.JpaRepository

interface StudentClassroomRepository : JpaRepository<StudentClassroom, Int> {
}
