import java.util.ArrayList;

public class EstatisticasCollex {

    public static double valorTotalPago(ArrayList<Movimento> movimentos) {
        double total = 0;
        for (Movimento m : movimentos) {
            if (m.getValor() > 0) {
                total += m.getValor();
            }
        }
        return total;
    }
}
