// Edit and View Data
$(document).ready(function(){
    $('.table .vBtn').on('click', function(event){
            event.preventDefault();
            var href = $(this).attr('href');
            $.get(href, function(onboarding, status){
                $('.onboarding #id').val(onboarding.id_calonmitra).hide();
                $('.onboarding #FullName').val(onboarding.namaCalonMitra);
                $('.onboarding #NikKtp').val(onboarding.nikKtpCalonMitra);
                $('.onboarding #PhoneNumber').val(onboarding.noHpCalonMitra);
                $('.onboarding #Email').val(onboarding.emailCalonMitra);
                $('.onboarding #EName').val(onboarding.namaKontakDaruratCalonMitra);
                $('.onboarding #EPhoneNumber').val(onboarding.noHpKontakDaruratCalonMitra);
                $('.onboarding #ERelationship').val(onboarding.hubKontakDaruratCalonMitra);
                document.getElementById('imageKtpEdit').src = "/" + onboarding.namaFileKtpCalonMitra;
                document.getElementById('imageSelfieKtpEdit').src = "/" + onboarding.namaFileSelfiektpCalonMitra;
            });
            $('.onboarding #onboardingModal').modal();

        });
});

function showDiv(element){
    document.getElementById('failed_div').style.display = element.value == 23 ? 'block' : 'none';
    document.getElementById('reasonFailed').required = element.value == 23 ? true : false;
}