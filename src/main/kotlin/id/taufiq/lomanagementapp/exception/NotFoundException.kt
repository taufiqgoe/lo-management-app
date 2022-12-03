package id.taufiq.lomanagementapp.exception

class NotFoundException(override val message: String = "Not found") : Exception(message) {
}
