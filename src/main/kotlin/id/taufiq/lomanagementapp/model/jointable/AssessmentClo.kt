package id.taufiq.lomanagementapp.model.jointable

import id.taufiq.lomanagementapp.model.Assessment
import id.taufiq.lomanagementapp.model.CourseLearningOutcome
import jakarta.persistence.*

@Entity
data class AssessmentClo(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Int? = null,

    @ManyToOne(optional = false)
    @JoinColumn(name = "assessment_id", nullable = false)
    var assessment: Assessment? = null,

    @ManyToOne(optional = false)
    @JoinColumn(name = "course_learning_outcome_id", nullable = false)
    var courseLearningOutcome: CourseLearningOutcome? = null

)
