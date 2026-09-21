package id.ac.polinema.lumajang.portalku.matakuliah;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MataKuliahRepository extends JpaRepository<MataKuliah, Integer> {
    List<MataKuliah> findByKurikulumId(Integer idKurikulum);
}