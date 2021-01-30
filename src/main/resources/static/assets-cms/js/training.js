// Edit and View Data
$(document).ready(function(){
    $('.table .vBtn').on('click', function(event){
            event.preventDefault();
            var href = $(this).attr('href');
            $.get(href, function(training, status){
                $('.training #id').val(training.id_calonmitra).hide();
                $('.training #FullName').val(training.namaCalonMitra);
                $('.training #NikKtp').val(training.nikKtpCalonMitra);
                $('.training #PhoneNumber').val(training.noHpCalonMitra);
                $('.training #Email').val(training.emailCalonMitra);
                $('.training #EName').val(training.namaKontakDaruratCalonMitra);
                $('.training #EPhoneNumber').val(training.noHpKontakDaruratCalonMitra);
                $('.training #ERelationship').val(training.hubKontakDaruratCalonMitra);
            });
            $('.training #trainingModal').modal();

            document.getElementById('failed_div').required = true;

        });
});

function showDiv(element){
    document.getElementById('failed_div').style.display = element.value == 22 ? 'block' : 'none';
    document.getElementById('reasonFailed').required = element.value == 22 ? true : false;

    document.getElementById('keahlian_div').style.display = element.value == 12 ? 'block' : 'none';
    document.getElementById('keahlian').required = element.value == 12 ? true : false;
}