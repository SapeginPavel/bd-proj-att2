package ru.vsu.cs.sapegin.bd_proj_att2.app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import ru.vsu.cs.sapegin.bd_proj_att2.api.model.ClientDto;
import ru.vsu.cs.sapegin.bd_proj_att2.item.model.ClientItem;
import ru.vsu.cs.sapegin.bd_proj_att2.item.model.ServiceItem;

import java.util.List;

@Mapper
public interface ClientMapper {
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    @Mapping(target = "services_id", source = "services", qualifiedByName = "mapToIdList")
    @Mapping(ignore = true, target = "services")
    ClientDto mapToDto(ClientItem item);

    @Named("mapToIdList")
    static List<Integer> mapToIdList(List<ServiceItem> services) {
//        System.out.println("пытаемся мапить кастомно");
        return services.stream().map(ServiceItem::getService_id).toList();
    }

    @Mapping(ignore = true, target = "services")

    List<ClientDto> mapToDtos(List<ClientItem> items);

    ClientItem mapToItem(ClientDto dto);
    List<ClientItem> mapToItems(List<ClientDto> dtos);

}
