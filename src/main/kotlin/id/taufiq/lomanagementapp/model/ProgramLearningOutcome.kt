package id.taufiq.lomanagementapp.model

import id.taufiq.lomanagementapp.model.jointable.PloClo
import id.taufiq.lomanagementapp.model.jointable.ProgramCurriculum
import jakarta.persistence.*

@Entity
data class ProgramLearningOutcome(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Int? = null,

    var name: String? = null,

    @ManyToOne(optional = false)
    @JoinColumn(name = "program_curriculum_id", nullable = false)
    var programCurriculum: ProgramCurriculum? = null

) {
    @OneToMany(mappedBy = "programLearningOutcome", orphanRemoval = true)
    var ploCloes: MutableCollection<PloClo> = mutableListOf()
}
