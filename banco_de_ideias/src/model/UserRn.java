package model;

import java.util.List;

import Dominio.User;
import dao.UserDao;

public class UserRn {
	
	private UserDao dao;
	
	public UserRn() {
		dao = new UserDao();
	}

	public void salvar(User user) throws Exception {
		if (user.getNome().trim().isEmpty()) {
			throw new Exception("O nome é obrigatório!");
		}

		if (user.getEmail().trim().isEmpty()) {
			throw new Exception("O E-mail é obrigatório!");
		}
		
		dao.salvar(user);
	}

	public List<User> listar() {
		return dao.listarTodos();
	}

	public User buscarPorId(Long id) {
		return dao.buscarPorId(id);
	}

	public void excluir(Long id) throws Exception {
		 dao.excluir(id);
	}
	public User buscarPorEmail(String email) {
		return dao.buscarPorEmail(email);
	}

}

