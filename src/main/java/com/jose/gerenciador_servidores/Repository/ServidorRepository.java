package com.jose.gerenciador_servidores.Repository;

import com.jose.gerenciador_servidores.Model.Servidor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServidorRepository extends JpaRepository<Servidor, Integer> {
}
