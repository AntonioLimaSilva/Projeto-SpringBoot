var SysNDE = SysNDE || {};

SysNDE.ComboEstado = (function(){
	
	function ComboEstado() {
		this.estado = $('#estado');
		this.emitter = $({});
		this.on = this.emitter.on.bind(this.emitter);
	}
	
	ComboEstado.prototype.iniciar = function() {
		this.estado.on('change', onEstadoClicado.bind(this));
	}
	
	function onEstadoClicado(evento) {
		let value = $(evento.target).val();
		
		this.emitter.trigger('clicado', value);
	}
	
	return ComboEstado;
	
}());

SysNDE.ComboCidade = (function(){
	
	function ComboCidade(comboEstado) {
		this.comboEstado = comboEstado;
		this.cidade = $('#cidade');
	}
	
	ComboCidade.prototype.iniciar = function() {
		this.comboEstado.on('clicado', onEstadoClicado.bind(this));
	}
	
	function onEstadoClicado(evento, idEstado) {
		const response = $.ajax({
			url: this.cidade.data('url'),
			method: 'GET',
			contentType: 'application/json',
			data: { idEstado }
		});
		
		response.done(onPesquisaCidadesConcluida.bind(this));
	}
	
	function onPesquisaCidadesConcluida(cidades) {
		let options = cidades.map(c => `<option value="${c.id}">${c.nome}</option>`);
		
		this.cidade.html(options);
	}
	
	return ComboCidade;
	
}());

$(function(){
	
	let comboEstado = new SysNDE.ComboEstado();
	comboEstado.iniciar();
	
	let comboCidade = new SysNDE.ComboCidade(comboEstado);
	comboCidade.iniciar();
	
});