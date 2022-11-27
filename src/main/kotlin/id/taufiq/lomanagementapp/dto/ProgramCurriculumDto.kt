package id.taufiq.lomanagementapp.dto

import java.io.Serializable

/**
 * A DTO for the {@link id.taufiq.lomanagementapp.model.jointable.ProgramCurriculum} entity
 */
data class ProgramCurriculumDto(
    var id: Int? = null,
    var programId: Int? = null,
    var curriculumId: Int? = null
) : Serializable
