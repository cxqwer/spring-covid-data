package org.level.up.covid19.springcovid.jpa;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "world_status", schema = "public", catalog = "covid")
public class WorldStatusEntity {
    private Integer newConfirmed;
    private Integer totalConfirmed;
    private Integer newDeaths;
    private Integer totalDeaths;
    private Integer newRecovered;
    private Integer totalRecovered;

    @Basic
    @Column(name = "new_confirmed")
    public Integer getNewConfirmed() {
        return newConfirmed;
    }

    public void setNewConfirmed(Integer newConfirmed) {
        this.newConfirmed = newConfirmed;
    }

    @Basic
    @Column(name = "total_confirmed")
    public Integer getTotalConfirmed() {
        return totalConfirmed;
    }

    public void setTotalConfirmed(Integer totalConfirmed) {
        this.totalConfirmed = totalConfirmed;
    }

    @Basic
    @Column(name = "new_deaths")
    public Integer getNewDeaths() {
        return newDeaths;
    }

    public void setNewDeaths(Integer newDeaths) {
        this.newDeaths = newDeaths;
    }

    @Basic
    @Column(name = "total_deaths")
    public Integer getTotalDeaths() {
        return totalDeaths;
    }

    public void setTotalDeaths(Integer totalDeaths) {
        this.totalDeaths = totalDeaths;
    }

    @Basic
    @Column(name = "new_recovered")
    public Integer getNewRecovered() {
        return newRecovered;
    }

    public void setNewRecovered(Integer newRecovered) {
        this.newRecovered = newRecovered;
    }

    @Basic
    @Column(name = "total_recovered")
    public Integer getTotalRecovered() {
        return totalRecovered;
    }

    public void setTotalRecovered(Integer totalRecovered) {
        this.totalRecovered = totalRecovered;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorldStatusEntity that = (WorldStatusEntity) o;
        return Objects.equals(newConfirmed, that.newConfirmed) &&
                Objects.equals(totalConfirmed, that.totalConfirmed) &&
                Objects.equals(newDeaths, that.newDeaths) &&
                Objects.equals(totalDeaths, that.totalDeaths) &&
                Objects.equals(newRecovered, that.newRecovered) &&
                Objects.equals(totalRecovered, that.totalRecovered);
    }

    @Override
    public int hashCode() {
        return Objects.hash(newConfirmed, totalConfirmed, newDeaths, totalDeaths, newRecovered, totalRecovered);
    }
}
