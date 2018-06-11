var SysNDE = SysNDE || {};

SysNDE.MaskDate = (function(){
	
	function MaskDate() {
		this.inputDate = $('.js-date');
	}
	
	MaskDate.prototype.iniciar = function() {
		this.inputDate.mask('00/00/0000');
		this.inputDate.datepicker({
			orientation: 'bottom',
			language: 'pt-BR',
			autoclose: true
		});
	}
	
	return MaskDate;
	
}());

SysNDE.MaskCep = (function(){
	
	function MaskCep() {
		this.inputCep = $('.js-cep');
	}
	
	MaskCep.prototype.iniciar = function() {
		this.inputCep.mask('00.000-000');
	}
	
	return MaskCep;
	
}());

SysNDE.MaskCpf = (function(){
	
	function MaskCpf() {
		this.inputCpf = $('.js-cpf');
	}
	
	MaskCpf.prototype.iniciar = function() {
		this.inputCpf.mask('000.000.000-00');
	}
	
	return MaskCpf;
	
}());

SysNDE.MaskPhofeNumber = (function(){
	
	function MaskPhofeNumber() {
		this.inputPhofeNumber = $('.js-phone');
	}
	
	MaskPhofeNumber.prototype.iniciar = function() {
		let maskBehavior = function(val) {
			return val.replace(/\D/g, '').length === 11 ? '(00) 00000-0000' : '(00) 0000-00009';
		}
		
		let options = {
			onKeyPress: function(val, e, field, options) {
			      field.mask(maskBehavior.apply({}, arguments), options);
			}
		};
		
		this.inputPhofeNumber.mask(maskBehavior, options);
	}
	
	return MaskPhofeNumber;
	
}());

$(function(){	
	let maskDate = new SysNDE.MaskDate();
	maskDate.iniciar();
	
	let maskCep = new SysNDE.MaskCep();
	maskCep.iniciar();
	
	let maskCpf = new SysNDE.MaskCpf();
	maskCpf.iniciar();
	
	let maskPhofeNumber = new SysNDE.MaskPhofeNumber();
	maskPhofeNumber.iniciar();
});