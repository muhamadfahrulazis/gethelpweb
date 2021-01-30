// Edit and View Data
$(document).ready(function(){
    $('.table .vBtn').on('click', function(event){
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function(keahlian, status){
            $('.infoKeahlianForm #kodeKeahlian').val(keahlian.kodeKeahlian);
            $('.infoKeahlianForm #namaKeahlian').val(keahlian.namaKeahlian);
            $('.infoKeahlianForm #deskripsiKeahlian').val(keahlian.deskripsiKeahlian);
        });

        $('.infoKeahlianForm #infoModal').modal();
    });

    $('.table .eBtn').on('click', function(event){
            event.preventDefault();
            var href = $(this).attr('href');
            $.get(href, function(keahlian, status){
                $('.editKeahlianForm #editIdKeahlian').val(keahlian.id_keahlian).hide();
                $('.editKeahlianForm #editKodeKeahlian').val(keahlian.kodeKeahlian);
                $('.editKeahlianForm #editNamaKeahlian').val(keahlian.namaKeahlian);
                $('.editKeahlianForm #editDeskripsiKeahlian').val(keahlian.deskripsiKeahlian);
            });
            $('.editKeahlianForm #editModal').modal();
    });

    $('.rBtn').click(function(event){
            event.preventDefault();
            var href = $(this).attr('href');
            $(".myRemove .dBtn").attr('href',href);
            $('.myRemove #removeModal').modal();
    });
});