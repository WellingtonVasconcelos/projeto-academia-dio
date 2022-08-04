package me.wellington.academiadigital.service.impl;

import me.wellington.academiadigital.entity.Aluno;
import me.wellington.academiadigital.entity.Matricula;
import me.wellington.academiadigital.entity.form.MatriculaForm;
import me.wellington.academiadigital.repository.AlunoRepository;
import me.wellington.academiadigital.repository.MatriculaRepository;
import me.wellington.academiadigital.service.IMatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatriculaServiceImpl implements IMatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public Matricula create(MatriculaForm form) {
        Matricula matricula = new Matricula();
        Aluno aluno = alunoRepository.findById(form.getAlunoId()).get();

        matricula.setAluno(aluno);

        return matriculaRepository.save(matricula);
    }

    @Override
    public Matricula get(Long id) {
        return (Matricula) matriculaRepository.findById(id);
    }

    @Override
    public List<Matricula> getAll() {
        return null;
    }

    @Override
    public List<Matricula> getAll(String bairro) {

        if(bairro == null){
            return matriculaRepository.findAll();
        }else{
            return matriculaRepository.findAlunosMatriculadosBairro(bairro);
        }

    }

    @Override
    public void delete(Long id) {}
}