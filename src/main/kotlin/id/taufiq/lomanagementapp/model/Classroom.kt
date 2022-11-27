package id.taufiq.lomanagementapp.model

import id.taufiq.lomanagementapp.model.jointable.LecturerClassroom
import id.taufiq.lomanagementapp.model.jointable.StudentClassroom
import jakarta.persistence.*

@Entity
data class Classroom(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Int? = null,

    var name: String? = null,

    @ManyToOne(optional = false)
    @JoinColumn(name = "course_id", nullable = false)
    var course: Course? = null

) {
    @OneToMany(mappedBy = "classroom", orphanRemoval = true)
    var assessments: MutableCollection<Assessment> = mutableListOf()

    @OneToMany(mappedBy = "classroom", orphanRemoval = true)
    var studentClassrooms: MutableCollection<StudentClassroom> = mutableListOf()

    @OneToMany(mappedBy = "classroom", orphanRemoval = true)
    var lecturerClassrooms: MutableCollection<LecturerClassroom> = mutableListOf()
}
