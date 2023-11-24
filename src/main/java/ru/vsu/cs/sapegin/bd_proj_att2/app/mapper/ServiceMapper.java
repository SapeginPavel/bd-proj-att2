package ru.vsu.cs.sapegin.bd_proj_att2.app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.vsu.cs.sapegin.bd_proj_att2.api.model.ClientDto;
import ru.vsu.cs.sapegin.bd_proj_att2.api.model.ServiceDto;
import ru.vsu.cs.sapegin.bd_proj_att2.item.model.ClientItem;
import ru.vsu.cs.sapegin.bd_proj_att2.item.model.ServiceItem;

import java.util.List;

@Mapper
public interface ServiceMapper {
    ServiceMapper INSTANCE = Mappers.getMapper(ServiceMapper.class);

    ServiceDto mapToDto(ServiceItem item);
    List<ServiceDto> mapToDtos(List<ServiceItem> items);
    ServiceItem mapToItem(ServiceDto dto);
    List<ServiceItem> mapToItems(List<ServiceDto> dtos);
}
