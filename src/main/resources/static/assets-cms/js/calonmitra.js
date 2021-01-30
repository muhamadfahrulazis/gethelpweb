// Edit and View Data
$(document).ready(function(){
    $('.table .vBtn').on('click', function(event){
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function(calonmitra, status){
            $('.infoForm #validationService').val(calonmitra.layananCalonMitra);
            $('.infoForm #validationFullName').val(calonmitra.namaCalonMitra);
            $('.infoForm #validationNikKtp').val(calonmitra.nikKtpCalonMitra);
            $('.infoForm #validationGender').val(calonmitra.jenisKelaminCalonMitra);
            $('.infoForm #validationPhoneNumber').val(calonmitra.noHpCalonMitra);
            $('.infoForm #validationEmail').val(calonmitra.emailCalonMitra);
            $('.infoForm #validationAddress').val(calonmitra.domisiliCalonMitra);
            $('.infoForm #validationProv').val(calonmitra.provinsiCalonMitra);
            $('.infoForm #validationKab').val(calonmitra.kabupatenCalonMitra);
            $('.infoForm #validationKec').val(calonmitra.kecamatanCalonMitra);
            $('.infoForm #validationKel').val(calonmitra.kelurahanCalonMitra);
            $('.infoForm #validationWorkingExp').val(calonmitra.pengalamanKerjaCalonMitra);
            $('.infoForm #validationCurrentJob').val(calonmitra.pekerjaanSaatIniCalonMitra);
            $('.infoForm #validationEName').val(calonmitra.namaKontakDaruratCalonMitra);
            $('.infoForm #validationEPhoneNumber').val(calonmitra.noHpKontakDaruratCalonMitra);
            $('.infoForm #validationERelationship').val(calonmitra.hubKontakDaruratCalonMitra);
            document.getElementById('imageKtp').src = "/file_registrant/ktp/" + calonmitra.id_calonmitra + "/" + calonmitra.namaFileKtpCalonMitra;
            document.getElementById('imageSelfieKtp').src ="/file_registrant/selfie_ktp/" + calonmitra.id_calonmitra + "/"  + calonmitra.namaFileSelfiektpCalonMitra;
        });

        $('.infoForm #infoModal').modal();
    });

    $('.table .eBtn').on('click', function(event){
            event.preventDefault();
            var href = $(this).attr('href');
            $.get(href, function(calonmitra, status){
                $('.editForm #id').val(calonmitra.id_calonmitra).hide();
                $('.editForm #isNewRegistrant').val(calonmitra.isNewRegistrant).hide();
                $('.editForm #Service').val(calonmitra.layananCalonMitra);
                $('.editForm #FullName').val(calonmitra.namaCalonMitra);
                $('.editForm #NikKtp').val(calonmitra.nikKtpCalonMitra);
                $('.editForm #Gender').val(calonmitra.jenisKelaminCalonMitra);
                $('.editForm #PhoneNumber').val(calonmitra.noHpCalonMitra);
                $('.editForm #Email').val(calonmitra.emailCalonMitra);
                $('.editForm #Address').val(calonmitra.domisiliCalonMitra);
                $('.editForm #Prov').val(calonmitra.provinsiCalonMitra);
                $('.editForm #Kab').append(new Option(calonmitra.kabupatenCalonMitra, calonmitra.kabupatenCalonMitra));
                $('.editForm #Kab').val(calonmitra.kabupatenCalonMitra);
                $('.editForm #Kec').append(new Option(calonmitra.kecamatanCalonMitra, calonmitra.kecamatanCalonMitra));
                $('.editForm #Kec').val(calonmitra.kecamatanCalonMitra);
                $('.editForm #Kel').append(new Option(calonmitra.kelurahanCalonMitra, calonmitra.kelurahanCalonMitra));
                $('.editForm #Kel').val(calonmitra.kelurahanCalonMitra);
                $('.editForm #WorkingExp').val(calonmitra.pengalamanKerjaCalonMitra);
                $('.editForm #CurrentJob').val(calonmitra.pekerjaanSaatIniCalonMitra);
                $('.editForm #EName').val(calonmitra.namaKontakDaruratCalonMitra);
                $('.editForm #EPhoneNumber').val(calonmitra.noHpKontakDaruratCalonMitra);
                $('.editForm #ERelationship').val(calonmitra.hubKontakDaruratCalonMitra);
                $('.editForm #hiddenKtp').val(calonmitra.namaFileKtpCalonMitra);
                $('.editForm #hiddenSelfieKtp').val(calonmitra.namaFileSelfiektpCalonMitra);
                document.getElementById('imageKtpEdit').src = "/file_registrant/ktp/" + calonmitra.id_calonmitra + "/" + calonmitra.namaFileKtpCalonMitra;
                document.getElementById('imageSelfieKtpEdit').src = "/file_registrant/selfie_ktp/" + calonmitra.id_calonmitra + "/"  + calonmitra.namaFileSelfiektpCalonMitra;
            });
            $('.editForm #editModal').modal();

        });

    $('.rBtn').click(function(event){
                event.preventDefault();
                var href = $(this).attr('href');
                $(".myRemove .dBtn").attr('href',href);
                $('.myRemove #removeModal').modal();
        });
});

// Address Script
function getData(url, elementId){
  // CREATE AN XMLHttpRequest OBJECT, WITH GET METHOD.
  var xhr = new XMLHttpRequest(),
  method = 'GET',
  overrideMimeType = 'application/json';

  xhr.onreadystatechange = function(){
    if(xhr.readyState == XMLHttpRequest.DONE && xhr.status == 200){
      // PARSE JSON DATA
      var data = JSON.parse(xhr.responseText);
      var element = document.getElementById(elementId);
      for(var i = 0; i < data.length; i++){
        element.innerHTML = element.innerHTML +
        '<option value="' + data[i].nama + '" id="'+ data[i].id +'">' + data[i].nama + '</option>';
      }
    }
  };
  xhr.open(method, url, true);
  xhr.send();
}

window.onload = populateSelectProv();
function populateSelectProv(){
  var url = 'https://ibnux.github.io/data-indonesia/propinsi.json';
  var elementId = 'Prov';
  getData(url, elementId);
}

function showSelectKab(element){
  // set value kosong di element select
  $('#Kab').empty();
  $('#Kab').prop('disabled', false);
  var url = 'https://ibnux.github.io/data-indonesia/kabupaten/'+ element.options[element.selectedIndex].id +'.json';
  var elementId = 'Kab';
  getData(url, elementId);
}

function showSelectKec(element){
  // set value kosong di element select
  $('#Kec').empty();
  $('#Kel').empty();
  $('#Kec').prop('disabled', false);
  var url = 'https://ibnux.github.io/data-indonesia/kecamatan/'+ element.options[element.selectedIndex].id +'.json';
  var elementId = 'Kec';
  getData(url, elementId);
}

function showSelectKel(element){
  // set value kosong di element select
  $('#Kel').empty();
  $('#Kel').prop('disabled', false);
  var url = 'https://ibnux.github.io/data-indonesia/kelurahan/'+ element.options[element.selectedIndex].id +'.json';
  var elementId = 'Kel';
  getData(url, elementId);
}

// Add the following code if you want the name of the file appear on select
// Custom File Upload Label
$(".custom-file-input").on("change", function() {
  var fileName = $(this).val().split("\\").pop();
  $(this).siblings(".custom-file-label").addClass("selected").html(fileName);
});

function enabledDomisili(){
    $('#Kab').prop('disabled', false);
    $('#Kec').prop('disabled', false);
    $('#Kel').prop('disabled', false);
}