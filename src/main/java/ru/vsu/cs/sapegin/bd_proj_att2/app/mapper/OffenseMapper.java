package ru.vsu.cs.sapegin.bd_proj_att2.app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.vsu.cs.sapegin.bd_proj_att2.api.model.OffenseDto;
import ru.vsu.cs.sapegin.bd_proj_att2.item.model.OffenseItem;

import java.util.List;

@Mapper
public interface OffenseMapper {
    OffenseMapper INSTANCE = Mappers.getMapper(OffenseMapper.class);

    OffenseDto mapToDto(OffenseItem item);
    List<OffenseDto> mapToDtos(List<OffenseItem> items);
    OffenseItem mapToItem(OffenseDto dto);
    List<OffenseItem> mapToItems(List<OffenseDto> dtos);
}
