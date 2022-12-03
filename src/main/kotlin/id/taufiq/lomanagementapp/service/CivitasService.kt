package id.taufiq.lomanagementapp.service

import id.taufiq.lomanagementapp.dto.civitas.*
import id.taufiq.lomanagementapp.exception.NotFoundException
import id.taufiq.lomanagementapp.model.Assignment
import id.taufiq.lomanagementapp.model.Lecturer
import id.taufiq.lomanagementapp.model.Student
import id.taufiq.lomanagementapp.model.jointable.LecturerClassroom
import id.taufiq.lomanagementapp.model.jointable.StudentClassroom
import id.taufiq.lomanagementapp.repository.*
import org.modelmapper.ModelMapper
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class CivitasService(
    private val mapper: ModelMapper,
    private val studentRepository: StudentRepository,
    private val lecturerRepository: LecturerRepository,
    private val studentClassroomRepository: StudentClassroomRepository,
    private val lecturerClassroomRepository: LecturerClassroomRepository,
    private val assignmentRepository: AssignmentRepository
) {

    //
    // STUDENT

    fun createStudent(studentDto: StudentDto): StudentDto {
        studentDto.id = null
        return studentDtoSaveAndMap(studentDto)
    }

    fun updateStudent(studentDto: StudentDto): StudentDto {
        return studentDtoSaveAndMap(studentDto)
    }

    fun findStudent(studentId: String): StudentDto {
        val student = studentRepository.findById(studentId).orElseThrow { NotFoundException("Student not found") }
        return mapper.map(student, StudentDto::class.java)
    }

    fun deleteStudent(studentId: String) {
        studentRepository.deleteById(studentId)
    }

    //
    // LECTURER

    fun createLecturer(lecturerDto: LecturerDto): LecturerDto {
        lecturerDto.id = null
        return lecturerDtoSaveAndMap(lecturerDto)
    }

    fun updateLecturer(lecturerDto: LecturerDto): LecturerDto {
        return lecturerDtoSaveAndMap(lecturerDto)
    }

    fun findLecturer(lecturerId: String): LecturerDto {
        val lecturer = lecturerRepository.findById(lecturerId).orElseThrow { NotFoundException("Lecturer not found") }
        return mapper.map(lecturer, LecturerDto::class.java)
    }

    fun deleteLecturer(lecturerId: String) {
        lecturerRepository.deleteById(lecturerId)
    }

    //
    // STUDENT CLASSROOM

    fun createStudentClassroom(studentClassroomDto: StudentClassroomDto): StudentClassroomDto {
        studentClassroomDto.id = null
        return studentClassroomDtoSaveAndMap(studentClassroomDto)
    }

    fun updateStudentClassroom(studentClassroomDto: StudentClassroomDto): StudentClassroomDto {
        return studentClassroomDtoSaveAndMap(studentClassroomDto)
    }

    fun findStudentClassroom(studentClassroomId: Int): StudentClassroom {
        val studentClassroom = studentClassroomRepository.findById(studentClassroomId)
            .orElseThrow { NotFoundException("Student classroom not found") }
        return mapper.map(studentClassroom, StudentClassroom::class.java)
    }

    fun deleteStudentClassroom(studentClassroomId: Int) {
        studentClassroomRepository.deleteById(studentClassroomId)
    }

    fun findAllStudentClassroomByStudentId(studentId: String, page: Int, size: Int): Page<StudentClassroomDto> {
        val studentClassrooms =
            studentClassroomRepository.findByStudentIdIgnoreCase(studentId, PageRequest.of(page, size))
        return studentClassrooms.map { mapper.map(it, StudentClassroomDto::class.java) }
    }

    fun findAllStudentClassroomByClassroomId(classroomId: Int, page: Int, size: Int): Page<StudentClassroomDto> {
        val studentClassroom = studentClassroomRepository.findByClassroomId(classroomId, PageRequest.of(page, size))
        return studentClassroom.map { mapper.map(it, StudentClassroomDto::class.java) }
    }

    //
    // LECTURER CLASSROOM

    fun createLecturerClassroom(lecturerClassroomDto: LecturerClassroomDto): LecturerClassroomDto {
        lecturerClassroomDto.id = null
        return lecturerClassroomDtoSaveAndMap(lecturerClassroomDto)
    }

    fun updateLecturerClassroom(lecturerClassroomDto: LecturerClassroomDto): LecturerClassroomDto {
        return lecturerClassroomDtoSaveAndMap(lecturerClassroomDto)
    }

    fun findLecturerClassroom(lecturerClassroomId: Int): LecturerClassroomDto {
        val lecturerClassroom = lecturerClassroomRepository.findById(lecturerClassroomId)
            .orElseThrow { NotFoundException("Lecturer classroom not found") }
        return mapper.map(lecturerClassroom, LecturerClassroomDto::class.java)
    }

    fun deleteLecturerClassroom(lecturerClassroomId: Int) {
        lecturerClassroomRepository.deleteById(lecturerClassroomId)
    }

    fun findAllLecturerClassroomByLecturerId(lecturerId: String, page: Int, size: Int): Page<LecturerClassroomDto> {
        val lecturerClassrooms =
            lecturerClassroomRepository.findByLecturerIdIgnoreCase(lecturerId, PageRequest.of(page, size))
        return lecturerClassrooms.map { mapper.map(it, LecturerClassroomDto::class.java) }
    }

    fun findAllLecturerClassroomsByClassroomId(classroomId: Int, page: Int, size: Int): Page<LecturerClassroomDto> {
        val lecturerClassrooms = lecturerClassroomRepository.findByClassroomId(classroomId, PageRequest.of(page, size))
        return lecturerClassrooms.map { mapper.map(it, LecturerClassroomDto::class.java) }
    }

    //
    // STUDENT ASSIGNMENT

    fun createAssignment(assignmentDto: AssignmentDto): AssignmentDto {
        assignmentDto.id = null
        return assignmentDtoSaveAndMap(assignmentDto)
    }

    fun updateAssignment(assignmentDto: AssignmentDto): AssignmentDto {
        return assignmentDtoSaveAndMap(assignmentDto)
    }

    fun findAssignment(assignmentId: Int): AssignmentDto {
        val assignment =
            assignmentRepository.findById(assignmentId).orElseThrow { NotFoundException("Assignment not found") }
        return mapper.map(assignment, AssignmentDto::class.java)
    }

    fun deleteAssignment(assignmentId: Int) {
        assignmentRepository.deleteById(assignmentId)
    }

    private fun studentDtoSaveAndMap(studentDto: StudentDto): StudentDto {
        val student = mapper.map(studentDto, Student::class.java)
        return mapper.map(studentRepository.save(student), StudentDto::class.java)
    }

    private fun lecturerDtoSaveAndMap(lecturerDto: LecturerDto): LecturerDto {
        val lecturer = mapper.map(lecturerDto, Lecturer::class.java)
        return mapper.map(lecturerRepository.save(lecturer), LecturerDto::class.java)
    }

    private fun studentClassroomDtoSaveAndMap(studentClassroomDto: StudentClassroomDto): StudentClassroomDto {
        val studentClassroom = mapper.map(studentClassroomDto, StudentClassroom::class.java)
        return mapper.map(studentClassroomRepository.save(studentClassroom), StudentClassroomDto::class.java)
    }

    private fun lecturerClassroomDtoSaveAndMap(lecturerClassroomDto: LecturerClassroomDto): LecturerClassroomDto {
        val lecturerClassroom = mapper.map(lecturerClassroomDto, LecturerClassroom::class.java)
        return mapper.map(lecturerClassroomRepository.save(lecturerClassroom), LecturerClassroomDto::class.java)
    }

    private fun assignmentDtoSaveAndMap(assignmentDto: AssignmentDto): AssignmentDto {
        val assignment = mapper.map(assignmentDto, Assignment::class.java)
        return mapper.map(assignmentRepository.save(assignment), AssignmentDto::class.java)
    }

}
