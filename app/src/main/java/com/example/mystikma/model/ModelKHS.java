package com.example.mystikma.model;

public class ModelKHS {
    private String matkulkhs, skskhs, gradekhs,sksnkhs;

    public ModelKHS(String matkulkhs, String skskhs, String gradekhs, String sksnkhs) {
        this.matkulkhs = matkulkhs;
        this.skskhs = skskhs;
        this.gradekhs = gradekhs;
        this.sksnkhs = sksnkhs;
    }

    public String getMatkulkhs() {
        return matkulkhs;
    }

    public String getSkskhs() {
        return skskhs;
    }

    public String getGradekhs() {
        return gradekhs;
    }

    public String getSksnkhs() {
        return sksnkhs;
    }
}
