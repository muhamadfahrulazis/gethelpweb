// Edit and View Data
$(document).ready(function(){
    $('.table .vBtn').on('click', function(event){
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function(peralatan, status){
            $('.infoPeralatanForm #kodePeralatan').val(peralatan.kodePeralatan);
            $('.infoPeralatanForm #namaPeralatan').val(peralatan.namaPeralatan);
            $('.infoPeralatanForm #deskripsiPeralatan').val(peralatan.deskripsiPeralatan);
        });

        $('.infoPeralatanForm #infoModal').modal();
    });

    $('.table .eBtn').on('click', function(event){
            event.preventDefault();
            var href = $(this).attr('href');
            $.get(href, function(peralatan, status){
                $('.editPeralatanForm #editIdPeralatan').val(peralatan.id_peralatan).hide();
                $('.editPeralatanForm #editKodePeralatan').val(peralatan.kodePeralatan);
                $('.editPeralatanForm #editNamaPeralatan').val(peralatan.namaPeralatan);
                $('.editPeralatanForm #editDeskripsiPeralatan').val(peralatan.deskripsiPeralatan);
            });
            $('.editPeralatanForm #editModal').modal();
    });

    $('.rBtn').click(function(event){
            event.preventDefault();
            var href = $(this).attr('href');
            $(".myRemove .dBtn").attr('href',href);
            $('.myRemove #removeModal').modal();
    });
});