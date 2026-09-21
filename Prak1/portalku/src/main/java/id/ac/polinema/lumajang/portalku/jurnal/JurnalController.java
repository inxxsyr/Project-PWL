package id.ac.polinema.lumajang.portalku.jurnal;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class JurnalController {

    private final JurnalRepository jurnalRepository;

    @GetMapping("/jurnal")
    public List<Jurnal> getAllJurnal() {
        return jurnalRepository.findAll();
    }
}