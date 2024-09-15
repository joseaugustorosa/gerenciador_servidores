package com.jose.gerenciador_servidores.Service.impl;

import com.jose.gerenciador_servidores.Model.Servidor;
import com.jose.gerenciador_servidores.Repository.ServidorRepository;
import com.jose.gerenciador_servidores.Service.ServidorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServidorServiceImpl implements ServidorService {

    private final ServidorRepository servidorRepository;

    @Override
    public List<Servidor> getAll() {
        return servidorRepository.findAll();
    }
    @Override
    public Optional<Servidor> findById(Integer id) {
        return servidorRepository.findById(id);
    }
    public void deleteById(Integer id){
        servidorRepository.deleteById(id);
    };
    public void save(Servidor servidor){
        servidorRepository.save(servidor);
    };
    public Servidor update(Integer id, Servidor servidor){
        servidor.setId(id);
        return servidorRepository.save(servidor);

    };
    public List<Servidor> findAllByNameContains(String nome){
        List<Servidor> servidors = new ArrayList<>();
        return servidors.stream().filter(name -> name.getNome().equals(nome)).toList();
    }
}
