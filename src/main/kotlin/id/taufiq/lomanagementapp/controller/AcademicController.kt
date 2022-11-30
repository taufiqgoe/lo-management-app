package id.taufiq.lomanagementapp.controller

import id.taufiq.lomanagementapp.dto.*
import id.taufiq.lomanagementapp.service.AcademicService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/academic")
class AcademicController(
    private val service: AcademicService
) {

    @PostMapping("department")
    fun createDepartment(@RequestBody departmentDto: DepartmentDto): DepartmentDto {
        return service.createDepartment(departmentDto)
    }

    @PutMapping("department")
    fun updateDepartment(@RequestBody departmentDto: DepartmentDto): DepartmentDto {
        return service.updateDepartment(departmentDto)
    }

    @GetMapping("department/{departmentId}")
    fun findDepartment(@PathVariable departmentId: Int): DepartmentDto {
        return service.findDepartment(departmentId)
    }

    @DeleteMapping("department/{departmentId}")
    fun deleteDepartment(@PathVariable departmentId: Int) {
        service.deleteDepartment(departmentId)
    }

    @PostMapping("program")
    fun createProgram(@RequestBody programDto: ProgramDto): ProgramDto {
        return service.createProgram(programDto)
    }

    @PutMapping("program")
    fun updateProgram(@RequestBody programDto: ProgramDto): ProgramDto {
        return service.updateProgram(programDto)
    }

    @GetMapping("program/{programId}")
    fun findProgram(@PathVariable programId: Int): ProgramDto {
        return service.findProgram(programId)
    }

    @DeleteMapping("program/{programId}")
    fun deleteProgram(@PathVariable programId: Int) {
        service.deleteProgram(programId)
    }

    @PostMapping("course")
    fun createCourse(courseDto: CourseDto): CourseDto {
        return service.createCourse(courseDto)
    }

    @PutMapping("course")
    fun updateCourse(courseDto: CourseDto): CourseDto {
        return service.updateCourse(courseDto)
    }

    @GetMapping("course/{courseId}")
    fun findCourse(@PathVariable courseId: Int): CourseDto {
        return service.findCourse(courseId)
    }

    @DeleteMapping("course/{courseId}")
    fun deleteCourse(@PathVariable courseId: Int) {
        service.deleteCourse(courseId)
    }

    @PostMapping("classroom")
    fun createClassroom(@RequestBody classroomDto: ClassroomDto): ClassroomDto {
        return service.createClassroom(classroomDto)
    }

    @PutMapping("classroom")
    fun updateClassroom(@RequestBody classroomDto: ClassroomDto): ClassroomDto {
        return service.updateClassroom(classroomDto)
    }

    @GetMapping("classroom/{classroomId}")
    fun findClassroom(@PathVariable classroomId: Int): ClassroomDto {
        return service.findClassroom(classroomId)
    }

    @DeleteMapping("classroom/{classroomId}")
    fun deleteClassroom(@PathVariable classroomId: Int) {
        service.deleteClassroom(classroomId)
    }

    @PostMapping("curriculum")
    fun createCurriculum(@RequestBody curriculumDto: CurriculumDto): CurriculumDto {
        return service.createCurriculum(curriculumDto)
    }

    @PutMapping("curriculum")
    fun updateCurriculum(@RequestBody curriculumDto: CurriculumDto): CurriculumDto {
        return service.updateCurriculum(curriculumDto)
    }

    @GetMapping("curriculum/{curriculumId}")
    fun findCurriculum(@PathVariable curriculumId: Int): CurriculumDto {
        return service.findCurriculum(curriculumId)
    }

    @DeleteMapping("curriculum/{curriculumId}")
    fun deleteCurriculum(@PathVariable curriculumId: Int) {
        service.deleteCurriculum(curriculumId)
    }

    @PostMapping("program-curriculum")
    fun createProgramCurriculum(@RequestBody programCurriculumDto: ProgramCurriculumDto): ProgramCurriculumDto {
        return service.createProgramCurriculum(programCurriculumDto)
    }

    @PutMapping("program-curriculum")
    fun updateProgramCurriculum(@RequestBody programCurriculumDto: ProgramCurriculumDto): ProgramCurriculumDto {
        return service.updateProgramCurriculum(programCurriculumDto)
    }

    @DeleteMapping("program-curriculum/{programCurriculumId}")
    fun deleteProgramCurriculum(@PathVariable programCurriculumId: Int) {
        return service.deleteProgramCurriculum(programCurriculumId)
    }

    @PostMapping("assessment")
    fun createAssessment(@RequestBody assessmentDto: AssessmentDto): AssessmentDto {
        return service.createAssessment(assessmentDto)
    }

    @PutMapping("assessment")
    fun updateAssessment(@RequestBody assessmentDto: AssessmentDto): AssessmentDto {
        return service.updateAssessment(assessmentDto)
    }

    @GetMapping("assessment/{assessmentId}")
    fun findAssessment(assessmentId: Int): AssessmentDto {
        return service.findAssessment(assessmentId)
    }

    @DeleteMapping("assessment/{assessmentId}")
    fun deleteAssessment(@PathVariable assessmentId: Int) {
        service.deleteAssessment(assessmentId)
    }

}
