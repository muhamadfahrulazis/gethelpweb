// Edit and View Data
$(document).ready(function(){
    $('.table .vBtn').on('click', function(event){
            event.preventDefault();
            var href = $(this).attr('href');
            $.get(href, function(mitraAktif, status){
                            $('.mitraAktif #Service').val(mitraAktif.calonMitra.layananCalonMitra);
                            $('.mitraAktif #FullName').val(mitraAktif.calonMitra.namaCalonMitra);
                            $('.mitraAktif #NikKtp').val(mitraAktif.calonMitra.nikKtpCalonMitra);
                            $('.mitraAktif #Gender').val(mitraAktif.calonMitra.jenisKelaminCalonMitra);
                            $('.mitraAktif #PhoneNumber').val(mitraAktif.calonMitra.noHpCalonMitra);
                            $('.mitraAktif #Email').val(mitraAktif.calonMitra.emailCalonMitra);
                            $('.mitraAktif #Address').val(mitraAktif.calonMitra.domisiliCalonMitra);
                            $('.mitraAktif #Prov').val(mitraAktif.calonMitra.provinsiCalonMitra);
                            $('.mitraAktif #Kab').append(new Option(mitraAktif.calonMitra.kabupatenCalonMitra, mitraAktif.calonMitra.kabupatenCalonMitra));
                            $('.mitraAktif #Kab').val(mitraAktif.calonMitra.kabupatenCalonMitra);
                            $('.mitraAktif #Kec').append(new Option(mitraAktif.calonMitra.kecamatanCalonMitra, mitraAktif.calonMitra.kecamatanCalonMitra));
                            $('.mitraAktif #Kec').val(mitraAktif.calonMitra.kecamatanCalonMitra);
                            $('.mitraAktif #Kel').append(new Option(mitraAktif.calonMitra.kelurahanCalonMitra, mitraAktif.calonMitra.kelurahanCalonMitra));
                            $('.mitraAktif #Kel').val(mitraAktif.calonMitra.kelurahanCalonMitra);
                            $('.mitraAktif #WorkingExp').val(mitraAktif.calonMitra.pengalamanKerjaCalonMitra);
                            $('.mitraAktif #CurrentJob').val(mitraAktif.calonMitra.pekerjaanSaatIniCalonMitra);
                            $('.mitraAktif #EName').val(mitraAktif.calonMitra.namaKontakDaruratCalonMitra);
                            $('.mitraAktif #EPhoneNumber').val(mitraAktif.calonMitra.noHpKontakDaruratCalonMitra);
                            $('.mitraAktif #ERelationship').val(mitraAktif.calonMitra.hubKontakDaruratCalonMitra);
                            document.getElementById('imageKtp').src = "/file_registrant/ktp/" + mitraAktif.calonMitra.id_calonmitra + "/" + mitraAktif.calonMitra.namaFileKtpCalonMitra;
                            document.getElementById('imageSelfieKtp').src ="/file_registrant/selfie_ktp/" + mitraAktif.calonMitra.id_calonmitra + "/"  + mitraAktif.calonMitra.namaFileSelfiektpCalonMitra;
                            $('.mitraAktif #statusVerifikasi').val(mitraAktif.kode_proses);
                            $('.mitraAktif #reasonFailed').val(mitraAktif.alasanGagal);
                        });
                        $('.mitraAktif #mitraAktifModal').modal();

        });
});