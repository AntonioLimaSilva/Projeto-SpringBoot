package br.com.luciano.sysnde.storage.local;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import br.com.luciano.sysnde.storage.FotoStorage;

@Component
public class FotoStorageLocal implements FotoStorage {
	
	private Path path;
	
	public FotoStorageLocal() {
		this.path = FileSystems.getDefault().getPath(System.getProperty("user.home"), "fotossysnde");
		criarLocalDasFotos();
	}

	@Override
	public String salvarFoto(MultipartFile[] files) {
		String novoNome = null;
		if(files != null && files.length > 0) {
			MultipartFile arquivo = files[0];
			
			novoNome = renomearArquivo(arquivo.getOriginalFilename());
			try {
				arquivo.transferTo(new File(this.path.toAbsolutePath().toString() + FileSystems.getDefault().getSeparator() + novoNome));
			} catch (IOException e) {
				throw new RuntimeException("Erro salvando foto");
			}			
		}
		
		return novoNome;
	}
	
	private String renomearArquivo(String nomeFoto) {
		return String.format("%s", UUID.randomUUID().toString() + "_" + nomeFoto);
	}

	private void criarLocalDasFotos() {
		try {
			Files.createDirectories(this.path);
		} catch (IOException e) {
			throw new RuntimeException("Erro criando diretório para fotos");
		}
	}
}
