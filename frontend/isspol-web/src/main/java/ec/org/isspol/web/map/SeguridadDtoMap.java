package ec.org.isspol.web.map;

import ec.org.isspol.persistence.entities.security.Grupo;
import ec.org.isspol.web.dto.seguridad.GrupoDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


/**
 * Created by santiago.yacelga on 5/5/2017.
 */
@Mapper
public interface SeguridadDtoMap {
    SeguridadDtoMap INSTANCE = Mappers.getMapper( SeguridadDtoMap.class );

    GrupoDto grupoToGrupoDto(Grupo grupo);

    Grupo grupoDtoToGrupo(GrupoDto grupoDto);
}
