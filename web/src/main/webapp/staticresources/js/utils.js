$(document).ready(function(){
    $('#addPerson').click(function () {
        addPerson();
    });
});


function addPerson() {
    $('#personForm').prop('action', 'addproducttoorder');
    $('#personButton').prop('value', 'Add person');
    $('#personForm').show();
}
