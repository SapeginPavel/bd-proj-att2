package ru.vsu.cs.sapegin.bd_proj_att2.app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.vsu.cs.sapegin.bd_proj_att2.api.model.ClientDto;
import ru.vsu.cs.sapegin.bd_proj_att2.item.model.ClientItem;

import java.util.List;

@Mapper
public interface ClientMapper {
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    ClientDto mapToDto(ClientItem item);
    List<ClientDto> mapToDtos(List<ClientItem> items);
    ClientItem mapToItem(ClientDto dto);
    List<ClientItem> mapToItems(List<ClientDto> dtos);

    //List<Target> sourceListToTargetList(List<Source> sourceList);
}
