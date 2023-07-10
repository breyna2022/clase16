$(document).ready(function () {
    listar();
});
let url = "http://localhost:9090/editorial/";
function listar() {
    let x;
    $.ajax({
        url: url + "listar",
        type: 'GET',
        dataType: 'json',
        success: function (data, textStatus, xhr) {
            x = JSON.parse(JSON.stringify(data));
            $("#tablita tbody tr").remove();
            x.forEach((item, index) => {
                $("#tablita").append("<tr><td>" + item.id + "</td><td>" + item.nombre + "</td><td>" + item.pais + "</td><td>" + item.estado + "</td><td><a href='#' class='text-danger' onclick='eliminar(" + item.id + ")'><i class='fa-solid fa-trash-can'></i></a></td><td><a href='#' class='text-warning' onclick='editar(" + item.id + ")'><i class='fa-solid fa-pen-to-square'></i></a></td><tr>");
            });
        },
        error: function (xhr, textStatus, errorThrown) {
            console.log('Error in Operation');
        }
    });
}
function editar(x) {
    $.get("rol2", {"opc": 2, "id": x}, function (data) {
        var x = JSON.parse(data);
        $("#edit_nomrol").val(x.nomrol);
        $("#edit_idrol").val(x.idr);
    });
    $("#myModal2").modal('show');
}
function eliminar(x) {
    let id = x;
    Swal.fire({
        title: 'Are you sure?',
        text: "You won't be able to revert this!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes, delete it!'
    }).then((result) => {
        if (result.isConfirmed) {
            $.ajax({
                url: url + id,
                type: 'DELETE',
                dataType: 'json',
                data: id,
                success: function (data, textStatus, xhr) {
                    window.location.reload();
                },
                error: function (xhr, textStatus, errorThrown) {
                    console.log('Error in Operation');
                }
            });
            Swal.fire(
                    'Deleted!',
                    'Your file has been deleted.',
                    'success'
                    );
            window.location= "http://localhost:9090/menu/editorial";
        }
    });
}
function listarRolId() {
    $.get("rol2", {"opc": 2}, function (data) {
        alert(data);
    });
}
$("#crearRol").click(function () {
    alert("saverol");
    $("#nomrol").val("");
    document.getElementById("nomrol").focus();
    $("#myModal").modal('show');

});

$("#saverol").click(function () {
    alert("saverol");
    var nr = $("#nomrol").val();
    $.post("rol2", {"nombrerol": nr, "opc": 3}, function () {
        listarRol();
    });
    $("#myModal").modal('hide');

});
$("#editrol").click(function () {
    var id = $("#edit_idrol").val();
    var nomrol = $("#edit_nomrol").val();
    $.post("rol2", {"id": id, "nomrol": nomrol, "opc": 4}, function () {
        listarRol();
    });
    $("#myModal2").modal('hide');
});
