package id.taufiq.lomanagementapp.dto.lo

import java.io.Serializable

/**
 * A DTO for the {@link id.taufiq.lomanagementapp.model.ProgramLearningOutcome} entity
 */
data class ProgramLearningOutcomeDto(
    var id: Int? = null,
    var name: String? = null,
    var programCurriculumId: Int? = null
) : Serializable
