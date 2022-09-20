package org.hthu.test;


import java.io.Serializable;

/**
 *
 */
public class BusyLineNotifyDto implements Serializable {
    private Long driverId;

    private Long cargoId;

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public Long getCargoId() {
        return cargoId;
    }

    public void setCargoId(Long cargoId) {
        this.cargoId = cargoId;
    }
}
