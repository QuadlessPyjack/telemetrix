/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.Entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bogdanv
 */
@Entity
@Table(name = "Snapshot", catalog = "telemetrix", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"DatasetId"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Snapshot.findAll", query = "SELECT s FROM Snapshot s")
    , @NamedQuery(name = "Snapshot.findById", query = "SELECT s FROM Snapshot s WHERE s.id = :id")
    , @NamedQuery(name = "Snapshot.findByTimestamp", query = "SELECT s FROM Snapshot s WHERE s.timestamp = :timestamp")
    , @NamedQuery(name = "Snapshot.findByBLELatency", query = "SELECT s FROM Snapshot s WHERE s.bLELatency = :bLELatency")
    , @NamedQuery(name = "Snapshot.findByImageProcessingTime", query = "SELECT s FROM Snapshot s WHERE s.imageProcessingTime = :imageProcessingTime")
    , @NamedQuery(name = "Snapshot.findByFrameRate", query = "SELECT s FROM Snapshot s WHERE s.frameRate = :frameRate")})
public class Snapshot implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Timestamp", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;
    @Column(name = "BLELatency")
    private Integer bLELatency;
    @Column(name = "ImageProcessingTime")
    @Temporal(TemporalType.TIME)
    private Date imageProcessingTime;
    @Column(name = "FrameRate")
    private Integer frameRate;
    @JoinColumn(name = "DatasetId", referencedColumnName = "Id", nullable = false)
    @OneToOne(optional = false)
    private Dataset datasetId;

    public Snapshot() {
    }

    public Snapshot(Integer id) {
        this.id = id;
    }

    public Snapshot(Integer id, Date timestamp) {
        this.id = id;
        this.timestamp = timestamp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getBLELatency() {
        return bLELatency;
    }

    public void setBLELatency(Integer bLELatency) {
        this.bLELatency = bLELatency;
    }

    public Date getImageProcessingTime() {
        return imageProcessingTime;
    }

    public void setImageProcessingTime(Date imageProcessingTime) {
        this.imageProcessingTime = imageProcessingTime;
    }

    public Integer getFrameRate() {
        return frameRate;
    }

    public void setFrameRate(Integer frameRate) {
        this.frameRate = frameRate;
    }

    public Dataset getDatasetId() {
        return datasetId;
    }

    public void setDatasetId(Dataset datasetId) {
        this.datasetId = datasetId;
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
        if (!(object instanceof Snapshot)) {
            return false;
        }
        Snapshot other = (Snapshot) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataAccess.Entities.Snapshot[ id=" + id + " ]";
    }
    
}
