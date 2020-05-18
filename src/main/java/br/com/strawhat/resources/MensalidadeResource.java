package br.com.strawhat.resources;

import java.net.URI;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.strawhat.dto.AssociadoGetMensalidadeDTO;
import br.com.strawhat.dto.MensalidadeDTO;
import br.com.strawhat.dto.MensalidadeGetDTO;
import br.com.strawhat.model.Mensalidade;
import br.com.strawhat.services.MensalidadeService;

@RestController
@RequestMapping(value = "/mensalidades")
public class MensalidadeResource {
	@Autowired
	private MensalidadeService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Mensalidade mensalidade = service.find(id);
		MensalidadeGetDTO mensalidadeGetDTO = new MensalidadeGetDTO(mensalidade);
		AssociadoGetMensalidadeDTO associadoGetMensalidadeDTO = new AssociadoGetMensalidadeDTO(
				mensalidade.getAssociado());
		mensalidadeGetDTO.setAssociado(associadoGetMensalidadeDTO);
		return ResponseEntity.ok().body(mensalidadeGetDTO);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody Mensalidade obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody Mensalidade obj, @PathVariable Integer id) {
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<MensalidadeDTO>> findAll() {
		List<Mensalidade> list = service.findAll();
		List<MensalidadeDTO> listDTO = list.stream().map(obj -> new MensalidadeDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<MensalidadeDTO>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		Page<Mensalidade> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<MensalidadeDTO> listDTO = list.map(obj -> new MensalidadeDTO(obj));
		return ResponseEntity.ok().body(listDTO);
	}

	@RequestMapping(value = "/data", method = RequestMethod.GET)
	public ResponseEntity<List<MensalidadeDTO>> findBetweenDates(@RequestParam(value = "startDate") String startDate,
			@RequestParam(value = "endDate") String endDate) throws ParseException {
		List<Mensalidade> list = service.findBetweenDates(service.formatDate(startDate), service.formatDate(endDate));
		List<MensalidadeDTO> listDTO = list.stream().map(obj -> new MensalidadeDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
}
