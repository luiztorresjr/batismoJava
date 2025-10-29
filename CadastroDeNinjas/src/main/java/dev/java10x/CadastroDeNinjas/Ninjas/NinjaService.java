package dev.java10x.CadastroDeNinjas.Ninjas;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

@Service
public class NinjaService {

	private NinjaRepository ninjaRepository;
	private NinjaMapper ninjaMapper;
	
	public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
		this.ninjaRepository = ninjaRepository;
		this.ninjaMapper = ninjaMapper;
	}
	
	//Listar todos os meus ninjas
	public List<NinjaDTO> listarNinjas(){
		List<NinjaModel> ninjas = ninjaRepository.findAll();
		return ninjas.stream().map(ninjaMapper::map)
				.collect(Collectors.toList());
	}
	
	// Listar todos os ninjas com o id
	public NinjaDTO listaNinjasPorId(Long id) {
		Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
		return ninjaPorId.map(ninjaMapper::map).orElse(null);
	}
	
	public NinjaDTO criarNinja(NinjaDTO ninjaDTO) {
		NinjaModel ninja = ninjaMapper.map(ninjaDTO);
		ninja = ninjaRepository.save(ninja);
		return ninjaMapper.map(ninja);
	}
	
	public void deletarNinjaPorId(Long id){
		 ninjaRepository.deleteById(id);
	}
	
	
	public NinjaDTO atualizarNinja(Long id, NinjaDTO ninjaDTO) {
		Optional<NinjaModel> ninjaExistente = ninjaRepository.findById(id);
		if(ninjaExistente.isPresent()) {
			NinjaModel ninjaAtualizado = ninjaMapper.map(ninjaDTO);
			ninjaAtualizado.setId(id);
			NinjaModel ninjaSalvo = ninjaRepository.save(ninjaAtualizado);
			return ninjaMapper.map(ninjaSalvo);
		}
		return null;
	}
}
