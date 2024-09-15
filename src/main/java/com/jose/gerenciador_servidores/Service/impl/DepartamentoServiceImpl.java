package com.jose.gerenciador_servidores.Service.impl;

import com.jose.gerenciador_servidores.Model.Departamento;
import com.jose.gerenciador_servidores.Model.Servidor;
import com.jose.gerenciador_servidores.Repository.DepartamentoRepository;
import com.jose.gerenciador_servidores.Repository.ServidorRepository;
import com.jose.gerenciador_servidores.Service.DepartamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartamentoServiceImpl implements DepartamentoService {

    private final DepartamentoRepository departamentoRepository;

    @Override
    public List<Departamento> findAll() {
        return departamentoRepository.findAll();
    }
    @Override
    public Optional<Departamento> findById(Integer id) {
        return departamentoRepository.findById(id);
    }
    public void deleteById(Integer id){
        departamentoRepository.deleteById(id);
    };
    public void save(Departamento departamento){
        departamentoRepository.save(departamento);
    };
    public Departamento update(Integer id, Departamento departamento){
        departamento.setId(id);
        return departamentoRepository.save(departamento);

    };
}
