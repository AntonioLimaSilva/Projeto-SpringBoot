package br.com.luciano.sysnde.storage;

import org.springframework.web.multipart.MultipartFile;

public interface FotoStorage {
	
	String salvarFoto(MultipartFile[] files);

}
