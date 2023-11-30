package ru.vsu.cs.sapegin.bd_proj_att2.item.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ru.vsu.cs.sapegin.bd_proj_att2.item.model.CarItem;

@Repository
public interface CarRepository extends JpaRepository<CarItem, Integer>, JpaSpecificationExecutor<CarItem> {
}
