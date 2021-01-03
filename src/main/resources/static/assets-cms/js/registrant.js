// Edit and View Data
$(document).ready(function(){
    $('.table .vBtn').on('click', function(event){
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function(registrant, status){
            $('.infoForm #validationService').val(registrant.service);
            $('.infoForm #validationFullName').val(registrant.fullName);
            $('.infoForm #validationNikKtp').val(registrant.nikKtp);
            $('.infoForm #validationGender').val(registrant.gender);
            $('.infoForm #validationPhoneNumber').val(registrant.phoneNumber);
            $('.infoForm #validationEmail').val(registrant.email);
            $('.infoForm #validationAddress').val(registrant.address);
            $('.infoForm #validationProv').val(registrant.provinsi);
            $('.infoForm #validationKab').val(registrant.kabupaten);
            $('.infoForm #validationKec').val(registrant.kecamatan);
            $('.infoForm #validationKel').val(registrant.kelurahan);
            $('.infoForm #validationWorkingExp').val(registrant.workingExperience);
            $('.infoForm #validationCurrentJob').val(registrant.currentJob);
            $('.infoForm #validationEName').val(registrant.emergencyName);
            $('.infoForm #validationEPhoneNumber').val(registrant.emergencyPhoneNumber);
            $('.infoForm #validationERelationship').val(registrant.emergencyRelationship);
            document.getElementById('imageKtp').src = "/" + registrant.urlPhotoKtp;
            document.getElementById('imageSelfieKtp').src = "/" + registrant.urlSelfieKtp;
        });

        $('.infoForm #infoModal').modal();
    });

    $('.table .eBtn').on('click', function(event){
            event.preventDefault();
            var href = $(this).attr('href');
            $.get(href, function(registrant, status){
                $('.editForm #id').val(registrant.id).hide();
                $('.editForm #Service').val(registrant.service);
                $('.editForm #FullName').val(registrant.fullName);
                $('.editForm #NikKtp').val(registrant.nikKtp);
                $('.editForm #Gender').val(registrant.gender);
                $('.editForm #PhoneNumber').val(registrant.phoneNumber);
                $('.editForm #Email').val(registrant.email);
                $('.editForm #Address').val(registrant.address);
                $('.editForm #Prov').val(registrant.provinsi);
                $('.editForm #Kab').append(new Option(registrant.kabupaten, registrant.kabupaten));
                $('.editForm #Kab').val(registrant.kabupaten);
                $('.editForm #Kec').append(new Option(registrant.kecamatan, registrant.kecamatan));
                $('.editForm #Kec').val(registrant.kecamatan);
                $('.editForm #Kel').append(new Option(registrant.kelurahan, registrant.kelurahan));
                $('.editForm #Kel').val(registrant.kelurahan);
                $('.editForm #WorkingExp').val(registrant.workingExperience);
                $('.editForm #CurrentJob').val(registrant.currentJob);
                $('.editForm #EName').val(registrant.emergencyName);
                $('.editForm #EPhoneNumber').val(registrant.emergencyPhoneNumber);
                $('.editForm #ERelationship').val(registrant.emergencyRelationship);
                document.getElementById('imageKtpEdit').src = "/" + registrant.urlPhotoKtp;
                document.getElementById('imageSelfieKtpEdit').src = "/" + registrant.urlSelfieKtp;
            });
            $('.editForm #editModal').modal();

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

function myFunction(){
    $('#Kab').prop('disabled', false);
    $('#Kec').prop('disabled', false);
    $('#Kel').prop('disabled', false);
}