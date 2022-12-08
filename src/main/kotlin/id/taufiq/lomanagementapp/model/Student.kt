package id.taufiq.lomanagementapp.model

import id.taufiq.lomanagementapp.model.jointable.StudentClassroom
import jakarta.persistence.*
import org.hibernate.Hibernate
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes

@Entity
data class Student(

    @Id
    @Column(name = "id", nullable = false)
    var id: String? = null,

    @Column(nullable = false)
    var name: String? = null,

    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(name = "gender", length = 1)
    var gender: String? = null,

    @ManyToOne(optional = false)
    @JoinColumn(name = "program_id", nullable = false)
    var program: Program? = null

) {
    @OneToMany(mappedBy = "student", orphanRemoval = true)
    var studentClassrooms: MutableCollection<StudentClassroom> = mutableListOf()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Student

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , name = $name , gender = $gender , program = $program )"
    }
}
