package id.ac.polinema.lumajang.portalku.dosen;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface DosenRepository extends JpaRepository<Dosen, Integer> {
    Optional<Dosen> findByNip(String nip);
}