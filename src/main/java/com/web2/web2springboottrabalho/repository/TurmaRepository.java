package com.web2.web2springboottrabalho.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web2.web2springboottrabalho.models.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Integer> {

}
