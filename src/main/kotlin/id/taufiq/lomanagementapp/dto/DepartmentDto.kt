package id.taufiq.lomanagementapp.dto

import java.io.Serializable

/**
 * A DTO for the {@link id.taufiq.lomanagementapp.model.Department} entity
 */
data class DepartmentDto(var id: Int? = null, var name: String? = null) : Serializable
