package com.example.library.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;
import com.example.library.model.Libreria;

@RestController
@RequestMapping({ "generales" })
public class GeneralesController {
    private Libreria libreria;

    public GeneralesController() {
        libreria = new Libreria();
        Date date = new Date();
        libreria.setId(String.valueOf(date.getTime()));
        libreria.setNombre("Librería Central");
        libreria.setDireccion("Avenida Siempreviva");
        libreria.setTelefono("1234567890");
        libreria.setHorario("7 a.m a 5:30 p.m.");
    }

    private String generarAleatorio(int min, int max) {
        Date date = new Date();
        long timeMilli = date.getTime();
        // private String id;
        return String.valueOf(timeMilli+2).substring(min, max);
    }

    @GetMapping("/")
    public Libreria info() {
        return libreria;
    }

    @GetMapping("/nombre")
    public String nombre() {
        return libreria.getNombre();
    }

    @GetMapping("/direccion")
    public String direccion() {
        return libreria.getDireccion();
    }

    @GetMapping("/telefono")
    public String telefono() {
        return libreria.getTelefono();
    }

    @GetMapping("/horario")
    public String horario() {
        return libreria.getHorario();
    }

    @PostMapping("/user")
    @ResponseBody
    public String user(String user) {
        return "USER con método POST --> " + user;
    }
}