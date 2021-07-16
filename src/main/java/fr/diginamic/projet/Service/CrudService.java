package fr.diginamic.projet.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.NoSuchElementException;

public abstract class CrudService<T> {

    @Autowired
    CrudRepository<T, Long> crudRepository;

    public List<T> findAll() {
        return (List<T>) crudRepository.findAll();
    }

    public T findById(Long id) throws NoSuchElementException {
        return crudRepository.findById(id).orElseThrow();
    }

    public T save(T t) {
        return crudRepository.save(t);
    }

    public void delete(Long id) {
        crudRepository.deleteById(id);
    }

    public void delete(T t) {
        crudRepository.delete(t);
    }

}
