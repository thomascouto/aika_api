package com.aika.backend.api.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public abstract class BaseController<T extends BaseClass, U extends JpaRepository<T, UUID>> {

    @Autowired
    protected U repository;

    @PostMapping(value = "/add")
    public ResponseEntity<T> add(@RequestBody T entity) {
        try {
            if (entity.getId() == null)
                entity.setId(UUID.randomUUID());
            repository.save(entity);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<T>> getAll() {
        try {
            List<T> resultList = new ArrayList<T>();
            repository.findAll().forEach(resultList::add);

            if (resultList.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return new ResponseEntity<List<T>>(resultList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> getById(@PathVariable("id") UUID id) {
        try {
            Optional<T> em = repository.findById(id);
            if (em.isPresent())
                return new ResponseEntity<T>(em.get(), HttpStatus.OK);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<T> deleteById(@PathVariable("id") UUID id) {
        try {
            repository.deleteById(id);
            return new ResponseEntity<T>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    protected ResponseEntity<T> updateEntity(@PathVariable("id") UUID id,
            @RequestBody T updateEntity) {
        try {
            Optional<T> entity = repository.findById(id);
            if (entity.isPresent() && entity.get().getId().equals(updateEntity.getId()))
                return new ResponseEntity<T>(repository.save(updateEntity), HttpStatus.OK);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
