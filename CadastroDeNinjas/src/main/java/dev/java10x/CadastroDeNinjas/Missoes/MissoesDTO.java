package dev.java10x.CadastroDeNinjas.Missoes;

import java.util.List;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MissoesDTO {
	private long id;
	private String nome;
	private String dificuldade;
	private List<NinjaModel> ninjas;
}
