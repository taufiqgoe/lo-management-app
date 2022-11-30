package id.taufiq.lomanagementapp.dto.lo

import java.io.Serializable

/**
 * A DTO for the {@link id.taufiq.lomanagementapp.model.jointable.PloClo} entity
 */
data class PloCloDto(
    var id: Int? = null,
    var programLearningOutcomeId: Int? = null,
    var courseLearningOutcomeId: Int? = null,
    var grade: String? = null
) : Serializable