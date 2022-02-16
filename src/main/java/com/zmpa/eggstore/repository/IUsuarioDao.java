package com.zmpa.eggstore.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zmpa.eggstore.model.Usuario;

@Repository
public interface IUsuarioDao extends JpaRepository<Usuario, Integer>{
	Optional<Usuario> findByMail(String mail);
	
}
