package br.com.luciano.sysnde.storage;

import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;

import br.com.luciano.sysnde.dto.FotoDTO;

public class FotoStorageRunnable implements Runnable {

	private MultipartFile[] files;
	private FotoStorage fotoStorage;
	private DeferredResult<FotoDTO> resultado;
	

	public FotoStorageRunnable(MultipartFile[] files, FotoStorage fotoStorage, DeferredResult<FotoDTO> resultado) {
		this.files = files;
		this.fotoStorage = fotoStorage;
		this.resultado = resultado;	
	}

	@Override
	public void run() {
		String foto = this.fotoStorage.salvarFoto(files);
			
		resultado.setResult(new FotoDTO(foto, files[0].getContentType()));
	}

}
