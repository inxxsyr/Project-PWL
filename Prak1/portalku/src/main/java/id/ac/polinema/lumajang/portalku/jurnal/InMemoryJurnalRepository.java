package id.ac.polinema.lumajang.portalku.jurnal;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryJurnalRepository {
    
    private final List<Jurnal> listJurnal = new ArrayList<>();

    public List<Jurnal> findAll() {
        return listJurnal;
    }
}