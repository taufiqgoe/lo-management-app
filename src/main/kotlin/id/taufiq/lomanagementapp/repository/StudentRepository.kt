package id.taufiq.lomanagementapp.repository

import id.taufiq.lomanagementapp.model.Student
import org.springframework.data.jpa.repository.JpaRepository

interface StudentRepository : JpaRepository<Student, String> {
}