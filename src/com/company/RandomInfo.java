package com.company;


import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class RandomInfo {
    private static final String FICHERO_USUARIOS = "usernames.txt";
    private static final String FICHERO_NOMBRES = "names.txt";
    private static final String FICHERO_COMPANIAS = "companies.txt";
    private static final String FICHERO_CIUDADES = "cities.txt";
    private static final String FICHERO_DIRECCIONES = "adress.txt";
    private String usuario;
    private String nombre;
    private String apellido;
    private String numeroTelefono;
    private String compania;
    private String ciudad;
    private String direccion1;
    private String direccion2;
    private String estado;
    private String nPostal;
    private String contrasenya;
    private String email;
    private Random rand;


    public RandomInfo() throws IOException, JSONException {
        System.out.println("Generando información falsa...");
        rand = new Random();
        obtenerUsuarioAleatorio();
        obtenerNombreAleatorio();
        obtenerApellidoAleatorio();
        obtenerNumeroTelefonoAleatorio();
        obtenerCompaniaAleatoria();
        obtenerEstadoAleatorio();
        obtenerCiudadAleatoria();
        obtenerDireccion1Aleatoria();
        obtenerDireccion2Aleatoria();
        obtenerPostalAleatorio();
        obtenerContrasenyaAleatoria();
        obtenerEmail();
    }


    public String obtenerUsuarioAleatorio() throws IOException {
        try (Stream<String> lines = Files.lines(Paths.get(FICHERO_USUARIOS))) {
            usuario = lines.skip(obtenerNumeroAleatorio(50511)).findFirst().get();
        }

        usuario += obtenerNumeroAleatorio(9999);

        this.usuario = usuario;
        return usuario;
    }

    public String obtenerEmail() throws IOException, JSONException {
        Response dominios = TempMail.contactarApi(TempMail.URL_OBTENERDOMINIOS);
        List<String> list = toList(dominios.body().string());
        this.email = this.usuario + list.get(0);
        return this.usuario + list.get(0);
    }

    private int obtenerNumeroAleatorio(int max) {
        return rand.nextInt(max) + 1;
    }

    private String obtenerNombreAleatorio() throws IOException {
        try (Stream<String> lines = Files.lines(Paths.get(FICHERO_NOMBRES))) {
            nombre = lines.skip(obtenerNumeroAleatorio(4944)).findFirst().get();
        }

        this.nombre = nombre;
        return nombre;
    }

    private String obtenerApellidoAleatorio() throws IOException {
        try (Stream<String> lines = Files.lines(Paths.get(FICHERO_NOMBRES))) {
            apellido = lines.skip(obtenerNumeroAleatorio(4944)).findFirst().get();
        }

        this.apellido = apellido;
        return apellido;
    }

    private String obtenerNumeroTelefonoAleatorio() {
        int i1 = rand.nextInt(8); // returns random number between 0 and 7
        int i2 = rand.nextInt(8);
        int i3 = rand.nextInt(8);
        int i4 = rand.nextInt(742); // returns random number between 0 and 741
        int i5 = rand.nextInt(10000); // returns random number between 0 and 9999

        String phoneNumber = String.format("%d%d%d%03d%04d", i1, i2, i3, i4, i5);
        this.numeroTelefono = phoneNumber;
        return phoneNumber;
    }

    private String obtenerCompaniaAleatoria() throws IOException {
        String compania;
        try (Stream<String> lines = Files.lines(Paths.get(FICHERO_COMPANIAS))) {
            compania = lines.skip(5).findFirst().get();
        }

        this.compania = compania;
        return compania;
    }

    private String obtenerCiudadAleatoria() throws IOException {
        String ciudad;
        try (Stream<String> lines = Files.lines(Paths.get(FICHERO_CIUDADES))) {
            ciudad = lines.skip(obtenerNumeroAleatorio(20579)).findFirst().get();
        }

        this.ciudad = ciudad;
        return ciudad;
    }

    private String obtenerDireccion1Aleatoria() throws IOException {
        String direccion1;
        try (Stream<String> lines = Files.lines(Paths.get(FICHERO_DIRECCIONES))) {
            direccion1 = lines.skip(obtenerNumeroAleatorio(467)).findFirst().get();
        }

        this.direccion1 = direccion1;
        return direccion1;
    }

    private String obtenerDireccion2Aleatoria() throws IOException {
        String direccion2;
        try (Stream<String> lines = Files.lines(Paths.get(FICHERO_DIRECCIONES))) {
            direccion2 = lines.skip(obtenerNumeroAleatorio(467)).findFirst().get();
        }

        this.direccion2 = direccion2;
        return direccion2;
    }

    private String obtenerEstadoAleatorio() throws IOException {
        String estado;
        try (Stream<String> lines = Files.lines(Paths.get(FICHERO_CIUDADES))) {
            estado = lines.skip(obtenerNumeroAleatorio(20579)).findFirst().get();
        }

        this.estado = estado;
        return estado;
    }

    private String obtenerPostalAleatorio() {
        Random r = new Random( System.currentTimeMillis() );
        String nPostal = String.valueOf(10000 + r.nextInt(20000));
        this.nPostal = nPostal;
        return nPostal;
    }

    private String obtenerContrasenyaAleatoria() throws IOException {
        try (Stream<String> lines = Files.lines(Paths.get(FICHERO_USUARIOS))) {
            contrasenya = lines.skip(obtenerNumeroAleatorio(50511)).findFirst().get();
        }

        contrasenya += obtenerNumeroAleatorio(9999);

        this.contrasenya = contrasenya;
        return contrasenya;
    }

    private List<String> toList(String list) {
        String[] strings = list.substring(1, list.length() - 1).split(",");

        for (int i = 0; i < strings.length; i++) {
            strings[i] = strings[i].substring(1);
            strings[i] = strings[i].substring(0, strings[i].length() - 1);
        }

        return Arrays.asList(strings);
    }

    public String toString() {
        return  "--- INFORMACIÓN FAKE GENERADA ---\n" +
                "Nombre: " + nombre + "\n" +
                "Apellido: " + apellido + "\n" +
                "Email: " + email + "\n" +
                "Teléfono: " + numeroTelefono + "\n" +
                "Compañía: " + compania + "\n" +
                "Direccion 1: " + direccion1 + "\n" +
                "Dirección 2: " + direccion2 + "\n" +
                "Ciudad: " + ciudad + "\n" +
                "Estado: " + estado + "\n" +
                "Código postal: " + nPostal + "\n" +
                "Contraseña: " + contrasenya + "\n";

    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public String getCompania() {
        return compania;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getDireccion1() {
        return direccion1;
    }

    public String getDireccion2() {
        return direccion2;
    }

    public String getEstado() {
        return estado;
    }

    public String getnPostal() {
        return nPostal;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String MD5(String md5) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }
        return null;
    }
}
