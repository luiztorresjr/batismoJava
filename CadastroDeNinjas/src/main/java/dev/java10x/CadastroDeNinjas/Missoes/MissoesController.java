package dev.java10x.CadastroDeNinjas.Missoes;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/missoes")
public class MissoesController {
	
	private MissoesService missoesService;
	
	public MissoesController(MissoesService missoesService) {
		this.missoesService = missoesService;
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<MissoesDTO>> listarMissoes() {
		List<MissoesDTO> missoes = missoesService.listaMissoes();
		return ResponseEntity.status(HttpStatus.OK).body(missoes);
	}
	
	@GetMapping("/listar/{id}")
	public ResponseEntity<String> listarMissoesPorId(@PathVariable Long id){
		MissoesDTO missao =  missoesService.listarMissoesPorId(id);
		if(missao != null) {
			return ResponseEntity.ok(missao.toString());
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missão com id: "+id+" no encontrada");
		}
	}
	
	@PostMapping("/criar")
	public ResponseEntity<String> criarMissao(@RequestBody MissoesDTO missoes){
		MissoesDTO missoesDTO = missoesService.criarMissoes(missoes);
		return ResponseEntity.status(HttpStatus.CREATED).
				body("A nova missão com id: "+missoesDTO.getId()+" foi criada com sucesso");
	}
	
	@PutMapping("/alterar/{id}")
	public ResponseEntity<String> alterarMissoes(@PathVariable Long id, @RequestBody MissoesDTO missoes){
		if(missoesService.listarMissoesPorId(id)!= null) {
			MissoesDTO missoesDTO = missoesService.atualizarMissoes(id, missoes);
			return ResponseEntity.ok("A missao de id: "+missoesDTO.getId()+" foi atualizado com sucesso");
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missão com id: "+id+" no encontrada");
		}
	}
	
	@PutMapping("/alterar/{id}")
	public ResponseEntity<String> deletar(@PathVariable Long id){
		if(missoesService.listarMissoesPorId(id)!= null) {
			missoesService.deletarMissoesPorId(id);
			return ResponseEntity.ok("A missao de id: "+id+" foi atualizado com sucesso");
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missão com id: "+id+" no encontrada");
		}
	}

}
