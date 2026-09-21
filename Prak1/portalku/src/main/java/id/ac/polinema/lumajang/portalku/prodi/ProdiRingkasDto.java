package id.ac.polinema.lumajang.portalku.prodi;

public record ProdiRingkasDto(
    Integer id,
    String kode,
    String nama,
    String jenjang,
    int jumlahKurikulum
) {}