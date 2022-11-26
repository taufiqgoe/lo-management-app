package id.taufiq.lomanagementapp.repository

import id.taufiq.lomanagementapp.model.jointable.PloClo
import org.springframework.data.jpa.repository.JpaRepository

interface PloCloRepository : JpaRepository<PloClo, Int> {
}