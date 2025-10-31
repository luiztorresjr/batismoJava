package dev.java10x.CadastroDeNinjas.Missoes;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table (name = "tb_missoes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MissoesModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "dificuldade")
	private String dificuldade;
	
	@OneToMany(mappedBy = "missoes")
	@JsonIgnore
	private List<NinjaModel> ninjas;
	
}
