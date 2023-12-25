package ru.vsu.cs.sapegin.bd_proj_att2.app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import ru.vsu.cs.sapegin.bd_proj_att2.api.model.ClientDto;
import ru.vsu.cs.sapegin.bd_proj_att2.api.model.special.ServiceDtoForSingleClient;
import ru.vsu.cs.sapegin.bd_proj_att2.item.model.ClientItem;
import ru.vsu.cs.sapegin.bd_proj_att2.item.model.ServiceItem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Mapper
public interface ClientMapper {
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    @Mapping(target = "serviceDtoForSingleClients", source = "services", qualifiedByName = "mapToCustomList")
    @Mapping(ignore = true, target = "services")
    @Mapping(target = "client_id", source = "clientId")
    ClientDto mapToDto(ClientItem item);

    @Named("mapToCustomList")
    static List<ServiceDtoForSingleClient> mapToCustomDtoList(List<ServiceItem> services) {
        if (services == null) {
            return null;
        }
        services.sort(new Comparator<ServiceItem>() {
            @Override
            public int compare(ServiceItem o1, ServiceItem o2) {
                return o1.getService_id() - o2.getService_id();
            }
        });
        List<ServiceDtoForSingleClient> customServices = new ArrayList<>();
        for (ServiceItem s : services) {
            customServices.add(new ServiceDtoForSingleClient(
                    s.getService_id(), s.getStartDate(), s.getEndDate(), s.getCar().getCar_id()
            ));
        }
        return customServices;
    }

    @Mapping(ignore = true, target = "services")
    @Mapping(target = "client_id", source = "clientId")
    List<ClientDto> mapToDtos(List<ClientItem> items);

    @Mapping(target = "clientId", source = "client_id")
    ClientItem mapToItem(ClientDto dto);

    @Mapping(target = "clientId", source = "client_id")
    List<ClientItem> mapToItems(List<ClientDto> dtos);

}
