package id.taufiq.lomanagementapp.model.jointable

import id.taufiq.lomanagementapp.model.Assignment
import id.taufiq.lomanagementapp.model.Classroom
import id.taufiq.lomanagementapp.model.Student
import jakarta.persistence.*

@Entity
data class StudentClassroom(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Int? = null,

    @ManyToOne(optional = false)
    @JoinColumn(name = "student_id", nullable = false)
    var student: Student? = null,

    @ManyToOne(optional = false)
    @JoinColumn(name = "classroom_id", nullable = false)
    var classroom: Classroom? = null

) {
    @OneToMany(mappedBy = "studentClassroom", orphanRemoval = true)
    var assignments: MutableCollection<Assignment> = mutableListOf()
}
