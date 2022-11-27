package id.taufiq.lomanagementapp.dto.adm

import java.io.Serializable
import java.util.*

/**
 * A DTO for the {@link id.taufiq.lomanagementapp.model.adm.User} entity
 */
data class UserDto(
    var id: UUID? = null,
    var username: String? = null,
    var password: String? = null,
    var email: String? = null,
    var isEnabled: Boolean? = null,
    var roles: MutableCollection<RoleDto> = mutableListOf()
) : Serializable