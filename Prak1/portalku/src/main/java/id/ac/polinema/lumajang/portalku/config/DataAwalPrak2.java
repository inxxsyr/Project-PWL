package id.ac.polinema.lumajang.portalku.config;

import id.ac.polinema.lumajang.portalku.kurikulum.Kurikulum;
import id.ac.polinema.lumajang.portalku.prodi.Prodi;
import id.ac.polinema.lumajang.portalku.prodi.ProdiRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataAwalPrak2 {

    @Bean
    CommandLineRunner initDataPrak2(ProdiRepository prodiRepo) {
        return args -> {
            if (prodiRepo.count() == 0) {
                // Prodi 1: D3 TI
                Prodi prodi1 = new Prodi();
                prodi1.setKode("TI");
                prodi1.setNama("Teknologi Informasi");
                prodi1.setJenjang(Prodi.Jenjang.D3);

                Kurikulum k1 = new Kurikulum();
                k1.setKode("KUR-TI-2023");
                k1.setTahunBerlaku(2023);
                k1.setStatus(Kurikulum.Status.AKTIF);

                Kurikulum k2 = new Kurikulum();
                k2.setKode("KUR-TI-2020");
                k2.setTahunBerlaku(2020);
                k2.setStatus(Kurikulum.Status.NONAKTIF);

                prodi1.tambahKurikulum(k1);
                prodi1.tambahKurikulum(k2);
                prodiRepo.save(prodi1);

                // Prodi 2: D4 SIB
                Prodi prodi2 = new Prodi();
                prodi2.setKode("SIB");
                prodi2.setNama("Sistem Informasi Bisnis");
                prodi2.setJenjang(Prodi.Jenjang.D4);

                Kurikulum k3 = new Kurikulum();
                k3.setKode("KUR-SIB-2024");
                k3.setTahunBerlaku(2024);
                k3.setStatus(Kurikulum.Status.AKTIF);

                prodi2.tambahKurikulum(k3);
                prodiRepo.save(prodi2);
            }
        };
    }
}