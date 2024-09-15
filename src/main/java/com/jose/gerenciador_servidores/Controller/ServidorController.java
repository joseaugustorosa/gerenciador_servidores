package com.jose.gerenciador_servidores.Controller;

import com.jose.gerenciador_servidores.Exception.ResourceNotFoundException;
import com.jose.gerenciador_servidores.Model.Servidor;
import com.jose.gerenciador_servidores.Payload.MessagePayload;
import com.jose.gerenciador_servidores.Repository.ServidorRepository;
import com.jose.gerenciador_servidores.Service.ServidorService;
import com.jose.gerenciador_servidores.Service.ServidorServiceOld;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/servidor")
public class ServidorController {


    final ServidorServiceOld servidorService;
    final ServidorRepository servidorRepository;

    public ServidorController(ServidorServiceOld servidorService, ServidorRepository servidorRepository) {
        this.servidorService = servidorService;
        this.servidorRepository = servidorRepository;
    }
//    @Operation(summary ="Busca servidores" )
//    @ApiResponses(value = {
//            @ApiResponse( responseCode = "200",
//                    description = "Busca realizada",
//                    content = {@Content(mediaType = "application/json",
//                            schema = @Schema(implementation = ResponseEntity.class))
//                    }),
//            @ApiResponse( responseCode = "204",
//                    description = "Sem conteúdo",
//                    content = {@Content(mediaType = "application/json",
//                            schema = @Schema(implementation = ResponseEntity.class))
//                    })
//    })
////    @GetMapping
//    public ResponseEntity<List<Servidor>> getAll(@RequestParam(required = false) Optional<String> nome) {
//
//        if (nome.isEmpty()) {
//            return ResponseEntity.ok(servidorService.getAll());
//        }else {
//            List<Servidor> servidores = servidorService.filterByName(nome.get());
//            if (servidores.isEmpty()) {
//
//                return ResponseEntity.noContent().build();
//            }else {
//                return ResponseEntity.ok(servidores);
//            }
//
//        }
//
//    }
    @Operation(summary ="Busca por ID servidor" )
    @ApiResponses(value = {
            @ApiResponse( responseCode = "200",
                    description = "Busca realizada",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseEntity.class))
                    }),
            @ApiResponse( responseCode = "404",
                    description = "Busca não encontrada",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseEntity.class))
                    })
    })
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){

        try{
            Servidor server = servidorService.getById(id);
            return ResponseEntity.ok(server);
        }catch (ResourceNotFoundException e){
            Map<String, String> message = Map.of("Message", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }

    }
    @Operation(summary ="Criar servidor" )
    @ApiResponses(value = {
            @ApiResponse( responseCode = "201",
                    description = "Servidor criado com sucesso",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = MessagePayload.class))
                    })
    })
    @PostMapping
    public  ResponseEntity<MessagePayload>  save(@RequestBody Servidor servidor){
        servidorService.save(servidor);
        return ResponseEntity.status(HttpStatus.CREATED).body(new MessagePayload("Servidor criado com sucesso"));
    }

    @Operation(summary ="Deletar servidor" )
    @ApiResponses(value = {
            @ApiResponse( responseCode = "202",
                    description = "Servidor deletado com sucesso",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = MessagePayload.class))
            }),
            @ApiResponse( responseCode = "404",
                    description = "Servidor não encontrado",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = MessagePayload.class))
                    })
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<MessagePayload> delete(@PathVariable Integer id){
        try {
            servidorService.deleteById(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(new MessagePayload("Servidor deletado com sucesso"));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MessagePayload(e.getMessage()));
        }
    }
    @Operation(summary ="Editar servidor" )
    @ApiResponses(value = {
            @ApiResponse( responseCode = "202",
                    description = "Servidor editado com sucesso",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = MessagePayload.class))
                    }),
            @ApiResponse( responseCode = "404",
                    description = "Servidor não encontrado",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = MessagePayload.class))
                    })
    })
    @PutMapping("/{id}")
    public ResponseEntity<MessagePayload> update(@PathVariable Integer id, @RequestBody Servidor servidor){
        try {
            servidorService.update(id, servidor);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(new MessagePayload("Servidor editado com sucesso"));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MessagePayload(e.getMessage()));
        }

    }



}
