package id.taufiq.lomanagementapp.dto.lo

import java.io.Serializable

/**
 * A DTO for the {@link id.taufiq.lomanagementapp.model.jointable.AssessmentClo} entity
 */
data class AssessmentCloDto(
    var id: Int? = null,
    var assessmentId: Int? = null,
    var courseLearningOutcomeId: Int? = null
) : Serializable
