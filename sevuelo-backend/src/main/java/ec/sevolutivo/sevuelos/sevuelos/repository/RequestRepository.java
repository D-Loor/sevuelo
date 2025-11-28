package ec.sevolutivo.sevuelos.sevuelos.repository;

import ec.sevolutivo.sevuelos.sevuelos.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@SuppressWarnings("unused")
@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {

    List<Request> findAllByDestination(String destination);

}
