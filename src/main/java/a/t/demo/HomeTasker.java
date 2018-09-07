package a.t.demo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class HomeTasker {
    private String opis;
    private String osoba;
    private int punkty;

    @DateTimeFormat(pattern="yyyy-MM-dd’T’HH:mm")
    private Date dateTimeFormat;

    public HomeTasker(){

    }

    public HomeTasker(String opis, String osoba, int punkty, Date dateTimeFormat) {
        this.opis = opis;
        this.osoba = osoba;
        this.punkty = punkty;
        this.dateTimeFormat = dateTimeFormat;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getOsoba() {
        return osoba;
    }

    public void setOsoba(String osoba) {
        this.osoba = osoba;
    }

    public int getPunkty() {
        return punkty;
    }

    public void setPunkty(int punkty) {
        this.punkty = punkty;
    }

    public Date getDateTimeFormat() {
        return dateTimeFormat;
    }

    public void setDateTimeFormat(Date dateTimeFormat) {
        this.dateTimeFormat = dateTimeFormat;
    }
}
