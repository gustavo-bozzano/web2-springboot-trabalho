package com.web2.web2springboottrabalho.repository;

import com.web2.web2springboottrabalho.models.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
    
}
