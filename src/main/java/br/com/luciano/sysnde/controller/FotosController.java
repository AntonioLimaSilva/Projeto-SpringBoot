package br.com.luciano.sysnde.controller;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;

import br.com.luciano.sysnde.dto.FotoDTO;
import br.com.luciano.sysnde.storage.FotoStorage;
import br.com.luciano.sysnde.storage.FotoStorageRunnable;

@RestController
@RequestMapping("/fotos")
public class FotosController {
	
	@Autowired
	private FotoStorage fotoStorage;
	
	@PostMapping
	public DeferredResult<FotoDTO> foto(@RequestParam("files[]") MultipartFile[] files) {
		DeferredResult<FotoDTO> resultado = new DeferredResult<>();
		ExecutorService executorService = Executors.newSingleThreadExecutor();	
		executorService.execute(new FotoStorageRunnable(files, fotoStorage,  resultado));		
		executorService.shutdown();
		
		return resultado;
	}

}
