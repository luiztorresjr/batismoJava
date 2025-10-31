package dev.java10x.CadastroDeNinjas.Missoes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class MissoesService {
	private MissoesRepository missoesRepository;
	private MissoesMapper missoesMapper;
	
	public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
		this.missoesMapper = missoesMapper;
		this.missoesRepository = missoesRepository;
	}
	
	public List<MissoesDTO> listaMissoes(){
		List<MissoesModel> missoes = missoesRepository.findAll();
		return missoes.stream().map(missoesMapper::map)
				.collect(Collectors.toList());
	}
	
	public MissoesDTO listarMissoesPorId(Long id) {
		Optional<MissoesModel> missoesPorId = missoesRepository.findById(id);
		return missoesPorId.map(missoesMapper::map).orElse(null);
	}
	
	
	public MissoesDTO criarMissoes(MissoesDTO missoesDTO) {
		MissoesModel missoes = missoesMapper.map(missoesDTO);
		missoes = missoesRepository.save(missoes);
		return missoesMapper.map(missoes);
	}
	
	public void deletarMissoesPorId(Long id) {
		missoesRepository.deleteById(id);
	}
	
	public MissoesDTO atualizarMissoes(Long id, MissoesDTO missoesDTO) {
		Optional<MissoesModel> missoesExistente = missoesRepository.findById(id);
		if(missoesExistente.isPresent()) {
			MissoesModel missoesAtualizada = missoesMapper.map(missoesDTO);
			missoesAtualizada.setId(id);
			MissoesModel missoesSalvo  = missoesRepository.save(missoesAtualizada);
			return missoesMapper.map(missoesSalvo);
		}
		return null;
	}
}
