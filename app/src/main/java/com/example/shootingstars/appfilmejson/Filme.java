package com.example.shootingstars.appfilmejson;

import android.os.Build;
import android.support.annotation.RequiresApi;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class Filme {

    @SerializedName("id")
    private long ID;
    private String titulo;
    private Integer ano;
    private boolean venceuOscar;
    private Double bilheteriaMundial;

    public Filme() {
    }

    public Filme(long ID, String titulo, Integer ano, boolean venceuOscar, Double bilheteriaMundial) {
        this.ID = ID;
        this.titulo = titulo;
        this.ano = ano;
        this.venceuOscar = venceuOscar;
        this.bilheteriaMundial = bilheteriaMundial;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public boolean isVenceuOscar() {
        return venceuOscar;
    }

    public void setVenceuOscar(boolean venceuOscar) {
        this.venceuOscar = venceuOscar;
    }

    public Double getBilheteriaMundial() {
        return bilheteriaMundial;
    }

    public void setBilheteriaMundial(Double bilheteriaMundial) {
        this.bilheteriaMundial = bilheteriaMundial;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Filme filme = (Filme) o;
        return ID == filme.ID &&
                venceuOscar == filme.venceuOscar &&
                Objects.equals(titulo, filme.titulo) &&
                Objects.equals(ano, filme.ano) &&
                Objects.equals(bilheteriaMundial, filme.bilheteriaMundial);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {

        return Objects.hash(ID, titulo, ano, venceuOscar, bilheteriaMundial);
    }

    @Override
    public String toString() {
        return "Filme{" +
                "ID=" + ID +
                ", titulo='" + titulo + '\'' +
                ", ano=" + ano +
                ", venceuOscar=" + venceuOscar +
                ", bilheteriaMundial=" + bilheteriaMundial +
                '}';
    }
}
