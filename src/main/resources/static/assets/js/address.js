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
  var elementId = 'validationProv';
  getData(url, elementId);
}

function showSelectKab(element){
  // set value kosong di element select
  $('#validationKab').empty();
  $('#validationKab').prop('disabled', false);
  var url = 'https://ibnux.github.io/data-indonesia/kabupaten/'+ element.options[element.selectedIndex].id +'.json';
  var elementId = 'validationKab';
  getData(url, elementId);
}

function showSelectKec(element){
  // set value kosong di element select
  $('#validationKec').empty();
  $('#validationKec').prop('disabled', false);
  var url = 'https://ibnux.github.io/data-indonesia/kecamatan/'+ element.options[element.selectedIndex].id +'.json';
  var elementId = 'validationKec';
  getData(url, elementId);
}

function showSelectKel(element){
  // set value kosong di element select
  $('#validationKel').empty();
  $('#validationKel').prop('disabled', false);
  var url = 'https://ibnux.github.io/data-indonesia/kelurahan/'+ element.options[element.selectedIndex].id +'.json';
  var elementId = 'validationKel';
  getData(url, elementId);
}

// Add the following code if you want the name of the file appear on select
// Custom File Upload Label
$(".custom-file-input").on("change", function() {
  var fileName = $(this).val().split("\\").pop();
  $(this).siblings(".custom-file-label").addClass("selected").html(fileName);
});