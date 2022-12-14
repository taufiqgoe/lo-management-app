package id.taufiq.lomanagementapp.repository

import id.taufiq.lomanagementapp.model.adm.Role
import org.springframework.data.jpa.repository.JpaRepository

interface RoleRepository : JpaRepository<Role, Int> {
}