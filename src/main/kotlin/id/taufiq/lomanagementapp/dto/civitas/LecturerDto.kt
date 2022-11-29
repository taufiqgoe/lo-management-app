package id.taufiq.lomanagementapp.dto.civitas

import java.io.Serializable

/**
 * A DTO for the {@link id.taufiq.lomanagementapp.model.Lecturer} entity
 */
data class LecturerDto(
    var id: String? = null,
    var nationalIdNumber: String? = null,
    var name: String? = null,
    var programId: Int? = null
) : Serializable
