package model;

import javax.swing.Icon;

public class Model_PemasukanPengeluaran {

    /**
     * @return the icon1
     */
    public Icon getIcon1() {
        return icon1;
    }

    /**
     * @param icon1 the icon1 to set
     */
    public void setIcon1(Icon icon1) {
        this.icon1 = icon1;
    }

    /**
     * @return the title1
     */
    public String getTitle1() {
        return title1;
    }

    /**
     * @param title1 the title1 to set
     */
    public void setTitle1(String title1) {
        this.title1 = title1;
    }

    /**
     * @return the icon
     */
    public Icon getIcon() {
        return icon;
    }

    /**
     * @param icon the icon to set
     */
    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the values
     */
    public String getValues() {
        return values;
    }

    /**
     * @param values the values to set
     */
    public void setValues(String values) {
        this.values = values;
    }

    /**
     * @return the description
     */
    public String getValues1() {
        return values1;
    }

    /**
     * @param description the description to set
     */
    public void setValues1(String values1) {
        this.values1 = values1;
    }

    public Model_PemasukanPengeluaran(Icon icon, String title, String values, String description) {
        this.icon = icon;
        this.title = title;
        this.values = values;
    }

    
    public Model_PemasukanPengeluaran() {
    }
    

    private Icon icon;
    private String title;
    private String values;
    private Icon icon1;
    private String title1;
    private String values1;
}
