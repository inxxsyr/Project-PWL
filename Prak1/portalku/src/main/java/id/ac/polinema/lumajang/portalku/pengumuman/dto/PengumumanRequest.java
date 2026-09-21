package id.ac.polinema.lumajang.portalku.pengumuman.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public record PengumumanRequest(
        @Schema(description = "Judul pengumuman, harus unik", example = "Jadwal UTS Semester Genap")
        @NotBlank(message = "Judul wajib diisi")
        @Size(max = 150, message = "Judul maksimal 150 karakter")
        String judul,

        @NotBlank(message = "Isi wajib diisi")
        String isi,

        @NotNull(message = "Tanggal terbit wajib diisi")
        LocalDate tanggalTerbit,

        @Schema(description = "Nomor kategori", example = "1")
        @NotNull(message = "Kategori wajib dipilih")
        Integer idKategori
) {}