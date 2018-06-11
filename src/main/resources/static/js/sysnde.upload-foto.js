var SysNDE = SysNDE || {};

SysNDE.UploadFoto = (function(){
	
	function UploadFoto() {
		this.inputFileFoto = $('#fotoSelecionada');
		this.inputFoto = $('#foto');
		this.inputTipoConteudo = $('#tipoConteudo');
	}
	
	UploadFoto.prototype.iniciar = function() {
		var options = {
			url: this.inputFileFoto.data('url'),
			type: 'json',
			allow: '*.(jpg|jpeg|png)',
			concurrent: 1,
			complete: onUploadConcluido.bind(this)
		}
		
		UIkit.upload(this.inputFileFoto, options);
		/*UIkit.drop('#drop', 'top-left');*/
	}
	
	function onUploadConcluido(resposta) {	
		let jsonResponse = JSON.parse(resposta.response);
		     
       this.inputFoto.val(jsonResponse.foto);
       this.inputTipoConteudo.val(jsonResponse.contentType);
    }
	
	return UploadFoto;
	
}());

$(function(){
	
	let uploadFoto = new SysNDE.UploadFoto();
	uploadFoto.iniciar();
	
});