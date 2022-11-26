package id.taufiq.lomanagementapp.repository

import id.taufiq.lomanagementapp.model.adm.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserRepository : JpaRepository<User, UUID> {

    fun findByUsername(username: String): Optional<User>

}