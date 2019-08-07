package forme.reciklazer.model;

import domen.Reciklazer;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModelTabeleReciklazera extends AbstractTableModel {

    ArrayList<Reciklazer> listaReciklazera;
    private String[] naziviKolona = new String[]{"ID", "Naziv reciklazera", "Opis reciklazera", "Email", "Kategorija"};

    public ModelTabeleReciklazera() {
        listaReciklazera = new ArrayList<>();
    }

    public ModelTabeleReciklazera(ArrayList<Reciklazer> listaReciklazera) {
        this.listaReciklazera = listaReciklazera;
    }

    public ArrayList<Reciklazer> getListaReciklazera() {
        return listaReciklazera;
    }

    public void setListaReciklazera(ArrayList<Reciklazer> listaReciklazera) {
        this.listaReciklazera = listaReciklazera;
    }

    @Override
    public int getRowCount() {
        return listaReciklazera.size();
    }

    @Override
    public int getColumnCount() {
        return naziviKolona.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Reciklazer reciklazer = listaReciklazera.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return reciklazer.getReciklazerID();
            case 1:
                return reciklazer.getNazivReciklazera();
            case 2:
                return reciklazer.getOpisReciklazera();
            case 3:
                return reciklazer.getEmail();
            case 4:
                return reciklazer.getKategorija().getNazivKategorije();

            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return naziviKolona[column];
    }

}
