package br.com.consultorio.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.consultorio.model.bean.Paciente;

public class PacienteDAO {
	public static void salvar(Paciente paciente) {
		EntityManagerFactory gerenciador = Persistence.createEntityManagerFactory("HibernatePU");

		EntityManager gerenciadorEntidade = gerenciador.createEntityManager();
		try {
			gerenciadorEntidade.getTransaction().begin();
			if (paciente.getId() == 0) {
				gerenciadorEntidade.persist(paciente);
			} else {
				gerenciadorEntidade.merge(paciente);
			}

			gerenciadorEntidade.getTransaction().commit();
		} catch (Exception e) {
			gerenciadorEntidade.getTransaction().rollback();
		} finally {

			gerenciadorEntidade.close();
		}

	}
}
