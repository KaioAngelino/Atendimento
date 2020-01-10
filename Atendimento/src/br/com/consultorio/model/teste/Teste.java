package br.com.consultorio.model.teste;

import java.time.LocalDate;

import br.com.consultorio.model.bean.Consulta;
import br.com.consultorio.model.bean.Medico;
import br.com.consultorio.model.bean.Paciente;
import br.com.consultorio.model.dao.ConsultaDao;

public class Teste {

	public static void main(String[] args){
		
		Paciente p = new Paciente();
		p.setNome("Yan");
		p.setId(1);
		//PacienteDao.salvar(p);
		
		Medico m = new Medico();
		m.setCrm("10110");
		m.setNome("Dra Marina");
		//MedicoDao.salvar(m);
		//m.setId(1);
		
		Consulta c = new Consulta();
		c.setData(LocalDate.now());
		c.setPaciente(p);
		c.setMedico(m);
		
		//ConsultaDao.salvar(c);
		//c = ConsultaDao.listarPorId(5);
		
		//System.out.println(c.getPaciente());
		//System.out.println(c.getMedico());
		
		
		Consulta c2 = ConsultaDao.buscarPorId(3);
		
		
		System.out.print("Médico(a):"+c2.getMedico().getNome());
		System.out.println(" crm: "+c2.getMedico().getCrm());
		System.out.print("paciente: "+c2.getPaciente().getNome());
		System.out.println("horário: "+c2.getData());
	
	}
	
}




























