package org.hthu.test;


import java.io.Serializable;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BusyLineNotifyDto that = (BusyLineNotifyDto) o;
        return Objects.equals(driverId, that.driverId) && Objects.equals(cargoId, that.cargoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(driverId, cargoId);
    }

    @Override
    public String toString() {
        return "BusyLineNotifyDto{" +
                "driverId=" + driverId +
                ", cargoId=" + cargoId +
                '}';
    }
}
