package entities;

import java.util.Date;

public class Branch {
    private String outlet;
    private Date period;
    private Integer omset;
    private Integer total_trx;

    public Branch(String outlet, Date period, Integer omset, Integer total_trx) {
        this.outlet = outlet;
        this.period = period;
        this.omset = omset;
        this.total_trx = total_trx;
    }

    public String getOutlet() {
        return outlet;
    }

    public void setOutlet(String outlet) {
        this.outlet = outlet;
    }

    public Date getPeriod() {
        return period;
    }

    public void setPeriod(Date period) {
        this.period = period;
    }

    public Integer getOmset() {
        return omset;
    }

    public void setOmset(Integer omset) {
        this.omset = omset;
    }

    public Integer getTotal_trx() {
        return total_trx;
    }

    public void setTotal_trx(Integer total_trx) {
        this.total_trx = total_trx;
    }
}
