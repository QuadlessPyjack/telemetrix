/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.Entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bogdanv
 */
@Entity
@Table(name = "Dataset", catalog = "telemetrix", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dataset.findAll", query = "SELECT d FROM Dataset d")
    , @NamedQuery(name = "Dataset.findById", query = "SELECT d FROM Dataset d WHERE d.id = :id")
    , @NamedQuery(name = "Dataset.findByUptime", query = "SELECT d FROM Dataset d WHERE d.uptime = :uptime")
    , @NamedQuery(name = "Dataset.findByDate", query = "SELECT d FROM Dataset d WHERE d.date = :date")})
public class Dataset implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id", nullable = false)
    private Integer id;
    @Column(name = "Uptime")
    @Temporal(TemporalType.TIME)
    private Date uptime;
    @Column(name = "Date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "datasetId")
    private Snapshot snapshot;
    @JoinColumn(name = "AssociatedDeviceId", referencedColumnName = "Id", nullable = false)
    @ManyToOne(optional = false)
    private Devices associatedDeviceId;
    @JoinColumn(name = "UserId", referencedColumnName = "Id")
    @ManyToOne
    private Users userId;

    public Dataset() {
    }

    public Dataset(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getUptime() {
        return uptime;
    }

    public void setUptime(Date uptime) {
        this.uptime = uptime;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Snapshot getSnapshot() {
        return snapshot;
    }

    public void setSnapshot(Snapshot snapshot) {
        this.snapshot = snapshot;
    }

    public Devices getAssociatedDeviceId() {
        return associatedDeviceId;
    }

    public void setAssociatedDeviceId(Devices associatedDeviceId) {
        this.associatedDeviceId = associatedDeviceId;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dataset)) {
            return false;
        }
        Dataset other = (Dataset) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataAccess.Entities.Dataset[ id=" + id + " ]";
    }
    
}
