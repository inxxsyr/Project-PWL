package id.ac.polinema.lumajang.portalku.pengumuman;

import id.ac.polinema.lumajang.portalku.kategori.Kategori;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Table(name = "pengumuman")
@Getter @Setter
public class Pengumuman {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String judul;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String isi;

    @Column(name = "tanggal_terbit", nullable = false)
    private LocalDate tanggalTerbit;

    @Column(name = "jumlah_dilihat", nullable = false)
    private Integer jumlahDilihat = 0;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kategori_id", nullable = false)
    private Kategori kategori;
}