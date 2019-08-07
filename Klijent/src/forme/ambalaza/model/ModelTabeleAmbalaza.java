package forme.ambalaza.model;

import domen.Ambalaza;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModelTabeleAmbalaza extends AbstractTableModel {

    ArrayList<Ambalaza> listaAmbalaza;
    private String[] naziviKolona = new String[]{"ID", "Naziv ambalaže", "Reciklažni kod"};

    public ModelTabeleAmbalaza() {
        listaAmbalaza = new ArrayList<>();
    }

    public ModelTabeleAmbalaza(ArrayList<Ambalaza> listaAmbalaza) {
        this.listaAmbalaza = listaAmbalaza;
    }

    public ArrayList<Ambalaza> getListaAmbalaza() {
        return listaAmbalaza;
    }

    public void setListaAmbalaza(ArrayList<Ambalaza> listaAmbalaza) {
        this.listaAmbalaza = listaAmbalaza;
    }

    @Override
    public int getRowCount() {
        return listaAmbalaza.size();
    }

    @Override
    public int getColumnCount() {
        return naziviKolona.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Ambalaza ambalaza = listaAmbalaza.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return ambalaza.getAmbalazaID();
            case 1:
                return ambalaza.getNazivAmbalaze();
            case 2:
                return ambalaza.getReciklazniKod().getSlova();

            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return naziviKolona[column];
    }

}
