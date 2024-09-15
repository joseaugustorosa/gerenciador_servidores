package com.jose.gerenciador_servidores.Service;

import com.jose.gerenciador_servidores.Exception.ResourceNotFoundException;
import com.jose.gerenciador_servidores.Model.Servidor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServidorServiceOld {

    List<Servidor> servidores = initValues();

    private static List<Servidor> initValues(){
        ArrayList<Servidor> listaServidor = new ArrayList<>();

        
        return listaServidor;
    }
    public List<Servidor> getAll(){
        return this.servidores;
    }
    public Servidor getById(int id) {
        if(id< 0 ){
            throw new ResourceNotFoundException("Valor inválido");
        }else{
            Optional<Servidor> server =servidores.stream().filter(servidor -> servidor.getId() == id).findFirst();
            if (server.isEmpty()) throw new ResourceNotFoundException("Objeto não existente");
            return server.get();

        }


    }

    public void save(Servidor servidor){
       servidores.add(servidor);
    }

    public List<Servidor> filterByName(String nome){
        List<Servidor> all = getAll();
        return  all.stream().filter(servidor -> servidor.getNome().contains(nome)).toList();
    }

    public  void deleteById(int id){
        if(ResouceNotFound(id)){
            throw new ResourceNotFoundException("Servidor não localizado");
        }
        servidores.remove(servidores.get(id));
    }

    private boolean ResouceNotFound(int id) {
        return servidores.stream().filter(servidor -> servidor.getId() == id).findFirst().isEmpty();
    }

    public void update(Integer id, Servidor servidor) {
        if(ResouceNotFound(id)){
            throw new ResourceNotFoundException("Servidor não localizado");
        }
        servidores.set(id, servidor);
    }
}
