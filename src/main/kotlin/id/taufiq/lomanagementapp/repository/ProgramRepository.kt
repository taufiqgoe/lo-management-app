package id.taufiq.lomanagementapp.repository

import id.taufiq.lomanagementapp.model.Program
import org.springframework.data.jpa.repository.JpaRepository

interface ProgramRepository : JpaRepository<Program, Int> {
}