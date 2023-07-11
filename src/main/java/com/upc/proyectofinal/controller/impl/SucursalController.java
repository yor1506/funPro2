package com.upc.proyectofinal.controller.impl;

import com.upc.proyectofinal.controller.ISucursalController;
import com.upc.proyectofinal.controller.mapper.MapperSucursal;
import com.upc.proyectofinal.dto.Almacen;
import com.upc.proyectofinal.dto.Sucursal;
import com.upc.proyectofinal.dto.Tienda;
import com.upc.proyectofinal.entity.SucursalEntity;
import com.upc.proyectofinal.service.SucursalService;
import com.upc.proyectofinal.utils.exception.GenericException;
import com.upc.proyectofinal.utils.exception.ValidacionRequestException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/sucursal")
public class SucursalController implements ISucursalController {

    @Autowired
    SucursalService sucursalService;

    @Autowired
    MapperSucursal mapperSucursal;


    @Override
    @GetMapping("/listar")
    public ResponseEntity<?> listarSucursal() {
        List<SucursalEntity> listaSucursalEntity = sucursalService.listarSucursal();
        List<Sucursal> listaSucursal = mapperSucursal.listSucursalEntityToListSucursalDTO(listaSucursalEntity);
        return ResponseEntity.ok(listaSucursal);
    }

    @Override
    @PostMapping("/guardar/almacen")
    public ResponseEntity<?> guardarAlmacen(@Valid @RequestBody Almacen almacen, BindingResult result) {
        if (result.hasErrors()){
            HashMap<String,String> erorres = new HashMap<>();
            result.getFieldErrors().forEach(e->{
                erorres.put(e.getField(),e.getDefaultMessage());
            });
            throw new ValidacionRequestException("Datos de entrada incorrectos",erorres.toString());
        }
        if (!Objects.isNull(almacen.getSucursalId())){
            HashMap<String,String> erorres = new HashMap<>();
            erorres.put("error","no se debe enviar ID para guardar almacen");
            throw new ValidacionRequestException("Datos de entrada incorrectos",erorres.toString());
        }
        almacen.setTipo("ALMACEN");
        SucursalEntity sucursalEntity = mapperSucursal.almacenToSucursal(almacen);
        sucursalEntity = sucursalService.guardarSucursal(sucursalEntity);
        if (Objects.isNull(sucursalEntity)){
            HashMap<String,String> erorres = new HashMap<>();
            erorres.put("error","no se pudo guardar sucursal");
            throw new GenericException("Error de sistema",erorres.toString());
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @Override
    @PostMapping("/guardar/tienda")
    public ResponseEntity<?> guardarTienda(@Valid @RequestBody Tienda tienda, BindingResult result) {
        if (result.hasErrors()){
            HashMap<String,String> erorres = new HashMap<>();
            result.getFieldErrors().forEach(e->{
                erorres.put(e.getField(),e.getDefaultMessage());
            });
            throw new ValidacionRequestException("Datos de entrada incorrectos",erorres.toString());
        }
        if (!Objects.isNull(tienda.getSucursalId())){
            HashMap<String,String> erorres = new HashMap<>();
            erorres.put("error","no se debe enviar ID para guardar tienda");
            throw new ValidacionRequestException("Datos de entrada incorrectos",erorres.toString());
        }
        tienda.setTipo("TIENDA");
        SucursalEntity sucursalEntity = mapperSucursal.tiendaToSucursal(tienda);
        sucursalEntity = sucursalService.guardarSucursal(sucursalEntity);
        if (Objects.isNull(sucursalEntity)){
            HashMap<String,String> erorres = new HashMap<>();
            erorres.put("error","no se pudo guardar sucursal");
            throw new GenericException("Error de sistema",erorres.toString());
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    @GetMapping("/listar/almacen")
    public ResponseEntity<?> listarAlmacen() {
        List<SucursalEntity> listaSucursalEntity = sucursalService.listarSucursal();
        List<Almacen> listaAlmacen = mapperSucursal.listSucursalEntityToListAlmacen(listaSucursalEntity);
        return ResponseEntity.ok(listaAlmacen);
    }

    @Override
    @GetMapping("/listar/tienda")
    public ResponseEntity<?> listarTienda() {
        List<SucursalEntity> listaSucursalEntity = sucursalService.listarSucursal();
        List<Tienda> listaTienda = mapperSucursal.listSucursalEntityToListTienda(listaSucursalEntity);
        return ResponseEntity.ok(listaTienda);
    }

    @Override
    @GetMapping("/obtener/{id}")
    public ResponseEntity<?> obtenerSucursal(@PathVariable Integer id) {
        Optional<SucursalEntity> sucursal = sucursalService.buscarSucursal(id);
        if (sucursal.isEmpty()){
            HashMap<String,String> erorres = new HashMap<>();
            erorres.put("error","no se encuentra sucursal");
            throw new ValidacionRequestException("Datos de entrada incorrectos",erorres.toString());
        }
        Sucursal response = new Sucursal();
        if (sucursal.get().getTipo().equalsIgnoreCase("TIENDA"))
            response = mapperSucursal.sucursalEntityToTienda(sucursal.get());

        if (sucursal.get().getTipo().equalsIgnoreCase("ALMACEN"))
            response = mapperSucursal.sucursalEntityToAlmacen(sucursal.get());

        return ResponseEntity.ok(response);
    }

    @Override
    @PostMapping("/editar/almacen")
    public ResponseEntity<?> editarAlmacen(@Valid @RequestBody Almacen almacen, BindingResult result) {
        if (result.hasErrors()){
            HashMap<String,String> erorres = new HashMap<>();
            result.getFieldErrors().forEach(e->{
                erorres.put(e.getField(),e.getDefaultMessage());
            });
            throw new ValidacionRequestException("Datos de entrada incorrectos",erorres.toString());
        }
        if (Objects.isNull(almacen.getSucursalId())){
            HashMap<String,String> erorres = new HashMap<>();
            erorres.put("error","se debe indicar el ID del almacen a editar");
            throw new ValidacionRequestException("Datos de entrada incorrectos",erorres.toString());
        }
        Optional<SucursalEntity>  validacion = sucursalService.buscarSucursal(almacen.getSucursalId());
        if (validacion.isEmpty()){
            HashMap<String,String> erorres = new HashMap<>();
            erorres.put("error","almacen a editar no existe");
            throw new ValidacionRequestException("Datos de entrada incorrectos",erorres.toString());
        }
        if (!validacion.get().getTipo().equalsIgnoreCase("ALMACEN")){
            HashMap<String,String> erorres = new HashMap<>();
            erorres.put("error","no es un almacen");
            throw new ValidacionRequestException("Datos de entrada incorrectos",erorres.toString());
        }
        almacen.setTipo("ALMACEN");
        SucursalEntity sucursalEntity = mapperSucursal.almacenToSucursal(almacen);
        sucursalEntity = sucursalService.guardarSucursal(sucursalEntity);
        if (Objects.isNull(sucursalEntity)){
            HashMap<String,String> erorres = new HashMap<>();
            erorres.put("error","no se pudo editar almacen");
            throw new GenericException("Error de sistema",erorres.toString());
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Override
    @PostMapping("/editar/tienda")
    public ResponseEntity<?> editarTienda(@Valid @RequestBody Tienda tienda, BindingResult result) {
        if (result.hasErrors()){
            HashMap<String,String> erorres = new HashMap<>();
            result.getFieldErrors().forEach(e->{
                erorres.put(e.getField(),e.getDefaultMessage());
            });
            throw new ValidacionRequestException("Datos de entrada incorrectos",erorres.toString());
        }
        if (Objects.isNull(tienda.getSucursalId())){
            HashMap<String,String> erorres = new HashMap<>();
            erorres.put("error","se debe indicar el ID del almacen a tienda");
            throw new ValidacionRequestException("Datos de entrada incorrectos",erorres.toString());
        }
        Optional<SucursalEntity>  validacion = sucursalService.buscarSucursal(tienda.getSucursalId());
        if (validacion.isEmpty()){
            HashMap<String,String> erorres = new HashMap<>();
            erorres.put("error","tienda a editar no existe");
            throw new ValidacionRequestException("Datos de entrada incorrectos",erorres.toString());
        }
        if (!validacion.get().getTipo().equalsIgnoreCase("TIENDA")){
            HashMap<String,String> erorres = new HashMap<>();
            erorres.put("error","no es una tienda");
            throw new ValidacionRequestException("Datos de entrada incorrectos",erorres.toString());
        }
        tienda.setTipo("TIENDA");
        SucursalEntity sucursalEntity = mapperSucursal.tiendaToSucursal(tienda);
        sucursalEntity = sucursalService.guardarSucursal(sucursalEntity);
        if (Objects.isNull(sucursalEntity)){
            HashMap<String,String> erorres = new HashMap<>();
            erorres.put("error","no se pudo editar tienda");
            throw new GenericException("Error de sistema",erorres.toString());
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
