package id.taufiq.lomanagementapp.config

import org.modelmapper.ModelMapper
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component

@Component
class BeanComponent {

    @Bean
    fun modelMapper(): ModelMapper? {
        return ModelMapper()
    }

}
