package ru.vsu.cs.sapegin.bd_proj_att2.app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.vsu.cs.sapegin.bd_proj_att2.api.model.CarDto;
import ru.vsu.cs.sapegin.bd_proj_att2.item.model.CarItem;

import java.util.List;

@Mapper
public interface CarMapper {
    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    CarDto mapToDto(CarItem items);
    List<CarDto> mapToDtos(List<CarItem> items);
    CarItem mapToItem(CarDto dto);
    List<CarItem> mapToItems(List<CarDto> dtos);
}
