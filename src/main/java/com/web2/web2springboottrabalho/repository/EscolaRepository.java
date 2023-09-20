package com.web2.web2springboottrabalho.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web2.web2springboottrabalho.models.AlunoTurma;

@Repository
public interface EscolaRepository extends JpaRepository<AlunoTurma, Long> {
}
