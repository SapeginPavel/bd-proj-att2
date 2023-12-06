package ru.vsu.cs.sapegin.bd_proj_att2.app.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import ru.vsu.cs.sapegin.bd_proj_att2.item.model.ServiceItem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ServicesSerializer extends StdSerializer<List<ServiceItem>> {

    protected ServicesSerializer(Class<List<ServiceItem>> t) {
        super(t);
    }

    @Override
    public void serialize(List<ServiceItem> serviceItems, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
//        List<ServiceDtoForClient> dtos = new ArrayList<>();
        System.out.println("ЗАХОДИМ");
//        for (ServiceItem item : serviceItems) {
//            dtos.add(new ServiceDtoForClient(
//                    item.getService_id(),
//                    item.getStartDate(),
//                    item.getEndDate(),
//                    item.getCar().getCar_id()
//            ));
//        }
        List<Integer> ids = new ArrayList<>();
        for (ServiceItem item : serviceItems) {
            ids.add(item.getService_id());
        }
        jsonGenerator.writeObject(ids);
//        jsonGenerator.writeObject(dtos);
    }
}
