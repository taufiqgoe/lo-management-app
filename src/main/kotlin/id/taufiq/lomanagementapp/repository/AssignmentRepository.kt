package id.taufiq.lomanagementapp.repository

import id.taufiq.lomanagementapp.model.Assignment
import org.springframework.data.jpa.repository.JpaRepository

interface AssignmentRepository : JpaRepository<Assignment, Int> {
}