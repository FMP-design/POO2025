package controller;
import java.util.List;

public class EstatisticasCollex {
	
	/*double valorEstimado(CollexFunc c)
	 * valorTotalPago
	 * numeroTotalItens
	 * Estatisticas por categoria (ex. calor total por categoria
	 * total comprado / vendido por mes ou ano
	 * numero de itens na colecao ao longo do tempo (se fizermos logica de entrada e saida de itens)
	 * 
	 */
	
	//valor total estimado
	public static double valorTotalEstimado(CollexFunc collex) {
		double total= 0.0;
		for (int i = 0; i < collex.getItens().size(); i++) {
			total = total + collex.getItens().get(i).getValorEst();
		}
		return total;
	}
	
	//Valor estimado por categoria
	public static double valorEstimadoPorCategoria(CollexFunc collex, Categoria cat) {
		double total = 0.0;
		List<ItemCollecao> itens = collex.getItensPorCategoria(cat);
		for(int i = 0; i < itens.size(); i++) {
			total = total + itens.get(i).getValorEst();
		}
		
		return total;
	}
		
	//Valor total pago por categoria
	public static double valorPagoPorCategoria(CollexFunc collex, Categoria cat) {
		double total = 0.0;
		List<ItemCollecao> itens = collex.getItensPorCategoria(cat);
		for(int i = 0; i< itens.size(); i++) {
			total = total + itens.get(i).getValorPago();
		}
		return total;
	}
	
	//valor total pago
	public static double valorTotalPago(CollexFunc collex) {
		double total = 0.0;
		for(int i = 0 ; i < collex.getItens().size(); i++) {
			total = total + collex.getItens().get(i).getValorPago();
		} return total;
	}
		
	//numero total de itens
	public static int numeroTotalItens(CollexFunc collex) {
		return collex.getItens().size();
	}
	
	//Total gasto em compras(moviemntos do tipo COMPRA)
	public static double totalGastoCompras(CollexFunc collex) {
		double total = 0.0;
		List<Movimento> movimentos = collex.getMovimentosPorTipo(Movimento.Tipo.COMPRA);
		for(int i = 0; i < movimentos.size(); i++) {
			total = total + movimentos.get(i).getValor();
		}
		return total;
	}
	
	//Total ganho em vendas(movimentos do tipo VENDA)
	public static double totalGanhoVendas(CollexFunc collex) {
		double total = 0.0;
		List<Movimento> movimentos = collex.getMovimentosPorTipo(Movimento.Tipo.VENDA);
		for (int i = 0; i < movimentos.size(); i++) {
			total = total + movimentos.get(i).getValor();
		}
		return total;
	}
	
	//Numero de movimentos por tipo
	public static int numeroMovimentosPorTipo(CollexFunc collex, Movimento.Tipo tipo) {
		return collex.getMovimentosPorTipo(tipo).size();
	}
	
	//Lucro/Prejuizo total (vendas-compras)
	public static double lucroPrejuizo(CollexFunc collex) {
		return totalGanhoVendas(collex) - totalGastoCompras(collex);
	}
	
	//Numero total de contactos
	public static int numeroTotalContactos(CollexFunc collex) {
		return collex.getContactos().size();
	}
	
	//Prints
	public static void mostrarResumoGeral(CollexFunc collex) {
		System.out.println("\n=== ESTATÍSTICAS DA COLEÇÃO ===");
		System.out.println("Número total de itens: " + numeroTotalItens(collex));
		System.out.println("Valor total estimado: " + String.format("%.2f", valorTotalEstimado(collex)) + " €");
		System.out.println("Valor total pago: " + String.format("%.2f", valorTotalPago(collex)) + " €");
		System.out.println("\n--- Movimentos ---");
		System.out.println("Compras: " + numeroMovimentosPorTipo(collex, Movimento.Tipo.COMPRA) + 
						   " (Total: " + String.format("%.2f", totalGastoCompras(collex)) + " €)");
		System.out.println("Vendas: " + numeroMovimentosPorTipo(collex, Movimento.Tipo.VENDA) + 
						   " (Total: " + String.format("%.2f", totalGanhoVendas(collex)) + " €)");
		System.out.println("Trocas: " + numeroMovimentosPorTipo(collex, Movimento.Tipo.TROCA));
		System.out.println("Lucro/Prejuízo: " + String.format("%.2f", lucroPrejuizo(collex)) + " €");
		System.out.println("\nNúmero total de contactos: " + numeroTotalContactos(collex));
		System.out.println("================================\n");
	}
}
