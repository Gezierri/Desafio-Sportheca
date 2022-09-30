package com.project.desafio_sportheca.models;

import com.google.gson.annotations.SerializedName;

public class Barras {

    @SerializedName("Copas_do_Mundo_Vencidas")
    CopasVencidas copasVencidas;
    @SerializedName("Copas_do_Mundo_Disputadas")
    CopasDisputadas copasDisputadas;

    public CopasVencidas getCopasVencidas() {
        return copasVencidas;
    }

    public void setCopasVencidas(CopasVencidas copasVencidas) {
        this.copasVencidas = copasVencidas;
    }

    public CopasDisputadas getCopasDisputadas() {
        return copasDisputadas;
    }

    public void setCopasDisputadas(CopasDisputadas copasDisputadas) {
        this.copasDisputadas = copasDisputadas;
    }

    @Override
    public String toString() {
        return "Barras{" +
                "copasVencidas=" + copasVencidas +
                ", copasDisputadas=" + copasDisputadas +
                '}';
    }
}
