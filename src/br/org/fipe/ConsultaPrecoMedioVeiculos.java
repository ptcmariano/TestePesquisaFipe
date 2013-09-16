package br.org.fipe;

import br.com.configuracoes.EnumElemento;

public class ConsultaPrecoMedioVeiculos extends ObjetoPaginaBase {
	
	/**
	 * Navegar para pagina princiapl de consulta de veiculos
	 */
	public void navegar(){
		funcao.navegar("http://www.fipe.org.br/web/index.asp?aspx=/web/indices/veiculos/introducao.aspx");
	}
	/**
	 * Navegar para a pagina de consulta de carros e utilitarios
	 */
	public void consultaCarrosClickLink(){
		//funcao.navegar("http://www.fipe.org.br/web/indices/veiculos/default.aspx?p=51");
		funcao.usarFrame().framePorID("fconteudo");
		funcao.clicar(EnumElemento.XPATH, "//*[@id='lblTexto']/p[2]/a[1]");
	}
	/**
	 * Selecionar uma marca de carro a partir do texto da marca 
	 * @param valor Passar texto que é exibido da marca
	 */
	public void selecionaMarca(String marca){
		funcao.usarLista(EnumElemento.ID, "ddlMarca").selecionarOpcaoPeloTexto(marca);
	}
	/**
	 * Selecionar o modelo a partir do texto
	 * @param modelo Passar texto que é exibido do modelo
	 */
	public void selecionarModelo(String modelo){
		//funcao.usarEspera().atributoPresente(funcao.pegarElemento(EnumElemento.ID, "ddlModelo"), "disabled", "false", 10000);
		funcao.usarEspera().elementoEstarClicavel(EnumElemento.ID, "ddlModelo", 10);
		funcao.usarLista(EnumElemento.ID, "ddlModelo").selecionarOpcaoPeloTexto(modelo);
	}
	/**
	 * Selecionar o ano
	 * @param passar texto que é exibido na lista
	 */
	public void selecionarAno(String ano){
		//     \/ não é a melhor forma! mas as vezes quebra sem aguardar =(
		//funcao.aguardar(2000);
		//
		funcao.usarEspera().elementoEstarClicavel(EnumElemento.ID, "ddlAnoValor", 10);
		funcao.usarLista(EnumElemento.ID, "ddlAnoValor").selecionarOpcaoPeloTexto(ano);
	}
	/**
	 * Retorna o valor exibido da consulta de preços medios de veiculos<br />
	 * Utilize sempre após selecionar o ANO para evitar erros :x
	 * @return retorna valor exibido na pesquisa
	 */
	public float buscaValorResultado(){
		return Float.parseFloat(funcao.pegarTexto(EnumElemento.ID, "lblValor").replace("R$", "").replace(".", "").replace(",", "")) / 100;
	}
	
	/**
	 * Exibe caixa de texto com uma mensagem
	 * @param mensagem mensagem a ser exibida
	 */
	public void mensagem(String mensagem){
		funcao.usarUtilidade().msg("FIPE", mensagem);
	}
	/**
	 * Fecha navegador da pagina ConsultaPrecoMedioVeiculos
	 */
	public void fechar() {
		funcao.fechar();
	}
	
}

