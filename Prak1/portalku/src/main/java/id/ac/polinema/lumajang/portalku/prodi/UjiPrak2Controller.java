package id.ac.polinema.lumajang.portalku.prodi;

import id.ac.polinema.lumajang.portalku.kurikulum.KurikulumRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/uji")
public class UjiPrak2Controller {

    private final KurikulumRepository kurikulumRepo;
    private final ProdiRepository prodiRepo;

    public UjiPrak2Controller(KurikulumRepository kurikulumRepo, ProdiRepository prodiRepo) {
        this.kurikulumRepo = kurikulumRepo;
        this.prodiRepo = prodiRepo;
    }

    // 1. N+1 Problem (Biasa)
    @GetMapping("/kurikulum-biasa")
    @Transactional(readOnly = true)
    public List<String> getKurikulumBiasa() {
        return kurikulumRepo.findAll().stream()
                .map(k -> k.getKode() + " - " + k.getProdi().getNama())
                .toList();
    }

    // 2. Solusi N+1 (JOIN FETCH)
    @GetMapping("/kurikulum-fetch")
    public List<String> getKurikulumFetch() {
        return kurikulumRepo.findAllWithProdi().stream()
                .map(k -> k.getKode() + " - " + k.getProdi().getNama())
                .toList();
    }

    // 3. Solusi DTO Ringkas (Pake @Transactional biar gak error LazyInitializationException)
    @GetMapping("/prodi-ringkas")
    @Transactional(readOnly = true)
    public List<ProdiRingkasDto> getProdiRingkas() {
        return prodiRepo.findAll().stream()
                .map(p -> new ProdiRingkasDto(
                        p.getId(),
                        p.getKode(),
                        p.getNama(),
                        p.getJenjang().name(),
                        p.getDaftarKurikulum().size()
                ))
                .toList();
    }
}