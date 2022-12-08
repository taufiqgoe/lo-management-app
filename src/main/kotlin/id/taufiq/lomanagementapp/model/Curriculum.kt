package id.taufiq.lomanagementapp.model

import id.taufiq.lomanagementapp.model.jointable.ProgramCurriculum
import jakarta.persistence.*
import org.hibernate.Hibernate

@Entity
data class Curriculum(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Int? = null,

    @Column(nullable = false, unique = true)
    var name: String? = null,

    @Column(nullable = false, unique = true)
    var code: Int? = null

) {
    @OneToMany(mappedBy = "curriculum", orphanRemoval = true)
    var programCurricula: MutableCollection<ProgramCurriculum> = mutableListOf()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Curriculum

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , name = $name , code = $code )"
    }
}
