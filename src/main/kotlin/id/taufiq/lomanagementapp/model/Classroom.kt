package id.taufiq.lomanagementapp.model

import id.taufiq.lomanagementapp.model.jointable.LecturerClassroom
import id.taufiq.lomanagementapp.model.jointable.StudentClassroom
import jakarta.persistence.*
import org.hibernate.Hibernate

@Entity
data class Classroom(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Int? = null,

    @Column(nullable = false)
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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Classroom

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , name = $name , course = $course )"
    }
}
