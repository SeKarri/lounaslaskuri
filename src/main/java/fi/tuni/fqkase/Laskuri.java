package fi.tuni.fqkase;

public class Laskuri {
    private String value = "";
    private String err = "";
    private String start = "";
    private String remain = "";

    public Object getValue() {
        if (err == "" && this.value != "") {
            return Double.toString(Double.parseDouble(value)) + "€";
        } else if (this.value == "") {
            return err;
        }
        return err;
    }

    public String getStart() {
        if (err == "") {
            return start + "€";
        }
        return err;
    }

    public String getRemain() {
        if (err == "") {
            return remain + "€";
        }
        return err;
    }

    public void setValue(String val) {
        try {
            this.start = val;
            double d = Double.parseDouble(val);
            if (d <= 8) {
                this.value = "0.00";
            } else if (d <= 10.66) {
                this.value = String.format(java.util.Locale.US, "%.2f", d - 8);
            } else if (d < 11.5) {
                this.value = String.format(java.util.Locale.US, "%.2f", d * 0.25);
            } else {
                this.value = "2.87";
            }
            this.remain = String.format(java.util.Locale.US, "%.2f", d - Double.parseDouble(this.value));
        } catch (Exception e) {
            this.err = "Väärä syöte, anna hinta desimaalimuodossa pisteellä esim: 10.25";
        }
    }
}
