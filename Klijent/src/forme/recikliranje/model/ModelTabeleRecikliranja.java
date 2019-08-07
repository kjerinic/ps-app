package forme.recikliranje.model;

import domen.Recikliranje;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModelTabeleRecikliranja extends AbstractTableModel {

    ArrayList<Recikliranje> listaRecikliranja = new ArrayList<>();
    String[] naziviKolona = new String[]{"Naziv ambalaže", "Naziv reciklažera", "Napomena"};

    public ModelTabeleRecikliranja() {
    }

    public ModelTabeleRecikliranja(ArrayList<Recikliranje> listaRecikliranja) {
        this.listaRecikliranja = listaRecikliranja;
    }

    public void setListaRecikliranja(ArrayList<Recikliranje> listaRecikliranja) {
        this.listaRecikliranja = listaRecikliranja;
    }

    public ArrayList<Recikliranje> getListaRecikliranja() {
        return listaRecikliranja;
    }

    @Override
    public int getRowCount() {
        return listaRecikliranja.size();
    }

    @Override
    public int getColumnCount() {
        return naziviKolona.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Recikliranje recikliranje = listaRecikliranja.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return recikliranje.getAmbalazaID().getNazivAmbalaze();
            case 1:
                return recikliranje.getReciklazerID().getNazivReciklazera();
            case 2:
                return recikliranje.getNapomena();
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return naziviKolona[column];
    }
    
    

}
