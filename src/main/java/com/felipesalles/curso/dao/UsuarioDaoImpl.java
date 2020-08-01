package com.felipesalles.curso.dao;

import java.time.LocalDate;
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
			users.add(new Usuario(System.currentTimeMillis()+1L, "Ana", "da Silva", LocalDate.of(1992, 5, 10)));
			users.add(new Usuario(System.currentTimeMillis()+2L, "Luiz", "dos Santos", LocalDate.of(1990, 8, 11)));
			users.add(new Usuario(System.currentTimeMillis()+3L, "Mariana", "Mello", LocalDate.of(1988, 9, 17)));
			users.add(new Usuario(System.currentTimeMillis()+4L, "Karen", "Pereira", LocalDate.of(1988, 9, 17)));
			users.add(new Usuario(System.currentTimeMillis()+5L, "Sonia", "Fagundes", LocalDate.of(1988, 9, 17)));
			users.add(new Usuario(System.currentTimeMillis()+6L, "Norberto", "de Souza", LocalDate.of(1988, 9, 17)));
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
		 				u.setDtNascimento(usuario.getDtNascimento());
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
