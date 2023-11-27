package vista.tabla;

import controlador.sd.linkedlist.LinkedList;
import javax.swing.table.AbstractTableModel;
import model.Censo;

public class ModeloTablaCenso extends AbstractTableModel {

    private LinkedList<Censo> censos;

    public LinkedList<Censo> getCensos() {
        return censos;
    }

    public void setCensos(LinkedList<Censo> censos) {
        this.censos = censos;
    }

    @Override
    public int getRowCount() {
        return censos.getSize();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int row, int column) {

        Censo c = censos.get(row);

        switch (column) {
            case 0:
                return c.getCensador().getNombre() + " " + c.getCensador().getApellido();
            case 1:
                return c.getCesado().getNombre() + " " + c.getCesado().getApellido();
            case 2:
                return c.getTipo();
            case 3:
                return c.getMotivo();
            case 4:
                return c.getFechaDivorsio();
            case 5:
                return c.getEstadoEmosional();
            default:
                return null;
        }

    }

    @Override
    public String getColumnName(int column) {

        switch (column) {
            case 0:
                return "CENSADOR";
            case 1:
                return "CENSADO";
            case 2:
                return "TIPO";
            case 3:
                return "MOTIVO";
            case 4:
                return "FECHA";
            case 5:
                return "ESTADO EMOSIONAL";

            default:
                throw new AssertionError();
        }

    }

}
