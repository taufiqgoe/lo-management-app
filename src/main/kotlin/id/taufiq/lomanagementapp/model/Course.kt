package id.taufiq.lomanagementapp.model

import jakarta.persistence.*
import org.hibernate.Hibernate
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes

@Entity
data class Course(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Int? = null,

    @Column(nullable = false)
    var name: String? = null,

    @Column(nullable = false, unique = true)
    var code: String? = null,

    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(length = 1)
    var characteristic: String? = null,

    @ManyToOne(optional = false)
    @JoinColumn(name = "program_id", nullable = false)
    var program: Program? = null

) {
    @OneToMany(mappedBy = "course", orphanRemoval = true)
    var classrooms: MutableCollection<Classroom> = mutableListOf()

    @OneToMany(mappedBy = "course", orphanRemoval = true)
    var courseLearningOutcomes: MutableCollection<CourseLearningOutcome> = mutableListOf()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Course

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , name = $name , code = $code , characteristic = $characteristic , program = $program )"
    }
}
