package id.taufiq.lomanagementapp.dto

import java.io.Serializable

/**
 * A DTO for the {@link id.taufiq.lomanagementapp.model.Program} entity
 */
data class ProgramDto(
    var id: Int? = null,
    var name: String? = null,
    var departmentId: Int? = null
) : Serializable
