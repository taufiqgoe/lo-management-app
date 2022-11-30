package id.taufiq.lomanagementapp.controller

import id.taufiq.lomanagementapp.dto.lo.AssessmentCloDto
import id.taufiq.lomanagementapp.dto.lo.CourseLearningOutcomeDto
import id.taufiq.lomanagementapp.dto.lo.PloCloDto
import id.taufiq.lomanagementapp.dto.lo.ProgramLearningOutcomeDto
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
