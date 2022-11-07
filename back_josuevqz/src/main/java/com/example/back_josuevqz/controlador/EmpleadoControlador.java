package com.example.back_josuevqz.controlador;

import com.example.back_josuevqz.exepciones.ResourceNotFoundExeption;
import com.example.back_josuevqz.modelo.empleado;
import com.example.back_josuevqz.repositorio.EmpleadoRespositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200" )
public class EmpleadoControlador {
    @Autowired
    private EmpleadoRespositorio respositorio;
//ruta cuando acceda al endpoint de empleado
    @GetMapping("/empleados")
    public List<empleado> listarTodosLosEmpleados(){
        //retornamos todos los registros
        return  respositorio.findAll();
    }

    //metodo para poder guardar Usuarios
    //requesbody enviamos en formato json los datos a almacenar
    @PostMapping("/empleados")
    public empleado guardarEmpleado(@RequestBody empleado Empleado){

        return  respositorio.save(Empleado);
    }

    //metodo para buscar un Usuario por ID
    @GetMapping("/empleados/{id}")
    public ResponseEntity<empleado> obtenerEmpleadoID(@PathVariable Long id){
        //lanzaremos una execepcion cuando no exista el ID
        empleado Empleado = respositorio.findById(id).orElseThrow(()->new ResourceNotFoundExeption("No existe el usuario con el ID"));
      //retornamos mensaje OK del usuario
        return  ResponseEntity.ok(Empleado);
    }

    @PutMapping("/empleados/{id}")
    public ResponseEntity<empleado> actualizarEmpleado(@PathVariable Long id, @RequestBody empleado detallesEmpleado){
        //lanzaremos una execepcion cuando no exista el ID
        empleado Empleado = respositorio.findById(id).orElseThrow(()->new ResourceNotFoundExeption("No existe el usuario con el ID"));
       Empleado.setNombre(detallesEmpleado.getNombre());
       Empleado.setLocalidad(detallesEmpleado.getLocalidad());
       Empleado.setMunicipio(detallesEmpleado.getMunicipio());
       Empleado.setCp(detallesEmpleado.getCp());
       Empleado.setPais(detallesEmpleado.getPais());
       Empleado.setIdoma(detallesEmpleado.getIdoma());

       empleado empleadoActualizado = respositorio.save(Empleado);
        //retornamos mensaje OK del usuario
        return  ResponseEntity.ok(empleadoActualizado);
    }

    //este metodo sirve para eliminar un empleado
    @DeleteMapping("/empleados/{id}")
    public ResponseEntity<Map<String,Boolean>> eliminarEmpleado(@PathVariable Long id){
        empleado Empleado = respositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundExeption("No existe el empleado con el ID : " + id));

        respositorio.delete(Empleado);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminar",Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }


}
