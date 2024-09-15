package com.jose.gerenciador_servidores;

import com.jose.gerenciador_servidores.Model.Servidor;
import com.jose.gerenciador_servidores.Service.ServidorService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ServidorServiceTest {
    @Autowired
    ServidorService servidorService;

    @Test
    @DisplayName("Criar novos servidores")
    public void insert() {
        List<Servidor> all = servidorService.getAll();
        int tam_inicial = all.size();
        Servidor servidor = new Servidor();
        servidor.setNome("Servidor Teste");
        servidor.setDescricao("Servidor");
        servidorService.save(servidor);
        all = servidorService.getAll();
        int tam_final = all.size();
        assertEquals(tam_inicial + 1, tam_final);

    }
    @Test
    @DisplayName("Deletar um servidor")
    public void delete() {
        Servidor servidor = new Servidor();
        servidor.setNome("Servidor Teste");
        servidor.setDescricao("Servidor");
        servidorService.save(servidor);
        List<Servidor> all = servidorService.getAll();
        int tam_inicial = all.size();
        Servidor servidor1 = all.get(0);
        servidorService.deleteById(servidor1.getId());
        all = servidorService.getAll();
        int tam_final = all.size();
        assertEquals(tam_inicial - 1, tam_final);
    }
}
