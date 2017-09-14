package com.example.aluisiojunior.a1avaliacao;

import android.app.Application;

import java.io.Serializable;

/**
 * Created by Aluisio Junior on 11/09/2017.
 */

public class Contexto extends Application implements Serializable {

    private String Nome;
    private String ID;
    private String Email;

    private String Data;
    private String Hora;

    private String lec;

    private boolean dataShow;

    private String check1;
    private String check2;
    private String check3;
    private String check4;

    private boolean reserva;

    public String isCheck4() {
        return check4;
    }

    public void setCheck4(String check4) {
        this.check4 = check4;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        Data = data;
    }

    public String getHora() {
        return Hora;
    }

    public void setHora(String hora) {
        Hora = hora;
    }

    public String getLec() {
        return lec;
    }

    public void setLec(String lec) {
        this.lec = lec;
    }

    public boolean isDataShow() {
        return dataShow;
    }

    public void setDataShow(boolean dataShow) {
        this.dataShow = dataShow;
    }

    public String isCheck1() {
        return check1;
    }

    public void setCheck1(String check1) {
        this.check1 = check1;
    }

    public String isCheck2() {
        return check2;
    }

    public void setCheck2(String check2) {
        this.check2 = check2;
    }

    public String isCheck3() {
        return check3;
    }

    public void setCheck3(String check3) {
        this.check3 = check3;
    }

    public boolean isReserva() {
        return reserva;
    }

    public void setReserva(boolean reserva) {
        this.reserva = reserva;
    }
}
