package com.felipesalles.curso.dao;

import java.util.List;

import com.felipesalles.curso.domain.Usuario;

public interface UsuarioDao {

	void salvar(Usuario usuario);
	
	void editar(Usuario usuario);
	
	void excluir(Long id);
	
	Usuario getId(Long id);
	
	List<Usuario> getTodos();
	
}
