package id.ac.polinema.lumajang.portalku.pengumuman.dto;

import java.time.LocalDate;

public record PengumumanResponse(
        Integer id,
        String judul,
        String isi,
        String namaKategori,
        LocalDate tanggalTerbit,
        Integer jumlahDilihat
) {}