package br.com.consultorio.model.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.consultorio.model.bean.Consulta;

public class ConsultaDao {
	public static void salvar(Consulta c1) {
		EntityManagerFactory gerenciador = Persistence.createEntityManagerFactory("HibernatePU");

		EntityManager gerenciadorEntidade = gerenciador.createEntityManager();
		try {
			gerenciadorEntidade.getTransaction().begin();
			if (c1.getId() == 0) {
				gerenciadorEntidade.persist(c1);
			} else {
				gerenciadorEntidade.merge(c1);
			}

			gerenciadorEntidade.getTransaction().commit();
		} catch (Exception e) {
			gerenciadorEntidade.getTransaction().rollback();
		} finally {

			gerenciadorEntidade.close();
		}

	}

	public static Consulta buscarPorId(long id) {
		EntityManagerFactory gerenciador = Persistence.createEntityManagerFactory("HibernatePU");

		EntityManager gerenciadorEntidade = gerenciador.createEntityManager();

		Consulta consulta = new Consulta();
		try {
			consulta = gerenciadorEntidade.find(Consulta.class, id);
		} catch (Exception e) {
			System.err.print(e);
		} finally {
			gerenciadorEntidade.close();
		}

		return consulta;

	}

	public static ArrayList<Consulta> listarTodos() {
		EntityManagerFactory gerenciador = Persistence.createEntityManagerFactory("HibernatePU");

		EntityManager gerenciadorEntidade = gerenciador.createEntityManager();

		ArrayList<Consulta> consultas = new ArrayList<>();

		try {
			consultas = (ArrayList<Consulta>) gerenciadorEntidade.createQuery("from Consulta c").getResultList();

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			gerenciadorEntidade.close();
		}
		return consultas;
	}

	public static void deletar(long id) {
		EntityManagerFactory gerenciador = Persistence.createEntityManagerFactory("HibernatePU");

		EntityManager gerenciadorEntidade = gerenciador.createEntityManager();

		Consulta c = new Consulta();

		c = gerenciadorEntidade.find(Consulta.class, id);

		try {

			gerenciadorEntidade.getTransaction().begin();
			gerenciadorEntidade.remove(c);
			gerenciadorEntidade.getTransaction().commit();

		} catch (Exception e) {
			// TODO: handle exception
			gerenciadorEntidade.getTransaction().rollback();
		} finally {
			gerenciadorEntidade.close();
		}
	}
}
