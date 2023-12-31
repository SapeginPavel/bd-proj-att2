package ru.vsu.cs.sapegin.bd_proj_att2.item.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ru.vsu.cs.sapegin.bd_proj_att2.item.model.ClientItem;
import ru.vsu.cs.sapegin.bd_proj_att2.item.model.ServiceItem;

@Repository
public interface ServiceRepository extends JpaRepository<ServiceItem, Integer>, JpaSpecificationExecutor<ServiceItem> {
}
