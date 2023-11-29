package ru.vsu.cs.sapegin.bd_proj_att2.item.repository;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.vsu.cs.sapegin.bd_proj_att2.item.model.ClientItem;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<ClientItem, Integer>, JpaSpecificationExecutor<ClientItem> {
//    @Query(nativeQuery) hql //самая популярная машина //сколько в среднем идёт аренда //график по дням //добавить столбец с возрастом и по неу статистику
//    List<ClientItem> findAllBy
}
