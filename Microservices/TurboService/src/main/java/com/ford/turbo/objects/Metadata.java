package com.ford.core.objects;

public class Metadata {

    private String line_of_business;
    private String category;
    private int sic;

    public Metadata() {
    }

    public String getLine_of_business() {
        return line_of_business;
    }
    public String getCategory() {
        return category;
    }
    public int getSic() {
        return sic;
    }

    public void setLine_of_business(String lob) {
        this.line_of_business = lob.split(",")[0];
    }
    public void setCategory(String cat) {
        this.category = cat;
    }
    public void setSic(int sic) {
        this.sic = sic;
    }
}
