package id.ac.polinema.lumajang.portalku.prodi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ProdiRepository extends JpaRepository<Prodi, Integer> {
    Optional<Prodi> findByKode(String kode);
}