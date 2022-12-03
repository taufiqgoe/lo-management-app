package id.taufiq.lomanagementapp.controller

import id.taufiq.lomanagementapp.dto.lo.AssessmentCloDto
import id.taufiq.lomanagementapp.dto.lo.CourseLearningOutcomeDto
import id.taufiq.lomanagementapp.dto.lo.PloCloDto
import id.taufiq.lomanagementapp.dto.lo.ProgramLearningOutcomeDto
import id.taufiq.lomanagementapp.dto.op.LoScoreDto
import id.taufiq.lomanagementapp.service.LoService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/learning-outcomes")
class LoController(
    private val service: LoService
) {

    @PostMapping("plo")
    fun createPlo(@RequestBody ploDto: ProgramLearningOutcomeDto): ProgramLearningOutcomeDto {
        return service.createPlo(ploDto)
    }

    @PutMapping("plo")
    fun updatePlo(@RequestBody ploDto: ProgramLearningOutcomeDto): ProgramLearningOutcomeDto {
        return service.updatePlo(ploDto)
    }

    @GetMapping("plo/{ploId}")
    fun findPlo(@PathVariable ploId: Int): ProgramLearningOutcomeDto {
        return service.findPlo(ploId)
    }

    @DeleteMapping("plo/{ploId}")
    fun deletePlo(@PathVariable ploId: Int) {
        service.deletePlo(ploId)
    }

    @GetMapping("plo/average-score")
    fun findPloAverageScore(ploId: Int): LoScoreDto<ProgramLearningOutcomeDto> {
        return service.findPloAverageScore(ploId)
    }

    @GetMapping("plo/course-average-score")
    fun findCoursePloAverageScore(courseId: Int): List<LoScoreDto<ProgramLearningOutcomeDto>> {
        return service.findCoursePloAverageScore(courseId)
    }

    @PostMapping("clo")
    fun createClo(@RequestBody cloDto: CourseLearningOutcomeDto): CourseLearningOutcomeDto {
        return service.createClo(cloDto)
    }

    @PutMapping("clo")
    fun updateClo(@RequestBody cloDto: CourseLearningOutcomeDto): CourseLearningOutcomeDto {
        return service.updateClo(cloDto)
    }

    @GetMapping("clo/{cloId}")
    fun findClo(@PathVariable cloId: Int): CourseLearningOutcomeDto {
        return service.findClo(cloId)
    }

    @DeleteMapping("clo/{cloId}")
    fun deleteClo(@PathVariable cloId: Int) {
        return service.deleteClo(cloId)
    }

    @GetMapping("clo/average-score")
    fun findCloAverageScore(cloId: Int): LoScoreDto<CourseLearningOutcomeDto> {
        return service.findCloAverageScore(cloId)
    }

    @GetMapping("clo/course-average-score")
    fun findCourseCloAverageScore(courseId: Int): List<LoScoreDto<CourseLearningOutcomeDto>> {
        return service.findCourseCloAverageScore(courseId)
    }

    @PostMapping("plo-clo")
    fun createPloClo(@RequestBody ploCloDto: PloCloDto): PloCloDto {
        return service.createPloClo(ploCloDto)
    }

    @PutMapping("plo-clo")
    fun updatePloClo(@RequestBody ploCloDto: PloCloDto): PloCloDto {
        return service.updatePloClo(ploCloDto)
    }

    @GetMapping("plo-clo/{ploCloId}")
    fun findPloClo(@PathVariable ploCloId: Int): PloCloDto {
        return service.findPloClo(ploCloId)
    }

    @DeleteMapping("plo-clo/{ploCloId}")
    fun deletePloClo(@PathVariable ploCloId: Int) {
        service.deletePloClo(ploCloId)
    }

    @DeleteMapping("plo-clo/all/by-course/{courseId}")
    fun findAllPloCloByCourseId(@PathVariable courseId: Int): List<PloCloDto> {
        return service.findAllPloCloByCourseId(courseId)
    }

    @PostMapping("assessment-clo")
    fun createAssessmentClo(@RequestBody assessmentCloDto: AssessmentCloDto): AssessmentCloDto {
        return service.createAssessmentClo(assessmentCloDto)
    }

    @PutMapping("assessment-clo")
    fun updateAssessmentClo(@RequestBody assessmentCloDto: AssessmentCloDto): AssessmentCloDto {
        return service.updateAssessmentClo(assessmentCloDto)
    }

    @GetMapping("assessment-clo/{assessmentCLoId}")
    fun findAssessmentClo(@PathVariable assessmentCLoId: Int): AssessmentCloDto {
        return service.findAssessmentClo(assessmentCLoId)
    }

    @DeleteMapping("assessment-clo/{assessmentCLoId}")
    fun deleteAssessmentClo(@PathVariable assessmentCLoId: Int) {
        service.deleteAssessmentClo(assessmentCLoId)
    }

}
