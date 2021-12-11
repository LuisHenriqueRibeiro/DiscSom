package ribeiro.luis.discsom.loja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ribeiro.luis.discsom.loja.dto.CompraDTO;
import ribeiro.luis.discsom.loja.model.Compra;
import ribeiro.luis.discsom.loja.service.CompraService;
@CrossOrigin
@RestController
@RequestMapping("/compra")
public class CompraController 
{
	@Autowired
	private CompraService compraService;
	
	@RequestMapping(method = RequestMethod.POST)
	public Compra realizaCompra(@RequestBody CompraDTO compra)
	{
		return compraService.realizaCompra(compra);
	}
	

}