package id.taufiq.lomanagementapp.repository

import id.taufiq.lomanagementapp.model.Department
import org.springframework.data.jpa.repository.JpaRepository

interface DepartmentRepository : JpaRepository<Department, Int> {
}