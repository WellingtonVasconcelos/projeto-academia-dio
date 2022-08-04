package me.wellington.academiadigital.repository;

import me.wellington.academiadigital.entity.Matricula;
import me.wellington.academiadigital.service.IMatriculaService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface MatriculaRepository {
    @Autowired
    List<Matricula> findAlunosMatriculadosBairro(String bairro);

    @Autowired
    List<Matricula> findAll();

    @Autowired
    IMatriculaService findById(Long id);

    @Autowired
    Matricula save(Matricula matricula);
}
