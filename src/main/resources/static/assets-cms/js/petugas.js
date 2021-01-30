// Edit and View Data
$(document).ready(function(){
    $('.table .vBtn').on('click', function(event){
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function(petugas, status){
            $('.infoPetugasForm #nip').val(petugas.nip);
            $('.infoPetugasForm #nama').val(petugas.nama);
            $('.infoPetugasForm #jenisKelamin').val(petugas.jenisKelamin);
            $('.infoPetugasForm #noHp').val(petugas.noHp);
            $('.infoPetugasForm #email').val(petugas.email);
            $('.infoPetugasForm #jabatan').val(petugas.jabatan);
            $('.infoPetugasForm #status').val(petugas.statusPetugas);
        });

        $('.infoPetugasForm #infoModal').modal();
    });

    $('.table .eBtn').on('click', function(event){
            event.preventDefault();
            var href = $(this).attr('href');
            $.get(href, function(petugas, status){
                $('.editPetugasForm #editNip').val(petugas.nip);
                $('.editPetugasForm #editNama').val(petugas.nama);
                $('.editPetugasForm #editJenisKelamin').val(petugas.jenisKelamin);
                $('.editPetugasForm #editNoHp').val(petugas.noHp);
                $('.editPetugasForm #editEmail').val(petugas.email);
                $('.editPetugasForm #editJabatan').val(petugas.jabatan);
                $('.editPetugasForm #editStatus').val(petugas.statusPetugas);
            });
            $('.editPetugasForm #editModal').modal();
    });

    $('.rBtn').click(function(event){
            event.preventDefault();
            var href = $(this).attr('href');
            $(".myRemove .dBtn").attr('href',href);
            $('.myRemove #removeModal').modal();
    });
});