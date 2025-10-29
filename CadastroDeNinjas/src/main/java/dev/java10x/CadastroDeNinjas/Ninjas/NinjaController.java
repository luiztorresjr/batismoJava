package dev.java10x.CadastroDeNinjas.Ninjas;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
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
	public NinjaDTO criarNinja(NinjaDTO ninja) {
		return ninjaService.criarNinja(ninja);
	}
	
	@DeleteMapping("/deletar/{id}")
	public void deletarNinjaPorId(@PathVariable Long id) {
		ninjaService.deletarNinjaPorId(id);
	}
	
	
}
