package id.taufiq.lomanagementapp.model

import id.taufiq.lomanagementapp.model.jointable.StudentClassroom
import jakarta.persistence.*
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
}
