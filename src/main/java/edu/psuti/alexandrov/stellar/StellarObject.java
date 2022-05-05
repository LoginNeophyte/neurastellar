package edu.psuti.alexandrov.stellar;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.stream.Stream;

public class StellarObject implements Serializable {

    @CsvBindByName(column = "obj_ID")
    private String id;

    @CsvBindByName(column = "spec_obj_ID")
    private String specialId;

    @CsvBindByName(column = "alpha")
    private BigDecimal rightAscension;

    @CsvBindByName(column = "delta")
    private BigDecimal declination;

    @CsvBindByName(column = "u")
    private BigDecimal ultraviolet;

    @CsvBindByName(column = "g")
    private BigDecimal green;

    @CsvBindByName(column = "r")
    private BigDecimal red;

    @CsvBindByName(column = "i")
    private BigDecimal nearInfrared;

    @CsvBindByName(column = "z")
    private BigDecimal infrared;

    @CsvBindByName(column = "run_ID")
    private int run;

    @CsvBindByName(column = "rerun_ID")
    private int rerun;

    @CsvBindByName(column = "cam_col")
    private int cameraColumn;

    @CsvBindByName(column = "field_ID")
    private int field;

    @CsvCustomBindByName(column = "class", converter = StellarClassConverter.class)
    private StellarClass outputClass;

    @CsvBindByName(column = "redshift")
    private BigDecimal redshift;

    @CsvBindByName(column = "plate")
    private int plate;

    @CsvBindByName(column = "MJD")
    private int modifiedJulianDate;

    @CsvBindByName(column = "fiber_ID")
    private int fiber;

    public StellarClass getOutputClass() {
        return outputClass;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSpecialId(String specialId) {
        this.specialId = specialId;
    }

    public void setRightAscension(BigDecimal rightAscension) {
        this.rightAscension = rightAscension;
    }

    public void setDeclination(BigDecimal declination) {
        this.declination = declination;
    }

    public void setUltraviolet(BigDecimal ultraviolet) {
        this.ultraviolet = ultraviolet;
    }

    public void setGreen(BigDecimal green) {
        this.green = green;
    }

    public void setRed(BigDecimal red) {
        this.red = red;
    }

    public void setNearInfrared(BigDecimal nearInfrared) {
        this.nearInfrared = nearInfrared;
    }

    public void setInfrared(BigDecimal infrared) {
        this.infrared = infrared;
    }

    public void setRun(int run) {
        this.run = run;
    }

    public void setRerun(int rerun) {
        this.rerun = rerun;
    }

    public void setCameraColumn(int cameraColumn) {
        this.cameraColumn = cameraColumn;
    }

    public void setField(int field) {
        this.field = field;
    }

    public void setOutputClass(StellarClass outputClass) {
        this.outputClass = outputClass;
    }

    public void setRedshift(BigDecimal redshift) {
        this.redshift = redshift;
    }

    public void setPlate(int plate) {
        this.plate = plate;
    }

    public void setModifiedJulianDate(int modifiedJulianDate) {
        this.modifiedJulianDate = modifiedJulianDate;
    }

    public void setFiber(int fiber) {
        this.fiber = fiber;
    }

    public Stream<BigDecimal> datumStream() {
        return Stream.of(declination, rightAscension, redshift, red, ultraviolet, green, infrared, nearInfrared);
    }
}