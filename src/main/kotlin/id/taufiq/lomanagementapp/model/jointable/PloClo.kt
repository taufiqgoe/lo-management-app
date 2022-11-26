package id.taufiq.lomanagementapp.model.jointable

import id.taufiq.lomanagementapp.model.CourseLearningOutcome
import id.taufiq.lomanagementapp.model.ProgramLearningOutcome
import jakarta.persistence.*
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes

@Entity
data class PloClo(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Int? = null,

    @ManyToOne(optional = false)
    @JoinColumn(name = "program_learning_outcome_id", nullable = false)
    var programLearningOutcome: ProgramLearningOutcome? = null,

    @ManyToOne(optional = false)
    @JoinColumn(name = "course_learning_outcome_id", nullable = false)
    var courseLearningOutcome: CourseLearningOutcome? = null,

    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(name = "grade", length = 1)
    var grade: String? = null

)
