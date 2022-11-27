package id.taufiq.lomanagementapp.dto.adm

import java.io.Serializable

/**
 * A DTO for the {@link id.taufiq.lomanagementapp.model.adm.Role} entity
 */
data class RoleDto(
    var id: Int? = null,
    var name: String? = null
) : Serializable
