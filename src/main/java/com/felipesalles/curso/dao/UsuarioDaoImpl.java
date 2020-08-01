package com.felipesalles.curso.dao;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.felipesalles.curso.domain.Usuario;

@Repository
public class UsuarioDaoImpl implements UsuarioDao {
	
	private static List<Usuario> users;
	
	public UsuarioDaoImpl() {
		createUserList();
	}
	
	private List<Usuario> createUserList(){
		if(users == null) {
			users = new LinkedList<>();
			users.add(new Usuario(System.currentTimeMillis()+1L, "Ana", "da Silva"));
			users.add(new Usuario(System.currentTimeMillis()+2L, "Luiz", "dos Santos"));
			users.add(new Usuario(System.currentTimeMillis()+3L, "Mariana", "Mello"));
			users.add(new Usuario(System.currentTimeMillis()+4L, "Karen", "Pereira"));
			users.add(new Usuario(System.currentTimeMillis()+5L, "Sonia", "Fagundes"));
			users.add(new Usuario(System.currentTimeMillis()+6L, "Norberto", "de Souza"));
		}
		
		return users;
	}

	@Override
	public void salvar(Usuario usuario) {
		usuario.setId(System.currentTimeMillis());
		users.add(usuario);
		
	}

	@Override
	public void editar(Usuario usuario) {
		users.stream()
		.filter((u) -> u.getId().equals(usuario.getId()))
		.forEach((u) -> {u.setNome(usuario.getNome());
		 				u.setSobrenome(usuario.getSobrenome());
		 				});
		
	}

	@Override
	public void excluir(Long id) {
		users.removeIf((u) -> u.getId().equals(id));
		
	}

	@Override
	public Usuario getId(Long id) {
		
		return users.stream()
				    .filter((u) -> u.getId().equals(id))
				    .collect(Collectors.toList()).get(0);
	}

	@Override
	public List<Usuario> getTodos() {
		
		return users;
	}

	
	
}
