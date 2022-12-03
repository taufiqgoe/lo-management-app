package id.taufiq.lomanagementapp.controller

import id.taufiq.lomanagementapp.dto.civitas.*
import id.taufiq.lomanagementapp.model.jointable.StudentClassroom
import id.taufiq.lomanagementapp.service.CivitasService
import org.springframework.data.domain.Page
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/civitas")
class CivitasController(
    private val service: CivitasService
) {

    @PostMapping("student")
    fun createStudent(@RequestBody studentDto: StudentDto): StudentDto {
        return service.createStudent(studentDto)
    }

    @PutMapping("student")
    fun updateStudent(@RequestBody studentDto: StudentDto): StudentDto {
        return service.updateStudent(studentDto)
    }

    @GetMapping("student/{studentId}")
    fun findStudent(@PathVariable studentId: String): StudentDto {
        return service.findStudent(studentId)
    }

    @DeleteMapping("student/{studentId}")
    fun deleteStudent(@PathVariable studentId: String) {
        service.deleteStudent(studentId)
    }

    @PostMapping("lecturer")
    fun createLecturer(@RequestBody lecturerDto: LecturerDto): LecturerDto {
        return service.createLecturer(lecturerDto)
    }

    @PutMapping("lecturer")
    fun updateLecturer(@RequestBody lecturerDto: LecturerDto): LecturerDto {
        return service.updateLecturer(lecturerDto)
    }

    @GetMapping("lecturer/{lecturerId}")
    fun findLecturer(@PathVariable lecturerId: String): LecturerDto {
        return service.findLecturer(lecturerId)
    }

    @DeleteMapping("lecturer/{lecturerId}")
    fun deleteLecturer(@PathVariable lecturerId: String) {
        service.deleteLecturer(lecturerId)
    }

    @PostMapping("student-classroom")
    fun createStudentClassroom(@RequestBody studentClassroomDto: StudentClassroomDto): StudentClassroomDto {
        return service.createStudentClassroom(studentClassroomDto)
    }

    @PutMapping("student-classroom")
    fun updateStudentClassroom(@RequestBody studentClassroomDto: StudentClassroomDto): StudentClassroomDto {
        return service.updateStudentClassroom(studentClassroomDto)
    }

    @GetMapping("student-classroom/{studentClassroomId}")
    fun findStudentClassroom(@PathVariable studentClassroomId: Int): StudentClassroom {
        return service.findStudentClassroom(studentClassroomId)
    }

    @DeleteMapping("student-classroom/{studentClassroomId}")
    fun deleteStudentClassroom(@PathVariable studentClassroomId: Int) {
        service.deleteStudentClassroom(studentClassroomId)
    }

    @GetMapping("student-classroom/all/by-student/{studentId}")
    fun findAllStudentClassroomByStudentId(
        @PathVariable studentId: String,
        @RequestParam(defaultValue = "0") page: Int,
        @RequestParam(defaultValue = "10") size: Int
    ): Page<StudentClassroomDto> {
        return service.findAllStudentClassroomByStudentId(studentId, page, size)
    }

    @GetMapping("student-classroom/all/by-classroom/{classroomId}")
    fun findAllStudentClassroomByClassroomId(
        @PathVariable classroomId: Int,
        @RequestParam(defaultValue = "0") page: Int,
        @RequestParam(defaultValue = "10") size: Int
    ): Page<StudentClassroomDto> {
        return service.findAllStudentClassroomByClassroomId(classroomId, page, size)
    }

    @PostMapping("lecturer-classroom")
    fun createLecturerClassroom(@RequestBody lecturerClassroomDto: LecturerClassroomDto): LecturerClassroomDto {
        return service.createLecturerClassroom(lecturerClassroomDto)
    }

    @PutMapping("lecturer-classroom")
    fun updateLecturerClassroom(@RequestBody lecturerClassroomDto: LecturerClassroomDto): LecturerClassroomDto {
        return service.updateLecturerClassroom(lecturerClassroomDto)
    }

    @GetMapping("lecturer-classroom/{lecturerClassroomId}")
    fun findLecturerClassroom(@PathVariable lecturerClassroomId: Int): LecturerClassroomDto {
        return service.findLecturerClassroom(lecturerClassroomId)
    }

    @DeleteMapping("lecturer-classroom/{lecturerClassroomId}")
    fun deleteLecturerClassroom(@PathVariable lecturerClassroomId: Int) {
        service.deleteLecturerClassroom(lecturerClassroomId)
    }

    @GetMapping("lecturer-classroom/all/by-lecturer/{lecturerId}")
    fun findAllLecturerClassroomByLecturerId(
        @PathVariable lecturerId: String,
        @RequestParam(defaultValue = "0") page: Int,
        @RequestParam(defaultValue = "10") size: Int
    ): Page<LecturerClassroomDto> {
        return service.findAllLecturerClassroomByLecturerId(lecturerId, page, size)
    }

    @GetMapping("lecturer-classroom/all/by-classroom/{classroomId}")
    fun findAllLecturerClassroomsByClassroomId(
        @PathVariable classroomId: Int,
        @RequestParam(defaultValue = "0") page: Int,
        @RequestParam(defaultValue = "10") size: Int
    ): Page<LecturerClassroomDto> {
        return service.findAllLecturerClassroomsByClassroomId(classroomId, page, size)
    }

    @PostMapping("assignment")
    fun createAssignment(@RequestBody assignmentDto: AssignmentDto): AssignmentDto {
        return service.createAssignment(assignmentDto)
    }

    @PutMapping("assignment")
    fun updateAssignment(@RequestBody assignmentDto: AssignmentDto): AssignmentDto {
        return service.updateAssignment(assignmentDto)
    }

    @GetMapping("assignment/{assignmentId}")
    fun findAssignment(@PathVariable assignmentId: Int): AssignmentDto {
        return service.findAssignment(assignmentId)
    }

    @DeleteMapping("assignment/{assignmentId}")
    fun deleteAssignment(@PathVariable assignmentId: Int) {
        service.deleteAssignment(assignmentId)
    }

}
