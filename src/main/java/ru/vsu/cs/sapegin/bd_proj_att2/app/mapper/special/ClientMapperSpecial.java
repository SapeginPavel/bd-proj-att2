package ru.vsu.cs.sapegin.bd_proj_att2.app.mapper.special;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import ru.vsu.cs.sapegin.bd_proj_att2.api.model.ClientDto;
import ru.vsu.cs.sapegin.bd_proj_att2.api.model.special.ClientDtoServicesAsId;
import ru.vsu.cs.sapegin.bd_proj_att2.app.mapper.ClientMapper;
import ru.vsu.cs.sapegin.bd_proj_att2.item.model.ClientItem;
import ru.vsu.cs.sapegin.bd_proj_att2.item.model.ServiceItem;

import java.util.List;

@Mapper
public interface ClientMapperSpecial {
    ClientMapperSpecial INSTANCE = Mappers.getMapper(ClientMapperSpecial.class);

    @Mapping(target = "services", source = "services", qualifiedByName = "mapToIdsList")
    ClientDtoServicesAsId mapToDto(ClientItem item);

    List<ClientDto> mapToDtos(List<ClientItem> items);

    @Named("mapToIdsList")
    static List<Integer> mapToIdsList(List<ServiceItem> services) {
        System.out.println("пытаемся мапить кастомно");
        return services.stream().map(ServiceItem::getService_id).toList();
    }
}
