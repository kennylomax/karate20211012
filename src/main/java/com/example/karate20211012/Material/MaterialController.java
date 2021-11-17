package com.example.karate20211012;
 
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@RestController
@RequestMapping("/api/materials")
public class MaterialController {

    @Autowired
    private MaterialsRepository repository;

    @GetMapping("") 
    @Operation(summary = "Get all materials")
    public  ResponseEntity<Iterable<Material>> getAllMaterials( ) {
        Iterable<Material> m = repository.findAll();
        return new ResponseEntity<>(m, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Material with given Id")
    public ResponseEntity<Material> find( @PathVariable("id") final Long id ) {
        Optional<Material> m = repository.findById(id);
        if (m.isPresent())
            return new ResponseEntity<Material>(m.get(), HttpStatus.OK);  
        return new ResponseEntity<Material>(HttpStatus.NOT_FOUND);  
    }

    @PostMapping("")
    @Operation(summary = "Create new Material")
     public ResponseEntity<Material> saveMaterial(@RequestBody Material m) {
        repository.save(m);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("material", "/api/materials/" + m.getId().toString());
        return new ResponseEntity<>(m, httpHeaders, HttpStatus.CREATED);
     }

     @PutMapping({"/{id}"})
     @Operation(summary = "Update existing Material")
     @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Material deleted", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Material.class))}),
        @ApiResponse(responseCode = "400", description = "Material id not matching", content = { @Content(schema = @Schema(hidden = true))} ),
        @ApiResponse(responseCode = "404", description = "Material not found", content = { @Content(schema = @Schema(hidden = true))} )
    })

     public ResponseEntity<Material> updateMaterial(@PathVariable Long id, @RequestBody Material m) {
        if (id!=m.getId())
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
        if (!repository.existsById(id))
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);
        
        repository.save(m);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("material", "/api/materials/" + m.getId().toString());
        return new ResponseEntity<>(m, httpHeaders, HttpStatus.OK);

     }

     @DeleteMapping({"/{id}"})
     @Operation(summary = "Delete existing Material")
     @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Material deleted", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Material.class))}),
        @ApiResponse(responseCode = "404", description = "Material not found", content = { @Content(schema = @Schema(hidden = true))} )
    })

     public ResponseEntity<Material> deleteTodo(@PathVariable("id") Long id) {
        if (repository.existsById(id)){
            repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }  
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);  
     }
}