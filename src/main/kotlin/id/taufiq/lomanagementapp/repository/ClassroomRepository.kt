package id.taufiq.lomanagementapp.repository

import id.taufiq.lomanagementapp.model.Classroom
import org.springframework.data.jpa.repository.JpaRepository

interface ClassroomRepository : JpaRepository<Classroom, Int> {
}