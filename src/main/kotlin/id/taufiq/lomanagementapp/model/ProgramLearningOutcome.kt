package id.taufiq.lomanagementapp.model

import id.taufiq.lomanagementapp.model.jointable.PloClo
import id.taufiq.lomanagementapp.model.jointable.ProgramCurriculum
import jakarta.persistence.*
import org.hibernate.Hibernate

@Entity
data class ProgramLearningOutcome(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Int? = null,

    @Column(nullable = false)
    var name: String? = null,

    @ManyToOne(optional = false)
    @JoinColumn(name = "program_curriculum_id", nullable = false)
    var programCurriculum: ProgramCurriculum? = null

) {
    @OneToMany(mappedBy = "programLearningOutcome", orphanRemoval = true)
    var ploCloes: MutableCollection<PloClo> = mutableListOf()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as ProgramLearningOutcome

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , name = $name , programCurriculum = $programCurriculum )"
    }
}
