package com.jose.gerenciador_servidores.Service;

import com.jose.gerenciador_servidores.Model.Departamento;
import com.jose.gerenciador_servidores.Model.Servidor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface DepartamentoService {

    List<Departamento> findAll();
    Optional<Departamento> findById(Integer id);
    void deleteById(Integer id);
    void save(Departamento departamento);
    Departamento update(Integer id, Departamento departamento);
}
