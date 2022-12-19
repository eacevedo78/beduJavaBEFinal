package org.bedu.api.servidores.mapper;

import org.bedu.api.servidores.dto.ApplicationDTO;
import org.bedu.api.servidores.entity.Application;
import org.mapstruct.Mapper;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;


@Mapper(componentModel="spring", injectionStrategy=InjectionStrategy.CONSTRUCTOR)
        //nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ApplicationMapper {
    ApplicationDTO toDTO(Application data);
    Application toEntity(ApplicationDTO data);
    //Application updateApplicationFromDto(ApplicationDTO dto, @MappingTarget Application application);
}
