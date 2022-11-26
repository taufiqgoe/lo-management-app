package id.taufiq.lomanagementapp.repository

import id.taufiq.lomanagementapp.model.jointable.LecturerClassroom
import org.springframework.data.jpa.repository.JpaRepository

interface LecturerClassroomRepository : JpaRepository<LecturerClassroom, Int> {
}