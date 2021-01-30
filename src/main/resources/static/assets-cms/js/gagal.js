// Edit and View Data
$(document).ready(function(){
    $('.table .vBtn').on('click', function(event){
            event.preventDefault();
            var href = $(this).attr('href');
            $.get(href, function(gagal, status){
                            $('.gagal #Service').val(gagal.calonMitra.layananCalonMitra);
                            $('.gagal #FullName').val(gagal.calonMitra.namaCalonMitra);
                            $('.gagal #NikKtp').val(gagal.calonMitra.nikKtpCalonMitra);
                            $('.gagal #Gender').val(gagal.calonMitra.jenisKelaminCalonMitra);
                            $('.gagal #PhoneNumber').val(gagal.calonMitra.noHpCalonMitra);
                            $('.gagal #Email').val(gagal.calonMitra.emailCalonMitra);
                            $('.gagal #Address').val(gagal.calonMitra.domisiliCalonMitra);
                            $('.gagal #Prov').val(gagal.calonMitra.provinsiCalonMitra);
                            $('.gagal #Kab').append(new Option(gagal.calonMitra.kabupatenCalonMitra, gagal.calonMitra.kabupatenCalonMitra));
                            $('.gagal #Kab').val(gagal.calonMitra.kabupatenCalonMitra);
                            $('.gagal #Kec').append(new Option(gagal.calonMitra.kecamatanCalonMitra, gagal.calonMitra.kecamatanCalonMitra));
                            $('.gagal #Kec').val(gagal.calonMitra.kecamatanCalonMitra);
                            $('.gagal #Kel').append(new Option(gagal.calonMitra.kelurahanCalonMitra, gagal.calonMitra.kelurahanCalonMitra));
                            $('.gagal #Kel').val(gagal.calonMitra.kelurahanCalonMitra);
                            $('.gagal #WorkingExp').val(gagal.calonMitra.pengalamanKerjaCalonMitra);
                            $('.gagal #CurrentJob').val(gagal.calonMitra.pekerjaanSaatIniCalonMitra);
                            $('.gagal #EName').val(gagal.calonMitra.namaKontakDaruratCalonMitra);
                            $('.gagal #EPhoneNumber').val(gagal.calonMitra.noHpKontakDaruratCalonMitra);
                            $('.gagal #ERelationship').val(gagal.calonMitra.hubKontakDaruratCalonMitra);
                            document.getElementById('imageKtp').src = "/file_registrant/ktp/" + gagal.calonMitra.id_calonmitra + "/" + gagal.calonMitra.namaFileKtpCalonMitra;
                            document.getElementById('imageSelfieKtp').src ="/file_registrant/selfie_ktp/" + gagal.calonMitra.id_calonmitra + "/"  + gagal.calonMitra.namaFileSelfiektpCalonMitra;
                            $('.gagal #statusVerifikasi').val(gagal.kode_proses);
                            $('.gagal #reasonFailed').val(gagal.alasanGagal);
                        });
                        $('.gagal #gagalModal').modal();

        });
});