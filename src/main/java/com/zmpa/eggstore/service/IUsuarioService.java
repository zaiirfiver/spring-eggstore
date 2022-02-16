package com.zmpa.eggstore.service;

import java.util.Optional;

import com.zmpa.eggstore.model.Usuario;

public interface IUsuarioService {
	Optional<Usuario> findById(Integer id);
	Usuario save (Usuario usuario);
	Optional<Usuario> findByMail(String mail);

}
