package id.taufiq.lomanagementapp.model

import id.taufiq.lomanagementapp.model.jointable.ProgramCurriculum
import jakarta.persistence.*

@Entity
data class Curriculum(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Int? = null,

    var name: String? = null

) {
    @OneToMany(mappedBy = "curriculum", orphanRemoval = true)
    var programCurricula: MutableCollection<ProgramCurriculum> = mutableListOf()
}
