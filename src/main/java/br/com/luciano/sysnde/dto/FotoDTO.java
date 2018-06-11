package br.com.luciano.sysnde.dto;

public class FotoDTO {

	private String foto;
	private String contentType;

	public FotoDTO(String foto, String contentType) {
		this.foto = foto;
		this.contentType = contentType;
	}

	public String getFoto() {
		return foto;
	}

	public String getContentType() {
		return contentType;
	}

}
