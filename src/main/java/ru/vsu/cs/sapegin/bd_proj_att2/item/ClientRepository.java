package ru.vsu.cs.sapegin.bd_proj_att2.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vsu.cs.sapegin.bd_proj_att2.item.model.ClientItem;

@Repository
public interface ClientRepository extends JpaRepository<ClientItem, Integer> {

}
