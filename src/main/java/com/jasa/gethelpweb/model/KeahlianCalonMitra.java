package com.jasa.gethelpweb.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Data
@Entity
@Table(name = "_keahlian_calonmitra")
public class KeahlianCalonMitra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_keahlian_calonmitra;

    @ManyToOne
    @JoinColumn(name = "id_calonmitra")
    private CalonMitra calonMitra;

    @ManyToOne
    @JoinColumn(name = "id_keahlian")
    private Keahlian keahlian;

    public KeahlianCalonMitra(CalonMitra calonMitra, Keahlian keahlian) {
        this.calonMitra = calonMitra;
        this.keahlian = keahlian;
    }
}
