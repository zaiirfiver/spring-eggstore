package com.zmpa.eggstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zmpa.eggstore.model.Usuario;
import com.zmpa.eggstore.repository.IUsuarioDao;

@Service
public class UsuarioServiceImpl implements IUsuarioService{

	@Autowired
	private IUsuarioDao usuarioDao;

	@Override
	public Optional<Usuario> findById(Integer id) {
		return usuarioDao.findById(id);
	}
	
	

}
