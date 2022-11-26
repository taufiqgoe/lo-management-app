package id.taufiq.lomanagementapp.model.jointable

import id.taufiq.lomanagementapp.model.Curriculum
import id.taufiq.lomanagementapp.model.Program
import id.taufiq.lomanagementapp.model.ProgramLearningOutcome
import jakarta.persistence.*

@Entity
data class ProgramCurriculum(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Int? = null,

    @ManyToOne(optional = false)
    @JoinColumn(name = "program_id", nullable = false)
    var program: Program? = null,

    @ManyToOne(optional = false)
    @JoinColumn(name = "curriculum_id", nullable = false)
    var curriculum: Curriculum? = null

) {
    @OneToMany(mappedBy = "programCurriculum", orphanRemoval = true)
    var programLearningOutcomes: MutableCollection<ProgramLearningOutcome> = mutableListOf()
}
