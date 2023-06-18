$(document).ready(function() {
    $('#listar').on('click', function() {
        let tabla = document.querySelector('#tabla');
        tabla.innerHTML = '';
        $.ajax({
            url: "http://localhost:8080/mostrarproductos",
            type: "GET",
            dataType: "json",
            success: function(respuesta) {
                console.log(respuesta);
                tabla.innerHTML = '';
                for (var i = 0; i < respuesta.length; i++) {
                    tabla.innerHTML += '<tr><td>' + respuesta[i].referencia +
                        '</td><td>' + respuesta[i].nombre +
                        '</td><td>' + respuesta[i].categoria +
                        '</td><td>' + respuesta[i].preciounitario +
                        '</td><td>' + respuesta[i].cantidad +
                        '</td><td>' + respuesta[i].descuento10 +
                        '</td><td>' + respuesta[i].total +
                        '</td></tr>';
                }
            },
            error: function() {
                alert("Error en la solicitud");
            }
        });
    });

    $('#actualizarCategoria').on('click', function() {
        let referencia = $('#referencia').val();
        let nuevaCategoria = $('#nuevaCategoria').val();

        $.ajax({
            url: "http://localhost:8080/productos/" + referencia + "/categoria/" + nuevaCategoria,
            type: "PUT",
            contentType: "application/json",
            success: function(respuesta) {
                console.log(respuesta);
                alert(respuesta);
            },
            error: function() {
                alert("Error en la solicitud");
            }
        });
    });

    $('#buscarCategoria').on('click', function() {
        let categoria = $('#categoria').val();

        $.ajax({
            url: "http://localhost:8080/totalporcategoriaproducto/" + categoria,
            type: "GET",
            dataType: "json",
            success: function(response) {
                // Clear previous table data
                $('#tabla tbody').empty();

                // Populate table with new data
                response.forEach(function(producto) {
                    let row = `<tr>
                        <td>${producto.referencia}</td>
                        <td>${producto.nombre}</td>
                        <td>${producto.categoria}</td>
                        <td>${producto.preciounitario}</td>
                        <td>${producto.cantidad}</td>
                        <td>${producto.descuento10}</td>
                        <td>${producto.total}</td>
                    </tr>`;
                    $('#tabla tbody').append(row);
                });
            },
            error: function(error) {
                console.log(error);
            }
        });
    });
});