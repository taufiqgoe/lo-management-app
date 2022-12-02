package id.taufiq.lomanagementapp.service

import id.taufiq.lomanagementapp.dto.lo.AssessmentCloDto
import id.taufiq.lomanagementapp.dto.lo.CourseLearningOutcomeDto
import id.taufiq.lomanagementapp.dto.lo.PloCloDto
import id.taufiq.lomanagementapp.dto.lo.ProgramLearningOutcomeDto
import id.taufiq.lomanagementapp.dto.op.LoScoreDto
import id.taufiq.lomanagementapp.exception.NotFoundException
import id.taufiq.lomanagementapp.model.CourseLearningOutcome
import id.taufiq.lomanagementapp.model.ProgramLearningOutcome
import id.taufiq.lomanagementapp.model.jointable.AssessmentClo
import id.taufiq.lomanagementapp.model.jointable.PloClo
import id.taufiq.lomanagementapp.repository.*
import jakarta.transaction.Transactional
import org.modelmapper.ModelMapper
import org.springframework.stereotype.Service

@Service
class LoService(
    private val mapper: ModelMapper,
    private val programLearningOutcomeRepository: ProgramLearningOutcomeRepository,
    private val courseLearningOutcomeRepository: CourseLearningOutcomeRepository,
    private val ploCloRepository: PloCloRepository,
    private val assessmentCloRepository: AssessmentCloRepository,
    private val assignmentRepository: AssignmentRepository,
    private val courseRepository: CourseRepository
) {

    //
    // PLO

    fun createPlo(ploDto: ProgramLearningOutcomeDto): ProgramLearningOutcomeDto {
        ploDto.id = null
        return ploDtoSaveAndMap(ploDto)
    }

    fun updatePlo(ploDto: ProgramLearningOutcomeDto): ProgramLearningOutcomeDto {
        return ploDtoSaveAndMap(ploDto)
    }

    fun findPlo(ploId: Int): ProgramLearningOutcomeDto {
        val plo = findPloByIdOrThrowNotFound(ploId)
        return mapper.map(plo, ProgramLearningOutcomeDto::class.java)
    }

    fun deletePlo(ploId: Int) {
        programLearningOutcomeRepository.deleteById(ploId)
    }

    fun findPloAverageScore(ploId: Int): LoScoreDto<ProgramLearningOutcomeDto> {
        val plo = mapper.map(findPloByIdOrThrowNotFound(ploId), ProgramLearningOutcomeDto::class.java)
        val averageScore =
            assignmentRepository
                .findByAssessmentAssessmentCloesCourseLearningOutcomePloCloesProgramLearningOutcomeId(ploId)
                .map { it.score!! }.average()

        return LoScoreDto(plo, averageScore)
    }

    @Transactional
    fun findCoursePloAverageScore(courseId: Int): List<LoScoreDto<ProgramLearningOutcomeDto>> {
        val plos = programLearningOutcomeRepository.findByPloCloesCourseLearningOutcomeCourseId(courseId)

        val listOfLoScoreDto = mutableListOf<LoScoreDto<ProgramLearningOutcomeDto>>()
        for (plo in plos) {
            val ploDto = mapper.map(plo, ProgramLearningOutcomeDto::class.java)
            val averageScore =
                assignmentRepository
                    .findByAssessmentAssessmentCloesCourseLearningOutcomePloCloesProgramLearningOutcomeId(plo.id!!)
                    .map { it.score!! }.average()

            listOfLoScoreDto.add(LoScoreDto(ploDto, averageScore))
        }

        return listOfLoScoreDto
    }

    //
    // CLO

    fun createClo(cloDto: CourseLearningOutcomeDto): CourseLearningOutcomeDto {
        cloDto.id = null
        return cloDtoSaveAndMap(cloDto)
    }

    fun updateClo(cloDto: CourseLearningOutcomeDto): CourseLearningOutcomeDto {
        return cloDtoSaveAndMap(cloDto)
    }

    fun findClo(cloId: Int): CourseLearningOutcomeDto {
        val clo = findCloByIdOrThrowNotFound(cloId)
        return mapper.map(clo, CourseLearningOutcomeDto::class.java)
    }

    fun deleteClo(cloId: Int) {
        courseLearningOutcomeRepository.deleteById(cloId)
    }

    fun findCloAverageScore(cloId: Int): LoScoreDto<CourseLearningOutcomeDto> {
        val clo = mapper.map(findCloByIdOrThrowNotFound(cloId), CourseLearningOutcomeDto::class.java)
        val averageScore =
            assignmentRepository
                .findByAssessmentAssessmentCloesCourseLearningOutcomeId(cloId)
                .map { it.score!! }.average()

        return LoScoreDto(clo, averageScore)
    }

    fun findCourseCloAverageScore(courseId: Int): List<LoScoreDto<CourseLearningOutcomeDto>> {
        val clos = courseLearningOutcomeRepository.findByCourseId(courseId)

        val listOfLoScoreDto = mutableListOf<LoScoreDto<CourseLearningOutcomeDto>>()
        for (clo in clos) {
            val cloDto = mapper.map(clo, CourseLearningOutcomeDto::class.java)
            val averageScore =
                assignmentRepository
                    .findByAssessmentAssessmentCloesCourseLearningOutcomeId(clo.id!!)
                    .map { it.score!! }.average()

            listOfLoScoreDto.add(LoScoreDto(cloDto, averageScore))
        }

        return listOfLoScoreDto
    }

    //
    // PLO CLO

    fun createPloClo(ploCloDto: PloCloDto): PloCloDto {
        ploCloDto.id = null
        return ploCLoSaveAndMap(ploCloDto)
    }

    fun updatePloClo(ploCloDto: PloCloDto): PloCloDto {
        return ploCLoSaveAndMap(ploCloDto)
    }

    fun findPloClo(ploCloId: Int): PloCloDto {
        val ploClo = ploCloRepository.findById(ploCloId).orElseThrow { NotFoundException("PloClo not found") }
        return mapper.map(ploClo, PloCloDto::class.java)
    }

    fun deletePloClo(ploCloId: Int) {
        ploCloRepository.deleteById(ploCloId)
    }

    fun findCoursePloClo(courseId: Int) {
        val ploCloes = ploCloRepository.findByCourseLearningOutcomeCourseId(courseId)

    }

    //
    // ASSESSMENT CLO

    fun createAssessmentClo(assessmentCloDto: AssessmentCloDto): AssessmentCloDto {
        assessmentCloDto.id = null
        return assessmentCloDtoSaveAndMap(assessmentCloDto)
    }

    fun updateAssessmentClo(assessmentCloDto: AssessmentCloDto): AssessmentCloDto {
        return assessmentCloDtoSaveAndMap(assessmentCloDto)
    }

    fun findAssessmentClo(assessmentCLoId: Int): AssessmentCloDto {
        val assessmentClo = assessmentCloRepository.findById(assessmentCLoId)
            .orElseThrow { NotFoundException("Assessment clo not found") }
        return mapper.map(assessmentClo, AssessmentCloDto::class.java)
    }

    fun deleteAssessmentClo(assessmentCLoId: Int) {
        assessmentCloRepository.deleteById(assessmentCLoId)
    }

    //
    // PRIVATE FUNCTION

    private fun ploDtoSaveAndMap(ploDto: ProgramLearningOutcomeDto): ProgramLearningOutcomeDto {
        val plo = mapper.map(ploDto, ProgramLearningOutcome::class.java)
        return mapper.map(programLearningOutcomeRepository.save(plo), ProgramLearningOutcomeDto::class.java)
    }

    private fun cloDtoSaveAndMap(cloDto: CourseLearningOutcomeDto): CourseLearningOutcomeDto {
        val clo = mapper.map(cloDto, CourseLearningOutcome::class.java)
        return mapper.map(courseLearningOutcomeRepository.save(clo), CourseLearningOutcomeDto::class.java)
    }

    private fun ploCLoSaveAndMap(ploCloDto: PloCloDto): PloCloDto {
        val ploCLo = mapper.map(ploCloDto, PloClo::class.java)
        return mapper.map(ploCLo, PloCloDto::class.java)
    }

    private fun assessmentCloDtoSaveAndMap(assessmentCloDto: AssessmentCloDto): AssessmentCloDto {
        val assessmentClo = mapper.map(assessmentCloDto, AssessmentClo::class.java)
        return mapper.map(assessmentCloRepository.save(assessmentClo), AssessmentCloDto::class.java)
    }

    //

    private fun findPloByIdOrThrowNotFound(ploId: Int): ProgramLearningOutcome {
        return programLearningOutcomeRepository.findById(ploId).orElseThrow { NotFoundException("Plo not found") }
    }

    private fun findCloByIdOrThrowNotFound(cloId: Int): CourseLearningOutcome {
        return courseLearningOutcomeRepository.findById(cloId).orElseThrow { NotFoundException("CLo not found") }
    }

}
