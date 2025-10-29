package dev.java10x.CadastroDeNinjas.Missoes;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tb_missoes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MissoesModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String dificuldade;
	
	@OneToMany(mappedBy = "missoes")
	@JsonIgnore
	private List<NinjaModel> ninjas;
	
}
