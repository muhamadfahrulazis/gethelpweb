// Edit and View Data
$(document).ready(function(){
    $('.table .vBtn').on('click', function(event){
            event.preventDefault();
            var href = $(this).attr('href');
            $.get(href, function(verifikasi, status){
                $('.verifikasi #id').val(verifikasi.id_calonmitra).hide();
                $('.verifikasi #FullName').val(verifikasi.namaCalonMitra);
                $('.verifikasi #NikKtp').val(verifikasi.nikKtpCalonMitra);
                $('.verifikasi #PhoneNumber').val(verifikasi.noHpCalonMitra);
                $('.verifikasi #Email').val(verifikasi.emailCalonMitra);
                $('.verifikasi #EName').val(verifikasi.namaKontakDaruratCalonMitra);
                $('.verifikasi #EPhoneNumber').val(verifikasi.noHpKontakDaruratCalonMitra);
                $('.verifikasi #ERelationship').val(verifikasi.hubKontakDaruratCalonMitra);
                document.getElementById('imageKtpEdit').src = "/file_registrant/ktp/" + verifikasi.id_calonmitra + "/" + verifikasi.namaFileKtpCalonMitra;
                document.getElementById('imageSelfieKtpEdit').src = "/file_registrant/selfie_ktp/" + verifikasi.id_calonmitra + "/"  + verifikasi.namaFileSelfiektpCalonMitra;
            });
            $('.verifikasi #verifikasiModal').modal();

        });
});

function showDiv(element){
    document.getElementById('failed_div').style.display = element.value == 21 ? 'block' : 'none';
    document.getElementById('reasonFailed').required = element.value == 21 ? true : false;
}