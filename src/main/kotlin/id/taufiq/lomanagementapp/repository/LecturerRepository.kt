package id.taufiq.lomanagementapp.repository

import id.taufiq.lomanagementapp.model.Lecturer
import org.springframework.data.jpa.repository.JpaRepository

interface LecturerRepository : JpaRepository<Lecturer, String> {
}