package com.jose.gerenciador_servidores.Service;

import com.jose.gerenciador_servidores.Model.Servidor;

import java.util.List;
import java.util.Optional;

public interface ServidorService {

    List<Servidor> getAll();
    Optional<Servidor> findById(Integer id);
    List<Servidor> findAllByNameContains(String nome);
    void deleteById(Integer id);
    void save(Servidor servidor);
    Servidor update(Integer id, Servidor servidor);


}
