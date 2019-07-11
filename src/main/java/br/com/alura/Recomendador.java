package br.com.alura;

import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.model.DataModel;

import java.io.File;
import java.io.IOException;

public class Recomendador {

    public DataModel getModeloProdutos() throws IOException {
        return getModelo("dados.csv");
    }

    private DataModel getModelo(String path) throws IOException {
        File file = new File("src/main/resources/" + path);
        return new FileDataModel(file);
    }

    public DataModel getModeloDeCursos() throws IOException {
       return getModelo("cursos2.csv");
    }

}
