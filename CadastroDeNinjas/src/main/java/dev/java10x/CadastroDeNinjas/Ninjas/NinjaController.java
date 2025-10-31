package dev.java10x.CadastroDeNinjas.Ninjas;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {
	
	private NinjaService ninjaService;
	
	public NinjaController(NinjaService ninjaService) {
		this.ninjaService = ninjaService;
	}
	
	@GetMapping("/boasVindas")
	public String boasVindas() {
		return "Essa é minha primeira mensagem nessa rota";
	}
	
	@GetMapping("/listar")
	public List<NinjaDTO> listarNinjas(){
		return ninjaService.listarNinjas();
	}
	
	@GetMapping("/listar/{id}")
	public NinjaDTO listarNinjaPorId(@PathVariable Long id){
		return ninjaService.listaNinjasPorId(id);
	}
	
	
	@PostMapping("/criar")
	public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) {
		NinjaDTO ninjaDTO =  ninjaService.criarNinja(ninja);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body("Novo ninja com o id: "+ninjaDTO.getId()+"criado com sucesso");
	}
	
	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id) {
		if(ninjaService.listaNinjasPorId(id)!=null) {
			ninjaService.deletarNinjaPorId(id);
			return ResponseEntity.ok("Ninja com o ID "+id+" deletado com sucesso.");			 
		}else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja com o id: "+id+" não encontrado");
	}
	
	
	@PutMapping("/alterar/{id}")
	public NinjaDTO alterarNinja(@PathVariable Long id, @RequestBody NinjaDTO ninja) {
		
			return ninjaService.atualizarNinja(id, ninja);
		
	}
	
}
