package id.taufiq.lomanagementapp.service

import id.taufiq.lomanagementapp.dto.*
import id.taufiq.lomanagementapp.exception.NotFoundException
import id.taufiq.lomanagementapp.model.*
import id.taufiq.lomanagementapp.model.jointable.ProgramCurriculum
import id.taufiq.lomanagementapp.repository.*
import org.modelmapper.ModelMapper
import org.springframework.stereotype.Service

@Service
class AcademicService(
    private val mapper: ModelMapper,
    private val departmentRepository: DepartmentRepository,
    private val programRepository: ProgramRepository,
    private val courseRepository: CourseRepository,
    private val classroomRepository: ClassroomRepository,
    private val curriculumRepository: CurriculumRepository,
    private val programCurriculumRepository: ProgramCurriculumRepository,
    private val assessmentRepository: AssessmentRepository
) {

    //
    // DEPARTMENT

    fun createDepartment(departmentDto: DepartmentDto): DepartmentDto {
        departmentDto.id = null
        return departmentDtoMapAndSave(departmentDto)
    }

    fun updateDepartment(departmentDto: DepartmentDto): DepartmentDto {
        return departmentDtoMapAndSave(departmentDto)
    }

    fun findDepartment(departmentId: Int): DepartmentDto {
        val department =
            departmentRepository.findById(departmentId).orElseThrow { NotFoundException("Department not found") }
        return mapper.map(department, DepartmentDto::class.java)
    }

    fun deleteDepartment(departmentId: Int) {
        departmentRepository.deleteById(departmentId)
    }

    //
    // PROGRAM

    fun createProgram(programDto: ProgramDto): ProgramDto {
        programDto.id = null
        return programDtoMapAndSave(programDto)
    }

    fun updateProgram(programDto: ProgramDto): ProgramDto {
        return programDtoMapAndSave(programDto)
    }

    fun findProgram(programId: Int): ProgramDto {
        val program = programRepository.findById(programId).orElseThrow { NotFoundException("Program not found") }
        return mapper.map(program, ProgramDto::class.java)
    }

    fun deleteProgram(programId: Int) {
        programRepository.deleteById(programId)
    }

    //
    // Course

    fun createCourse(courseDto: CourseDto): CourseDto {
        courseDto.id = null
        return courseDtoMapAndSave(courseDto)
    }

    fun updateCourse(courseDto: CourseDto): CourseDto {
        return courseDtoMapAndSave(courseDto)
    }

    fun findCourse(courseId: Int): CourseDto {
        val course = courseRepository.findById(courseId).orElseThrow { NotFoundException("Course not found") }
        return mapper.map(course, CourseDto::class.java)
    }

    fun deleteCourse(courseId: Int) {
        courseRepository.deleteById(courseId)
    }

    //
    // CLASSROOM

    fun createClassroom(classroomDto: ClassroomDto): ClassroomDto {
        classroomDto.id = null
        return classroomDtoMapAndSave(classroomDto)
    }

    fun updateClassroom(classroomDto: ClassroomDto): ClassroomDto {
        return classroomDtoMapAndSave(classroomDto)
    }

    fun findClassroom(classroomId: Int): ClassroomDto {
        val classroom =
            classroomRepository.findById(classroomId).orElseThrow { NotFoundException("Classroom not found") }
        return mapper.map(classroom, ClassroomDto::class.java)
    }

    fun deleteClassroom(classroomId: Int) {
        classroomRepository.deleteById(classroomId)
    }

    //
    // CURRICULUM

    fun createCurriculum(curriculumDto: CurriculumDto): CurriculumDto {
        curriculumDto.id = null
        return curriculumDtoMapAndSave(curriculumDto)
    }

    fun updateCurriculum(curriculumDto: CurriculumDto): CurriculumDto {
        return curriculumDtoMapAndSave(curriculumDto)
    }

    fun findCurriculum(curriculumId: Int): CurriculumDto {
        val curriculum =
            curriculumRepository.findById(curriculumId).orElseThrow { NotFoundException("Curriculum not found") }
        return mapper.map(curriculum, CurriculumDto::class.java)
    }

    fun deleteCurriculum(curriculumId: Int) {
        curriculumRepository.deleteById(curriculumId)
    }

    //
    // PROGRAM CURRICULUM

    fun createProgramCurriculum(programCurriculumDto: ProgramCurriculumDto): ProgramCurriculumDto {
        programCurriculumDto.id = null
        return programCurriculumDtoMapAndSave(programCurriculumDto)
    }

    fun updateProgramCurriculum(programCurriculumDto: ProgramCurriculumDto): ProgramCurriculumDto {
        return programCurriculumDtoMapAndSave(programCurriculumDto)
    }

    fun deleteProgramCurriculum(programCurriculumId: Int) {
        programCurriculumRepository.deleteById(programCurriculumId)
    }

    //
    // ASSESSMENT

    fun createAssessment(assessmentDto: AssessmentDto): AssessmentDto {
        assessmentDto.id = null
        return assessmentDtoMapAndSave(assessmentDto)
    }

    fun updateAssessment(assessmentDto: AssessmentDto): AssessmentDto {
        return assessmentDtoMapAndSave(assessmentDto)
    }

    fun findAssessment(assessmentId: Int): AssessmentDto {
        val assessment =
            assessmentRepository.findById(assessmentId).orElseThrow { NotFoundException("Assessment not found") }
        return mapper.map(assessment, AssessmentDto::class.java)
    }

    fun deleteAssessment(assessmentId: Int) {
        assessmentRepository.deleteById(assessmentId)
    }

    //
    // private function

    private fun departmentDtoMapAndSave(departmentDto: DepartmentDto): DepartmentDto {
        val department = mapper.map(departmentDto, Department::class.java)
        return mapper.map(departmentRepository.save(department), DepartmentDto::class.java)
    }

    private fun programDtoMapAndSave(programDto: ProgramDto): ProgramDto {
        val program = mapper.map(programDto, Program::class.java)
        return mapper.map(programRepository.save(program), ProgramDto::class.java)
    }

    private fun courseDtoMapAndSave(courseDto: CourseDto): CourseDto {
        val course = mapper.map(courseDto, Course::class.java)
        return mapper.map(courseRepository.save(course), CourseDto::class.java)
    }

    private fun curriculumDtoMapAndSave(curriculumDto: CurriculumDto): CurriculumDto {
        val curriculum = mapper.map(curriculumDto, Curriculum::class.java)
        return mapper.map(curriculumRepository.save(curriculum), CurriculumDto::class.java)
    }

    private fun classroomDtoMapAndSave(classroomDto: ClassroomDto): ClassroomDto {
        val classroom = mapper.map(classroomDto, Classroom::class.java)
        return mapper.map(classroomRepository.save(classroom), ClassroomDto::class.java)
    }

    private fun programCurriculumDtoMapAndSave(programCurriculumDto: ProgramCurriculumDto): ProgramCurriculumDto {
        val programCurriculum = mapper.map(programCurriculumDto, ProgramCurriculum::class.java)
        return mapper.map(programCurriculumRepository.save(programCurriculum), ProgramCurriculumDto::class.java)
    }

    private fun assessmentDtoMapAndSave(assessmentDto: AssessmentDto): AssessmentDto {
        val assessment = mapper.map(assessmentDto, Assessment::class.java)
        return mapper.map(assessmentRepository.save(assessment), AssessmentDto::class.java)
    }

}
